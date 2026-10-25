/**
 * Representa um sócio ao abrigo de um protocolo empresarial.
 * Indica o nome e o NIF da empresa parceira e tem um desconto fixo de 20%.
 */
public class Socioempresa extends Socio {
    private String nomeEmpresa;
    private String nif;

    /**
     * Construtor da classe
     * @param nome Nome do sócio
     * @param numero Número de sócio (único)
     * @param email E-mail do sócio
     * @param nomeEmpresa Nome da empresa parceira
     * @param nif NIF da empresa parceira
     */
    public Socioempresa(String nome, int numero, String email, String nomeEmpresa, String nif) {
        super(nome, numero, email, 0.20, "Empresa");
        this.nomeEmpresa = nomeEmpresa;
        this.nif = nif;
    }

    /** @return Nome da empresa parceira */
    public String getNomeEmpresa() { return nomeEmpresa; }

    /** @return NIF da empresa parceira */
    public String getNif() { return nif; }

    /**
     * Devolve os dados completos do sócio empresa.
     * @return Dados comuns do sócio, empresa e NIF
     */
    public String getDetalhes() {
        return getInformacaoBase() + " | Empresa: " + nomeEmpresa + " (NIF " + nif + ")";
    }
}