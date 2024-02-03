package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.dto.UserDto;
import edu.icet.crm.entity.UsersEntity;

import java.util.List;

public interface UsersViewDao extends SuperDao {
    List<UsersEntity> getAllUsers();
    boolean addUser(UserDto userDto);
    boolean deleteUser(String userId);
    String getLastUserId();

}
