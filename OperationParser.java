import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationParser {
    public String answer;
    private static final Pattern EQUATION_PATTERN = Pattern.compile(
            "(-?\\d+(?:\\.\\d+)?)" +  // First number (supports negative numbers and decimals)
                    "([+\\-*/])" +             // Operator
                    "(-?\\d+(?:\\.\\d+)?)"     // Second number (supports negative numbers and decimals)
    );

    public OperationParser(String equation) {
        String cleaned_equation = equation.replaceAll("\\s", "");
        try {
            this.answer = evaluate(cleaned_equation).toString();
        }catch (IllegalArgumentException e){
            this.answer = null;
            System.err.println("Invalid equation: " + e.getMessage());
        }
    }
    private Number evaluate(String equation){
        List<String> tokens = tokenize(equation);
        List<String> processedTokens = processMultiplicationAndDivision(tokens);
        Number result = evaluateAdditionAndSubtraction(processedTokens);
        return result;
    }
    private List<String> tokenize(String equation){
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?|[+\\-*/])");
        Matcher matcher = pattern.matcher(equation);
        while (matcher.find()){
            tokens.add(matcher.group());
        }
        return tokens;
    }
    private List<String> processMultiplicationAndDivision(List<String> tokens){
        List<String> newTokens = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++){
            String token = tokens.get(i);
            if (tokens.get(i).equals("*") || tokens.get(i).equals("/")){
                Number a = parseNumber(newTokens.remove(newTokens.size() - 1));
                Number b = parseNumber(tokens.get(++i));
                Number result = new Operation(a, b, token).RESULT;
                newTokens.add(result.toString());
            } else {
                newTokens.add(token);
            }
        }
        return newTokens;
    }
    private Number evaluateAdditionAndSubtraction(List<String> tokens){
        Number result = parseNumber(tokens.get(0));
        for (int i = 1; i < tokens.size(); i+=2){
            String operator = tokens.get(i);
            Number operand = parseNumber(tokens.get(i+1));
            result = new Operation(result, operand, operator).RESULT;
        }
        return result;
    }
    private Number parseNumber(String number){
        try {
           if (number.contains(".")){
               return Double.parseDouble(number);
           }
           return Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid equation format");
        }
    }
}
