package model;

public class SubtractionOperation implements ComplexOperation {
    @Override
    public ComplexNumber operate(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getReal() - num2.getReal();
        double imaginary = num1.getImaginary() - num2.getImaginary();
        return new ComplexNumber(real, imaginary);
    }
}