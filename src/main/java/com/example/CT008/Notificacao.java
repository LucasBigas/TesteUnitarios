package com.example.CT008;

public class Notificacao {
    private String canal;
    private String mensagem;
    private boolean enviada;

    public Notificacao(String canal, String mensagem) {
        this.canal = canal;
        this.mensagem = mensagem;
        this.enviada = false;
    }

    public void enviar() {
        System.out.println("Enviando via " + canal + ": " + mensagem);
        this.enviada = true; // Simula o envio da notificação
    }

    public boolean isEnviada() {
        return enviada;
    }

    public String getCanal() {
        return canal;
    }

    public String getMensagem() {
        return mensagem;
    }
}
