package com.service.eCommerceStarter.utils.Classes;

public class User extends Thread {

    Purchase purchase;
    int availableQuantity;
    int requestedQuantity;
    boolean validity = true;

    public User(Purchase purchase, int availableQuantity, int requestedQuantity) {
        this.purchase = purchase;
        this.availableQuantity = availableQuantity;
        this.requestedQuantity = requestedQuantity;
    }

    @Override
    public void run() {
        boolean status = purchase.reserveProduct(availableQuantity, requestedQuantity);
        if(!status) {
            validity = false;
        }else {
            validity = true;
        }
    }

    public boolean getValidity() {
        return validity;
    }
}
