public enum Months {

    JANEIRO(31),
    FEVEREIRO(28),
    MARCO(31),
    ABRIL(30),
    MAIO(31),
    JUNHO(30),
    JULHO(31),
    AGOSTO(31),
    SETEMBRO(30),
    OUTRUBRO(31),
    NOVEMBRO(30),
    DEZEMBRO(31);

    private final int days;
    Months(int days){
        this.days = days;
    }

    public int getNumberDays(){
        return days;
    }
}
