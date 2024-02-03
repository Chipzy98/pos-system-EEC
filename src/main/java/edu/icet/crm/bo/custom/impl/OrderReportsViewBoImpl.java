package edu.icet.crm.bo.custom.impl;

import edu.icet.crm.bo.custom.OrderReportsViewBo;
import edu.icet.crm.dao.DaoFactory;
import edu.icet.crm.dao.custom.OrderReportsViewDao;
import edu.icet.crm.dao.util.DaoType;
import edu.icet.crm.dto.OrderDto;
import edu.icet.crm.entity.OrdersEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderReportsViewBoImpl implements OrderReportsViewBo {
    OrderReportsViewDao orderReportsViewDao= DaoFactory.getInstance().getDao(DaoType.ORDER_REPORTS_VIEW_DAO);

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrdersEntity> ordersEntities = orderReportsViewDao.getAllOrders();
        return ordersEntities.stream()
                .map(ordersEntity -> new OrderDto(
                        ordersEntity.getOrderId(),
                        ordersEntity.getOrderStatus(),
                        ordersEntity.getCustomer().getCustomerId(),
                        ordersEntity.getOrderDate(),
                        ordersEntity.getNote()
                ))
                .collect(Collectors.toList());
    }
}
