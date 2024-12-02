package com.example.CT003;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SistemaDeAlertaTest {
    @Test
    public void testEnvioDeAlertaParaProfissionaisDeSaude() {
        // Pré-condições: sistema configurado para envio de alertas
        SistemaDeAlertas sistema = new SistemaDeAlertas();
        

        // Roteiro de Teste: simular queda nos níveis de oxigênio
        String paciente = "Paciente 001";
        String mensagem = "Alerta Crítico: Saturação de oxigênio abaixo de 90%.";

        sistema.enviarAlerta(mensagem, paciente);

        // Verificar se o alerta foi enviado
        assertEquals(1, sistema.getAlertasEnviados().size());

        // Verificar se o alerta contém as informações corretas
        Alerta alerta = sistema.getAlertasEnviados().get(0);
        assertNotNull(alerta);
        assertEquals(mensagem, alerta.getMensagem());
        assertEquals(paciente, alerta.getPaciente());

        // Verificar se o alerta foi enviado dentro de um tempo aceitável
        long tempoAtual = System.currentTimeMillis();
        long diferenca = tempoAtual - alerta.getTimestamp();
        assertTrue(diferenca <= 10000, "O alerta deve ser enviado em até 10 segundos.");
        
    }
}
