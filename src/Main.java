import java.util.Scanner;

/**
 * Classe principal do POOGym: apresenta o menu e interage com o utilizador.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Ginasio ginasio = new Ginasio();

    /**
     * Ponto de entrada da aplicação.
     * @param args Argumentos da linha de comandos (não utilizados)
     */
    public static void main(String[] args) {
        carregarDados();
        int opcao;
        do {
            mostrarMenu();
            opcao = lerInt("Opção: ");
            System.out.println();
            switch (opcao) {
                case 1: registarSocio(); break;
                case 2: registarInstrutor(); break;
                case 3: registarAtividade(); break;
                case 4: ginasio.listarSocios(); break;
                case 5: ginasio.listarAtividades(); break;
                case 6: criarMarcacao(); break;
                case 7: ginasio.listarMarcacoes(); break;
                case 8: ginasio.imprimirResumo(); break;
                case 9: maisPopular(); break;
                case 10: valoresSocio(); break;
                case 0: System.out.println("Até à próxima!"); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Dados de demonstração: 6 sócios, 3 instrutores, 8 atividades e 6 marcações
    private static void carregarDados() {
        // Sócios individuais (10%, 0% e 15% de desconto)
        ginasio.registarSocioIndividual(new SocioIndividual("Ana Silva", 1, "ana@mail.pt", 2012));
        ginasio.registarSocioIndividual(new SocioIndividual("Bruno Matos", 2, "bruno@mail.pt", 1990));
        ginasio.registarSocioIndividual(new SocioIndividual("Carlos Pinto", 3, "carlos@mail.pt", 1955));

        // Sócios empresa (20% de desconto)
        ginasio.registarSocioEmpresa(new Socioempresa("Diana Rocha", 4, "diana@mail.pt", "TechCoimbra", "501234567"));
        ginasio.registarSocioEmpresa(new Socioempresa("Eduardo Lopes", 5, "eduardo@mail.pt", "Mondego Lda", "502345678"));
        ginasio.registarSocioEmpresa(new Socioempresa("Filipa Neves", 6, "filipa@mail.pt", "Beira Software", "503456789"));

        // Instrutores
        ginasio.registarInstrutor(new Instrutor("Rui Costa", "M", "Licenciatura em Desporto; Curso de Yoga"));
        ginasio.registarInstrutor(new Instrutor("Marta Dias", "F", "Mestrado em Treino Desportivo; Instrutora de Spinning"));
        ginasio.registarInstrutor(new Instrutor("Tiago Faria", "M", "Personal Trainer certificado; Curso de CrossFit"));
        Instrutor rui = ginasio.getInstrutor(0);
        Instrutor marta = ginasio.getInstrutor(1);
        Instrutor tiago = ginasio.getInstrutor(2);

        // Aulas de grupo (modalidade: 0 Yoga, 1 Spinning, 2 Zumba, 3 CrossFit)
        ginasio.registarAulaGrupo(new Aulagrupo("Yoga manhã", rui, "26/10/2026 09:00", 60, 0, 15));
        ginasio.registarAulaGrupo(new Aulagrupo("Spinning energia", marta, "26/10/2026 18:30", 45, 1, 20));
        ginasio.registarAulaGrupo(new Aulagrupo("Zumba festa", marta, "27/10/2026 19:00", 50, 2, 25));
        ginasio.registarAulaGrupo(new Aulagrupo("CrossFit intenso", tiago, "27/10/2026 07:30", 60, 3, 12));
        ginasio.registarAulaGrupo(new Aulagrupo("Yoga tarde", rui, "28/10/2026 17:00", 60, 0, 15));

        // Sessões de personal training (nível: 0 Iniciação, 1 Intermédio, 2 Avançado)
        ginasio.registarSessaoPT(new Sessaopt("PT iniciação", tiago, "28/10/2026 10:00", 45, 0));
        ginasio.registarSessaoPT(new Sessaopt("PT intermédio", rui, "29/10/2026 11:00", 45, 1));
        ginasio.registarSessaoPT(new Sessaopt("PT avançado", tiago, "29/10/2026 16:00", 60, 2));

        // Marcações (a atividade 0 fica com 3, para a opção "Mais popular")
        ginasio.criarMarcacao(ginasio.procurarSocio(1), ginasio.getAtividade(0), "25/10/2026 10:00");
        ginasio.criarMarcacao(ginasio.procurarSocio(2), ginasio.getAtividade(0), "25/10/2026 10:30");
        ginasio.criarMarcacao(ginasio.procurarSocio(3), ginasio.getAtividade(0), "25/10/2026 11:00");
        ginasio.criarMarcacao(ginasio.procurarSocio(4), ginasio.getAtividade(5), "25/10/2026 12:00");
        ginasio.criarMarcacao(ginasio.procurarSocio(5), ginasio.getAtividade(2), "25/10/2026 14:00");
        ginasio.criarMarcacao(ginasio.procurarSocio(1), ginasio.getAtividade(6), "25/10/2026 15:00");
    }

    private static void mostrarMenu() {
        System.out.println("\n===== POOGym =====");
        System.out.println(" 1 - Registar sócio");
        System.out.println(" 2 - Registar instrutor");
        System.out.println(" 3 - Registar atividade");
        System.out.println(" 4 - Listar sócios");
        System.out.println(" 5 - Listar atividades");
        System.out.println(" 6 - Criar marcação");
        System.out.println(" 7 - Listar marcações");
        System.out.println(" 8 - Resumo de atividades");
        System.out.println(" 9 - Mais popular");
        System.out.println("10 - Valores sócio");
        System.out.println(" 0 - Sair");
    }

    // ---------- 1. Registar sócio ----------
    private static void registarSocio() {
        System.out.println("Tipo de sócio: 1 - Individual | 2 - Empresa");
        int tipo = lerInt("Tipo: ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido.");
            return;
        }
        String nome = lerTexto("Nome: ");
        int numero = lerInt("Número de sócio: ");
        if (ginasio.procurarSocio(numero) != null) {
            System.out.println("Já existe um sócio com o número " + numero + ".");
            return;
        }
        String email = lerTexto("E-mail: ");

        if (tipo == 1) {
            int ano = lerInt("Ano de nascimento: ");
            SocioIndividual socio = new SocioIndividual(nome, numero, email, ano);
            ginasio.registarSocioIndividual(socio);
            System.out.println("Sócio registado: " + socio.getDetalhes());
        } else {
            String empresa = lerTexto("Nome da empresa: ");
            String nif = lerTexto("NIF da empresa: ");
            Socioempresa socio = new Socioempresa(nome, numero, email, empresa, nif);
            ginasio.registarSocioEmpresa(socio);
            System.out.println("Sócio registado: " + socio.getDetalhes());
        }
    }

    // ---------- 2. Registar instrutor ----------
    private static void registarInstrutor() {
        String nome = lerTexto("Nome: ");
        String genero = lerTexto("Género: ");
        String formacao = lerTexto("Formação (cursos e formações): ");
        ginasio.registarInstrutor(new Instrutor(nome, genero, formacao));
        System.out.println("Instrutor registado.");
    }

    // ---------- 3. Registar atividade ----------
    private static void registarAtividade() {
        if (ginasio.getNumInstrutores() == 0) {
            System.out.println("Registe primeiro um instrutor.");
            return;
        }
        System.out.println("Tipo: 1 - Aula de grupo | 2 - Sessão de Personal Training");
        int tipo = lerInt("Tipo: ");
        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido.");
            return;
        }

        String nome = lerTexto("Nome da atividade: ");

        System.out.println("Instrutores:");
        ginasio.listarInstrutores();
        int idx = lerInt("Instrutor (n.º): ") - 1;
        if (idx < 0 || idx >= ginasio.getNumInstrutores()) {
            System.out.println("Instrutor inválido.");
            return;
        }
        Instrutor instrutor = ginasio.getInstrutor(idx);

        String inicio = lerDataHora("Data e hora de início (dd/MM/yyyy HH:mm): ");
        int duracao = lerInt("Duração (minutos): ");

        if (tipo == 1) {
            System.out.println("Modalidades:");
            for (int i = 0; i < Aulagrupo.getNumModalidades(); i++) {
                System.out.println("  " + (i + 1) + " - " + Aulagrupo.getNomeModalidade(i)
                        + " (" + Formato.euros(Aulagrupo.getCustoModalidade(i)) + ")");
            }
            int m = lerInt("Modalidade: ") - 1;
            if (m < 0 || m >= Aulagrupo.getNumModalidades()) {
                System.out.println("Modalidade inválida.");
                return;
            }
            int capacidade = lerInt("Capacidade máxima: ");
            ginasio.registarAulaGrupo(new Aulagrupo(nome, instrutor, inicio, duracao, m, capacidade));
        } else {
            System.out.println("Níveis:");
            for (int i = 0; i < Sessaopt.getNumNiveis(); i++) {
                System.out.println("  " + (i + 1) + " - " + Sessaopt.getNomeNivel(i)
                        + " (" + Formato.euros(Sessaopt.getCustoNivel(i)) + ")");
            }
            int n = lerInt("Nível: ") - 1;
            if (n < 0 || n >= Sessaopt.getNumNiveis()) {
                System.out.println("Nível inválido.");
                return;
            }
            ginasio.registarSessaoPT(new Sessaopt(nome, instrutor, inicio, duracao, n));
        }
        System.out.println("Atividade registada.");
    }

    // ---------- 6. Criar marcação ----------
    private static void criarMarcacao() {
        if (ginasio.getNumSocios() == 0 || ginasio.getNumAtividades() == 0) {
            System.out.println("É necessário haver pelo menos um sócio e uma atividade.");
            return;
        }
        int numero = lerInt("Número de sócio: ");
        Socio socio = ginasio.procurarSocio(numero);
        if (socio == null) {
            System.out.println("Sócio não encontrado.");
            return;
        }
        ginasio.listarAtividades();
        int idx = lerInt("Atividade (n.º): ") - 1;
        if (idx < 0 || idx >= ginasio.getNumAtividades()) {
            System.out.println("Atividade inválida.");
            return;
        }
        String dataHora = lerDataHora("Data e hora da marcação (dd/MM/yyyy HH:mm): ");

        Marcacao m = ginasio.criarMarcacao(socio, ginasio.getAtividade(idx), dataHora);
        System.out.println("Marcação criada. Custo base: " + Formato.euros(m.getCustoBase())
                + " | Desconto: " + Math.round(socio.getDesconto() * 100) + "%"
                + " | Custo final: " + Formato.euros(m.getCustoFinal()));
    }

    // ---------- 9. Mais popular ----------
    private static void maisPopular() {
        Atividade a = ginasio.maisPopular();
        if (a == null) {
            System.out.println("Ainda não existem marcações.");
        } else {
            System.out.println("Atividade mais popular (" + ginasio.contarMarcacoes(a) + " marcações):");
            System.out.println(a.getInformacaoBase());
        }
    }

    // ---------- 10. Valores sócio ----------
    private static void valoresSocio() {
        int numero = lerInt("Número de sócio: ");
        Socio socio = ginasio.procurarSocio(numero);
        if (socio == null) {
            System.out.println("Sócio não encontrado.");
            return;
        }
        System.out.println(socio.getInformacaoBase());
        System.out.println("Total gasto: " + Formato.euros(ginasio.totalGasto(socio)));
        System.out.println("Total poupado com o desconto: " + Formato.euros(ginasio.totalPoupado(socio)));
    }

    // ---------- Leitura de dados ----------
    private static String lerTexto(String msg) {
        System.out.print(msg);
        return in.nextLine().trim();
    }

    // Lê um número inteiro positivo; repete a pergunta se o texto não for válido
    private static int lerInt(String msg) {
        while (true) {
            String texto = lerTexto(msg);
            boolean valido = texto.length() > 0 && texto.length() <= 9;
            for (int i = 0; i < texto.length(); i++) {
                char c = texto.charAt(i);
                if (c < '0' || c > '9') {
                    valido = false;
                }
            }
            if (valido) {
                int valor = 0;
                for (int i = 0; i < texto.length(); i++) {
                    valor = valor * 10 + (texto.charAt(i) - '0');
                }
                return valor;
            }
            System.out.println("Valor inválido. Introduza um número inteiro positivo.");
        }
    }

    // Lê uma data e hora no formato dd/MM/yyyy HH:mm (verifica só o formato)
    private static String lerDataHora(String msg) {
        while (true) {
            String t = lerTexto(msg);
            if (t.length() == 16 && t.charAt(2) == '/' && t.charAt(5) == '/'
                    && t.charAt(10) == ' ' && t.charAt(13) == ':') {
                return t;
            }
            System.out.println("Formato inválido. Exemplo: 25/10/2026 18:30");
        }
    }
}