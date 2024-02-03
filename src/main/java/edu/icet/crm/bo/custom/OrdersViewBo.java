package edu.icet.crm.bo.custom;
import edu.icet.crm.bo.SuperBo;
import edu.icet.crm.dto.OrderDto;

import java.util.List;
public interface OrdersViewBo extends SuperBo {
    List<OrderDto> getOrdersViewDto();
    boolean updateOrder(OrderDto updatedDto);

}
