package pri.liyang.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import pri.liyang.dao.AccountDao;
import pri.liyang.entity.Account;
import pri.liyang.service.SecondService;

import javax.annotation.Resource;

@RestController
public class SecondProviderController implements SecondService {

    @Resource
    AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String getSecondValueLcn(Long id, Long cash) {
        Account account = accountDao.queryById(id);
        account.setAccount(account.getAccount() + cash);
        accountDao.update(account);
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String getSecondValueTcc(String param) {
        System.out.println("Second provider execute [try], param: " + param);
        return "Second success";
    }

    public String confirmGetSecondValueTcc(String param) {
        System.out.println("Second provider execute [confirm], param: " + param);
        return "Second confirm success";
    }

    public String cancelGetSecondValueTcc(String param) {
        System.out.println("Second provider execute [cancel], param: " + param);
        return "Second cancel success";
    }

}
