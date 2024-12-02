package com.example.CT006;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GeradorRelatorioTest {
    @Test
    public void testGeracaoRelatorioTexto() throws IOException {
        // Configuração do relatório
        RelatorioPaciente relatorio = new RelatorioPaciente("João Silva");
        relatorio.adicionarSinalVital("Frequência Cardíaca: 80 bpm");
        relatorio.adicionarSinalVital("Saturação de Oxigênio: 98%");
        relatorio.adicionarSinalVital("Pressão Arterial: 120/80 mmHg");
        relatorio.adicionarAlerta("Frequência cardíaca acima do normal às 14:00.");
        relatorio.adicionarAlerta("Queda de saturação às 16:00.");

        // Gerar o relatório
        GeradorRelatorio gerador = new GeradorRelatorio();
        String caminhoArquivo = "relatorio_joao_silva.txt";
        gerador.exportarRelatorioComoTexto(relatorio, caminhoArquivo);
        

        // Verificar se o arquivo foi gerado corretamente
        File arquivo = new File(caminhoArquivo);
        assertTrue(arquivo.exists());
        assertTrue(arquivo.length() > 0);

        // Limpar o arquivo após o teste
        arquivo.delete();
    }
}
