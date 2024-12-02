package com.example.CT007;

import com.example.CT001.SensorBiometrico;

public class Termometro extends SensorBiometrico {
    public Termometro() {
        super("Termômetro");
    }

    public boolean validarDados() {
        double leitura = getLeituraAtual();
        return leitura >= 35 && leitura <= 42; // Intervalo típico de temperatura corporal (°C)
    }
}
