package edu.icet.crm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PartDto {
    private String itemId;
    private Long partId;
    private String name;
    private int quantity;
    private double price;
    private double total;

    public PartDto(String itemId, String name, int quantity, double price) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
