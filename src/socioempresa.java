public class Socioempresa extends Socio {
    public static final double DESCONTO_EMPRESA = 0.20;

    private String nomeEmpresa;
    private String nif;

    public Socioempresa(String nome, int numero, String email, String nomeEmpresa, String nif) {
        super(nome, numero, email, DESCONTO_EMPRESA);
        this.nomeEmpresa = nomeEmpresa;
        this.nif = nif;
    }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public String getNif() { return nif; }

    @Override
    public String toString() {
        return super.toString() + " | Empresa: " + nomeEmpresa + " (NIF " + nif + ")";
    }
}

//ola
