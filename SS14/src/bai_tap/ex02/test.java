package bai_tap.ex02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = dateIn(sc);
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("(Task 5) convert string to LocalDate: "+localDate);
    }
    public static String dateIn(Scanner sc) {
        Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\-](0?[1-9]|1[012])[\\-]\\d{4}$");
        System.out.println("Enter date");
        String inputDate="" ;
        do {
            inputDate = sc.nextLine();
            if(inputDate.isEmpty()){
                System.err.println("Data is empty! ");
                break;
            } else {
                Matcher matcher = pattern.matcher(inputDate);
                if (matcher.find()) {
                    return inputDate;
                } else
                    break;
            }
        }while(true);
        return inputDate;
    }
}
