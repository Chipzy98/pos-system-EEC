package edu.icet.crm.dao.custom;
import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.entity.OrdersEntity;

import java.util.List;
public interface OrdersViewDao extends SuperDao {
    List<OrdersEntity> getOrdersViewDto();
    boolean updateOrder(OrdersEntity updatedEntity);

}
