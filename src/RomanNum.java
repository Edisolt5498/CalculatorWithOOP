public class RomanNum implements Calculable {
    private final static String[] BookRoman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
            "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII",
            "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
            "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
            "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
            "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    private final String romanNum;
    private int arabNum;

    public RomanNum(String romanNum) {
        this.romanNum = romanNum;
        if (!isItRoman()) {
            throw new NumberFormatException("Не римское число от 0 до 100");
        }
    }

    ///////////////////////////////////////////////////////////////////

    public RomanNum valueOf (String value) {
        return new RomanNum(value);
    }
    public String add(RomanNum valueToAdd) {
        return arabToRoman(this.arabNum + valueToAdd.arabNum);
    }
    @Override
    public String add(String value) {
        return add(valueOf(value));
    }

    public String subtract(RomanNum valueToSub) {
        return arabToRoman(this.arabNum - valueToSub.arabNum);
    }
    @Override
    public String subtract(String value) {
        return subtract(valueOf(value));
    }

    public String multiply(RomanNum valueToMul) {
        return arabToRoman(this.arabNum * valueToMul.arabNum);
    }
    @Override
    public String multiply(String value) {
        return multiply(valueOf(value));
    }
    public String divide(RomanNum valueToDiv) {
        return arabToRoman(this.arabNum / valueToDiv.arabNum);
    }
    @Override
    public String divide(String value) {
        return divide(valueOf(value));
    }


    ///////////////////////////////////////////////////////////////////

    public String getRomanNum() {
        return romanNum;
    }

    public int getArabNum() {
        return arabNum;
    }

    public static boolean isItRoman (String isThisRoman) {
        for (String s : BookRoman) {
            if (isThisRoman.equals(s)) {
                return true;
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////
    private boolean isItRoman () {
        for (int i = 0; i < BookRoman.length; i++) {
            if (romanNum.equals(BookRoman[i])) {
                arabNum = i;
                return true;
            }
        }
        return false;
    }

    private String arabToRoman (int arabValue) {
        return BookRoman[arabValue];
    }

    ///////////////////////////////////////////////////////////////////

    @Override
    public String toString () {
        return getRomanNum();
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        return (((RomanNum)obj).arabNum == arabNum);
    }

    @Override
    public int hashCode() {
        return this.arabNum;
    }
}
