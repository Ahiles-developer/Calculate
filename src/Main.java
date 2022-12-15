import java.util.Scanner;

/**
 * Yakushev V.S. 14.12.2022
 * */
public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        calc("1 + 5");


    }

    public static String calc(String input) {
        String[] str;
        if(input.contains(" + ")) {
            str = input.split(" + ");
            Integer sum = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
            input = String.valueOf(sum);
        }

        return input;
    }
}