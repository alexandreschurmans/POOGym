/**
 * Representa a marcação de um sócio numa atividade.
 * Guarda o custo base e o custo final (já com o desconto do sócio).
 */
public class Marcacao {
    private Socio socio;
    private Atividade atividade;
    private String dataHora; // formato dd/MM/yyyy HH:mm
    private double custoBase;
    private double custoFinal;

    /**
     * Construtor da classe. Calcula o custo final aplicando o desconto do sócio.
     * @param socio Sócio que faz a marcação
     * @param atividade Atividade marcada
     * @param dataHora Data e hora da marcação (dd/MM/yyyy HH:mm)
     */
    public Marcacao(Socio socio, Atividade atividade, String dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = dataHora;
        this.custoBase = atividade.getCustoBase();
        this.custoFinal = custoBase * (1 - socio.getDesconto());
    }

    /** @return Sócio da marcação */
    public Socio getSocio() { return socio; }

    /** @return Atividade marcada */
    public Atividade getAtividade() { return atividade; }

    /** @return Data e hora da marcação (dd/MM/yyyy HH:mm) */
    public String getDataHora() { return dataHora; }

    /** @return Custo base da atividade em euros */
    public double getCustoBase() { return custoBase; }

    /** @return Custo final, com desconto, em euros */
    public double getCustoFinal() { return custoFinal; }

    /** @return Valor poupado graças ao desconto (custo base - custo final) */
    public double getPoupanca() { return custoBase - custoFinal; }

    /**
     * Devolve os dados da marcação em texto.
     * @return Data/hora, sócio, atividade e custos
     */
    public String toString() {
        return dataHora + " | Sócio: " + socio.getNome() + " (n.º " + socio.getNumero()
                + ") | Atividade: " + atividade.getNome()
                + " | custo base: " + Formato.euros(custoBase)
                + " | custo final: " + Formato.euros(custoFinal);
    }
}