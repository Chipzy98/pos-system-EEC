package edu.icet.crm.dao;

import edu.icet.crm.dao.custom.impl.*;
import edu.icet.crm.dao.util.DaoType;

public class DaoFactory {
    private DaoFactory(){}
    private static DaoFactory daoFactory;
    public static DaoFactory getInstance(){
        return daoFactory!=null? daoFactory:(daoFactory=new DaoFactory());
    }
    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case PLACE_ORDER_DAO:return (T)new PlaceOrderDaoImpl();
            case ORDERS_VIEW_DAO:return (T)new OrdersViewDaoImpl();
            case ITEMS_VIEW_DAO:return (T) new ItemsViewDaoImpl();
            case CUSTOMER_REPORTS_VIEW_DAO:return (T) new CustomerReportsViewDaoImpl();
            case ORDER_REPORTS_VIEW_DAO:return (T) new OrderReportsViewDaoImpl();
            case USERS_VIEW_DAO:return (T) new UsersViewDaoImpl();
            case LOGIN_VIEW_DAO:return (T) new LogInViewDaoImpl();
            case PART_DAO:return (T) new PartDaoImpl();
        }
        return null;
    }
}
