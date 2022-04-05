package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class Calculator {

    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String helloCalculator() {
        return "<h1>Добро пожаловать в калькулятор!</h1>";
    }

    @GetMapping("/plus")
    public String SumNumbers(@RequestParam int number1, @RequestParam int number2) {
        int result = calculatorService.sum(number1, number2);
        return generateMessage(number1, number2, '+', result);
    }

    @GetMapping("/minus")
    public String SubtractNumbers(@RequestParam int number1, @RequestParam int number2) {
        int result = calculatorService.minus(number1, number2);
        return generateMessage(number1, number2, '-', result);
    }

    @GetMapping("/multiply")
    public String MultiplyNumbers(@RequestParam int number1, @RequestParam int number2) {
        int result = calculatorService.multiply(number1, number2);
        return generateMessage(number1, number2, '*', result);
    }

    @GetMapping("/divide")
    public String DivideNumbers(@RequestParam int number1, @RequestParam int number2) {
        if (number2 == 0) {
            return "Деление на 0 невозможно.";
        }
        int result = calculatorService.divide(number1, number2);
        return generateMessage(number1, number2, '/', result);
    }

    private String generateMessage(int number1, int number2, char action, int result) {
        return String.format("%d %c %d = %d", number1, action, number2, result);
    }

}
