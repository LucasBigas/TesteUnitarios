package com.example.CT007;
import com.example.CT001.SensorBiometrico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaMonitoramentoAvancadoTest {
    @Test
    public void testIntegracaoSensores() {
        SistemaMonitoramentoAvancado sistema = new SistemaMonitoramentoAvancado();
        // Conectar diferentes sensores
        SensorBiometrico oximetro = new Oximetro();
        SensorBiometrico termometro = new Termometro();
        SensorBiometrico monitorCardiaco = new MonitorCardiaco();
        sistema.conectarSensor(oximetro);
        sistema.conectarSensor(termometro);
        sistema.conectarSensor(monitorCardiaco);
        // Atualizar dados
        sistema.atualizarDadosEmTempoReal(oximetro, 95.0);
        sistema.atualizarDadosEmTempoReal(termometro, 36.5);
        sistema.atualizarDadosEmTempoReal(monitorCardiaco, 72.0);
        // Validar os dados coletados
        assertEquals(95.0, sistema.getDadoSensor("Oxímetro"));
        assertEquals(36.5, sistema.getDadoSensor("Termômetro"));
        assertEquals(72.0, sistema.getDadoSensor("Monitor Cardíaco"));
    }
    @Test
    public void testValidacaoDadosInvalidos() {
        SistemaMonitoramentoAvancado sistema = new SistemaMonitoramentoAvancado();
        SensorBiometrico oximetro = new Oximetro();
        sistema.conectarSensor(oximetro);
        // Dados inválidos
        sistema.atualizarDadosEmTempoReal(oximetro, 60.0);
        assertEquals(60.0, sistema.getDadoSensor("Oxímetro"));
    }
    @Test
    public void testSensorInativo() {
        SistemaMonitoramentoAvancado sistema = new SistemaMonitoramentoAvancado();
        SensorBiometrico oximetro = new Oximetro();
        sistema.conectarSensor(oximetro);
        // Sensor inativo
        sistema.verificarSensoresInativos();
    }
}
