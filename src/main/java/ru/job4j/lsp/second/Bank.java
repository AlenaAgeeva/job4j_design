package ru.job4j.lsp.second;

public class Bank {
    private BankAccount bankAccount;

    public Bank(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    double getCredit(BankAccount bankAccount) throws Exception {
        if (bankAccount.getCreditScore() < 5000.) {
            throw new Exception("Low credit score, credit is declined.");
        } else if (bankAccount.getDeposit() < 45000.) {
            return bankAccount.getDeposit() * bankAccount.getCreditScore() / 10;
        }
        return bankAccount.getDeposit() * bankAccount.getCreditScore() / 4;
    }
}
