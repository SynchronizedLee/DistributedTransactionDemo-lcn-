package pri.liyang.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import pri.liyang.dao.AccountDao;
import pri.liyang.entity.Account;
import pri.liyang.service.FirstService;

import javax.annotation.Resource;

@RestController
public class FirstProviderController implements FirstService {

    @Resource
    AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String getFirstValueLcn(Long id, Long cash) {
        Account account = accountDao.queryById(id);
        account.setAccount(account.getAccount() + cash);
        accountDao.update(account);
        return "success";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String getFirstValueTcc(String param) {
        System.out.println("First provider execute [try], param: " + param);
        return "First success";
    }

    public String confirmGetFirstValueTcc(String param) {
        System.out.println("First provider execute [confirm], param: " + param);
        return "First confirm success";
    }

    public String cancelGetFirstValueTcc(String param) {
        System.out.println("First provider execute [cancel], param: " + param);
        return "First cancel success";
    }

}
