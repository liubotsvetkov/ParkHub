package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private Boolean enabled;
    @Column(nullable=false)
    @OneToMany(mappedBy="user")
    private List<UserAuthority> authorities;
}
