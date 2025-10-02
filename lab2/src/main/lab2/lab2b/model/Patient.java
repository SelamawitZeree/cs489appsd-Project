package lab2b.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a Patient with their personal and contact information.
 * [cite_start]This class corresponds to the Patient entity described in the lab instructions. [cite: 76]
 */
public class Patient {
    private long patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String mailingAddress;
    private LocalDate dateOfBirth;

    public Patient(long patientId, String firstName, String lastName, String phoneNumber, String email, String mailingAddress, LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters for all fields
    public long getPatientId() { return patientId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getMailingAddress() { return mailingAddress; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }

    /**
     * This method calculates the patient's current age based on their date of birth.
     * [cite_start]This fulfills the requirement to include each patient's age in the JSON output. [cite: 82]
     */
    public int getAge() {
        if (this.dateOfBirth == null) {
            return 0;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}