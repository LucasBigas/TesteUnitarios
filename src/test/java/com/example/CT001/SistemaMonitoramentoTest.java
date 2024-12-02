package com.example.CT001;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SistemaMonitoramentoTest {
    
    @Test
    public void testColetaDeDadosDosSensores() {
        // Pré-condições: sensores configurados e sistema operacional
        SensorBiometrico sensorCardiaco = new SensorBiometrico("Frequência Cardíaca");
        SensorBiometrico sensorOxigenio = new SensorBiometrico("Saturação de Oxigênio");

        SistemaMonitoramento sistema = new SistemaMonitoramento();

        // Roteiro de Teste: dados coletados pelos sensores
        sensorCardiaco.ColetarDados(75.5);// Exemplo: 75.5 bpm
        sensorOxigenio.ColetarDados(98.2); // Exemplo: 98.2%

        sistema.registrarDados(sensorCardiaco);
        sistema.registrarDados(sensorOxigenio);

        // Verificação dos dados registrados
        assertEquals(75.5, sistema.getDadoSensor("Frequência Cardíaca"), 0.1);
        assertEquals(98.2, sistema.getDadoSensor("Saturação de Oxigênio"), 0.1);

        // Verificação de disponibilidade em tempo real
        assertTrue(sistema.getTodosDados().containsKey("Frequência Cardíaca"));
        assertTrue(sistema.getTodosDados().containsKey("Saturação de Oxigênio"));

        // Resultados esperados: dados precisos e disponíveis
        assertNotNull(sistema.getDadoSensor("Frequência Cardíaca"));
        assertNotNull(sistema.getDadoSensor("Saturação de Oxigênio"));
    }
    
}
