import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.print("\nEnter the numerator ----> ");
            int num = Keyboard.getInt();
            System.out.print("\nEnter the denominator --> ");
            int den = Keyboard.getInt();
            if (den == 0) {
                System.out.println("Denominator can't be 0!");
                continue;
            }

            Rational r = new Rational(num, den);
            r.displayData();
            System.out.println("\nWould you like to continue?");
            String answer = Keyboard.getString();
            if(answer.contains("n")) break;
        }
    }
}

class Rational
{
    private final int num;
    private final int den;
    // Complete for 80-Points
    public Rational(int num, int den)
    {
        this.num = num;
        this.den = den;
    }
    // Complete for 80-Points
    public double getDecimal()
    {
        return ((double)num)/den;
    }
    // Complete for 80-Points
    public String getRational()
    {
        return String.format("%d/%d", num, den);
    }
    // Complete for 100-Points
    public String getReduced()
    {
        int gcf = getGCF(num, den);
        return String.format("%d/%d", num / gcf, den / gcf);
    }
    // Method for 80-Points; Change for 100-Points
    public void displayData()
    {
        System.out.println();
        System.out.println(getRational() + " equals " + Math.round(getDecimal() * 1000)/(double)1000);
        System.out.println();
        System.out.println("and reduces to " + getReduced());
    }
    // Complete for 100-Points
    private int getGCF(int n1,int n2)
    {
        while(true) {
            int div = n1 / n2;
            int remainder = n1 - (div * n2);
            if(remainder == 0) break;
            n1 = n2;
            n2 = remainder;
        }
        return n2;
    }
}

// Library of keyboard input methods.
// Place library in same folder as the program that uses the methods.
class Keyboard
{
    public static int getInt()
    {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static double getDouble()
    {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }
    public static String getString()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
