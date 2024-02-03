package edu.icet.crm.bo;

import edu.icet.crm.bo.custom.impl.*;

public class BoFactory {
    private BoFactory(){}
    private static BoFactory boFactory;
    public static BoFactory getInstance(){
        return boFactory!=null?boFactory:(boFactory=new BoFactory());
    }
    public <T extends SuperBo>T getBo(BoType boType){

        switch (boType){
            case PLACE_ORDER_BO:return (T)new PlaceOrderBoImpl();
            case ORDERS_VIEW_BO:return (T)new OrdersViewBoImpl();
            case ITEMS_VIEW_BO:return (T)new ItemsViewBoImpl();
            case CUSTOMER_REPORTS_VIEW_BO:return (T)new CustomerReportsViewBoImpl();
            case ORDER_REPORTS_VIEW_BO:return (T)new OrderReportsViewBoImpl();
            case USERS_VIEW_BO:return (T)new UserViewBoImpl();
            case LOGIN_VIEW_BO:return (T)new LogInViewBoImpl();
        }

        return null;
    }
}
