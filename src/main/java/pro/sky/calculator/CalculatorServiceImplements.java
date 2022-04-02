package pro.sky.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImplements implements CalculatorService{

    public int sum(int number1, int number2) {
        return number1 + number2;
    }

    public int minus(int number1, int number2) {
        return number1 - number2;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public int divide(int number1, int number2) {
        return number1 / number2;
    }
}
