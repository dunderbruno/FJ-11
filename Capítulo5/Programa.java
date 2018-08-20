class Conta {
    int numero;
    String titular;
    double saldo;

    boolean saca(double valor) {
        if (this.saldo < valor) {
            return false;
        }
        else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }


    void deposita(double quantidade) {
        this.saldo += quantidade;
    }

    boolean transfere(Conta destino, double valor) {
        boolean retirou = this.saca(valor);
        if (retirou == false) {
            // não deu pra sacar!
            return false;
        }
        else {
            destino.deposita(valor);
            return true;
        }
    }
}

class Programa {
    public static void main(String[] args) {
        // criando a conta
        Conta minhaConta;
        minhaConta = new Conta();

        // alterando os valores de minhaConta
        minhaConta.titular = "Duke";
        minhaConta.saldo = 1000.0;

        // saca 200 reais
        minhaConta.saca(200);

        // deposita 500 reais
        minhaConta.deposita(500);
        System.out.println("Saldo atual: " + minhaConta.saldo);

        // tentar sacar mais que o limite
        System.out.println("Sacar 2000");
        if (minhaConta.saca(2000)) {
            System.out.println("Consegui sacar");
        } else {
            System.out.println("Não consegui sacar");
        }
    }
}
