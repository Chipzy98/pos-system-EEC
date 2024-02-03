// OrderBean.java
package edu.icet.crm.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderBean {
    private String order_id;
    private String order_status;
    private String customer_id;
    private String order_date;
    private String note;
}
