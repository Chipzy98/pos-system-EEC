package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.LogInViewDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LogInViewDaoImpl implements LogInViewDao {
    @Override
    public boolean updatePassword(String email, String newPassword) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<UsersEntity> query = session.createQuery("FROM UsersEntity WHERE userName = :userName", UsersEntity.class);
            query.setParameter("userName", email);
            UsersEntity userEntity = query.uniqueResult();

            if (userEntity != null) {

                userEntity.setPassword(hashPassword(newPassword));

                transaction.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    private String hashPassword(String password) {

        return password;
    }
    @Override
    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> userEntities = new ArrayList<>();

        try (Session session = HibernateUtil.getSession()) {
            Query<UsersEntity> query = session.createQuery("FROM UsersEntity", UsersEntity.class);
            userEntities = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userEntities;
    }

}
