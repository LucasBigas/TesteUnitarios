package com.example.CT007;

import com.example.CT001.SensorBiometrico;
import com.example.CT001.SistemaMonitoramento;

import java.util.HashMap;
import java.util.Map;

public class SistemaMonitoramentoAvancado extends SistemaMonitoramento {
    private Map<String, SensorBiometrico> sensores = new HashMap<>();

    public void conectarSensor(SensorBiometrico sensor) {
        sensores.put(sensor.getTipo(), sensor);
    }

    @Override
    public void atualizarDadosEmTempoReal(SensorBiometrico sensor, double leitura) {
        sensor.ColetarDados(leitura);
        if (sensor instanceof Oximetro && !((Oximetro) sensor).validarDados()) {
            System.out.println("Alerta: Dados inválidos para o " + sensor.getTipo());
        } else if (sensor instanceof Termometro && !((Termometro) sensor).validarDados()) {
            System.out.println("Alerta: Dados inválidos para o " + sensor.getTipo());
        } else if (sensor instanceof MonitorCardiaco && !((MonitorCardiaco) sensor).validarDados()) {
            System.out.println("Alerta: Dados inválidos para o " + sensor.getTipo());
        }
        super.registrarDados(sensor);
    }

    public void verificarSensoresInativos() {
        for (String tipo : sensores.keySet()) {
            SensorBiometrico sensor = sensores.get(tipo);
            if (sensor.getLeituraAtual() == 0.0) {
                System.out.println("Alerta: Sensor " + tipo + " está inativo.");
            }
        }
    }
}
