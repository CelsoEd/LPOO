package Model;


public class Motorista {
    private String nome;
    private String CPF;
    private String CNH;
    private Double saldo;

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

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Motorista(String nome, String CPF, String CNH, Double saldo) {
        this.nome = nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.saldo = saldo;
    }

    public Motorista() {
    }

    @Override
    public String toString() {
        return "\nMotorista" + 
                "\nNome:" + getNome() + 
                "\nCPF: " + getCPF() + 
                "\nCNH: " + getCNH()+
                "\n Saldo: "+getSaldo();
    }

    
      
}
