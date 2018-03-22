package home;

/**
 * FizzBuzz problem solution using two if statements
 * @author Karolina Melnychuk
 */
public class FizzBuzzProblem {
    public static void main(String[] args) {
        String convertedNumber;
        String fizz;
        String buzz;
        for (int i = 1; i <= 100; i++) {
            convertedNumber = i + "";
            fizz = "Fizz";
            buzz = "Buzz";
            if (i % 5 != 0) {
                buzz = "";
            } else {
                convertedNumber = "";
            }
            if (i % 3 != 0) {
                fizz = "";
            } else {
                convertedNumber = "";
            }
            System.out.println(convertedNumber + fizz + buzz);
        }
    }
}
