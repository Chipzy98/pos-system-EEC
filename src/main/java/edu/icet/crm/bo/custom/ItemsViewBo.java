package edu.icet.crm.bo.custom;

import edu.icet.crm.bo.SuperBo;
import edu.icet.crm.dto.ItemDto;
import edu.icet.crm.dto.PartDto;

import java.util.List;

public interface ItemsViewBo extends SuperBo {
    List<ItemDto> getAllItems();
    boolean deleteItem(String itemId);
    boolean updateItemStatus(String orderId, String newStatus);
    boolean isItemPendingForMoreThan10Days(String itemId);
    boolean savePart(PartDto partDto);
}
