/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getSalary() {
        return baseSalary;
    }

    public void displayRole() {
        System.out.println(name + " works as a regular employee.");
    }
}

class Manager extends Employee {
    private double performanceBonus;

    public Manager(String name, double baseSalary, double performanceBonus) {
        super(name, baseSalary);
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double getSalary() {
        return baseSalary + performanceBonus;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " manages a team of developers.");
    }
}

public class p1_b {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 50000);
        emp.displayRole();
        System.out.println("Alice's Salary: $" + emp.getSalary());
        System.out.println("----------------------------------------------");

        Manager mgr = new Manager("Bob", 80000, 15000);
        mgr.displayRole();
        System.out.println("Bob's Total Salary (with bonus): $" + mgr.getSalary());
    }
}