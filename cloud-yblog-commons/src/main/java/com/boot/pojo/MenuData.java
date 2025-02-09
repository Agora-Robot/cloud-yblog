package com.boot.pojo;

public class MenuData {

    private long id;
    private int authority; //权限id
    private String menu; //menu的JSON

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "MenuData{" +
                "id=" + id +
                ", authority=" + authority +
                ", menu='" + menu + '\'' +
                '}';
    }
}
