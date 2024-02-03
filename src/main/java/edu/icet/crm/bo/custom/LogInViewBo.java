package edu.icet.crm.bo.custom;

import edu.icet.crm.bo.SuperBo;
import edu.icet.crm.dto.UserDto;

import java.util.List;

public interface LogInViewBo extends SuperBo {
    List<UserDto> getUsers();
    boolean updatePassword(String email, String newPassword);
}
