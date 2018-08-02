package com.squalex.saturday.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date lastLogin;
}
