package bai_tap.ex02;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.LocalDate.now;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//       1 Viết chương trình để lấy ngày hiện tại của hệ thống và các nơi bao gồm : Asia/Tokyo, Australia/Sydney ,America/Sao_Paulo
        LocalDate todayTokyo = now(ZoneId.of("Asia/Tokyo"));
        LocalDate todaySydney = now(ZoneId.of("Australia/Sydney"));
        LocalDate todaySaoPaulo = now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Tokyo " + todayTokyo);
        System.out.println("Sydney "+todaySydney);
        System.out.println("SaoPaulo "+todaySaoPaulo);
//       2 Viết chương trình để lấy thời gian hiện tại (giờ phút giây).
        LocalTime now = LocalTime.now();
        LocalDate dateNow = now();
        System.out.println("Time now: " + now);
//      3  Viết chương trình để tính toán số ngày trong tháng hiện tại.

        int length  = dateNow.lengthOfMonth();
        System.out.println("Length of Month : "+length);
//      4  Viết chương trình để tính toán số ngày trong năm hiện tại.
        int lengthOfYear = dateNow.lengthOfYear();
        System.out.println("Length of Year : "+lengthOfYear);
//      5  Viết chương trình để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "27/08/2024";
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("(Task 5) convert string to LocalDate: "+localDate);
//       6 Viết chương trình để chuyển đổi một đối tượng LocalDate sang một chuỗi ngày (dd/MM/yyyy).
        LocalDate ld = LocalDate.now();
        System.out.print("Task 6 convert LocalDate to string: ");
        System.out.println(ld.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println();
//       7 Viết chương trình để chuyển đổi một đối tượng LocalDateTime sang một chuỗi ngày(dd/MM/yyyy HH:mm:ss).
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
       
//       8 Viết chương trình để so sánh hai ngày LocalDate ( trả về int ).
        LocalDate date1=LocalDate.of(2018,1,1);
        LocalDate date2=LocalDate.of(2019,2,1);
        if(date1.equals(date2)){
            System.out.println(date1 + " and "+date2+" are equals");
        } else if(date1.compareTo(date2)>0){
            System.out.println(date1+" is after "+date2);
        } else {
            System.out.println(date1+" is before "+date2);
        }

//       9 Viết chương trình để so sánh hai thời gian LocalTime.
        LocalTime time1=LocalTime.of(20,1,1);
        LocalTime time2=LocalTime.of(16,2,1);
        if(time1.equals(time2)){
            System.out.println(time1 + " and "+time2+" are equals");
        } else if(time1.compareTo(time2)>0){
            System.out.println(time1+" is after "+time2);
        } else {
            System.out.println(time1+" is before "+time2);
        }
//      10  Viết chương trình để thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào.
        LocalDate today = LocalDate.now();
        System.out.println("Enter the number u want to add");
        int num = Integer.parseInt(scanner.nextLine());
        LocalDate newDate = today.plusDays(num);
        System.out.println("New Date : "+newDate);
        LocalTime newTime = time1.plusHours(2);

//       11 Viết chương trình để tính toán ngày (LocalDate) tiếp theo hoặc ngày trước đó của một ngày.

        System.out.println("Today "+today);
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("Tomorrow "+tomorrow);
        LocalDate yesterday = today.plusDays(-1);
        System.out.println("Yesterday "+yesterday);
        LocalDate dayAfterTomorrow = today.plusDays(2);
        System.out.println("DayAfterTomorrow "+dayAfterTomorrow);
        LocalDate dayBeforeYesterday = today.plusDays(-2);
        System.out.println("DayBeforeYesterday "+dayBeforeYesterday);
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
    public static int compareDate(LocalDate date1, LocalDate date2) {
        return date1.compareTo(date2);
    }
    public static int compareTime(LocalTime time1, LocalTime time2) {
        return time1.compareTo(time2);
    }
}
