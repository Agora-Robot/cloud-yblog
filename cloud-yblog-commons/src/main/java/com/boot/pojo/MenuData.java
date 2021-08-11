package com.boot.pojo;

public class MenuData {

    private long id;
    private long authority; //权限id
    private String menu; //menu的JSON

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthority() {
        return authority;
    }

    public void setAuthority(long authority) {
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
