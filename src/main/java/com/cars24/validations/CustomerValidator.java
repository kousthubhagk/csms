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
        validateCustomerPhone(customerProfileReq.getPhone());
        validateCustomerEmail(customerProfileReq.getEmail());
    }

    public static void validateDeletion(DeleteCustomerReq deleteCustomerReq) {
        validateCustomerPhone(deleteCustomerReq.getPhone());
        validateCustomerEmail(deleteCustomerReq.getEmail());
    }

    private static void validateCustomerName(String name){
        if (name == null){
            throw new IllegalArgumentException("Name cannot be EMPTY");
        }
        if (name.length() < 3 || name.length() >100){
            throw new IllegalArgumentException("Name should be min 3 chars or 100 chars max");
        }


    }

    private static void validateCustomerPhone(String phone) {
        String regex = "^[6789]\\d{9}$";
        if (!phone.matches(regex)) {
            throw new IllegalArgumentException("Phone number should start with 6, 7, 8, or 9 and must be 10 digits long.");
        }
    }

    private static void validateCustomerEmail(String email){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(!email.matches(regex)){
            throw new IllegalArgumentException("Email id is not valid");
        }
//            return "";
    }

    private static void validateCustomerAddress(String address) {
        String regex = "^[a-zA-Z0-9\\s,.-]+$";
        if (!address.matches(regex)) {
            throw new IllegalArgumentException("Invalid address. Address can include letters, numbers, spaces, commas, periods, and dashes.");
        }
    }


}
