import com.minisrm.admin.AdminApplication;
import com.minisrm.admin.mapper.UserMapper;
import com.minisrm.admin.model.User;
import com.minisrm.admin.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdminApplication.class})
public class Test {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void my(){
        User user = new User();
        user.setUserStatus(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setUserName("admin");
        user.setPassword("123456");
        user.setEmail("111222@qq.com");
        user.setUserMobile("15754256842");
        user.setRoleId(1L);
       userService.save(user);
        System.out.println(user.getId());
    }
}
