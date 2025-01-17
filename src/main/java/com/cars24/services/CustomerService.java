package com.cars24.services;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomerService {
    String registerCustomer(AddCustomerReq addCustomerReq);
    CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq);

    CustomerProfileRes updateCustomer(CustomerProfileReq customerProfileReq);
    String deleteCustomer(DeleteCustomerReq deleteCustomerReq);


}
