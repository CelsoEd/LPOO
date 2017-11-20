package Model;




public class Cliente {
  private String nome; 
  private String CPF;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Cliente() {
    }

    public Cliente(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "\nCliente" + 
                "\nNome: " + getNome() + 
                "\nCPF:" + getCPF();
    }
    
    
  
}
