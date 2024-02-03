package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.OrdersViewDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.entity.OrdersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class OrdersViewDaoImpl implements OrdersViewDao {
    @Override
    public List<OrdersEntity> getOrdersViewDto() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("FROM OrdersEntity");
            List<OrdersEntity> list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateOrder(OrdersEntity updatedEntity) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                OrdersEntity existingEntity = session.get(OrdersEntity.class, updatedEntity.getOrderId());
                if (existingEntity != null) {
                    existingEntity.setOrderStatus(updatedEntity.getOrderStatus());

                    if (updatedEntity.getTotal() != null) {
                        existingEntity.setTotal(updatedEntity.getTotal());
                    }

                    transaction.commit();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                return false;
            }
        }
    }

}