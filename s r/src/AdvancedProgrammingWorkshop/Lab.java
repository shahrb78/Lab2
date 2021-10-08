package AdvancedProgrammingWorkshop;

import java.util.ArrayList;
import Student.Student;

/**
 * the Lab class represents a laboratory in a education system
 * it holds the laboratory details relevant in our context
 *
 * @author s r
 * @version 0.0
 */
public class Lab {

    // An arrayList to save students
    private ArrayList<Student> students;

    // The average of the grades of students
    private double avg;

    // The day witch lab will be held
    private String day;

    // Limit on the number of students
    private int capacity;

    // The number of students
    private int currentSize;

    /**
     * Create a new lab with a given capacity and day.
     *
     * @param cap Limit on the number of students
     * @param day The day witch lab will be held
     */
    public Lab(int cap, String day) {
        setCapacity(cap);
        setDay(day);
        students = new ArrayList<>();
        currentSize = 0;
    }

    /**
     * add a student to the lab
     * @param std a student
     */
    public String enrollStudent(Student std) {
        if (currentSize < capacity) {
            students.add(std);
            currentSize++;
            calculateAvg();
            return "The new student added successfully";
        } else {
            return "Lab is full!!!";
        }
    }

    /**
     * prints information of the lab (list of students and the average of lab)
     * @return the information about lab
     */
    public String print() {
        StringBuilder info = new StringBuilder();
        info.append("List of students :\n");
        int num = 1;
        for (Student student : students) {
            info.append(num).append(". ").append(student.print()).append("\n");
        }
        info.append("The average of lab : ").append(avg);
        return info.toString();
    }

    /**
     * get the list of students
     * @return students field
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * add the list of students to lab
     * @param students list of students
     * @return result of operation
     */
    public String setStudents(ArrayList<Student> students) {
        if (students.size() > capacity) {
            calculateAvg();
            return "The number of students is greater tha lab capacity";
        } else {
            this.students = students;
            return "The new students added successfully";
        }
    }

    /**
     * get the average of lab's students
     * @return avg filed
     */
    public double getAvg() {
        return avg;
    }

    /**
     * calculates the average of grades of lab's students
     */
    private void calculateAvg() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        avg = sum / currentSize;
    }

    /**
     * get day of the lab
     * @return day field
     */
    public String getDay() {
        return day;
    }

    /**
     * set a day for lab
     * @param day a day
     */
    public void setDay(String day) {
        if (dayVerifier(day)) {
            this.day = day;
        } else {
            this.day = "Invalid!";
        }
    }

    /**
     * get the capacity of lab
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set the capacity of a lab
     * @param capacity capacity of a lab
     */
    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        } else {
            this.capacity = 0;
        }
    }

    /**
     * checks if a day is valid or not
     * @param day a string that should be a day
     * @return if the day is valid or not
     */
    private boolean dayVerifier(String day) {
        switch (day.toLowerCase().trim()) {
            case "saturday" :
            case "sunday" :
            case "monday" :
            case "tuesday" :
            case "wednesday" :
            case "thursday" :
            case "friday" :
                return true;
            default:
                return false;
        }
    }
}
