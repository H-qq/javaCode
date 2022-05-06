package common;

import java.io.Serializable;

/**
 * @author hongtao
 * @create 2022-04-28-21:35
 * 表示 客户信息
 */

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId; //用户名
    private String passwd ; //密码

    public User() {
    }

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
