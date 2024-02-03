package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.PlaceOrderDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.dto.OrderDetailsDto;
import edu.icet.crm.dto.PlaceOrderDto;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.ItemsEntity;
import edu.icet.crm.entity.OrdersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderDaoImpl implements PlaceOrderDao {

    public String getLastOrderId() {
        String hql = "SELECT o.orderId FROM OrdersEntity o ORDER BY o.orderId DESC";

        try (Session session = HibernateUtil.getSession()) {
            Query<String> query = session.createQuery(hql, String.class);
            query.setMaxResults(1);

            List<String> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLastCustomerId() {
        String hql = "SELECT c.customerId FROM CustomerEntity c ORDER BY c.customerId DESC";

        try (Session session = HibernateUtil.getSession()) {
            Query<String> query = session.createQuery(hql, String.class);
            query.setMaxResults(1);

            List<String> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLastItemId() {
        String hql = "SELECT i.itemId FROM ItemsEntity i ORDER BY i.itemId DESC";

        try (Session session = HibernateUtil.getSession()) {
            Query<String> query = session.createQuery(hql, String.class);
            query.setMaxResults(1);

            List<String> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(PlaceOrderDto placeOrderDto) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Save Customer
            CustomerEntity customerEntity = new CustomerEntity(
                    placeOrderDto.getCustomerId(),
                    placeOrderDto.getCustomerName(),
                    placeOrderDto.getEmail(),
                    placeOrderDto.getContactNumber()
            );
            session.save(customerEntity);

            // Save Order
            OrdersEntity ordersEntity = new OrdersEntity(
                    placeOrderDto.getOrderId(),
                    placeOrderDto.getDate(),
                    placeOrderDto.getNote(),
                    "PENDING"
            );
            ordersEntity.setCustomer(customerEntity);
            session.save(ordersEntity);

            // Save Items
            List<ItemsEntity> itemsEntities = new ArrayList<>();
            for (OrderDetailsDto dto : placeOrderDto.getOrderDetailsDtoList()) {
                ItemsEntity itemsEntity = new ItemsEntity(
                        dto.getItemCode(),
                        dto.getItemName(),
                        dto.getCategory(),
                        "PENDING"
                );
                itemsEntity.setOrder(ordersEntity);
                itemsEntities.add(itemsEntity);
                session.save(itemsEntity);
            }

            transaction.commit();
        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
