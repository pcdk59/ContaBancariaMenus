public class ContaPoupanca extends Conta{

    private int diaAniversario;
    private double taxaDeJuros;

    public ContaPoupanca(int numero, int agencia, String banco, double saldo, int diaAniversario, double taxaDeJuros) {
        super(numero, agencia, banco, saldo);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }

    @Override
    public double sacar(double valor) {
        setSaldo(getSaldo() - valor);
        return valor;
    }

    @Override
    public double depositar(double valor) {
        setSaldo(getSaldo() + valor);
        return valor;
    }

    @Override
    public double getSaldo() {
        return this.saldo + this.taxaDeJuros*this.saldo;
    }
}
