package ru.job4j.isp.payment;

import java.util.List;

public class BankPayment implements Payment {

    public void initiatePayments() {
    }

    public Object status() {
        return null;
    }

    public List<Object> getPayments() {
        return null;
    }

    @Override
    public void initiateLoanSettlement() {
        throw new UnsupportedOperationException("This is not a loan payment");
    }

    @Override
    public void initiateRePayment() {
        throw new UnsupportedOperationException("This is not a loan payment");
    }
}
