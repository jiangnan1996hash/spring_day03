package testAop;


import com.sun.service.UserService1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext1.xml")
public class TestAopUserService1 {

    @Autowired //注解注入依赖
    private UserService1 userService1 = null;


    @Test
    public void testLogin(){
        userService1.login();
    }

}
