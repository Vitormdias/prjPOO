package fatec.poo.model;

public class Fiscal extends Pessoa {

    private String codigo;
    public String local;

    public Fiscal(String codigo, String cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
        this.codigo = codigo;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
}
