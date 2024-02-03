package edu.icet.crm.bo.custom.impl;

import edu.icet.crm.bo.custom.OrdersViewBo;
import edu.icet.crm.dao.DaoFactory;
import edu.icet.crm.dao.custom.OrdersViewDao;
import edu.icet.crm.dao.util.DaoType;
import edu.icet.crm.dto.OrderDto;
import edu.icet.crm.entity.OrdersEntity;

import java.util.ArrayList;
import java.util.List;

public class OrdersViewBoImpl implements OrdersViewBo {
    OrdersViewDao orderViewDao= DaoFactory.getInstance().getDao(DaoType.ORDERS_VIEW_DAO);
    @Override
    public List<OrderDto> getOrdersViewDto() {
        List<OrderDto> orderDtoList=new ArrayList<>();
        for (OrdersEntity ordersEntity:orderViewDao.getOrdersViewDto()){
            orderDtoList.add(new OrderDto(
                    ordersEntity.getOrderId(),
                    ordersEntity.getOrderStatus(),
                    ordersEntity.getCustomer().getCustomerId(),
                    ordersEntity.getOrderDate(),
                    ordersEntity.getNote(),
                    ordersEntity.getTotal()
            ));
        }
        return orderDtoList;
    }
    public boolean updateOrder(OrderDto updatedDto){
        return orderViewDao.updateOrder(new OrdersEntity(
                updatedDto.getOrderId(),
                updatedDto.getStatus(),
                updatedDto.getTotal()
        ));
    }

}
