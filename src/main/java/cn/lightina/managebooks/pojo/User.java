package cn.lightina.managebooks.pojo;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String passWd;
    private String rname;
    private String phone;
    private String email;
    /**
     * 1:管理员，2：读者
     */
    private Integer roleType;

    public User(String userName, String passWd) {
        this.userName = userName;
        this.passWd = passWd;
    }

    public User() {}
}
