package edu.miu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab2a.model.Employee;
import lab2a.model.PensionPlan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePensionsApp {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2023, 1, 17), new BigDecimal("105945.50"),
                new PensionPlan("EX1089", null, new BigDecimal("100.00"))));

        employees.add(new Employee(2, "Benard", "Shaw", LocalDate.of(2022, 9, 3), new BigDecimal("197750.00")));
        
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), new BigDecimal("842000.75"),
                new PensionPlan("SM2307", LocalDate.of(2017, 5, 17), new BigDecimal("1555.50"))));
                
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2023, 7, 21), new BigDecimal("74500.00")));
        employees.add(new Employee(5, "Anna", "Wiltord", LocalDate.of(2023, 3, 15), new BigDecimal("85750.00")));
        employees.add(new Employee(6, "Yosef", "Tesfalem", LocalDate.of(2024, 10, 31), new BigDecimal("100000.00")));
        
        printAllEmployees(employees);
        printUpcomingEnrollees(employees);
    }

    private static void printAllEmployees(List<Employee> employees) {
        System.out.println("--- All Employees (Sorted by Last Name ASC, then Yearly Salary DESC) ---");
        
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getYearlySalary, Comparator.reverseOrder()).thenComparing(Employee::getLastName))
                .collect(Collectors.toList());


        printAsJson(sortedEmployees);
    }

    private static void printUpcomingEnrollees(List<Employee> employees) {
        System.out.println("\n--- Quarterly Upcoming Enrollees Report ---");

        LocalDate nextQuarterStart = LocalDate.of(2026, 1, 1);
        LocalDate nextQuarterEnd = LocalDate.of(2026, 3, 31);

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(e -> e.getPensionPlan() == null)
                .filter(e -> {
                    LocalDate anniversary = e.getEmploymentDate().plusYears(3);
                    return !anniversary.isBefore(nextQuarterStart) && !anniversary.isAfter(nextQuarterEnd);
                })
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .collect(Collectors.toList());
        
        printAsJson(upcomingEnrollees);
    }


    private static void printAsJson(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String json = mapper.writeValueAsString(obj);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}