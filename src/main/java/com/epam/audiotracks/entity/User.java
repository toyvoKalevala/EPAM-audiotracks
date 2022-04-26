package com.epam.audiotracks.entity;

public class User implements Identifiable {

    public static final String TABLE = "users";
    private String login;
    private String password;
    private boolean isAdmin;
    private int discount;
    private int id;

    public User(String login, String password, boolean isAdmin, int discount, int id) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.discount = discount;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public int getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }
}
