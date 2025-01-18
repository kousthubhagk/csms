package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.validations.CustomerValidator;

public class CustomerServiceImpl implements CustomerService {
    CustomerDaoImpl customerDao = new CustomerDaoImpl();
    CustomerValidator customerValidator = new CustomerValidator();

    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {
            customerValidator.validateAddCustomerRequest(addCustomerReq);
            customerDao.createCustomer(addCustomerReq);
            return "Customer registered successfully.";
        } catch (Exception e) {
            return "Error during customer registration: " + e.getMessage();
        }
    }


    @Override
    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq) {
        CustomerDaoImpl cust_dao = new CustomerDaoImpl();

        customerValidator.validateRequest(customerProfileReq);

        CustomerProfileRes response = cust_dao.getCustomer(customerProfileReq);

        return response;
    }

    @Override
    public CustomerProfileRes updateCustomer(CustomerProfileReq customerProfileReq) {
        return null;
    }

    @Override
    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq) {
        CustomerDaoImpl cust_dao = new CustomerDaoImpl();

        customerValidator.validateDeletion(deleteCustomerReq);

        String response = cust_dao.deleteCustomer(deleteCustomerReq);
        return response;
    }


}
