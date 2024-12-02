package com.example.CT008;

import com.example.CT001.SensorBiometrico;

public class AlertaCritico {
    private SistemaNotificacao sistemaNotificacao;

    public AlertaCritico(SistemaNotificacao sistemaNotificacao) {
        this.sistemaNotificacao = sistemaNotificacao;
    }

    public void verificarSensor(SensorBiometrico sensor) {
        if (sensor.getTipo().equals("Oxímetro") && sensor.getLeituraAtual() < 90.0) {
            String mensagem = "Alerta Crítico: Saturação de oxigênio baixa (" + sensor.getLeituraAtual() + "%).";
            sistemaNotificacao.adicionarNotificacao("SMS", mensagem);
            sistemaNotificacao.adicionarNotificacao("E-mail", mensagem);
            sistemaNotificacao.adicionarNotificacao("Aplicativo Móvel", mensagem);
        }
    }
}
