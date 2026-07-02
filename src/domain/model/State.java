package domain.model;

public enum State {

    AC("Acre"),
    AL("Alagoas"),
    AM("Amazonas"),
    AP("Amapá"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MG("Minas Gerais"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),
    PA("Pará"),
    PB("Paraíba"),
    PE("Pernambuco"),
    PI("Piauí"),
    PR("Paraná"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RO("Rondônia"),
    RR("Roraima"),
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    SE("Sergipe"),
    SP("São Paulo"),
    TO("Tocantins");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static State getStateByName(String name) {
        if (name == null) return null;
        for (State s : State.values()) {
            if (s.getName().equalsIgnoreCase(name.trim())) {
                return s;
            }
        }
        return null;
    }

}
