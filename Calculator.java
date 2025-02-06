public class Calculator {
    private final String INTRO =
            """
                    Welcome please choose from:
                    \t1. Addition
                    \t2. Subtraction
                    \t3. Multiplication
                    \t4. Division
                    \t5. Modulo
                    
                """;
    public Calculator(){}

    private int add(int a, int b){
        return a + b;
    }
    private int subtract(int a, int b){
        return a - b;
    }
    private int multiply(int a, int b){
        return a * b;
    }
    private int divide(int a, int b){
        if (b == 0){
            return -1;
        }
        return a / b;
    }
    private int modulo(int a, int b){
        return a % b;
    }
}
