package com.example.dd;

public class LoginUtils {

    /**
     * This method checks if the input is a valid email address
     *
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email){
        boolean hasAtSign = email.indexOf("@") > -1;

        return hasAtSign;
    }

    /**
     * This method returns the length of the local part of an email address
     * @param email
     * @return
     */
    public int getLocalPartLength(String email){
        int start = email.indexOf("@");
        String localPart = email.substring(0, start);
        return localPart.length();
    }

    /**
     * This method will check whether the both username and
     * password inputs before the login
     *
     * @param username
     * @param password
     * @return
     */
    public boolean validLogin(String username, String password){
        if(username.isEmpty() || password.isEmpty()){
            return false;
        }

        if (password.length() < 2){
            return false;
        }

        return true;
    }

    /**
     * This method will check whether the delivery notice is
     * submitting with the OrderId and delivery note
     *
     * @param OrderId
     * @param note
     * @return
     */
    public boolean checkdeliveryNote (String OrderId, String note){
        if(OrderId.isEmpty() ||  note.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * This method will check whether the product  is
     * submitting with all the details
     *
     * @param ProName
     * @param des
     * @param price
     * @param supplier
     * @return
     */
    public boolean checkProductDetails(String ProName, String des, double price, String supplier){
        if(ProName.isEmpty() || des.isEmpty() || supplier.isEmpty()){
            return false;
        }
        return true;
    }
}
