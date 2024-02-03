package edu.icet.crm.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrdersViewTm {
    private String orderId;
    private String status;
    private String customerId;
    private String orderDate;
    private String note;
    private JFXButton closeOrderButton;
    private Double total;
    private JFXButton returnOrderButton;
}
