package com.example.CT008;

import com.example.CT001.SensorBiometrico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertaCriticoTest {

    @Test
    public void testEnvioNotificacoesCriticas() {
        // Configuração
        SistemaNotificacao sistema = new SistemaNotificacao();
        AlertaCritico alerta = new AlertaCritico(sistema);
        SensorBiometrico oximetro = new SensorBiometrico("Oxímetro");

        // Simulação de leitura crítica
        oximetro.ColetarDados(85.0);
        alerta.verificarSensor(oximetro);

        // Verificar notificações
        assertFalse(sistema.getNotificacoes().isEmpty());
        sistema.enviarNotificacoes();
        assertTrue(sistema.todasNotificacoesEnviadas());

        // Validar canais e mensagens
        assertEquals(3, sistema.getNotificacoes().size());
        assertTrue(sistema.getNotificacoes().stream().anyMatch(n -> n.getCanal().equals("SMS")));
        assertTrue(sistema.getNotificacoes().stream().anyMatch(n -> n.getCanal().equals("E-mail")));
        assertTrue(sistema.getNotificacoes().stream().anyMatch(n -> n.getCanal().equals("Aplicativo Móvel")));
    }
}
