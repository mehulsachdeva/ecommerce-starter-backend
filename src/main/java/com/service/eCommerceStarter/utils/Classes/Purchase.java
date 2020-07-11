package com.service.eCommerceStarter.utils.Classes;

public class Purchase {
    synchronized boolean reserveProduct(int availableQuantity, int requestedQuantity) {
        System.out.println(Thread.currentThread().getName() + " entered.");
        System.out.println("Available : " + availableQuantity + " Requested : " + requestedQuantity);
        if(availableQuantity >= requestedQuantity) {
            System.out.println("Product Available. Book now :-)");
            System.out.println(requestedQuantity + " quantity reserved.");
            availableQuantity = availableQuantity - requestedQuantity;
            System.out.println("New available quantity: " + availableQuantity);
            System.out.println(Thread.currentThread().getName() + " leaving.");
            System.out.println("----------------------------------------------");
            return true;
        }else {
            System.out.println("Requested seats not available :-(");
            System.out.println(Thread.currentThread().getName() + " leaving.");
            System.out.println("----------------------------------------------");
            return false;
        }
    }
}