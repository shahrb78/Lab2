package College;

import Student.Student;

import java.util.ArrayList;

/**
 * the Course class represents a course in a education system
 * It holds the course details relevant in our context.
 *
 *
 * @author s r
 * @version 0.0
 */
public class Course {

    // Name of the course
    private String name;

    // List of the students
    private ArrayList<Student> students;

    // Average of grades of the students
    private double avg;

    // Capacity of a course
    private int capacity;

    /**
     * make a new course with a given capacity
     * @param capacity capacity of the course
     * @param name a name for the course
     */
    public Course(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        setStudents(new ArrayList<>());
    }

    /**
     * get the name of course
     * @return name field
     */
    public String getName() {
        return name;
    }

    /**
     * set a name for the course
     * @param name a name for the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the list of the students
     * @return students field
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * set a list as list of students
     * @param students a list of students
     */
    public void setStudents(ArrayList<Student> students) {
        if (students.size() <= capacity) {
            this.students = students;
        }
    }

    /**
     * get capacity of the course
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set capacity of the course
     * @param capacity an integer for capacity of the course
     */
    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        }
    }

    /**
     * add a student to the list
     * @param student a student
     */
    public void enrollStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
        }
    }

    /**
     * Dismisses a student
     * @param student a student of the list
     */
    public void studentExpulsion(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }

    /**
     * calculates the average of grades of students
     */
    public void calculateAvg() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        avg = sum / students.size();
    }

    /**
     * prints information of the course (list of students and the average of course)
     * @return the information about the course
     */
    public String print() {
        StringBuilder info = new StringBuilder();
        info.append("\n").append(name).append("\nList of students :\n");
        int num = 1;
        for (Student student : students) {
            info.append(num).append(". ").append(student.print()).append("\n");
        }
        info.append("The average of course : ").append(avg);
        return info.toString();
    }
}
