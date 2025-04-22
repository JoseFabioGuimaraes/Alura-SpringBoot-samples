import java.util.Optional;

public class PositiveNumber {
    public static void main(String[] args) {
        System.out.println(processaNumero(Optional.of(5)));
        System.out.println(processaNumero(Optional.of(-3)));
        System.out.println(processaNumero(Optional.empty()));

    }


    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
      return numero.filter(n->n>0).map(n-> n*n);
    }
}
