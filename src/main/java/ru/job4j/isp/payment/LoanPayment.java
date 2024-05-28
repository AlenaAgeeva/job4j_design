package ru.job4j.isp.payment;

import java.util.List;

public class LoanPayment implements Payment {

    public void initiatePayments() {
        throw new UnsupportedOperationException("This is not a bank payment");
    }

    public Object status() {
        return null;
    }

    public List<Object> getPayments() {
        return null;
    }

    @Override
    public void initiateLoanSettlement() {
    }

    @Override
    public void initiateRePayment() {
    }
}
