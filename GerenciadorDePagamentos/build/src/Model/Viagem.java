package Model;

public class Viagem {

    private String origem;
    private String destino;
    private Double TotalViagem;
    private int idViagem;

    private Cliente cliente;
    private Motorista motorista;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getTotalViagem() {
        return TotalViagem;
    }

    public void setTotalViagem(Double TotalViagem) {
        this.TotalViagem = TotalViagem;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Viagem() {
    }

    public Viagem(int idViagem, String origem, String destino, Double TotalViagem, Cliente cliente, Motorista motorista) {
        this.idViagem = idViagem;
        this.origem = origem;
        this.destino = destino;
        this.TotalViagem = TotalViagem;
        this.cliente = cliente;
        this.motorista = motorista;
    }

    public Viagem(String origem, String destino, Double TotalViagem, Cliente cliente, Motorista motorista) {
        this.origem = origem;
        this.destino = destino;
        this.TotalViagem = TotalViagem;
        this.cliente = cliente;
        this.motorista = motorista;
    }

    @Override
     public String toString() {
        return /**"\nMotorista: " + getMotorista().getNome()
                + "\nCliente: " + getCliente().getNome()
                + */"\nViagem"
                + "\nOrigem: " + getOrigem()
                + "\nDestino:" + getDestino()
                + "\nValor Viagem: " + getTotalViagem();
    }
}
