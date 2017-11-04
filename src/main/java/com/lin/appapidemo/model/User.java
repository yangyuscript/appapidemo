package com.lin.appapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@Table(name="t_user")
public class User {
    private int id;
    private String username;
    private String idcard;
    private String phone;
    private String password;

    public User(String username, String idcard, String phone, String password) {
        this.username = username;
        this.idcard = idcard;
        this.phone = phone;
        this.password = password;
    }
}
