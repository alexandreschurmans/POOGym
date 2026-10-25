/**
 * Representa uma sessão de personal training.
 * Além dos dados de qualquer atividade, indica o nível do treino
 * (Iniciação, Intermédio ou Avançado).
 */
public class Sessaopt extends Atividade {
    private static String[] niveis = {"Iniciação", "Intermédio", "Avançado"};
    private static double[] custos = {18.00, 22.00, 28.00};

    private String nivel;

    /**
     * Construtor da classe
     * @param nome Nome da atividade
     * @param instrutor Instrutor responsável
     * @param inicio Data e hora de início (dd/MM/yyyy HH:mm)
     * @param duracaoMinutos Duração em minutos
     * @param indiceNivel Índice do nível (0 a 2)
     */
    public Sessaopt(String nome, Instrutor instrutor, String inicio, int duracaoMinutos,
                    int indiceNivel) {
        super(nome, instrutor, inicio, duracaoMinutos, custos[indiceNivel], "Sessão PT");
        this.nivel = niveis[indiceNivel];
    }

    /** @return Número de níveis disponíveis */
    public static int getNumNiveis() { return niveis.length; }

    /**
     * @param indice Índice do nível
     * @return Nome do nível
     */
    public static String getNomeNivel(int indice) { return niveis[indice]; }

    /**
     * @param indice Índice do nível
     * @return Custo base do nível em euros
     */
    public static double getCustoNivel(int indice) { return custos[indice]; }

    /** @return Nome do nível desta sessão */
    public String getNivel() { return nivel; }

    /**
     * Devolve os dados completos da sessão de personal training.
     * @return Nível e dados comuns da atividade
     */
    public String getDetalhes() {
        return "[Personal Training - " + nivel + "] " + getInformacaoBase();
    }
}