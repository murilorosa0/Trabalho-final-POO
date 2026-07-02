package main;

import domain.model.State;
import domain.service.TaxCalculator;
import ui.UiInitializer;

public class Main {

    public static TaxCalculator taxCalculator;

    static void main(String[] args) {

        taxCalculator = new TaxCalculator();
        new UiInitializer();


    }


}
