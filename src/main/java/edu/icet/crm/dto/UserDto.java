package edu.icet.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    private String userId;
    private String userName;
    private String password;
    private String role;
}
