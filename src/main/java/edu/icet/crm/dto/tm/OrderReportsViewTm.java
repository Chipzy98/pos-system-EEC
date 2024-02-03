package edu.icet.crm.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderReportsViewTm {
    private String orderId;
    private String status;
    private String customerId;
    private String orderDate;
    private String note;
}
