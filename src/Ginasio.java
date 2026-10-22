import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Ginasio {
    private ArrayList<Socio> socios = new ArrayList<>();
    private ArrayList<Instrutor> instrutores = new ArrayList<>();
    private ArrayList<Atividade> atividades = new ArrayList<>();
    private ArrayList<Marcacao> marcacoes = new ArrayList<>();

    // ---------- Sócios ----------
    public Socio procurarSocio(int numero) {
        for (Socio s : socios) {
            if (s.getNumero() == numero) return s;
        }
        return null;
    }

    /** @return false se já existir um sócio com esse número */
    public boolean registarSocio(Socio socio) {
        if (procurarSocio(socio.getNumero()) != null) return false;
        socios.add(socio);
        return true;
    }

    public ArrayList<Socio> getSocios() { return new ArrayList<>(socios); }

    // ---------- Instrutores ----------
    public void registarInstrutor(Instrutor instrutor) { instrutores.add(instrutor); }
    public ArrayList<Instrutor> getInstrutores() { return new ArrayList<>(instrutores); }

    // ---------- Atividades ----------
    public void registarAtividade(Atividade atividade) { atividades.add(atividade); }
    public ArrayList<Atividade> getAtividades() { return new ArrayList<>(atividades); }

    // ---------- Marcações ----------
    public int contarMarcacoes(Atividade atividade) {
        int total = 0;
        for (Marcacao m : marcacoes) {
            if (m.getAtividade() == atividade) total++;
        }
        return total;
    }

    /** @return a marcação criada, ou null se a aula de grupo estiver cheia */
    public Marcacao criarMarcacao(Socio socio, Atividade atividade, LocalDateTime dataHora) {
        if (atividade instanceof Aulagrupo) {
            Aulagrupo aula = (Aulagrupo) atividade;
            if (contarMarcacoes(aula) >= aula.getCapacidadeMaxima()) return null;
        }
        Marcacao m = new Marcacao(socio, atividade, dataHora);
        marcacoes.add(m);
        return m;
    }

    public ArrayList<Marcacao> getMarcacoes() { return new ArrayList<>(marcacoes); }

    public double totalFaturado() {
        double total = 0;
        for (Marcacao m : marcacoes) total += m.getCustoFinal();
        return total;
    }

    // ---------- Resumo ----------
    public int contarSociosIndividuais() {
        int n = 0;
        for (Socio s : socios) if (s instanceof SocioIndividual) n++;
        return n;
    }

    public int contarSociosEmpresa() {
        int n = 0;
        for (Socio s : socios) if (s instanceof Socioempresa) n++;
        return n;
    }

    public int contarAulasGrupo() {
        int n = 0;
        for (Atividade a : atividades) if (a instanceof Aulagrupo) n++;
        return n;
    }

    public int contarSessoesPT() {
        int n = 0;
        for (Atividade a : atividades) if (a instanceof Sessaopt) n++;
        return n;
    }

    // ---------- Mais popular ----------
    public Atividade maisPopular() {
        HashMap<Atividade, Integer> contagem = new HashMap<>();
        for (Marcacao m : marcacoes) {
            contagem.put(m.getAtividade(), contagem.getOrDefault(m.getAtividade(), 0) + 1);
        }
        Atividade melhor = null;
        int max = 0;
        for (Atividade a : atividades) { // percorre por ordem de registo (desempate: a mais antiga)
            int n = contagem.getOrDefault(a, 0);
            if (n > max) {
                max = n;
                melhor = a;
            }
        }
        return melhor;
    }

    // ---------- Valores por sócio ----------
    public double totalGasto(Socio socio) {
        double total = 0;
        for (Marcacao m : marcacoes) if (m.getSocio() == socio) total += m.getCustoFinal();
        return total;
    }

    public double totalPoupado(Socio socio) {
        double total = 0;
        for (Marcacao m : marcacoes) if (m.getSocio() == socio) total += m.getPoupanca();
        return total;
    }
}