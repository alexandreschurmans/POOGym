import java.util.ArrayList;
import java.util.List;

public class Ginasio {
    private List<Socio> socios = new ArrayList<>();
    private List<Instrutor> instrutores = new ArrayList<>();
    private List<Atividade> atividades = new ArrayList<>();
    private List<Marcacao> marcacoes = new ArrayList<>();

    // ---------- Sócios ----------

    public Socio procurarSocio(int numero) {
        for (Socio s : socios) {
            if (s.getNumero() == numero) {
                return s;
            }
        }
        return null;
    }

    /**
     * Regista um sócio
     * @param socio Sócio a registar
     * @return false se já existir um sócio com esse número
     */
    public boolean registarSocio(Socio socio) {
        if (procurarSocio(socio.getNumero()) != null) {
            return false;
        }
        socios.add(socio);
        return true;
    }

    /** @return Número de sócios registados */
    public int getNumSocios() { return socios.size(); }

    /** Escreve todos os sócios no ecrã */
    public void listarSocios() {
        if (socios.isEmpty()) {
            System.out.println("Não existem sócios.");
            return;
        }
        for (Socio s : socios) {
            System.out.println(s);
        }
    }

    // ---------- Instrutores ----------

    public void registarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    /** @return Número de instrutores registados */
    public int getNumInstrutores() { return instrutores.size(); }

    public Instrutor getInstrutor(int indice) { return instrutores.get(indice); }

    /** Escreve os instrutores numerados a partir de 1 */
    public void listarInstrutores() {
        for (int i = 0; i < instrutores.size(); i++) {
            System.out.println("  " + (i + 1) + " - " + instrutores.get(i));
        }
    }

    // ---------- Atividades ----------

    public void registarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    /** return Número de atividades registadas */
    public int getNumAtividades() { return atividades.size(); }

    public Atividade getAtividade(int indice) { return atividades.get(indice); }

    /** Escreve as atividades numeradas a partir de 1 */
    public void listarAtividades() {
        if (atividades.isEmpty()) {
            System.out.println("Não existem atividades.");
            return;
        }
        for (int i = 0; i < atividades.size(); i++) {
            System.out.println((i + 1) + " - " + atividades.get(i));
        }
    }

    // ---------- Marcações ----------

    public int contarMarcacoes(Atividade atividade) {
        int total = 0;
        for (Marcacao m : marcacoes) {
            if (m.getAtividade() == atividade) {
                total++;
            }
        }
        return total;
    }

    public Marcacao criarMarcacao(Socio socio, Atividade atividade, String dataHora) {
        Marcacao m = new Marcacao(socio, atividade, dataHora);
        marcacoes.add(m);
        return m;
    }

    /** Escreve todas as marcações, com custos, e o total faturado */
    public void listarMarcacoes() {
        if (marcacoes.isEmpty()) {
            System.out.println("Não existem marcações.");
            return;
        }
        for (Marcacao m : marcacoes) {
            System.out.println(m);
        }
        System.out.println("Total faturado: " + Formato.euros(totalFaturado()));
    }

    /** Soma dos custos finais de todas as marcações */
    public double totalFaturado() {
        double total = 0;
        for (Marcacao m : marcacoes) {
            total += m.getCustoFinal();
        }
        return total;
    }

    // ---------- Resumo ----------

    private int contarSocios(String tipo) {
        int n = 0;
        for (Socio s : socios) {
            if (s.getTipo().equals(tipo)) {
                n++;
            }
        }
        return n;
    }

    private int contarAtividades(String tipo) {
        int n = 0;
        for (Atividade a : atividades) {
            if (a.getTipo().equals(tipo)) {
                n++;
            }
        }
        return n;
    }

    /** Escreve o número de registos por tipo de sócio e por tipo de atividade */
    public void imprimirResumo() {
        System.out.println("Sócios individuais: " + contarSocios("Individual"));
        System.out.println("Sócios empresa: " + contarSocios("Empresa"));
        System.out.println("Aulas de grupo: " + contarAtividades("Aula de grupo"));
        System.out.println("Sessões de PT: " + contarAtividades("Sessão PT"));
    }

    // ---------- Mais popular ----------

    public Atividade maisPopular() {
        Atividade melhor = null;
        int max = 0;
        for (Atividade a : atividades) {
            int n = contarMarcacoes(a);
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
        for (Marcacao m : marcacoes) {
            if (m.getSocio() == socio) {
                total += m.getCustoFinal();
            }
        }
        return total;
    }

    public double totalPoupado(Socio socio) {
        double total = 0;
        for (Marcacao m : marcacoes) {
            if (m.getSocio() == socio) {
                total += m.getPoupanca();
            }
        }
        return total;
    }
}