package com.example.CT007;

import com.example.CT001.SensorBiometrico;

public class Oximetro extends SensorBiometrico {
    public Oximetro() {
        super("Oxímetro");
    }

    public boolean validarDados() {
        double leitura = getLeituraAtual();
        return leitura >= 70 && leitura <= 100; // Intervalo típico de saturação de oxigênio
    }
}
