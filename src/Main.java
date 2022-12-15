import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Yakushev V.S. 14.12.2022
 * */
public class Main {
    public static void main(String[] args) throws Exception {
        /*Scanner sc = new Scanner(System.in);
        System.out.println(calc(sc.nextLine()));*/
        System.out.println(calc("1+5"));
        System.out.println(calc("9-5"));
        System.out.println(calc("9*5"));
        System.out.println(calc("9/3"));

    }

    public static String calc(String input) throws Exception {
        String[] str;
        if (input.contains("+")) {
            str = input.split("\\+");
            input = getString(input, str);
        } else if (input.contains("-")) {
            str = input.split("-");
            input = getString(input, str);
        } else if (input.contains("*")) {
            str = input.split("\\*");
            input = getString(input, str);
        } else if (input.contains("/")) {
            str = input.split("/");
            input = getString(input, str);
        } else {
            throw new Exception("Некорректное действие...");
        }
        return input;
    }


    private static String getString(String input, String[] str) {
        if((Integer.parseInt(str[0]) < 10 && Integer.parseInt(str[0]) >= 1) &&
            Integer.parseInt(str[1]) < 10 && Integer.parseInt(str[1]) >= 1) {
            Integer sum = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
            input = String.valueOf(sum);
        } else {
            System.out.println("Вы ввели число меньше 0, либо больше 10.");
        }
        return input;
    }
}
