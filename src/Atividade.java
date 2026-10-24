public class Atividade {
    private String nome;
    private Instrutor instrutor;
    private String inicio;      // formato dd/MM/yyyy HH:mm
    private int duracaoMinutos;
    private double custoBase;
    private String tipo;        // "Aula de grupo" ou "Sessão PT"

    /**
     * Construtor da classe
     * @param nome Nome da atividade
     * @param instrutor Instrutor responsável
     * @param inicio Data e hora de início (dd/MM/yyyy HH:mm)
     * @param duracaoMinutos Duração em minutos
     * @param custoBase Custo base em euros
     * @param tipo Tipo de atividade ("Aula de grupo" ou "Sessão PT")
     */
    public Atividade(String nome, Instrutor instrutor, String inicio,
                     int duracaoMinutos, double custoBase, String tipo) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.inicio = inicio;
        this.duracaoMinutos = duracaoMinutos;
        this.custoBase = custoBase;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public Instrutor getInstrutor() { return instrutor; }
    public String getInicio() { return inicio; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public double getCustoBase() { return custoBase; }
    public String getTipo() { return tipo; }

    public String toString() {
        return nome + " | Instrutor: " + instrutor.getNome() + " | " + inicio
                + " | " + duracaoMinutos + " min | custo base: " + Formato.euros(custoBase);
    }
}
