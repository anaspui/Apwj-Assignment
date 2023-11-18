import java.time.LocalDate;

public class Employee {
    private static final int VACATION_OFFICER = 15;
    private static final int SICK_OFFICER = 10;
    private static final int VACATION_STAFF = 10;
    private static final int SICK_STAFF = 7;
    private String id;
    private String name;
    public LocalDate dateOfBirth;
    private String email;
    private String role;
    public LocalDate joiningDate;
    private int vacationLeave;
    private int sickLeave;

    public Employee(String id, String name, LocalDate dateOfBirth, String email, LocalDate joiningDate, String role) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.joiningDate = joiningDate;
        this.role = role;
        this.vacationLeave = calculateVacationLeave();
        this.sickLeave = calculateSickLeave();
    }

    //getter
    public int getVacationLeave() {
        return vacationLeave;
    }
    public String getRole() { return role; }
    public String getId() {
        return id;
    }
    public String getName(){ return name;  }
    public String getEmail(){ return email; }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public LocalDate getJoiningDate(){
        return joiningDate;
    }
    public int getSickLeave() { return sickLeave; }



    //setter
    public void setVacationLeave(int vacationLeave) {
        this.vacationLeave = vacationLeave;
    }
    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }






    //calculator
    public int calculateVacationLeave() {
        int totalLeaveDays = role.equals("officer") ? VACATION_OFFICER : VACATION_STAFF;
        return calculate(joiningDate, totalLeaveDays);
    }

    public int calculateSickLeave() {
        int totalLeaveDays = role.equals("officer") ? SICK_OFFICER : SICK_STAFF;
        return calculate(joiningDate, totalLeaveDays);
    }

    private int calculate(LocalDate startDate, int totalLeaveDays) {
        LocalDate currentDate = LocalDate.now();
        int daysWorked = (int) Math.round(((currentDate.toEpochDay() - startDate.toEpochDay()) + 1.0));
        return daysWorked > 0 ? Math.min(totalLeaveDays, daysWorked) : 0;
    }

}
