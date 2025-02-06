import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                try {
                    String input = sc.nextLine();
                    switch (Integer.parseInt(input)) {
                        case 1:
                            System.out.println("Enter an operation:");
                            String equation = sc.nextLine();
                            String answer = new OperationParser(equation).answer;
                            System.out.println(answer);
                            break;
                        case 2:
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
                if (!continueProgram(sc)) {
                    System.out.println("Exiting...");
                    break;
                }
            }
        }
    }
    private static void displayMenu() {
        System.out.println("\n--- Calculator Application ---");
        System.out.println("Please select an option:");
        System.out.println("1. Basic Calculator");
        System.out.println("2. Unit Conversion");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static boolean continueProgram(Scanner sc){
        while (true){
            System.out.print("Would you like to perform another operation? (y/n)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
