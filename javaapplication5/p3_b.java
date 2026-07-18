/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author IT-14
 */
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class ExceptionDemo {
    public void performTask(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Value cannot be negative");
        } else if (value > 100) {
            throw new CustomException("Value cannot exceed 100");
        } else {
            System.out.println("Task performed successfully");
        }
    }
}

public class p3_b {
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();

        try {
            demo.performTask(50);
        } catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }

        try {
            demo.performTask(-10);
        } catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }

        try {
            demo.performTask(120);
        } catch (CustomException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
    }
}