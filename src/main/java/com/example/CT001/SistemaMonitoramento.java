package com.example.CT001;
import java.util.HashMap;
import java.util.Map;

public class SistemaMonitoramento {
    private HashMap<String, Double> dadosSensores = new HashMap<>();

    public void registrarDados(SensorBiometrico sensor){
        dadosSensores.put(sensor.getTipo(), sensor.getLeituraAtual());
    }

    public Double getDadoSensor(String tipo) {
        return dadosSensores.get(tipo);
    }

    public Map<String, Double> getTodosDados() {
        return dadosSensores;
    }

    // Método para simular atualização contínua dos dados em tempo real
    public void atualizarDadosEmTempoReal(SensorBiometrico sensor, double leitura) {
        sensor.ColetarDados(leitura);
        registrarDados(sensor);
    }

}
