import java.time.LocalDate;

public class socioindividual extends socio {
    private int anoNascimento;

    public socioindividual(String nome, int numero, String email, int anoNascimento) {
        super(nome, numero, email, calcularDesconto(anoNascimento));
        this.anoNascimento = anoNascimento;
    }

    // <18 anos: 10% | >=65 anos: 15% | restantes: 0%
    private static double calcularDesconto(int anoNascimento) {
        int idade = LocalDate.now().getYear() - anoNascimento;
        if (idade < 18) return 0.10;
        if (idade >= 65) return 0.15;
        return 0.0;
    }

    public int getAnoNascimento() { return anoNascimento; }

    @Override
    public String toString() {
        return super.toString() + " | Individual (nascido em " + anoNascimento + ")";
    }
}
