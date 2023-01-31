public class ArabNum implements Calculable{
    private final int num;

    public ArabNum(String num) {
        this.num = Integer.parseInt(num);
    }

    /////////////////////////////////////////////////////////////////////

    @Override
    public String add(String value) {
        return String.valueOf(num + Integer.parseInt(value));
    }
    @Override
    public String subtract(String value) {
        return String.valueOf(num - Integer.parseInt(value));
    }
    @Override
    public String multiply(String value) {
        return String.valueOf(num * Integer.parseInt(value));
    }
    @Override
    public String divide(String value) {
        return String.valueOf(num / Integer.parseInt(value));
    }

    /////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return Integer.toString(num);
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        return (((ArabNum)obj).num == num);
    }

    @Override
    public int hashCode() {
        return num;
    }
}