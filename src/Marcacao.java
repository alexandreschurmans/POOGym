import java.time.LocalDateTime;

public class Marcacao {
    private Socio socio;
    private Atividade atividade;
    private LocalDateTime dataHora;
    private double custoBase;
    private double custoFinal;

    public Marcacao(Socio socio, Atividade atividade, LocalDateTime dataHora) {
        this.socio = socio;
        this.atividade = atividade;
        this.dataHora = dataHora;
        this.custoBase = atividade.getCustoBase();
        this.custoFinal = custoBase * (1 - socio.getDesconto());
    }

    public Socio getSocio() { return socio; }
    public Atividade getAtividade() { return atividade; }
    public LocalDateTime getDataHora() { return dataHora; }
    public double getCustoBase() { return custoBase; }
    public double getCustoFinal() { return custoFinal; }
    public double getPoupanca() { return custoBase - custoFinal; }

    @Override
    public String toString() {
        return String.format("%s | Sócio: %s (n.º %d) | Atividade: %s | custo base: %.2f € | custo final: %.2f €",
                dataHora.format(Atividade.FORMATO), socio.getNome(), socio.getNumero(),
                atividade.getNome(), custoBase, custoFinal);
    }
}