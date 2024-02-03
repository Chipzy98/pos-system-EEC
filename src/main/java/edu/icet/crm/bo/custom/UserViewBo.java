package edu.icet.crm.bo.custom;

import edu.icet.crm.bo.SuperBo;
import edu.icet.crm.dto.UserDto;

import java.util.List;
public interface UserViewBo extends SuperBo {
    List<UserDto> getUsers();
    boolean addUser(UserDto userDto);
    boolean deleteUser(String userId);
    int getLastUserId();
}
