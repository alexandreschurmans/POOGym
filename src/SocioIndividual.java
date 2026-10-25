/**
 * Representa um sócio individual.
 * O desconto depende da idade: 10% abaixo dos 18 anos, 15% a partir dos 65
 * e sem desconto nos restantes casos.
 */
public class SocioIndividual extends Socio {
    // Ano usado para calcular a idade (alterar se necessário)
    private static int anoAtual = 2026;

    private int anoNascimento;

    /**
     * Construtor da classe. O desconto é calculado a partir do ano de nascimento.
     * @param nome Nome do sócio
     * @param numero Número de sócio (único)
     * @param email E-mail do sócio
     * @param anoNascimento Ano de nascimento do sócio
     */
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

    /** @return Ano de nascimento do sócio */
    public int getAnoNascimento() { return anoNascimento; }

    /**
     * Devolve os dados completos do sócio individual.
     * @return Dados comuns do sócio e ano de nascimento
     */
    public String getDetalhes() {
        return getInformacaoBase() + " | Individual (nascido em " + anoNascimento + ")";
    }
}