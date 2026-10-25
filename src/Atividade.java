/**
 * Representa uma atividade do ginásio (aula de grupo ou sessão de personal training).
 * Guarda o nome, o instrutor responsável, a data e hora de início, a duração e o custo base.
 */
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

    /** @return Nome da atividade */
    public String getNome() { return nome; }

    /** @return Instrutor responsável pela atividade */
    public Instrutor getInstrutor() { return instrutor; }

    /** @return Data e hora de início (dd/MM/yyyy HH:mm) */
    public String getInicio() { return inicio; }

    /** @return Duração da atividade em minutos */
    public int getDuracaoMinutos() { return duracaoMinutos; }

    /** @return Custo base da atividade em euros */
    public double getCustoBase() { return custoBase; }

    /** @return Tipo de atividade ("Aula de grupo" ou "Sessão PT") */
    public String getTipo() { return tipo; }

    /**
     * Devolve o texto com os dados comuns a todas as atividades.
     * @return Nome, instrutor, início, duração e custo base
     */
    public String getInformacaoBase() {
        return nome + " | Instrutor: " + instrutor.getNome() + " | " + inicio
                + " | " + duracaoMinutos + " min | custo base: " + Formato.euros(custoBase);
    }
}