package com.example.CT005;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SegurancaDadosTest {
    @Test
    public void testArmazenamentoSeguro() {
        SegurancaDados seguranca = new SegurancaDados();

        // Armazenar dados de forma segura
        seguranca.armazenarDados("paciente1", "Dados Sensíveis");
        seguranca.armazenarDados("paciente2", "Informação Confidencial");

        // Verificar se os dados estão criptografados
        String dadoCriptografado = seguranca.acessarDados("paciente1", "admin");
        assertEquals("Dados SensíveisMinhaChaveSecreta123", dadoCriptografado); // Simulação de criptografia

        // Verificar acesso não autorizado
        assertThrows(SecurityException.class, () -> {
            seguranca.acessarDados("paciente1", "visitante");
        });

        // Verificar auditoria
        seguranca.acessarDados("paciente2", "medico");
        assertEquals("Acessou dados do paciente paciente2", seguranca.getHistoricoAcessos().get("medico"));
    }
}
