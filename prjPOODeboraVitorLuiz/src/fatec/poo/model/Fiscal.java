package fatec.poo.model;

public class Fiscal extends Pessoa {

    private String codigo;
    private String local;
    private String sigla;

    public Fiscal(String codigo, String cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
        this.codigo = codigo;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getLocal() {
        return local;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
}
