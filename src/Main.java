import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Yakushev V.S. 14.12.2022
 * */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        String operation;
        String result;
        boolean isRomain;
        String[] operands = input.split("[+\\-*/]");
        if(operands.length != 2) throw new Exception("Должно быть только два числа");

        operation = detectOperation(input);
        //если оба числа римские
        if(Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            //конвертируем оба числа в римские
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[1]);
            isRomain = true;
        }
        //если оба числа арабские
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRomain = false;
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }
        //если какое-либо число больше 10
        if(num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int arabian = calculate(num1, num2, operation);
        if(isRomain) {
            //если римское число получилось меньше либо равно нулю, генерируем ошибку
            if(arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            //конвертируем результат операции из арабского в римское
            result = Roman.convertToRoman(arabian);
        } else {
            //конвертируем арабское число в тип String
            result = String.valueOf(arabian);
        }
        //возвращаем результат
        return result;
    }

    static String detectOperation(String input) {
        if (input.contains("+")) {
            return "+";
        } else if (input.contains("-")) {
            return "-";
        } else if (input.contains("*")) {
            return "*";
        } else if (input.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int calculate(int a, int b, String operation) {
        if(operation.equals("+")) {
            return a + b;
        } else if (operation.contains("-")) {
            return a - b;
        } else if (operation.contains("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}

class Roman {
    static String[] romanArray = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    //проверяем римское это число или нет
    public static boolean isRoman(String value) {
        for (int i = 0; i < romanArray.length; i++) {
            if(value.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    //конвертируем в арабское
    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if(roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    //конвертируем в римское
    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}