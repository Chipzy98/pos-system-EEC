package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.ItemsViewDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.entity.ItemsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemsViewDaoImpl implements ItemsViewDao {
    @Override
    public List<ItemsEntity> getAllItems() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("FROM ItemsEntity ");
            List<ItemsEntity> list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteItem(String itemId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();

            ItemsEntity item = session.get(ItemsEntity.class, itemId);

            if (item != null) {
                session.delete(item);
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

    public boolean updateItemStatus(String itemId, String newStatus) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                ItemsEntity itemsEntity = session.get(ItemsEntity.class, itemId);
                if (itemsEntity != null) {
                    itemsEntity.setStatus(newStatus);
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

    @Override
    public String getCustomerEmailByOrderId(String orderId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<String> query = session.createQuery("SELECT o.customer.emailAddress FROM OrdersEntity o WHERE o.orderId = :orderId", String.class);
            query.setParameter("orderId", orderId);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getOrderIdByItemId(String itemId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<String> query = session.createQuery("SELECT order.orderId FROM ItemsEntity WHERE itemId = :itemId", String.class);
            query.setParameter("itemId", itemId);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getOrderItemCountByStatus(String orderId, String status) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM ItemsEntity WHERE order.orderId = :orderId AND status = :status", Long.class);
            query.setParameter("orderId", orderId);
            query.setParameter("status", status);
            return Math.toIntExact(query.uniqueResult());
        }
    }

    public int getTotalItemCountByOrderId(String orderId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Long> query = session.createQuery(
                    "SELECT COUNT(*) FROM ItemsEntity WHERE order.orderId = :orderId", Long.class);
            query.setParameter("orderId", orderId);
            return Math.toIntExact(query.uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String getOrderDateByItemId(String itemId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<String> query = session.createQuery("SELECT order.orderDate FROM ItemsEntity WHERE itemId = :itemId", String.class);
            query.setParameter("itemId", itemId);
            System.out.println(query.uniqueResult());
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
