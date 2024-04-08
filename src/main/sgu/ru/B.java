package main.sgu.ru;
import java.math.BigDecimal;

class B { 
    public enum Operation {
        ADD, SUB, MULT, DIV, REM, POW;
    }

    public void main() {  
        String[] input = System.console().readLine(
            "Enter line in format num num operation: "
        ).split(" ");
        Operation operation = Operation.valueOf(input[2]);
        BigDecimal a = new BigDecimal(input[0]);
        BigDecimal b = new BigDecimal(input[1]);
        BigDecimal answer;
        switch (operation) {
            case ADD:
                answer = a.add(b);
                break;
            case SUB:
                answer = a.subtract(b);
                break;
            case MULT:
                answer = a.multiply(b);
                break;
            case DIV:
                answer = a.divide(b);
                break;
            case REM:
                answer = a.remainder(b);
                break;
            case POW:
                Integer degree = b.toBigInteger().intValueExact();
                answer = a.pow(degree);
                break;
            default:
                throw new java.lang.Error("Unexpected method");
        }
        System.out.println("Result = " + answer);  
    }
}