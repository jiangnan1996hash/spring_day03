package testAop;

import com.aop.AopConfig;
import com.sun.service.UserService1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *  纯注解模式的测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfig.class)
public class TestAopUserService2 {

    @Autowired
    private UserService1 userService;

    @Test
    public void testLogin(){
        userService.login();
    }
}
