package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.validations.CustomerValidator;

import java.util.Scanner;

public class Ui {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerServiceImpl customerServices = new CustomerServiceImpl();

    public static void addCustomer() {
        System.out.println("\nEnter customer details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        AddCustomerReq req = new AddCustomerReq();
        req.setName(name);
        req.setPhone(phone);
        req.setEmail(email);
        req.setAddress(address);

        String result = customerServices.registerCustomer(req);
        System.out.println(result);
    }

    public static void getCustomer() {
//        CustomerValidator customerValidator = new CustomerValidator();
        System.out.println("\nEnter customer details to search:");
        System.out.print("Email (leave blank if using phone): ");
        String email = scanner.nextLine();

        System.out.print("Phone (leave blank if using email): ");
        String phone = scanner.nextLine();

        // Ensure at least one identifier is provided
        if ((email.isEmpty() || email.isBlank()) && (phone.isEmpty() || phone.isBlank())) {
            System.out.println("Please provide either an email or a phone number to search.");
            return;
        }

        // Only validate if email or phone is provided
        try {
            if (!email.isEmpty()) {
                CustomerValidator.validateCustomerEmail(email);
            }
            if (!phone.isEmpty()) {
                CustomerValidator.validateCustomerPhone(phone);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
            return;
        }

        // Create request object
        CustomerProfileReq req = new CustomerProfileReq();
        req.setEmail(email.isEmpty() ? null : email); // Null if blank
        req.setPhone(phone.isEmpty() ? null : phone);

        // Fetch customer profile
        CustomerProfileRes result = customerServices.getCustomerProfile(req);

        if (result != null) {
            System.out.println("\nCustomer Found:");
            System.out.println("Name: " + result.getName());
            System.out.println("Phone: " + result.getPhone());
            System.out.println("Email: " + result.getEmail());
            System.out.println("Address: " + result.getAddress());
        } else {
            System.out.println("Customer not found!");
        }
    }



    public static void updateCustomer() {
        System.out.println("\nEnter either the email or phone of the customer to update:");
        System.out.print("Email (leave blank if using phone): ");
        String email = scanner.nextLine();

        System.out.print("Phone (leave blank if using email): ");
        String phone = scanner.nextLine();

        // Ensure at least one identifier is provided
        if (email.isEmpty() && phone.isEmpty()) {
            System.out.println("Please provide either an email or a phone number to identify the customer.");
            return;
        }

        System.out.println("Enter new details (leave blank to keep unchanged):");

        System.out.print("New Name (leave blank to keep unchanged): ");
        String name = scanner.nextLine();

        System.out.print("New Phone (leave blank to keep unchanged): ");
        String newPhone = scanner.nextLine();

        System.out.print("New Address (leave blank to keep unchanged): ");
        String address = scanner.nextLine();

        // Prepare the request object
        AddCustomerReq req = new AddCustomerReq();
        CustomerProfileReq preq = new CustomerProfileReq();
        preq.setEmail(email.isEmpty() ? null : email); // Set email only if provided
        preq.setPhone(phone.isEmpty() ? null : phone); // Set phone only if provided
        req.setName(name.isEmpty() ? null : name);     // Set name only if provided
        req.setPhone(newPhone.isEmpty() ? null : newPhone);
        req.setAddress(address.isEmpty() ? null : address);

        // Call the service layer to perform the update
        CustomerProfileRes result = customerServices.updateCustomer(preq);
        System.out.println(result);
    }

    public static void deleteCustomer() {
        System.out.println("\nEnter either the email or phone of the customer to delete:");
        System.out.print("Email (leave blank if using phone): ");
        String email = scanner.nextLine();

        System.out.print("Phone (leave blank if using email): ");
        String phone = scanner.nextLine();

        // Ensure at least one identifier is provided
        if (email.isEmpty() && phone.isEmpty()) {
            System.out.println("Please provide either an email or a phone number to identify the customer.");
            return;
        }

        // Prepare the request object
        DeleteCustomerReq dreq = new DeleteCustomerReq();
        dreq.setEmail(email.isEmpty() ? null : email); // Set email only if provided
        dreq.setPhone(phone.isEmpty() ? null : phone); // Set phone only if provided

        // Call the service layer to perform the delete operation
        String result = customerServices.deleteCustomer(dreq);
        System.out.println(result);
    }


}