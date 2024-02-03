package edu.icet.crm.bo.custom.impl;

import edu.icet.crm.bo.custom.CustomerReportsViewBo;
import edu.icet.crm.dao.DaoFactory;
import edu.icet.crm.dao.custom.CustomerReportsViewDao;
import edu.icet.crm.dao.util.DaoType;
import edu.icet.crm.dto.CustomerDto;
import edu.icet.crm.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerReportsViewBoImpl implements CustomerReportsViewBo {
    CustomerReportsViewDao customerReportsViewDao= DaoFactory.getInstance().getDao(DaoType.CUSTOMER_REPORTS_VIEW_DAO);
    public List<CustomerDto> getCustomers(){
        List<CustomerDto> customerDtoList=new ArrayList<>();
        for (CustomerEntity customerEntity:customerReportsViewDao.getAllCustomers()){
            customerDtoList.add(new CustomerDto(
                    customerEntity.getCustomerId(),
                    customerEntity.getCustomerName(),
                    customerEntity.getContactNumber(),
                    customerEntity.getEmailAddress()
            ));
        }
        return customerDtoList;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerReportsViewDao.deleteCustomer(id);
    }
}
