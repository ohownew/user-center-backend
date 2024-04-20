package xyz.techfjord.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author zysddz
 */
@Data
public class UserRegisterRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 6849880866324953884L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String inviteCode;
}
