public class Socio {
    private String nome;
    private int numero;
    private String email;
    private double desconto; // fração: 0.10 = 10%
    private String tipo;     // "Individual" ou "Empresa"

    public Socio(String nome, int numero, String email, double desconto, String tipo) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.desconto = desconto;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public int getNumero() { return numero; }
    public String getEmail() { return email; }
    public double getDesconto() { return desconto; }
    public String getTipo() { return tipo; }

    public String toString() {
        return "Sócio n.º " + numero + " | " + nome + " | " + email
                + " | desconto: " + Math.round(desconto * 100) + "%";
    }
}