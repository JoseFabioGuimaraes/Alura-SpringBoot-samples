public class Palindrome {
    public static void main(String[] args) {
        System.out.println(ehPalindromo("A cara rajada da jararaca"));
        System.out.println(ehPalindromo("Fábio"));
    }

    public static boolean ehPalindromo(String palavra){
        String palavraSemEspaco = palavra.replace(" ", "")
                .toLowerCase();
        return new StringBuilder(palavraSemEspaco).reverse().toString().equalsIgnoreCase(palavraSemEspaco);
    }
}
