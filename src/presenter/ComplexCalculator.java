package presenter;

import view.CalculatorView;

public class ComplexCalculator {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        ComplexCalculatorController controller = new ComplexCalculatorController(view);
        controller.run();
    }
}