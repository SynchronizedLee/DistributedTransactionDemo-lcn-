package pri.liyang.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.liyang.dao.AccountDao;
import pri.liyang.entity.Account;
import pri.liyang.service.FirstRemoteService;
import pri.liyang.service.SecondRemoteService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    @Autowired
    @Qualifier("firstRemoteService")
    FirstRemoteService firstRemoteService;

    @Autowired
    @Qualifier("secondRemoteService")
    SecondRemoteService secondRemoteService;

    @Resource
    AccountDao accountDao;

    @GetMapping("/startTrans/lcn")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String startTransactionLcn(String name) {
        // 事务：张三+10000，李四+10000，王五-20000

        // 首先，王五-20000
        Account account = accountDao.queryById(3L);
        account.setAccount(account.getAccount() - 20000);
        accountDao.update(account);

        // 然后，张三+10000
        firstRemoteService.getFirstValueLcn(1L, 10000L);

        // 最后，李四+10000
        secondRemoteService.getSecondValueLcn(2L, 10000L);

        // 模拟事务的异常发生
        if ("error".equals(name)) {
            int err = 1 / 0;
        }

        return "success";
    }

    @GetMapping("/startTrans/tcc")
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String startTransactionTcc(String param) {
        // 调用事务1
        String firstValueTcc = firstRemoteService.getFirstValueTcc(param);
        System.out.println("firstValueTcc: " + firstValueTcc);

        // 调用事务2
        String secondValueTcc = secondRemoteService.getSecondValueTcc(param);
        System.out.println("secondValueTcc: " + secondValueTcc);

        // 执行自己的业务逻辑
        System.out.println("Consumer execute [try], param: " + param);

        // 根据参数来抛异常
        if ("error".equals(param)) {
            int i = 1 / 0;
        }

        return "Consumer success";
    }

    public String confirmStartTransactionTcc(String param) {
        System.out.println("Consumer execute [confirm], param: " + param);
        return "Consumer confirm success";
    }

    public String cancelStartTransactionTcc(String param) {
        System.out.println("Consumer execute [cancel], param: " + param);
        return "Consumer cancel success";
    }

}
