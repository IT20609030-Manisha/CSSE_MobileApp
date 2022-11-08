package com.example.dd;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginUtilsTest {

    private LoginUtils utils = new LoginUtils();

    @Test
    public void inputValidEmailAddress() throws Exception {
        assertTrue(utils.isValidEmailAddress("admin@gmail.com"));
    }

    @Test
    public void InvalidEmailAddressFails() throws Exception{
        assertTrue(!utils.isValidEmailAddress("invalid"));
    }

    @Test
    public void localPartLengthForValidEmailAddress() throws Exception{
        assertEquals(1, utils.getLocalPartLength("a@b.com"));
    }

    @Test
    public void emptyUserName() throws Exception{
        assertFalse(utils.validLogin("", "123"));
    }

    @Test
    public void checkDeliveryNote() throws Exception{
        assertFalse(utils.checkdeliveryNote("1", ""));
    }

    @Test
    public void checkProduct() throws Exception{
        assertFalse(utils.checkProductDetails("sand", "", 23000, "CC Hardware"));
    }


}