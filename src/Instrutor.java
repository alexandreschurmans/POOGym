/**
 * Representa um instrutor ou personal trainer do ginásio.
 * Guarda o nome, o género e a formação (texto com a lista de cursos e formações).
 */
public class Instrutor {
    private String nome;
    private String genero;
    private String formacao; // lista de cursos e formações

    /**
     * Construtor da classe
     * @param nome Nome do instrutor
     * @param genero Género do instrutor
     * @param formacao Lista de cursos e formações
     */
    public Instrutor(String nome, String genero, String formacao) {
        this.nome = nome;
        this.genero = genero;
        this.formacao = formacao;
    }

    /** @return Nome do instrutor */
    public String getNome() { return nome; }

    /** @return Género do instrutor */
    public String getGenero() { return genero; }

    /** @return Lista de cursos e formações do instrutor */
    public String getFormacao() { return formacao; }

    /**
     * Devolve os dados do instrutor em texto.
     * @return Nome, género e formação
     */
    public String toString() {
        return nome + " (" + genero + ") | Formação: " + formacao;
    }
}