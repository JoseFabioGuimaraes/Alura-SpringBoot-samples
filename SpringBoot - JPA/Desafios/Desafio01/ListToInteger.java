import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListToInteger {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        input.stream()
                .map(s -> {try{return Optional.of(Integer.parseInt(s));} catch (NumberFormatException e){
                    return Optional.<Integer>empty();}})
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList()
                .forEach(System.out::println);
    }
}
