package edu.icet.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderDto {
    private String orderId;
    private String status;
    private String customerId;
    private String orderDate;
    private String note;
    private Double total;

    public OrderDto(String orderId, String status, String customerId, String orderDate, String note) {
        this.orderId = orderId;
        this.status = status;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.note = note;
    }

    public OrderDto(String orderId, String status, Double total) {
        this.orderId = orderId;
        this.status = status;
        this.total = total;
    }
}