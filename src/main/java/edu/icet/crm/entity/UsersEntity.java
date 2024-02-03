package edu.icet.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "users")
public class UsersEntity {
    @Id
    private String userId;
    private String userName;
    private String password;
    private String role;
}