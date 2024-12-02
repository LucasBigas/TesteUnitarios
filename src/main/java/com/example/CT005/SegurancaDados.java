package com.example.CT005;
import java.util.HashMap;
import java.util.Map;

public class SegurancaDados {
    private Map<String, String> dadosCriptografados = new HashMap<>();
    private Map<String, String> historicoAcessos = new HashMap<>();
    private String chaveCriptografia = "MinhaChaveSecreta123"; // Simulação de chave de criptografia
    
    // Método para criptografar os dados
    private String criptografar(String dado) {
        return dado + chaveCriptografia; // Simulação simples; usar bibliotecas reais como AES no projeto final
    }
    // Método para armazenar dados de forma criptografada
    public void armazenarDados(String idPaciente, String dado) {
        String dadoCriptografado = criptografar(dado);
        dadosCriptografados.put(idPaciente, dadoCriptografado);
    }
    // Método para acessar os dados de forma segura
    public String acessarDados(String idPaciente, String usuarioAutorizado) {
        if (!isUsuarioAutorizado(usuarioAutorizado)) {
            throw new SecurityException("Usuário não autorizado.");
        }
        registrarAcesso(usuarioAutorizado, idPaciente);
        return dadosCriptografados.get(idPaciente);
    }
    // Verificar se o usuário é autorizado
    private boolean isUsuarioAutorizado(String usuario) {
        // Simulação de autorização; ajustar conforme necessidade
        return usuario.equals("admin") || usuario.equals("medico");
    }
    // Registrar acessos para auditoria
    private void registrarAcesso(String usuario, String idPaciente) {
        historicoAcessos.put(usuario, "Acessou dados do paciente " + idPaciente);
    }
    // Método para obter o histórico de auditoria
    public Map<String, String> getHistoricoAcessos() {
        return historicoAcessos;
    }
}
