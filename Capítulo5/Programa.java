class Conta {
    int numero;
    private String titular;
    private double saldo;
    private double limite;
    private static int totalDeContas;

    // contrutor
    Conta (String titular) {
        this.titular = titular;
        this.limite = 1000;
        Conta.totalDeContas = Conta.totalDeContas + 1;
    }

    Conta () {
        this.titular = "SEM ARGUMENTOS";
    }

    public double getSaldo() {
        return this.saldo + this.limite;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void deposita(double quantidade) {
        this.saldo = this.saldo + quantidade;
    }

    public boolean saca(double valor) {
        // permite sacar até o saldo
        if (this.saldo < valor) {
            System.out.println("Não é permitido sacar um valor maior que o saldo!");
            return false;
        } else {
            this.saldo = this.saldo - valor;
            return true;
        }
    }

    public boolean transfere(Conta destino, double valor) {
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

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }
}

class Cliente {
    private String nome;
    private String endereco;
    private String cpf;
    private int idade;

    public void mudaCPF(String cpf) {
        if (this.idade <= 60) {
            validaCPF(cpf);
        }
        this.cpf = cpf;
    }

    private void validaCPF(String cpf) {
        // série de regras aqui, falha caso nçao seja válido
    }
}

class Programa {
    public static void main(String[] args) {
        // criando a conta
        Conta minhaConta;
        minhaConta = new Conta("Duke");
        Conta suaConta;
        suaConta = new Conta();

        System.out.println(minhaConta.getTitular());
        System.out.println(suaConta.getTitular());
        // alterando os valores de minhaConta
        minhaConta.deposita(1000.0);

        // saca 200 reais
        minhaConta.saca(200);

        // deposita 500 reais
        minhaConta.deposita(500);
        System.out.println("Saldo atual: " + minhaConta.getSaldo());

        // tentar sacar mais que o limite
        System.out.println("Sacar 2000");
        if (minhaConta.saca(2000)) {
            System.out.println("Consegui sacar");
        } else {
        }
            System.out.println("Não consegui sacar");
    }
}
