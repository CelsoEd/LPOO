package Model;

import Model.FormaDePagamento;
import Model.Motorista;
import Model.Viagem;

public class ValePresente extends FormaDePagamento{
    private String codigo;
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ValePresente() {
    }

    public ValePresente(String codigo, double valor, Viagem viagem) {
        super(viagem);
        this.codigo = codigo;
        this.valor = valor;
    }
    
    public ValePresente(String codigo,double valor){
        this.codigo = codigo;
        this.valor = valor;
    }

    

    
    
    public void PagamentoMotorista(Viagem viagem,Motorista motorista) {
        double pagamento=(viagem.getTotalViagem()*0.80);        
        motorista.setSaldo(motorista.getSaldo()+pagamento);        
    }

    @Override
    public String toString() {
        return getViagem()+"\nValePresente" + 
                "\nCodigo = " + getCodigo()+
                "\nValor = "+getValor();
    }
    
    
    
    
    

    
    
}
