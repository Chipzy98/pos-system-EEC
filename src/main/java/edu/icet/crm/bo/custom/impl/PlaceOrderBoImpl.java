package edu.icet.crm.bo.custom.impl;

import edu.icet.crm.bo.custom.PlaceOrderBo;
import edu.icet.crm.dao.DaoFactory;
import edu.icet.crm.dao.custom.PlaceOrderDao;
import edu.icet.crm.dao.util.DaoType;
import edu.icet.crm.dto.PlaceOrderDto;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    PlaceOrderDao placeOrderDao= DaoFactory.getInstance().getDao(DaoType.PLACE_ORDER_DAO);

    public String getLastOrderId(){

        if (placeOrderDao.getLastOrderId()==null){
            return "ord1";
        }else {

            int num = Integer.parseInt(placeOrderDao.getLastOrderId().split("[d]")[1]);
            return String.format("ord%d", ++num);
        }
    }

    public int getLstItemId(){
        if (placeOrderDao.getLastItemId()==null){
            return 0;
        }else {
            return Integer.parseInt(placeOrderDao.getLastItemId().split("[m]")[1]);
        }
    }

    public String getLastCustomerId(){
        if (placeOrderDao.getLastCustomerId()==null){
            return "cus1";
        }else {

            int num = Integer.parseInt(placeOrderDao.getLastCustomerId().split("[s]")[1]);
            return String.format("cus%d", ++num);
        }
    }

    @Override
    public void save(PlaceOrderDto placeOrderDto) {
        placeOrderDao.save(placeOrderDto);
    }
}
