package org.example.mobile;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            return false;
        }
        // İsim varsa ve yeni isim başka bir kayıt ile çakışıyorsa engelle
        int existingContactPosition = findContact(newContact.getName());
        if (existingContactPosition >= 0 && existingContactPosition != position) {
            return false;
        }
        myContacts.set(position, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            return false;
        }
        myContacts.remove(position);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact c = myContacts.get(i);
            if (c.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact c : myContacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}
