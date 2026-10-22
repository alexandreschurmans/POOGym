public class Socio {
    private String nome;
    private int numero;
    private String email;
    private double desconto; // fração: 0.10 = 10%

    public Socio(String nome, int numero, String email, double desconto) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.desconto = desconto;
    }

    public String getNome() { return nome; }
    public int getNumero() { return numero; }
    public String getEmail() { return email; }
    public double getDesconto() { return desconto; }

    @Override
    public String toString() {
        return String.format("Sócio n.º %d | %s | %s | desconto: %.0f%%",
                numero, nome, email, desconto * 100);
    }
}