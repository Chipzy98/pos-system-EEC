package edu.icet.crm.bo.custom.impl;

import edu.icet.crm.bo.custom.LogInViewBo;
import edu.icet.crm.dao.DaoFactory;
import edu.icet.crm.dao.custom.LogInViewDao;
import edu.icet.crm.dao.util.DaoType;
import edu.icet.crm.dto.UserDto;
import edu.icet.crm.entity.UsersEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LogInViewBoImpl implements LogInViewBo {
    private LogInViewDao logInViewDao= DaoFactory.getInstance().getDao(DaoType.LOGIN_VIEW_DAO);
    @Override
    public List<UserDto> getUsers() {
        List<UsersEntity> usersEntities = logInViewDao.getAllUsers();
        return usersEntities.stream()
                .map(userEntity -> new UserDto(
                        userEntity.getUserId(),
                        userEntity.getUserName(),
                        userEntity.getPassword(),
                        userEntity.getRole()
                ))
                .collect(Collectors.toList());
    }
    @Override
    public boolean updatePassword(String email, String newPassword) {
        return logInViewDao.updatePassword(email,newPassword);
    }
}
