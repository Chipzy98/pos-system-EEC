package edu.icet.crm.bo.custom;

import edu.icet.crm.bo.SuperBo;
import edu.icet.crm.dto.PlaceOrderDto;

public interface PlaceOrderBo extends SuperBo {
    void save(PlaceOrderDto placeOrderDto);
    String getLastOrderId();
    int getLstItemId();
    String getLastCustomerId();
}
