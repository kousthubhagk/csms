package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.validations.CustomerValidator;

public class CustomerServiceImpl implements CustomerService {
    CustomerDaoImpl customerDao = new CustomerDaoImpl();
    CustomerValidator customerValidator = new CustomerValidator();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {

//            CustomerValidator customerValidator = new CustomerValidator();
            customerValidator.validateAddCustomerRequest(addCustomerReq);
//        check first before creating customer so as to ensure the data is clean

            customerDao.createCustomer(addCustomerReq);


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq) {
        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
        CustomerProfileRes response = cust_dao.getCustomer(customerProfileReq);
        return response;
    }

    @Override
    public CustomerProfileRes updateCustomer(CustomerProfileReq customerProfileReq) {
        return null;
    }

    @Override
    public String deleteCustomer(CustomerProfileReq customerProfileReq) {
        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
        String response = cust_dao.deleteCustomer(customerProfileReq);
        return response;
    }


}
