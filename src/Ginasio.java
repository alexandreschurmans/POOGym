import java.util.ArrayList;
import java.util.List;

/**
 * Gere os sócios, instrutores, atividades e marcações do ginásio.
 * Os sócios e as atividades são guardados em listas separadas por tipo.
 */
public class Ginasio {
    private List<SocioIndividual> sociosIndividuais = new ArrayList<>();
    private List<Socioempresa> sociosEmpresa = new ArrayList<>();
    private List<Instrutor> instrutores = new ArrayList<>();
    private List<Aulagrupo> aulasGrupo = new ArrayList<>();
    private List<Sessaopt> sessoesPT = new ArrayList<>();
    private List<Marcacao> marcacoes = new ArrayList<>();

    // ---------- Sócios ----------

    /**
     * Procura um sócio (individual ou empresa) pelo número.
     * @param numero Número do sócio a procurar
     * @return O sócio encontrado, ou null se não existir
     */
    public Socio procurarSocio(int numero) {
        for (SocioIndividual s : sociosIndividuais) {
            if (s.getNumero() == numero) {
                return s;
            }
        }
        for (Socioempresa s : sociosEmpresa) {
            if (s.getNumero() == numero) {
                return s;
            }
        }
        return null;
    }

    /**
     * Regista um sócio individual.
     * @param socio Sócio a registar
     * @return false se já existir um sócio com esse número
     */
    public boolean registarSocioIndividual(SocioIndividual socio) {
        if (procurarSocio(socio.getNumero()) != null) {
            return false;
        }
        sociosIndividuais.add(socio);
        return true;
    }

    /**
     * Regista um sócio empresa.
     * @param socio Sócio a registar
     * @return false se já existir um sócio com esse número
     */
    public boolean registarSocioEmpresa(Socioempresa socio) {
        if (procurarSocio(socio.getNumero()) != null) {
            return false;
        }
        sociosEmpresa.add(socio);
        return true;
    }

    /** @return Número total de sócios registados */
    public int getNumSocios() {
        return sociosIndividuais.size() + sociosEmpresa.size();
    }

    /** Escreve todos os sócios no ecrã. */
    public void listarSocios() {
        if (getNumSocios() == 0) {
            System.out.println("Não existem sócios.");
            return;
        }
        for (SocioIndividual s : sociosIndividuais) {
            System.out.println(s.getDetalhes());
        }
        for (Socioempresa s : sociosEmpresa) {
            System.out.println(s.getDetalhes());
        }
    }

    // ---------- Instrutores ----------

    /**
     * Regista um instrutor.
     * @param instrutor Instrutor a registar
     */
    public void registarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    /** @return Número de instrutores registados */
    public int getNumInstrutores() { return instrutores.size(); }

    /**
     * Devolve um instrutor pela sua posição na lista.
     * @param indice Posição do instrutor (a começar em 0)
     * @return O instrutor nessa posição
     */
    public Instrutor getInstrutor(int indice) { return instrutores.get(indice); }

    /** Escreve os instrutores numerados a partir de 1. */
    public void listarInstrutores() {
        for (int i = 0; i < instrutores.size(); i++) {
            System.out.println("  " + (i + 1) + " - " + instrutores.get(i));
        }
    }

    // ---------- Atividades ----------

    /**
     * Regista uma aula de grupo.
     * @param aula Aula a registar
     */
    public void registarAulaGrupo(Aulagrupo aula) {
        aulasGrupo.add(aula);
    }

    /**
     * Regista uma sessão de personal training.
     * @param sessao Sessão a registar
     */
    public void registarSessaoPT(Sessaopt sessao) {
        sessoesPT.add(sessao);
    }

    /** @return Número total de atividades registadas */
    public int getNumAtividades() {
        return aulasGrupo.size() + sessoesPT.size();
    }

    /**
     * Devolve uma atividade pela sua posição. As posições começam nas aulas
     * de grupo e continuam nas sessões de personal training, pela mesma ordem
     * da listagem.
     * @param indice Posição da atividade (a começar em 0)
     * @return A atividade nessa posição
     */
    public Atividade getAtividade(int indice) {
        if (indice < aulasGrupo.size()) {
            return aulasGrupo.get(indice);
        }
        return sessoesPT.get(indice - aulasGrupo.size());
    }

    /** Escreve as atividades numeradas a partir de 1. */
    public void listarAtividades() {
        if (getNumAtividades() == 0) {
            System.out.println("Não existem atividades.");
            return;
        }
        int n = 1;
        for (Aulagrupo a : aulasGrupo) {
            System.out.println(n + " - " + a.getDetalhes());
            n++;
        }
        for (Sessaopt s : sessoesPT) {
            System.out.println(n + " - " + s.getDetalhes());
            n++;
        }
    }

    // ---------- Marcações ----------

    /**
     * Conta as marcações associadas a uma atividade.
     * @param atividade Atividade a considerar
     * @return Número de marcações dessa atividade
     */
    public int contarMarcacoes(Atividade atividade) {
        int total = 0;
        for (Marcacao m : marcacoes) {
            if (m.getAtividade() == atividade) {
                total++;
            }
        }
        return total;
    }

    /**
     * Cria uma marcação e guarda-a.
     * @param socio Sócio da marcação
     * @param atividade Atividade marcada
     * @param dataHora Data e hora da marcação (dd/MM/yyyy HH:mm)
     * @return A marcação criada
     */
    public Marcacao criarMarcacao(Socio socio, Atividade atividade, String dataHora) {
        Marcacao m = new Marcacao(socio, atividade, dataHora);
        marcacoes.add(m);
        return m;
    }

    /** Escreve todas as marcações, com custos, e o total faturado. */
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

    /** @return Soma dos custos finais de todas as marcações */
    public double totalFaturado() {
        double total = 0;
        for (Marcacao m : marcacoes) {
            total += m.getCustoFinal();
        }
        return total;
    }

    // ---------- Resumo ----------

    /** Escreve o número de registos por tipo de sócio e por tipo de atividade. */
    public void imprimirResumo() {
        System.out.println("Sócios individuais: " + sociosIndividuais.size());
        System.out.println("Sócios empresa: " + sociosEmpresa.size());
        System.out.println("Aulas de grupo: " + aulasGrupo.size());
        System.out.println("Sessões de PT: " + sessoesPT.size());
    }

    // ---------- Mais popular ----------

    /**
     * Determina a atividade com mais marcações (a primeira, em caso de empate).
     * @return A atividade mais popular, ou null se não houver marcações
     */
    public Atividade maisPopular() {
        Atividade melhor = null;
        int max = 0;
        for (int i = 0; i < getNumAtividades(); i++) {
            Atividade a = getAtividade(i);
            int n = contarMarcacoes(a);
            if (n > max) {
                max = n;
                melhor = a;
            }
        }
        return melhor;
    }

    // ---------- Valores por sócio ----------

    /**
     * Calcula o valor total gasto por um sócio.
     * @param socio Sócio a considerar
     * @return Soma dos custos finais das marcações do sócio
     */
    public double totalGasto(Socio socio) {
        double total = 0;
        for (Marcacao m : marcacoes) {
            if (m.getSocio() == socio) {
                total += m.getCustoFinal();
            }
        }
        return total;
    }

    /**
     * Calcula o valor total poupado por um sócio graças ao seu desconto.
     * @param socio Sócio a considerar
     * @return Soma das poupanças das marcações do sócio
     */
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