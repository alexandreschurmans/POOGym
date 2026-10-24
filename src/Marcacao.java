
public class Marcacao {
    private Socio socio;
    private Atividade atividade;
    private String dataHora; // formato dd/MM/yyyy HH:mm
    private double custoBase;
    private double custoFinal;

    public Marcacao(Socio socio, Atividade atividade, String dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = dataHora;
        this.custoBase = atividade.getCustoBase();
        this.custoFinal = custoBase * (1 - socio.getDesconto());
    }

    public Socio getSocio() { return socio; }
    public Atividade getAtividade() { return atividade; }
    public String getDataHora() { return dataHora; }
    public double getCustoBase() { return custoBase; }
    public double getCustoFinal() { return custoFinal; }

    /** Valor poupado graças ao desconto (custo base - custo final) */
    public double getPoupanca() { return custoBase - custoFinal; }

    public String toString() {
        return dataHora + " | Sócio: " + socio.getNome() + " (n.º " + socio.getNumero()
                + ") | Atividade: " + atividade.getNome()
                + " | custo base: " + Formato.euros(custoBase)
                + " | custo final: " + Formato.euros(custoFinal);
    }
}