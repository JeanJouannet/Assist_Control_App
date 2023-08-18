package com.rule1.assist_control_app.entity;

import java.util.ArrayList;
import java.util.List;

public class ContractType {
    public static final String PARCIAL = "Parcial";
    public static final String COMPLETO = "Completo";


    private static List<String> customContracts = new ArrayList<>();

    public static void addCustomContract(String contract) {
        customContracts.add(contract);
    }

    public static List<String> obtenerContratosPersonalizados() {
        return customContracts;
    }
}

