package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.entity.OrdersEntity;

import java.util.List;

public interface OrderReportsViewDao extends SuperDao {
    List<OrdersEntity> getAllOrders();
    boolean deleteOrder(String orderId);
}
