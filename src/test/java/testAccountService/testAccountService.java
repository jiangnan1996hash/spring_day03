package testAccountService;

import com.sun.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContextAccount.xml")
public class testAccountService {
    @Autowired
    private AccountService accountService;

    @Test
    public void TestTransfer(){
        accountService.transfer("阴丽华","刘秀",1000.0);

    }
}
