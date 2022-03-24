public class ContaSalario extends Conta implements Tributavel{

    private int quantidadeDeSaques;

    public ContaSalario(int numero, int agencia, String banco, double saldo, int quantidadeDeSaques) {
        super(numero, agencia, banco, saldo);
        this.quantidadeDeSaques = quantidadeDeSaques;
    }

    @Override
    public String toString() {
        return "ContaSalario{" +
                "quantidadeDeSaques=" + quantidadeDeSaques +
                '}';
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public double valorImposto(){
        return this.getSaldo() * 0.02;
    }

    @Override
    public double sacar(double valor) {
        if (quantidadeDeSaques > 0) {
            setSaldo(getSaldo() - valor);
            return valor;
        }
        return 0.0;
    }

    @Override
    public double depositar(double valor) {
        setSaldo(getSaldo() + valor);
        return valor;
    }


}
