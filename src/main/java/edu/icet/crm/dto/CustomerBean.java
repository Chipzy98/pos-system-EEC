package edu.icet.crm.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CustomerBean {
    private String customer_id;
    private String customer_name;
    private String contact_number;
    private String email_address;
}
