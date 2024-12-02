package com.example.CT001;

public class SensorBiometrico {
    private String tipo;
    private double leituraAtual;

    public SensorBiometrico(String tipo) {
        this.tipo = tipo;
    }

    public void ColetarDados(double leitura) {
        this.leituraAtual = leitura;
    }

    public String getTipo() {
        return tipo;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }
 
}
