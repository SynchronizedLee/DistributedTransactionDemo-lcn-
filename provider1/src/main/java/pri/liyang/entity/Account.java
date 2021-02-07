package pri.liyang.entity;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2021-02-06 14:57:15
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -89981781961182447L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 姓名
    */
    private String username;
    /**
    * 余额(单位：分)
    */
    private Long account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

}