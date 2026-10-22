public class Instrutor {
    private String nome;
    private String genero;
    private String formacao; // lista de cursos e formações

    public Instrutor(String nome, String genero, String formacao) {
        this.nome = nome;
        this.genero = genero;
        this.formacao = formacao;
    }

    public String getNome() { return nome; }
    public String getGenero() { return genero; }
    public String getFormacao() { return formacao; }

    @Override
    public String toString() {
        return nome + " (" + genero + ") | Formação: " + formacao;
    }
}