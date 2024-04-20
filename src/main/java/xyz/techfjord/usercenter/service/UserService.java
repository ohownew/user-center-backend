package xyz.techfjord.usercenter.service;

import jakarta.servlet.http.HttpServletRequest;
import xyz.techfjord.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author zysddz
 * @description 针对表【user_basic(用户)】的用户服务
 * @createDate 2024-04-05 15:46:10
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param inviteCode 邀请码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String inviteCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @param request 请求体
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser 原始用户信息
     * @return 脱敏用户信息
     */
    User getSafetyUser(User originUser);

    /**
     * 用户退出登录
     *
     * @param request 请求
     * @return 1
     */
    int userLogout(HttpServletRequest request);
}
