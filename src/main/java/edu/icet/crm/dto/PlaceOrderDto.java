package edu.icet.crm.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PlaceOrderDto {
    private String customerId;
    private String customerName;
    private String email;
    private String contactNumber;
    private String orderId;
    private String date;
    private String note;
    private List<OrderDetailsDto> orderDetailsDtoList;
}
