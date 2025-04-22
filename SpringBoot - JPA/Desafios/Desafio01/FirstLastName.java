public class FirstLastName {
    public static void main(String[] args) {
        System.out.println(obterPrimeiroEUltimoNome("  José Fábio Guimarães   "));
        System.out.println(obterPrimeiroEUltimoNome("Fábio  "));
    }

    public static String obterPrimeiroEUltimoNome(String nome){
        String[] nomes = nome.trim().split("\\s+");
        if(nomes.length == 1){
            return nomes[0];
        }
        return nomes[0] + " " + nomes[nomes.length -1];
    }
}
