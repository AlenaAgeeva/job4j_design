package ru.job4j.lsp.first;

public class PointsRedeemer {
    protected Account account;

    public PointsRedeemer(Account account) {
        this.account = account;
    }

    public double redeem(double points) throws Exception {
        if (points == 0.) {
            throw new Exception("Account has no points for redemption");
        } else {
            updatePoints();
        }
        return account.getPoints();
    }

    void updatePoints() {
        account.setPoints(0.);
    }
}
