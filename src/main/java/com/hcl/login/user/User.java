package com.hcl.login.user;


import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;

    private String userName;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}