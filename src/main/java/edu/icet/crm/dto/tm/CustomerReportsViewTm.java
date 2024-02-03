package edu.icet.crm.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerReportsViewTm {
    private String customerId;
    private String name;
    private String contactNumber;
    private String emailAddress;
    private JFXButton deleteBtn;
}
