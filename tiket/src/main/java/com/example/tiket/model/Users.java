package com.example.tiket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    int userId;
    @Column(name = "username")
    String userName;
    @Column(name = "emailaddress")
    String emailAddress;
    @Column(name = "password")
    String password;
}
