public class ContaCorrente extends Conta implements Tributavel{

    private double chequeEspecial;

    public ContaCorrente(int numero, int agencia, String banco, double saldo, double chequeEspecial) {
        super(numero, agencia, banco, saldo);
        chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "chequeEspecial=" + chequeEspecial +
                '}';
    }

    public double valorImposto() {
        return this.chequeEspecial * 0.02;
    }

    @Override
    public double sacar(double valor) {
        System.out.println("Tentando sacar: " + valor);
        if (valor <= (getSaldo() + chequeEspecial)) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saldo atual: " +getSaldo());

            if (getSaldo() < 0) {
                System.out.println("Valor restante do cheque especial: " + getChequeEspecial());
            }
            return valor;
        } else {
            System.out.println("Você não tem o valor do cheque especial disponível para esse saque. Valor do cheque: " + chequeEspecial);
        }
        return 0.0;

    }

    @Override
    public double depositar(double valor) {
        System.out.println("Depositando: " + valor);
        setSaldo(getSaldo() + valor);
        System.out.println("Saldo atual: " +getSaldo());

        return valor;
    }

    private double getChequeEspecial() {
        if (getSaldo() < 0)
            return chequeEspecial - Math.abs(getSaldo());
        else
            return chequeEspecial;
    }

    @Override
    public double getSaldo() {
        return this.chequeEspecial + this.saldo;
    }
}
