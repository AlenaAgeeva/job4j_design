package ru.job4j.lsp.second;

public class TdBank extends Bank {
    public TdBank(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    double getCredit(BankAccount bankAccount) {
        return bankAccount.getDeposit() * bankAccount.getCreditScore() / 4;
    }
}
