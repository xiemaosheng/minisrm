import com.minisrm.admin.AdminApplication;
import com.minisrm.admin.mapper.UserMapper;
import com.minisrm.admin.model.User;
import com.minisrm.admin.service.UserService;
import org.joda.time.DateTime;
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
        System.out.println(new DateTime(0).toString("yyyy-MM-dd HH:mm:ss"));
    }
}
