package com.example.CT007;

import com.example.CT001.SensorBiometrico;

public class MonitorCardiaco extends SensorBiometrico {
    public MonitorCardiaco() {
        super("Monitor Cardíaco");
    }

    public boolean validarDados() {
        double leitura = getLeituraAtual();
        return leitura >= 40 && leitura <= 180; // Frequência cardíaca típica
    }
}
