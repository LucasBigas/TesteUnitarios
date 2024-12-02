package com.example.CT006;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorRelatorio {
    public void exportarRelatorioComoTexto(RelatorioPaciente relatorio, String caminhoArquivo) throws IOException {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write(relatorio.gerarRelatorioTexto());
        }
    }

    // Simulação para exportação futura em PDF ou Excel
    public void exportarRelatorioComoPDF(RelatorioPaciente relatorio) {
        // Simular integração com uma biblioteca de PDF como Apache PDFBox
        System.out.println("Relatório exportado como PDF.");
    }

    public void exportarRelatorioComoExcel(RelatorioPaciente relatorio) {
        // Simular integração com bibliotecas como Apache POI para Excel
        System.out.println("Relatório exportado como Excel.");
    }
}
