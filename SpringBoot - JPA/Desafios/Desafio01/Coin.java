public enum Coin {
    DOLAR(5.80),
    EURO(6.00),
    REAL(1.0);

    private final double taxa;

    Coin(double taxa){
        this.taxa = taxa;
    }

    public double convertePara(double valorEmReal){
        return  valorEmReal / taxa;
    }
}
