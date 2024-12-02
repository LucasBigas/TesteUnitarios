package com.example.CT002;

import java.util.HashMap;
import java.util.Map;

public class AnalisadorIA {
    private HashMap<String , String> alertas = new HashMap<>();

    public void analisarDados(String tipo, double valor) {
        String nivelRisco = avaliarRisco(tipo, valor);
        if (!nivelRisco.equals("Normal")) {
            alertas.put(tipo, nivelRisco);
        }
    }

    private String avaliarRisco(String tipo, double valor) {
        switch (tipo) {
            case "Pressão Arterial":
                if (valor >= 140) return "Crítico";
                if (valor >= 130) return "Moderado";
                return "Leve";
            case "Saturação de Oxigênio":
                if (valor < 90) return "Crítico";
                if (valor < 94) return "Moderado";
                return "Leve";
            default:
                return "Normal";
        }
    }

    public String getAlerta(String tipo) {
        return alertas.get(tipo);
    }

    public Map<String, String> getTodosAlertas() {
        return alertas;
    }
}
