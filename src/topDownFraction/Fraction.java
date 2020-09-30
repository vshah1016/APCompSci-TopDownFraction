package topDownFraction;


public class Fraction {
    public final int numerator;
    public final int denominator;

    public int simplifiedNumerator;
    public int simplifiedDenominator;

    public Fraction(int numerator, int denominator) throws Exception {
        if (denominator == 0) throw new Exception("Denominator cannot be 0"); //shivam: System.exit(0);
        this.numerator = numerator;
        this.denominator = denominator;

        simplify();
    }

    private void simplify() {
        int gcd = gcd();
        simplifiedNumerator = numerator / gcd;
        simplifiedDenominator = denominator / gcd;
    }

    private int gcd() { //Euclidian algorithm but more efficient than recursion
        int num1 = Math.max(numerator, denominator);
        int num2 = Math.min(numerator, denominator);

        int gcd = num1 % num2;
        if (gcd == 0) return num2;

        while (gcd != 0) {
            num1 = num2;
            num2 = gcd;
            gcd = num1 % num2;
        }

        return num2;
    }

    private Fraction reciprocal() throws Exception {
        return new Fraction(simplifiedDenominator, simplifiedNumerator);
    }

    public Fraction times(Fraction fraction) throws Exception {
        return new Fraction(simplifiedNumerator * fraction.simplifiedNumerator, simplifiedDenominator * fraction.simplifiedDenominator);
    }

    public Fraction plus(Fraction b) throws Exception {
        return new Fraction((simplifiedNumerator * b.simplifiedDenominator) + (b.simplifiedNumerator * simplifiedDenominator), simplifiedDenominator * b.simplifiedDenominator);
    }

    public Fraction minus(Fraction b) throws Exception {
        return new Fraction((simplifiedNumerator * b.simplifiedDenominator) - (b.simplifiedNumerator * simplifiedDenominator), simplifiedDenominator * b.simplifiedDenominator);
    }

    public Fraction over(Fraction b) throws Exception {
        return times(b.reciprocal());
    }

    public String toString() {
        if (simplifiedDenominator != 1) return simplifiedNumerator + "/" + simplifiedDenominator;
        else return Integer.toString(simplifiedNumerator);
    }

    public String unsimplified() {
        return numerator + "/" + denominator;
    }
}
