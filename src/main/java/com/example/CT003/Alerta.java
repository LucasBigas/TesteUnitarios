package com.example.CT003;

public class Alerta {
    private String mensagem;
    private String paciente;
    private long timestamp;

    public Alerta(String mensagem, String paciente) {
        this.mensagem = mensagem;
        this.paciente = paciente;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getPaciente() {
        return paciente;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
