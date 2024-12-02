package com.example.CT006;

import java.util.ArrayList;
import java.util.List;

public class RelatorioPaciente {
    private String nomePaciente;
    private List<String> sinaisVitais = new ArrayList<>();
    private List<String> alertas = new ArrayList<>();

    public RelatorioPaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void adicionarSinalVital(String sinal) {
        sinaisVitais.add(sinal);
    }

    public void adicionarAlerta(String alerta) {
        alertas.add(alerta);
    }

    public String gerarRelatorioTexto() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório do Paciente: ").append(nomePaciente).append("\n");
        relatorio.append("=======================================\n");
        relatorio.append("Sinais Vitais:\n");
        for (String sinal : sinaisVitais) {
            relatorio.append("- ").append(sinal).append("\n");
        }
        relatorio.append("\nAlertas:\n");
        for (String alerta : alertas) {
            relatorio.append("- ").append(alerta).append("\n");
        }
        relatorio.append("=======================================\n");
        return relatorio.toString();
    }
}
