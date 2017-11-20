package Model;

import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Win 10
 */
public class CartaoDeCredito extends FormaDePagamento {

    private int NumCartao;
    private String VencimentoCartao;
    private String NomeTitular;
    private int CVV;

    public int getNumCartao() {
        return NumCartao;
    }

    public void setNumCartao(int NumCartao) {
        this.NumCartao = NumCartao;
    }

    public String getVencimentoCartao() {
        return VencimentoCartao;
    }

    public void setVencimentoCartao(String VencimentoCartao) {
        this.VencimentoCartao = VencimentoCartao;
    }

    public String getNomeTitular() {
        return NomeTitular;
    }

    public void setNomeTitular(String NomeTitular) {
        this.NomeTitular = NomeTitular;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public CartaoDeCredito() {
    }

    public CartaoDeCredito(int NumCartao, String VencimentoCartao, String NomeTitular, int CVV) {
        this.NumCartao = NumCartao;
        this.VencimentoCartao = VencimentoCartao;
        this.NomeTitular = NomeTitular;
        this.CVV = CVV;
    }

    public CartaoDeCredito(int NumCartao, String VencimentoCartao, String NomeTitular, int CVV, int id, String data, Viagem viagem) {
        super(id, data, viagem);
        this.NumCartao = NumCartao;
        this.VencimentoCartao = VencimentoCartao;
        this.NomeTitular = NomeTitular;
        this.CVV = CVV;
    }

    public CartaoDeCredito(int NumCartao, String VencimentoCartao, String NomeTitular, int CVV, Viagem viagem) {
        super(viagem);
        this.NumCartao = NumCartao;
        this.VencimentoCartao = VencimentoCartao;
        this.NomeTitular = NomeTitular;
        this.CVV = CVV;
    }

    

    
    public void PagamentoMotorista(Viagem viagem,Motorista motorista) {
        double pagamento=(viagem.getTotalViagem()*0.80);        
        motorista.setSaldo(motorista.getSaldo()+pagamento);        
    }

    @Override
    public String toString() {
        return "\n CartaoDeCredito" + 
                "\nNumCartao=" + getNumCartao() + 
                "\nVencimento Cartao=" + getVencimentoCartao() + 
                "\nNome Titular=" + getNomeTitular() + 
                "\nCVV=" + getCVV();
    }

    
    
    

}
