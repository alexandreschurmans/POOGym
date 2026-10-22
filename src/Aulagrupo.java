import java.time.LocalDateTime;

public class Aulagrupo extends Atividade {
    public static final String[] MODALIDADES = {"Yoga", "Spinning", "Zumba", "CrossFit"};
    public static final double[] CUSTOS = {8.00, 9.00, 8.50, 12.00};

    private String modalidade;
    private int capacidadeMaxima;

    public Aulagrupo(String nome, Instrutor instrutor, LocalDateTime inicio, int duracaoMinutos,
                     String modalidade, int capacidadeMaxima) {
        super(nome, instrutor, inicio, duracaoMinutos, custoDaModalidade(modalidade));
        this.modalidade = modalidade;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    private static double custoDaModalidade(String modalidade) {
        for (int i = 0; i < MODALIDADES.length; i++) {
            if (MODALIDADES[i].equals(modalidade)) return CUSTOS[i];
        }
        return 0;
    }

    public String getModalidade() { return modalidade; }
    public int getCapacidadeMaxima() { return capacidadeMaxima; }

    @Override
    public String toString() {
        return "[Aula de grupo - " + modalidade + "] " + super.toString()
                + " | capacidade: " + capacidadeMaxima;
    }
}