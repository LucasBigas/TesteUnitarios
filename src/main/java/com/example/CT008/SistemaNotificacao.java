package com.example.CT008;

import java.util.ArrayList;
import java.util.List;

public class SistemaNotificacao {
    private List<Notificacao> notificacoes = new ArrayList<>();

    public void adicionarNotificacao(String canal, String mensagem) {
        notificacoes.add(new Notificacao(canal, mensagem));
    }

    public void enviarNotificacoes() {
        for (Notificacao notificacao : notificacoes) {
            notificacao.enviar();
        }
    }

    public boolean todasNotificacoesEnviadas() {
        return notificacoes.stream().allMatch(Notificacao::isEnviada);
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }
}
