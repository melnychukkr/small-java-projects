package home;

/**
 * Multiplication table solution using while statements
 *
 * @author Karolina Melnychuk
 */

public class MultiplicationMatrix {
    public static void main(String[] args) {
        int a = 1;

        while (a <= 10) {
            int b = 1;
            while (b <= 10) {
                int sum = a * b;
                System.out.print(sum);
                System.out.print(getAppropriateSpace(sum));
                ++b;
            }
            ++a;
            System.out.println();
        }
    }

    private static String getAppropriateSpace(int sum) {
        String space;
        if (sum < 10) {
            space = "    ";
        } else if (sum >= 100) {
            space = "  ";
        } else {
            space = "   ";
        }
        return space;
    }
}
