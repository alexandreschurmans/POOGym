import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Atividade {
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String nome;
    private Instrutor instrutor;
    private LocalDateTime inicio;
    private int duracaoMinutos;
    private double custoBase;

    public Atividade(String nome, Instrutor instrutor, LocalDateTime inicio,
                     int duracaoMinutos, double custoBase) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.inicio = inicio;
        this.duracaoMinutos = duracaoMinutos;
        this.custoBase = custoBase;
    }

    public String getNome() { return nome; }
    public Instrutor getInstrutor() { return instrutor; }
    public LocalDateTime getInicio() { return inicio; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public double getCustoBase() { return custoBase; }

    @Override
    public String toString() {
        return String.format("%s | Instrutor: %s | %s | %d min | custo base: %.2f €",
                nome, instrutor.getNome(), inicio.format(FORMATO), duracaoMinutos, custoBase);
    }
}
