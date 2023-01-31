import java.util.InputMismatchException;

public class inputForArabOrRomanCalc{
    private String num1 = "0";
    private String num2 = "0";
    private char operator = '0';
    private final String inputValue;

    public inputForArabOrRomanCalc (String inputValue) {
        this.inputValue = inputValue;
        this.OK();
    }

    private void OK () {
        for (int i = 0; i < inputValue.length(); i++) {

            if ((inputValue.charAt(i)) == '+'
                    || (inputValue.charAt(i)) == '-'
                    || (inputValue.charAt(i)) == '*'
                    || (inputValue.charAt(i)) == '/') {

                operator = inputValue.charAt(i); // проверка на наличие знака и сохранение знака и потенциальных чисел
                num1 = inputValue.substring(0, i);
                num2 = inputValue.substring(i + 1);
                break;

            } else if (i == inputValue.length()-1) {
                throw new InputMismatchException("Где знак?...Неправильный ввод...");
            }

        }
    }

    public char getOperator() {
        return operator;
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public boolean isItRoman () {
        return RomanNum.isItRoman(num1) && RomanNum.isItRoman(num2);
    }
    public boolean isItArab () {
        return !RomanNum.isItRoman(num1) && !RomanNum.isItRoman(num2);
    }
}
