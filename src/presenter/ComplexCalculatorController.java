package presenter;

import logger.CalculatorLogger;
import model.ComplexNumber;
import model.ComplexOperation;
import model.OperationFactory;
import view.CalculatorView;

public class ComplexCalculatorController {
    private final CalculatorView view;

    public ComplexCalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void run() {
        boolean running = true;

        while (running) {
            view.displayMenu();
            String choice = view.getOperationChoice();
            switch (choice) {
                case "1":
                    performOperation("+");
                    break;
                case "2":
                    performOperation("-");
                    break;
                case "3":
                    performOperation("*");
                    break;
                case "4":
                    performOperation("/");
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    view.displayError("Unsupported operation");
                    CalculatorLogger.log("Error: Unsupported operation");
            }
        }
    }

    private void performOperation(String operationType) {
        try {
            ComplexOperation operation = OperationFactory.createOperation(operationType);

            view.displayInputPrompt("Enter real part of the first complex number:");
            double real1 = view.getDoubleInput();
            view.displayInputPrompt("Enter imaginary part of the first complex number:");
            double imaginary1 = view.getDoubleInput();
            ComplexNumber num1 = new ComplexNumber(real1, imaginary1);

            view.displayInputPrompt("Enter real part of the second complex number:");
            double real2 = view.getDoubleInput();
            view.displayInputPrompt("Enter imaginary part of the second complex number:");
            double imaginary2 = view.getDoubleInput();
            ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

            ComplexNumber result = operation.operate(num1, num2);
            view.displayResult(result);

            String logMessage = "\nFirst number: " + num1 + ", Second number: " + num2 + "\n" +
                    "Operation: (" + operationType + ") Result: " + result;
            CalculatorLogger.log(logMessage);
            view.waitForInput();
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
            CalculatorLogger.log("Error: " + e.getMessage());
        }
    }
}