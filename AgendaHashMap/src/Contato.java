public class Contato {

    private String nome;
    private String fone;
    private String endereco;

    public Contato() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: "+getNome()+" - Telefone: "+getFone()+" - Endereco: "+getEndereco();
    }
    
}
