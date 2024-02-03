package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.OrderReportsViewDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.entity.OrdersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderReportsViewDaoImpl implements OrderReportsViewDao {
    @Override
    public List<OrdersEntity> getAllOrders() {
        try (Session session = HibernateUtil.getSession()) {
            String hql = "FROM OrdersEntity o";
            Query<OrdersEntity> query = session.createQuery(hql, OrdersEntity.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteOrder(String orderId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();

            OrdersEntity order = session.get(OrdersEntity.class, orderId);

            if (order != null) {
                session.delete(order);
                transaction.commit();
                return true;
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return false;
    }
}
