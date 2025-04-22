import java.util.Arrays;
import java.util.List;

public class EmailToLowerCase {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(converteEmails(emails));
    }

    public static List<String> converteEmails(List<String> emails){
        return emails.stream()
                .map(e -> e.trim().toLowerCase())
                .toList();
    }
}
