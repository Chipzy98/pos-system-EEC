package edu.icet.crm.bo.custom;

import edu.icet.crm.bo.SuperBo;
import edu.icet.crm.dto.CustomerDto;

import java.util.List;

public interface CustomerReportsViewBo extends SuperBo {
    List<CustomerDto> getCustomers();
    boolean deleteCustomer(String id);
}
