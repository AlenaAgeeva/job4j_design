package ru.job4j.lsp.first;

import java.util.Calendar;

public class VipPointsRedeemer extends PointsRedeemer {
    public VipPointsRedeemer(Account account) {
        super(account);
    }

    @Override
    public double redeem(double points) throws Exception {
        if (points == 0.) {
            throw new Exception("Account has no points for redemption");
        } else if (points < 10000.) {
            throw new Exception("Account has no enough points for redemption");
        } else {
            super.updatePoints();
        }
        return account.getPoints();
    }

    public static void main(String[] args) throws Exception {
        Account account = new Account("Oleg", "Ivanov", 12345678, 3899., Calendar.getInstance());
        PointsRedeemer pointsRedeemer = new VipPointsRedeemer(account);
        System.out.println(account.getPoints());
        System.out.println(pointsRedeemer.redeem(account.getPoints()));
        System.out.println(account.getPoints());
    }
}
