package bai_tap.ex01;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(100, 234, 123, 34, 567, 64, 97, 88, 49, 10));
//        Sử dụng Stream API để duyệt qua mảng và phương thức max() để tìm số lớn nhất trong mảng.
        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
        Optional<Integer> max = list.stream().max(Comparator.comparingInt(Integer::intValue));
        if (max.isPresent()) {
            System.out.println(max.get());
        } else
            System.out.println("List is empty");
//        Sử dụng Stream API và phương thức filter() để tìm số chẵn
        list.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
//        Sử dụng Stream API và phương thức filter() để lọc các số lớn hơn một giá trị xác định mà người dùng nhập vào
        System.out.println("Enter the number you want to compare:");
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        list.stream().filter(num1 -> num1 > num).forEach(System.out::println);
//        Sử dụng Stream API và phương thức reduce() để tính tổng của các số trong danh sách.
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        System.out.println();
//        Sử dụng Stream API và phương thức anyMatch() để kiểm tra xem danh sách có chứa ít nhất một số chẵn hay không.
        System.out.println("Any Match");
        System.out.println(list.stream().anyMatch(num2 -> num2 %2==0));;
//        Sử dụng Stream API và phương thức range() để tạo danh sách các số từ x đến y.
        IntStream.range(1, 10).forEach(i -> System.out.print(i + " "));
        System.out.println();
//        Sử dụng Stream API và phương thức sorted() để sắp xếp danh sách theo thứ tự bảng chữ cái.
        list.stream().sorted().forEach(i -> System.out.print(i + " "));
        System.out.println();
//        Sử dụng Stream API và phương thức map() để chuyển các chuỗi thành chữ in hoa.
        List<String> string = new ArrayList<>(List.of("banana", "peach", "grape"));
        string.stream().map(str -> str.toUpperCase()).forEach(i -> System.out.print(i + " "));
        System.out.println();



    }
}
