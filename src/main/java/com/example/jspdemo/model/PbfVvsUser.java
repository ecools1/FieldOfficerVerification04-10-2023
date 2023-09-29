package com.example.jspdemo.model;

import com.example.jspdemo.service.CustomUserDetailsService;

import javax.persistence.*;

@Entity
@Table(name = "pbf_vvs_users", schema = "public")
public class PbfVvsUser {

    @Id
    @Column(name = "user_id", nullable = false)
   // @GeneratedValue(strategy = GenerationType.TABLE)
     private Integer id;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "user_password", length = 50)
    private String userPassword;

    @Column(name = "user_role_id")
    private int userRoleId;

    public PbfVvsUser() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
}