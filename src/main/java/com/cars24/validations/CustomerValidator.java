package com.cars24.validations;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;

public class CustomerValidator {
    public static void validateAddCustomerRequest(AddCustomerReq addCustomerReq) {
//        database calling is expensive hence checking has to be done way before
//        dividing into smaller pieces
        validateCustomerName(addCustomerReq.getName());
        validateCustomerPhone(addCustomerReq.getPhone());
        validateCustomerEmail(addCustomerReq.getEmail());
        validateCustomerAddress(addCustomerReq.getAddress());
    }

    public static void validateRequest(CustomerProfileReq customerProfileReq) {
        if ((customerProfileReq.getPhone() == null || customerProfileReq.getPhone().isBlank()) &&
                (customerProfileReq.getEmail() == null || customerProfileReq.getEmail().isBlank())) {
            throw new IllegalArgumentException("Either phone or email must be provided.");
        }

        // Validate individually if present
        if (customerProfileReq.getPhone() != null && !customerProfileReq.getPhone().isBlank()) {
            validateCustomerPhone(customerProfileReq.getPhone());
        }
        if (customerProfileReq.getEmail() != null && !customerProfileReq.getEmail().isBlank()) {
            validateCustomerEmail(customerProfileReq.getEmail());
        }
    }


    public static void validateDeletion(DeleteCustomerReq deleteCustomerReq) {
        validateCustomerPhone(deleteCustomerReq.getPhone());
        validateCustomerEmail(deleteCustomerReq.getEmail());
    }

    private static void validateCustomerName(String name) {
        if (name != null) { // Only validate if the name is provided
            if (name.length() < 3 || name.length() > 100) {
                throw new IllegalArgumentException("Name should be min 3 chars or 100 chars max");
            }
        }
    }

    public static void validateCustomerPhone(String phone) {
        if (phone != null) { // Only validate if the phone is provided
            String regex = "^[6789]\\d{9}$";
            if (!phone.matches(regex)) {
                throw new IllegalArgumentException("Phone number should start with 6, 7, 8, or 9 and must be 10 digits long.");
            }
        }
    }

    public static void validateCustomerEmail(String email) {
        if (email != null) { // Only validate if the email is provided
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (!email.matches(regex)) {
                throw new IllegalArgumentException("Email id is not valid");
            }
        }
    }

    private static void validateCustomerAddress(String address) {
        if (address != null) { // Only validate if the address is provided
            String regex = "^[a-zA-Z0-9\\s,.-]+$";
            if (!address.matches(regex)) {
                throw new IllegalArgumentException("Invalid address. Address can include letters, numbers, spaces, commas, periods, and dashes.");
            }
        }
    }



}
