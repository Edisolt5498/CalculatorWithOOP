import java.util.Scanner;

public class otherMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Можно и нужно ввести выражение из двух арабских чисел от 0 до 10 " +
                "либо римских чисел от 0 до X. Разрешенны операции:");
        System.out.println("деления /\nумножения *\nсложения +\nвычитания -\nК примеру 4 + 8 или III * IX");

        System.out.print("Input:");
        inputForArabOrRomanCalc input = new inputForArabOrRomanCalc( in.nextLine().
                replaceAll(" ", "").
                trim() );
        Calculable finalCalculate;
        String result = "";

        try {
            if (input.isItArab()) {
                finalCalculate = new ArabNum(input.getNum1());
                result = calcForRomanOrArab( finalCalculate,
                        input.getNum2(),
                        input.getOperator() );
            } else if (input.isItRoman()) {
                finalCalculate = new RomanNum(input.getNum1());
                result = calcForRomanOrArab( finalCalculate,
                        input.getNum2(),
                        input.getOperator() );
            }
            else {
                System.out.println("Введены неверные данные. Числа разных систем");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введены неверные данные.");
        }
        System.out.println(result);
    }
    public static String calcForRomanOrArab (Calculable num1, String num2, char oper) {
        switch (oper) {
            case '+' -> {return num1.add(num2);}
            case '-' -> {return num1.subtract(num2);}
            case '*' -> {return num1.multiply(num2);}
            default -> {
                try {
                    return num1.divide(num2);
                } catch (ArithmeticException a) {
                    return "Ошибка, деление на ноль.";
                }
            }
        }
    }
}
