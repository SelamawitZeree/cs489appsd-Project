package lab2a.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private BigDecimal yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, BigDecimal yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }
    

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, BigDecimal yearlySalary) {
        this(employeeId, firstName, lastName, employmentDate, yearlySalary, null);
    }

    public long getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getEmploymentDate() { return employmentDate; }
    public BigDecimal getYearlySalary() { return yearlySalary; }
    public PensionPlan getPensionPlan() { return pensionPlan; }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + (pensionPlan != null ? pensionPlan.toString() : "null") +
                '}';
    }
}