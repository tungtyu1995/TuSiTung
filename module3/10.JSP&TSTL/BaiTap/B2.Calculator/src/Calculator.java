public class Calculator {
    public double calculate(double num1,double num2, String operand){
        double result;
        switch (operand){
            case "+":
                result = num1 + num2;
                return result;
            case "-":
                result = num1 - num2;
                return result;
            case "*":
                result = num1 * num2;
                return result;
            case "/":
                if (num2!=0){
                    result = num1 / num2;
                    return result;
                }else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
