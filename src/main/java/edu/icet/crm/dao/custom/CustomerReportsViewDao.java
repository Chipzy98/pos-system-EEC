package edu.icet.crm.dao.custom;

import edu.icet.crm.dao.SuperDao;
import edu.icet.crm.entity.CustomerEntity;

import java.util.List;

public interface CustomerReportsViewDao extends SuperDao {
    List<CustomerEntity> getAllCustomers();
    boolean deleteCustomer(String id);
}
