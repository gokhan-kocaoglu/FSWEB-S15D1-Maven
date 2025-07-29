package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    static MobilePhone mobilePhone = new MobilePhone("5551234567");;
    public static void main(String[] args) {
        Contact contact = new Contact("Test", "12345678");
        mobilePhone.addNewContact(new Contact("Test", "12345678"));
        mobilePhone.addNewContact(new Contact("Test2", "123456782"));
        mobilePhone.addNewContact(new Contact("Test3", "123456783"));
        mobilePhone.addNewContact(new Contact("Test4", "123456784"));
        mobilePhone.removeContact(contact);
    }
}
