package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.entity.UsersEntity;

import java.util.List;

public interface LogInViewDao extends SuperDao {
    boolean updatePassword(String email, String newPassword);
    List<UsersEntity> getAllUsers();
}
