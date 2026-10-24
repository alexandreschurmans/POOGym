
public class SocioIndividual extends Socio {
    // Ano usado para calcular a idade (alterar se necessário)
    private static int anoAtual = 2026;

    private int anoNascimento;

    public SocioIndividual(String nome, int numero, String email, int anoNascimento) {
        super(nome, numero, email, calcularDesconto(anoNascimento), "Individual");
        this.anoNascimento = anoNascimento;
    }

    // menos de 18 anos: 10% | 65 anos ou mais: 15% | restantes: 0%
    private static double calcularDesconto(int anoNascimento) {
        int idade = anoAtual - anoNascimento;
        if (idade < 18) {
            return 0.10;
        }
        if (idade >= 65) {
            return 0.15;
        }
        return 0.0;
    }

    public int getAnoNascimento() { return anoNascimento; }

    public String toString() {
        return super.toString() + " | Individual (nascido em " + anoNascimento + ")";
    }
}