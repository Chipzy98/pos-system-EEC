package edu.icet.crm.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UsersViewTm {
    private String userId;
    private String userName;
    private String password;
    private JFXButton deleteBtn;
}
