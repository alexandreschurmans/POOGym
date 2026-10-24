
public class SessaoPT extends Atividade {
    private static String[] niveis = {"Iniciação", "Intermédio", "Avançado"};
    private static double[] custos = {18.00, 22.00, 28.00};

    private String nivel;

    public SessaoPT(String nome, Instrutor instrutor, String inicio, int duracaoMinutos,
                    int indiceNivel) {
        super(nome, instrutor, inicio, duracaoMinutos, custos[indiceNivel], "Sessão PT");
        this.nivel = niveis[indiceNivel];
    }

    /** Número de níveis disponíveis */
    public static int getNumNiveis() { return niveis.length; }

    public static String getNomeNivel(int indice) { return niveis[indice]; }

    public static double getCustoNivel(int indice) { return custos[indice]; }

    public String getNivel() { return nivel; }

    public String toString() {
        return "[Personal Training - " + nivel + "] " + super.toString();
    }
}