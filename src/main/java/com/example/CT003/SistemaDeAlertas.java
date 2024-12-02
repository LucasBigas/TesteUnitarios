package com.example.CT003;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeAlertas {
    private List<Alerta> alertasEnviados = new ArrayList<>();

    public void enviarAlerta(String mensagem, String paciente) {
        Alerta alerta = new Alerta(mensagem, paciente);
        alertasEnviados.add(alerta);
        // Simular envio para os profissionais de saúde (ex.: log)
        System.out.println("Alerta enviado: " + alerta);
    }

    public List<Alerta> getAlertasEnviados() {
        return alertasEnviados;
    }
}
