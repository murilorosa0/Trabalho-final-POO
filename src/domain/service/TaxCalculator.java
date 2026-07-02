package domain.service;

import domain.model.State;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculator {

    private final Map<State, Double> taxesPerState;

    public TaxCalculator() {
        taxesPerState = new HashMap<State, Double>();
    }

    public void setTaxesPerState(State state, Double tax) {
        this.taxesPerState.put(state, tax);
    }

    public Double getTaxByState(State state) {
        return taxesPerState.get(state);
    }

    public Map<State, Double> getTaxesPerState() {
        return taxesPerState;
    }

    public double calculateValueWithTax() {
        return 0.0;
    }


}
