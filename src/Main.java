import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String exp = scan.nextLine();
        Calculator calculator = new Calculator(exp);
        calculator.getAnswer();
    }
}