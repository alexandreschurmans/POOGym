/**
 * Representa um sócio do ginásio.
 * Guarda os dados comuns a todos os sócios: nome, número, e-mail e desconto.
 */
public class Socio {
    private String nome;
    private int numero;
    private String email;
    private double desconto; // fração: 0.10 = 10%
    private String tipo;     // "Individual" ou "Empresa"

    /**
     * Construtor da classe
     * @param nome Nome do sócio
     * @param numero Número de sócio (único)
     * @param email E-mail do sócio
     * @param desconto Desconto como fração (0.10 = 10%)
     * @param tipo Tipo de sócio ("Individual" ou "Empresa")
     */
    public Socio(String nome, int numero, String email, double desconto, String tipo) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.desconto = desconto;
        this.tipo = tipo;
    }

    /** @return Nome do sócio */
    public String getNome() { return nome; }

    /** @return Número de sócio */
    public int getNumero() { return numero; }

    /** @return E-mail do sócio */
    public String getEmail() { return email; }

    /** @return Desconto como fração (0.10 = 10%) */
    public double getDesconto() { return desconto; }

    /** @return Tipo de sócio ("Individual" ou "Empresa") */
    public String getTipo() { return tipo; }

    /**
     * Devolve o texto com os dados comuns a todos os sócios.
     * @return Número, nome, e-mail e desconto
     */
    public String getInformacaoBase() {
        return "Sócio n.º " + numero + " | " + nome + " | " + email
                + " | desconto: " + Math.round(desconto * 100) + "%";
    }
}