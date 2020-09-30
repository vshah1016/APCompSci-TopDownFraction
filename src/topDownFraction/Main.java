package topDownFraction;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("Input the numerator for the first fraction: ");
        int firstNumerator = scanner.nextInt();

        System.out.print("Input the denominator for the first fraction: ");
        int firstDenominator = scanner.nextInt();
        System.out.println();

        System.out.print("Input the numerator for the second fraction: ");
        int secondNumerator = scanner.nextInt();

        System.out.print("Input the denominator for the second fraction: ");
        int secondDenominator = scanner.nextInt();
        System.out.println();

        Fraction a = new Fraction(firstNumerator, firstDenominator);
        Fraction b = new Fraction(secondNumerator, secondDenominator);

        Fraction c;
        System.out.print("What operation would you like | + | - | * | / | : ");
        String operation = scanner.next();
        if (operation.equals("+")) c = a.plus(b);
        else if (operation.equals("-")) c = a.minus(b);
        else if (operation.equals("*")) c = a.times(b);
        else if (operation.equals("/")) c = a.over(b);
        else throw new Exception("You entered a bad input. Try again.");
        System.out.println();

        System.out.println( a.unsimplified() + " " + operation + " " + b.unsimplified() + " = " + c);


    }
}
