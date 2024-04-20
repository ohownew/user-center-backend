package xyz.techfjord.usercenter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.techfjord.usercenter.model.domain.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author zysddz
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("zysddz");
        user.setUserAccount("zysddz");
        user.setAvatarUrl("https://s1.hdslb.com/bfs/static/jinkela/popular/assets/icon_popular.png");
        user.setGender(0);
        user.setUserPassword("zy1234");
        user.setPhone("123");
        user.setEmail("456@qq.com");

        boolean result = userService.save(user);
        System.out.println("This userid is: " + user.getId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        // 验证空
        String userAccount = "zysddz";
        String userPassword = "";
        String checkPassword = "123456";
        String inviteCode = "abcd";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证用户名小于4字符
        userAccount = "zy";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证密码小于8位
        userAccount = "zysddz";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证包含特殊字符
        userAccount = "zy sddz";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证校验密码
        userAccount = "zysddz";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证账户重复
        userAccount = "zysddz";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证邀请码不存在
        userAccount = "zhongy2";
        inviteCode = "ab";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 验证邀请码已被使用
        userAccount = "zhongy2";
        inviteCode = "abcd";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertEquals(-1, result);
        // 成功注册
        userAccount = "zhongy2";
        userPassword = "12345678";
        checkPassword = "12345678";
        inviteCode = "code1";
        result = userService.userRegister(userAccount, userPassword, checkPassword, inviteCode);
        assertTrue(result > 0);
    }
}