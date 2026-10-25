/**
 * Representa uma aula de grupo do ginásio.
 * Além dos dados de qualquer atividade, indica a modalidade
 * (Yoga, Spinning, Zumba ou CrossFit) e a capacidade máxima de participantes.
 */
public class Aulagrupo extends Atividade {
    private static String[] modalidades = {"Yoga", "Spinning", "Zumba", "CrossFit"};
    private static double[] custos = {8.00, 9.00, 8.50, 12.00};

    private String modalidade;
    private int capacidadeMaxima;

    /**
     * Construtor da classe
     * @param nome Nome da atividade
     * @param instrutor Instrutor responsável
     * @param inicio Data e hora de início (dd/MM/yyyy HH:mm)
     * @param duracaoMinutos Duração em minutos
     * @param indiceModalidade Índice da modalidade (0 a 3)
     * @param capacidadeMaxima Número máximo de participantes
     */
    public Aulagrupo(String nome, Instrutor instrutor, String inicio, int duracaoMinutos,
                     int indiceModalidade, int capacidadeMaxima) {
        super(nome, instrutor, inicio, duracaoMinutos, custos[indiceModalidade], "Aula de grupo");
        this.modalidade = modalidades[indiceModalidade];
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /** @return Número de modalidades disponíveis */
    public static int getNumModalidades() { return modalidades.length; }

    /**
     * @param indice Índice da modalidade
     * @return Nome da modalidade
     */
    public static String getNomeModalidade(int indice) { return modalidades[indice]; }

    /**
     * @param indice Índice da modalidade
     * @return Custo base da modalidade em euros
     */
    public static double getCustoModalidade(int indice) { return custos[indice]; }

    /** @return Nome da modalidade desta aula */
    public String getModalidade() { return modalidade; }

    /** @return Número máximo de participantes */
    public int getCapacidadeMaxima() { return capacidadeMaxima; }

    /**
     * Devolve os dados completos da aula de grupo.
     * @return Dados comuns da atividade, modalidade e capacidade
     */
    public String getDetalhes() {
        return "[Aula de grupo - " + modalidade + "] " + getInformacaoBase()
            + " | capacidade: " + capacidadeMaxima;
    }
}