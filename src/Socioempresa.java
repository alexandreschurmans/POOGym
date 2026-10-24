
public class Socioempresa extends Socio {
    private String nomeEmpresa;
    private String nif;

    public Socioempresa(String nome, int numero, String email, String nomeEmpresa, String nif) {
        super(nome, numero, email, 0.20, "Empresa");
        this.nomeEmpresa = nomeEmpresa;
        this.nif = nif;
    }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public String getNif() { return nif; }

    public String toString() {
        return super.toString() + " | Empresa: " + nomeEmpresa + " (NIF " + nif + ")";
    }
}