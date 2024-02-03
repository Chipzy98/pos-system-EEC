package edu.icet.crm.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PlaceOrderTm {
    private String itemName;
    private String category;
    private JFXButton button;
}
