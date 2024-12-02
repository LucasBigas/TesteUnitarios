package com.example.CT004;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.CT001.SensorBiometrico;
import com.example.CT001.SistemaMonitoramento;

public class SistemaMonitoramentoTest {
    @Test
    public void testMonitoramentoEmTempoReal() {
        // Inicializar o sistema e os sensores
        SistemaMonitoramento sistema = new SistemaMonitoramento();
        SensorBiometrico sensorFrequenciaCardiaca = new SensorBiometrico("Frequência Cardíaca");
        SensorBiometrico sensorOxigenio = new SensorBiometrico("Saturação de Oxigênio");
    
        // Coletar os dados inicialmente (aqui você pode definir as leituras iniciais)
        sensorOxigenio.ColetarDados(75.5); // Saturação de oxigênio inicial de 75.5
        sensorFrequenciaCardiaca.ColetarDados(81.0); // Frequência cardíaca inicial de 81 bpm
    
        // Registrar os dados no sistema
        sistema.registrarDados(sensorFrequenciaCardiaca);
        sistema.registrarDados(sensorOxigenio);
    
        // Verificar se os dados foram coletados corretamente
        assertNotNull(sistema.getDadoSensor("Frequência Cardíaca"));
        assertNotNull(sistema.getDadoSensor("Saturação de Oxigênio"));
        assertEquals(81.0, sistema.getDadoSensor("Frequência Cardíaca"));
        assertEquals(75.5, sistema.getDadoSensor("Saturação de Oxigênio"));
    
        // Agora, atualizar os dados em tempo real
        sistema.atualizarDadosEmTempoReal(sensorFrequenciaCardiaca, 83.0); // Atualizando a frequência cardíaca para 83 bpm
        sistema.atualizarDadosEmTempoReal(sensorOxigenio, 95.0); // Atualizando a saturação de oxigênio para 95%
    
        // Verificar se os dados foram atualizados corretamente
        assertEquals(83.0, sistema.getDadoSensor("Frequência Cardíaca"));
        assertEquals(95.0, sistema.getDadoSensor("Saturação de Oxigênio"));
    }
    
}
