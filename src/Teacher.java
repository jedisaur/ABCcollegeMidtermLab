import java.util.Locale;

public class Teacher extends Person{
    private String department, designation;
    private int teachingHours;
    private float totalSalary = 1200f;
    private int defaultHours = 0;


    public String getDepartment() {
        return department;
    }
    /*
         @Method - This function is used to set the department to business or computing only
         and transform the final department into capitalized first letter.
         @parameter:
             String department - It is used to determine the department of the teacher that accepts any String format.

     */
    public void setDepartment(String department) {
        department = department.toLowerCase();
        switch (department) {
            case "business":
            case "computing":
                department = department.substring(0,1).toUpperCase() + department.substring(1).toLowerCase();
                break;
        }
        this.department = department;


    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        designation = designation.toLowerCase();
        switch (designation){
            case "hof":
            case "co":
            case "l":
                designation = designation.toUpperCase();
                break;
        }
        this.designation = designation;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;


    }

    /*
        @Method - This function is used to calculate Net Salary of the teacher.
        @parameter:
            float totalSalary - It is used to get the total salary.
            float housingAllowance - It is used to get the housing allowance.
            float medicalAllowance - It is used to get the medical allowance.
            float travellingAllowance - It is used to get the travelling allowance.
    */
    public float calculateNetSalary(float totalSalary, float housingAllowance, float medicalAllowance, float travellingAllowance){
        return totalSalary + housingAllowance + medicalAllowance + travellingAllowance;
    }

    /*
        @Method - This function is used to calculate housing allowance.
        @parameter:
            float totalSalary - It is used to get the total salary.
    */
    public float calculateHousingAllowance(float totalSalary){
        return totalSalary * 0.1f;
    }

    /*
        @Method - This function is used to calculate medical allowance.
        @parameter:
            float totalSalary - It is used to get the total salary.
    */
    public float calculateMedicalAllowance(float totalSalary){
        return totalSalary * 0.03f;
    }

    /*
        @Method - This function is used to calculate travelling allowance.
        @parameter:
            float totalSalary - It is used to get the total salary.
    */
    public float calculateTravellingAllowance(float totalSalary){
        return totalSalary * 0.05f;
    }

    /*
        @Method - This function is used to calculate the over time salary of the teacher.
        @parameter:
            String designation - It is used to determine the position of the teacher.
            int teachHours - It is used to determine the number of teaching hours of the teacher.
    */
    public int overTimeSalary(String designation, int teachHours){
        switch(designation){
            case "HOF":
                defaultHours = 8;
                break;
            case "CO":
                defaultHours = 13;
                break;
            case "L":
                defaultHours = 18;
                break;
        }
        if(teachHours<defaultHours){
            return 0;
        }
        return ((teachHours - defaultHours) * 325);
    }

    public float getNetSalary() {


         totalSalary += overTimeSalary(designation, teachingHours);
         float housingAllowance = calculateHousingAllowance(totalSalary);
         float medicalAllowance = calculateMedicalAllowance(totalSalary);
         float travellingAllowance = calculateTravellingAllowance(totalSalary);
         float netSalary = calculateNetSalary(totalSalary, housingAllowance, medicalAllowance, travellingAllowance);

         return netSalary;

    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }
}


