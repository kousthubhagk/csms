package com.cars24.dao;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomersDao {
    String createCustomer(AddCustomerReq addCustomerReq);
    CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq);
    CustomerProfileRes updateCustomer(CustomerProfileReq customerProfileReq);
    String deleteCustomer(DeleteCustomerReq deleteCustomerReq);
}
