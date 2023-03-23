package bigdecimal;

import java.math.BigDecimal;

public class bigdecimalTest {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("1.00");
        BigDecimal decimal2 = new BigDecimal("1.0");



        System.out.println(decimal.equals(decimal2));
        System.out.println(decimal.scale());
        System.out.println(decimal.compareTo(decimal2));
    }
}
