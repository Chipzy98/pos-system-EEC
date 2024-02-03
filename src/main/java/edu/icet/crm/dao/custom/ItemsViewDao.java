package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.entity.ItemsEntity;

import java.util.List;

public interface ItemsViewDao extends SuperDao {
    List<ItemsEntity> getAllItems();
    boolean deleteItem(String itemId);
    boolean updateItemStatus(String orderId, String status);
    String getCustomerEmailByOrderId(String orderId);
    String getOrderIdByItemId(String itemId);
    int getOrderItemCountByStatus(String orderId, String status);
    int getTotalItemCountByOrderId(String orderId);
    String getOrderDateByItemId(String itemId);
}

