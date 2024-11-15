import java.util.Arrays;
import java.util.Optional;

public class Friday {
    public static void main(String[] args) {
        String s = "I like to visit australia";
        
        String[] new_str = s.split(" ");

        for(String str : new_str) {
            System.out.println(str + " ");
        }
        System.out.println("---------------------------");
        
        Optional<String> ans =    Arrays.asList(new_str)
                                        .stream()
                                        .sorted((s1, s2) -> s2.length() - s1.length())
                                        .skip(1)
                                        .findFirst();
        
        System.out.println("Second max word: "+ ans.get());
    }
}
