package edu.icet.crm.dao.custom.impl;

import edu.icet.crm.dao.custom.UsersViewDao;
import edu.icet.crm.dao.util.HibernateUtil;
import edu.icet.crm.dto.UserDto;
import edu.icet.crm.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UsersViewDaoImpl implements UsersViewDao {

    @Override
    public List<UsersEntity> getAllUsers() {
        try (Session session = HibernateUtil.getSession()) {
            Query<UsersEntity> query = session.createQuery("FROM UsersEntity", UsersEntity.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUser(UserDto userDto) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            UsersEntity userEntity = new UsersEntity(
                    userDto.getUserId(),
                    userDto.getUserName(),
                    userDto.getPassword(),
                    userDto.getRole()
            );

            session.save(userEntity);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        try {

            Query<UsersEntity> query = session.createQuery("FROM UsersEntity WHERE userId = :userId", UsersEntity.class);
            query.setParameter("userId", userId);
            UsersEntity userEntity = query.uniqueResult();

            if (userEntity != null) {
                session.delete(userEntity);
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

    @Override
    public String getLastUserId() {
        String hql = "SELECT u.userId FROM UsersEntity u ORDER BY u.userId DESC";

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
}
