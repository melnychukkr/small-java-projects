package home.calculator;

import home.calculator.exception.DivideByNullException;
import home.calculator.exception.IncorrectOperationTypeException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Simple calculator. The program works as follows: operation's name, digits you want to calculate.
 * Usage example:
 * ADD 2 3
 * Result is: 5.0
 */
public class Calculator {

    private static final String SPLIT_BY_WHITESPACE_REGEX = "\\s+";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String readLine = reader.readLine();
            double result = startOperation(readLine);
            System.out.println("Result is: " + result);
        } catch (IncorrectOperationTypeException inc) {
            System.out.println("You typed incorrect command.");
        } catch (DivideByNullException zero) {
            System.out.println("You can't divide by 0.");
        }
    }

    public static double startOperation(String readLine) throws Exception {
        String[] split = splitString(readLine);
        double result;
        if (split[0].equals("ADD")) {
            result = add(split);
        } else if (split[0].equals("SUB")) {
            result = sub(split);
        } else if (split[0].equals("MUL")) {
            result = mul(split);
        } else if (split[0].equals("DIV")) {
            result = dev(split);
        } else {
            throw new IncorrectOperationTypeException();
        }
        return result;
    }

    public static String[] splitString(String readLine) {
        return readLine.split(SPLIT_BY_WHITESPACE_REGEX);
    }

    public static int add(String[] split) {
        int result = Integer.valueOf(split[1]);
        for (int i = 2; i < split.length; i++) {
            result = result + Integer.valueOf(split[i]);
        }
        return result;
    }

    public static int sub(String[] split) {
        int result = Integer.valueOf(split[1]);
        for (int i = 2; i < split.length; i++) {
            result = result - Integer.valueOf(split[i]);
        }
        return result;
    }

    public static int mul(String[] split) {
        int result = Integer.valueOf(split[1]);
        for (int i = 2; i < split.length; i++) {
            result = result * Integer.valueOf(split[i]);
        }
        return result;
    }

    public static double dev(String[] split) throws DivideByNullException {
        double result = Integer.valueOf(split[1]);
        for (int i = 2; i < split.length; i++) {
            Integer integer = Integer.valueOf(split[i]);
            if (integer.equals(0))
                throw new DivideByNullException();
            result = result / integer;
        }
        return result;
    }
}


