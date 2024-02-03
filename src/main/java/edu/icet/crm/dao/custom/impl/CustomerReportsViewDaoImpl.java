package edu.icet.crm.dao.custom.impl;


import edu.icet.crm.dao.custom.CustomerReportsViewDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerReportsViewDaoImpl implements CustomerReportsViewDao {

    @Override
    public List<CustomerEntity> getAllCustomers() {
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createQuery("FROM CustomerEntity");
            List<CustomerEntity> list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();

            CustomerEntity customer = session.get(CustomerEntity.class, customerId);

            if (customer != null) {
                session.delete(customer);
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
