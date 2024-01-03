package com.example.ecommerceweb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "age")
    private Integer age;

    public Users() {
        super();
    }
    public Users(String username, String password, String fullname, Integer age) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;

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
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Users [username=" + username + ", password=" + password + ", fullname=" + fullname + ", age=" + age
                + ", gender=" + "]";
    }

}
