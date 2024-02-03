package edu.icet.crm.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderDetailsDto {
    private String itemCode;
    private String itemName;
    private String category;
//    private String orderId;
//    private String customerId;//optional??
}
