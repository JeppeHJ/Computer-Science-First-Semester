package Opgave4;

import java.time.LocalDate;

public class TestApp {
    public static void main(String[] args) {
        Kollegie k1 = new Kollegie("Din mors kollegie","Istedgade 30");

        Bolig bolig1 = k1.createBolig(30,"Istedgade 30 ST1", 300);
        Bolig bolig2 = k1.createBolig(35,"Istedgade 30 ST2", 400);
        Bolig bolig3 = k1.createBolig(36,"Istedgade 30 ST3", 401);
        Bolig bolig4 = k1.createBolig(37,"Istedgade 30 ST4", 402);
        Bolig bolig5 = k1.createBolig(38,"Istedgade 30 ST5", 403);

        Lejeaftale l1 = bolig1.createLejeAftale(LocalDate.of(2022,11,1));
        l1.setToDate(LocalDate.of(2022, 11, 6));
        Lejeaftale l2 = bolig1.createLejeAftale(LocalDate.of(2022,11,30));

        Lejeaftale l3 = bolig2.createLejeAftale(LocalDate.of(2022,11,1));
        l3.setToDate(LocalDate.of(2022, 11, 6));
        Lejeaftale l4 = bolig2.createLejeAftale(LocalDate.of(2022,11,30));

        Lejeaftale l5 = bolig3.createLejeAftale(LocalDate.of(2022,11,1));
        l5.setToDate(LocalDate.of(2022, 11, 6));
        Lejeaftale l6 = bolig3.createLejeAftale(LocalDate.of(2022,11,30));

        Lejeaftale l7 = bolig4.createLejeAftale(LocalDate.of(2022,11,1));
        l7.setToDate(LocalDate.of(2022, 11, 6));
        Lejeaftale l8 = bolig4.createLejeAftale(LocalDate.of(2022,11,30));

        Lejeaftale l9 = bolig5.createLejeAftale(LocalDate.of(2022,11,1));
        l9.setToDate(LocalDate.of(2022, 11, 6));
        Lejeaftale l10 = bolig5.createLejeAftale(LocalDate.of(2022,11,30));

        System.out.println(k1.getAntalLejeAftaler());
        System.out.println(k1.gennemsnitligAntalDage());

    }
}
