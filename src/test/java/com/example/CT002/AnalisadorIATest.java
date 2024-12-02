package com.example.CT002;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AnalisadorIATest {
    
    @Test
     public void testAnaliseDeDadosPorIA() {
        // Pré-condições: sistema configurado para análise de risco
        AnalisadorIA analisador = new AnalisadorIA();

        // Roteiro de Teste: simular anomalias nos dados
        analisador.analisarDados("Pressão Arterial", 145); // Exemplo: pressão arterial elevada
        analisador.analisarDados("Saturação de Oxigênio", 88); // Exemplo: saturação baixa

        // Verificar se as variações foram classificadas corretamente
        assertEquals("Crítico", analisador.getAlerta("Pressão Arterial"));
        assertEquals("Crítico", analisador.getAlerta("Saturação de Oxigênio"));

        // Verificar se os alertas foram gerados corretamente
        assertNotNull(analisador.getTodosAlertas().get("Pressão Arterial"));
        assertNotNull(analisador.getTodosAlertas().get("Saturação de Oxigênio"));

        // Verificar se todas as anomalias foram registradas
        assertEquals(2, analisador.getTodosAlertas().size());
    }
}
