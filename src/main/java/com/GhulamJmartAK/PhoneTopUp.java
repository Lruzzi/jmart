package com.GhulamJmartAK;

/**
 * Class untuk melakukan top up melalui nomor telepon
 * @auhtor Ghulam Izzul Fuad
 */

public class PhoneTopUp extends Invoice{
    public String phoneNumber;
    public Status status;

    public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;

    }

    @Override
    public double getTotalPay(Product product) {
        return product.price * product.discount;
    }
}
