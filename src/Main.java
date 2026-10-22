import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final Ginasio ginasio = new Ginasio();

    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = lerInt("Opção: ");
            System.out.println();
            switch (opcao) {
                case 1: registarSocio(); break;
                case 2: registarInstrutor(); break;
                case 3: registarAtividade(); break;
                case 4: listarSocios(); break;
                case 5: listarAtividades(); break;
                case 6: criarMarcacao(); break;
                case 7: listarMarcacoes(); break;
                case 8: resumoAtividades(); break;
                case 9: maisPopular(); break;
                case 10: valoresSocio(); break;
                case 0: System.out.println("Até à próxima!"); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
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

        Socio socio;
        if (tipo == 1) {
            int ano = lerInt("Ano de nascimento: ");
            socio = new SocioIndividual(nome, numero, email, ano);
        } else {
            String empresa = lerTexto("Nome da empresa: ");
            String nif = lerTexto("NIF da empresa: ");
            socio = new Socioempresa(nome, numero, email, empresa, nif);
        }
        ginasio.registarSocio(socio);
        System.out.println("Sócio registado: " + socio);
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
        ArrayList<Instrutor> instrutores = ginasio.getInstrutores();
        if (instrutores.isEmpty()) {
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
        for (int i = 0; i < instrutores.size(); i++) {
            System.out.println("  " + (i + 1) + " - " + instrutores.get(i));
        }
        int idx = lerInt("Instrutor (n.º): ") - 1;
        if (idx < 0 || idx >= instrutores.size()) {
            System.out.println("Instrutor inválido.");
            return;
        }
        Instrutor instrutor = instrutores.get(idx);

        LocalDateTime inicio = lerDataHora("Data e hora de início (dd/MM/yyyy HH:mm): ");
        int duracao = lerInt("Duração (minutos): ");

        if (tipo == 1) {
            System.out.println("Modalidades:");
            for (int i = 0; i < Aulagrupo.MODALIDADES.length; i++) {
                System.out.printf("  %d - %s (%.2f €)%n", i + 1, Aulagrupo.MODALIDADES[i], Aulagrupo.CUSTOS[i]);
            }
            int m = lerInt("Modalidade: ") - 1;
            if (m < 0 || m >= Aulagrupo.MODALIDADES.length) {
                System.out.println("Modalidade inválida.");
                return;
            }
            int capacidade = lerInt("Capacidade máxima: ");
            ginasio.registarAtividade(new Aulagrupo(nome, instrutor, inicio, duracao,
                    Aulagrupo.MODALIDADES[m], capacidade));
        } else {
            System.out.println("Níveis:");
            for (int i = 0; i < Sessaopt.NIVEIS.length; i++) {
                System.out.printf("  %d - %s (%.2f €)%n", i + 1, Sessaopt.NIVEIS[i], Sessaopt.CUSTOS[i]);
            }
            int n = lerInt("Nível: ") - 1;
            if (n < 0 || n >= Sessaopt.NIVEIS.length) {
                System.out.println("Nível inválido.");
                return;
            }
            ginasio.registarAtividade(new Sessaopt(nome, instrutor, inicio, duracao, Sessaopt.NIVEIS[n]));
        }
        System.out.println("Atividade registada.");
    }

    // ---------- 4. Listar sócios ----------
    private static void listarSocios() {
        ArrayList<Socio> socios = ginasio.getSocios();
        if (socios.isEmpty()) {
            System.out.println("Não existem sócios.");
            return;
        }
        for (Socio s : socios) System.out.println(s);
    }

    // ---------- 5. Listar atividades ----------
    private static void listarAtividades() {
        ArrayList<Atividade> atividades = ginasio.getAtividades();
        if (atividades.isEmpty()) {
            System.out.println("Não existem atividades.");
            return;
        }
        for (int i = 0; i < atividades.size(); i++) {
            System.out.println((i + 1) + " - " + atividades.get(i));
        }
    }

    // ---------- 6. Criar marcação ----------
    private static void criarMarcacao() {
        ArrayList<Atividade> atividades = ginasio.getAtividades();
        if (ginasio.getSocios().isEmpty() || atividades.isEmpty()) {
            System.out.println("É necessário haver pelo menos um sócio e uma atividade.");
            return;
        }
        int numero = lerInt("Número de sócio: ");
        Socio socio = ginasio.procurarSocio(numero);
        if (socio == null) {
            System.out.println("Sócio não encontrado.");
            return;
        }
        listarAtividades();
        int idx = lerInt("Atividade (n.º): ") - 1;
        if (idx < 0 || idx >= atividades.size()) {
            System.out.println("Atividade inválida.");
            return;
        }
        LocalDateTime dataHora = lerDataHora("Data e hora da marcação (dd/MM/yyyy HH:mm): ");

        Marcacao m = ginasio.criarMarcacao(socio, atividades.get(idx), dataHora);
        if (m == null) {
            System.out.println("Aula de grupo cheia: não é possível criar a marcação.");
        } else {
            System.out.printf("Marcação criada. Custo base: %.2f € | Desconto: %.0f%% | Custo final: %.2f €%n",
                    m.getCustoBase(), socio.getDesconto() * 100, m.getCustoFinal());
        }
    }

    // ---------- 7. Listar marcações ----------
    private static void listarMarcacoes() {
        ArrayList<Marcacao> marcacoes = ginasio.getMarcacoes();
        if (marcacoes.isEmpty()) {
            System.out.println("Não existem marcações.");
            return;
        }
        for (Marcacao m : marcacoes) System.out.println(m);
        System.out.printf("Total faturado: %.2f €%n", ginasio.totalFaturado());
    }

    // ---------- 8. Resumo de atividades ----------
    private static void resumoAtividades() {
        System.out.println("Sócios individuais: " + ginasio.contarSociosIndividuais());
        System.out.println("Sócios empresa: " + ginasio.contarSociosEmpresa());
        System.out.println("Aulas de grupo: " + ginasio.contarAulasGrupo());
        System.out.println("Sessões de PT: " + ginasio.contarSessoesPT());
    }

    // ---------- 9. Mais popular ----------
    private static void maisPopular() {
        Atividade a = ginasio.maisPopular();
        if (a == null) {
            System.out.println("Ainda não existem marcações.");
        } else {
            System.out.println("Atividade mais popular (" + ginasio.contarMarcacoes(a) + " marcações):");
            System.out.println(a);
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
        System.out.println(socio);
        System.out.printf("Total gasto: %.2f €%n", ginasio.totalGasto(socio));
        System.out.printf("Total poupado com o desconto: %.2f €%n", ginasio.totalPoupado(socio));
    }

    // ---------- Leitura de dados ----------
    private static String lerTexto(String msg) {
        System.out.print(msg);
        return in.nextLine().trim();
    }

    private static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Introduza um número inteiro.");
            }
        }
    }

    private static LocalDateTime lerDataHora(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return LocalDateTime.parse(in.nextLine().trim(), Atividade.FORMATO);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Exemplo: 25/10/2026 18:30");
            }
        }
    }
}