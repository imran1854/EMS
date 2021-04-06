package com.example.EMS;

public class users {
    private int id;
    private String name;
    private String contactno;
    private String username;
    private String password;

    public users(int id, String name, String contactno, String username, String password) {
        this.id = id;
        this.name = name;
        this.contactno = contactno;
        this.username = username;
        this.password = password;
    }

    public users(String name, String contactno, String username, String password) {
        this.name = name;
        this.contactno = contactno;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactno='" + contactno + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
