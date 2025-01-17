package com.cars24.runner;

import com.cars24.config.DbConfig;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        System.out.println("Enter choice: ");
        System.out.println("1 for add user");
        System.out.println("2 for get user");
        System.out.println("0 for exit");


        while(exit){
            Integer choice = scanner.nextInt();
            switch (choice){
                case 1: Ui.addCustomer(); break;
                case 2: Ui.getCustomer(); break;
                case 0: exit=false; break;
            }
        }
        */

        System.out.println("Application starts");

//        try {
//            DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
//            System.out.println("Connection successful!");
//        } catch (SQLException e) {
//            System.out.println("Error connecting to the database");
//            throw new RuntimeException(e);
//        }
        //      DbUtil.getDbConnection(); //connected java to db

//        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
//        cust_dao.createCustomer("John Doe", "9876543210", "john.doe@example.com", "Bangalore");



//        CustomerServiceImpl cust_service = new CustomerServiceImpl();

//        AddCustomerReq addCustomerReq = new AddCustomerReq();

//        addCustomerReq.setName("");
//        addCustomerReq.setPhone("");
//        addCustomerReq.setEmail("");
//        addCustomerReq.setAddress("");
//
////        String message = cust_dao.createCustomerV2("Kouu","8861773225","kousthubha.gk@cars24.com", "Bangalore");
//        String message = cust_service.registerCustomer(addCustomerReq);
//        System.out.println(message);
//        cannot do both at once - comment one out





//        dont directly call dao in main
//        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
        CustomerProfileReq req = new CustomerProfileReq();
//        req.setEmail("john.doe@example.com");
//        req.setPhone("9876543210");

        req.setEmail("dummy.joe@example.com");
        req.setPhone("9876555555");

        CustomerServiceImpl serv = new CustomerServiceImpl();
        CustomerProfileRes response = serv.getCustomerProfile(req);
//        DeleteCustomerReq delreq = new DeleteCustomerReq();

//        delreq.setEmail("dummy.joe@example.com");
//        delreq.setPhone("9876555555");
//
//        String response = serv.deleteCustomer(delreq);
//        CustomerProfileRes response = cust_dao.getCustomer(req);
        System.out.println(response);

//        implement the toString method here




        System.out.println("Application stops");
    }


}

