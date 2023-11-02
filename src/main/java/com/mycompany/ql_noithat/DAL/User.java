package com.mycompany.ql_noithat.DAL;

public class User {
    private String userName;
    private String password;
    private String createAt;

    public User() {
    }

    public User(String userName, String password, String createAt) {
        this.userName = userName;
        this.password = password;
        this.createAt = createAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

}
