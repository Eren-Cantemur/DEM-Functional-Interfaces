import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface // Optional
interface Converter<F, T> {
    T convert(F from);
}

public class Main {
    public static void main(String[] args) {

        // Functional References
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);

        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        // Lambda Expressions
        // Regular version
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // Lambda version
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });


        // Method References
        Converter<String, Integer> converterMR = Integer::valueOf;
        Integer convertedMR = converter.convert("123");
        System.out.println(convertedMR);   // 123
    }
}