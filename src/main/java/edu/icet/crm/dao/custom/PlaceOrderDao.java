package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.dto.PlaceOrderDto;

public interface PlaceOrderDao extends SuperDao {
    void save(PlaceOrderDto placeOrderDto);
    String getLastOrderId();
    String getLastItemId();
    String getLastCustomerId();
}
