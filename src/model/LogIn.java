package model;

import java.io.Serializable;

public class LogIn implements Serializable {
    private String user;
    private String password;

    public LogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Thông Tin Tài Khoản : " +
                " User : " + user + '\'' +
                " Mật Khẩu : " + password ;
    }
}
