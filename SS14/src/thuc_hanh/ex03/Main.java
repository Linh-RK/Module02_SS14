package thuc_hanh.ex03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("banana");
        strings.add("Strawberry");
        strings.add("grape");
        strings.add("peach");
        strings.add("pineapple");
        System.out.println("Even numbers: " );
        strings.stream()
                .filter(str -> str.startsWith("p") && str.length() >5)
                .forEach(System.out::println);
    }
}
