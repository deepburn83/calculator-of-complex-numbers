package model;

public class OperationFactory {
    public static ComplexOperation createOperation(String operationType) {
        return switch (operationType) {
            case "+" -> new AdditionOperation();
            case "-" -> new SubtractionOperation();
            case "*" -> new MultiplicationOperation();
            case "/" -> new DivisionOperation();
            default -> throw new IllegalArgumentException("Unsupported operation: " + operationType);
        };
    }
}