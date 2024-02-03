package edu.icet.crm.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ItemsViewTm {
    private String itemId;
    private String status;
    private String category;
    private String name;
    private String orderId;
    private JFXButton deleteButton;
}
