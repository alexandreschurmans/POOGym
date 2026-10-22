import java.time.LocalDateTime;

public class Sessaopt extends Atividade {
    public static final String[] NIVEIS = {"Iniciação", "Intermédio", "Avançado"};
    public static final double[] CUSTOS = {18.00, 22.00, 28.00};

    private String nivel;

    public Sessaopt(String nome, Instrutor instrutor, LocalDateTime inicio, int duracaoMinutos,
                    String nivel) {
        super(nome, instrutor, inicio, duracaoMinutos, custoDoNivel(nivel));
        this.nivel = nivel;
    }

    private static double custoDoNivel(String nivel) {
        for (int i = 0; i < NIVEIS.length; i++) {
            if (NIVEIS[i].equals(nivel)) return CUSTOS[i];
        }
        return 0;
    }

    public String getNivel() { return nivel; }

    @Override
    public String toString() {
        return "[Personal Training - " + nivel + "] " + super.toString();
    }
}