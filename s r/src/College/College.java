package College;

import Student.Student;

import java.util.ArrayList;

/**
 * The College class represents a college is education system
 * it holds the college details relevant of our context
 *
 * @author s r
 * @version 0.0
 */
public class College {

    // Name of the collage
    private String name;

    // List of the college courses
    private ArrayList<Course> courses;

    // List of the students
    private ArrayList<Student> students;

    /**
     * make a new college with given name
     * @param name name of a college
     */
    public College(String name) {
        setName(name);
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    /**
     * get the name of college
     * @return name field
     */
    public String getName() {
        return name;
    }

    /**
     * set a name for college
     * @param name name of the college
     */
    public void setName(String name) {
        if (nameVerifier(name)) {
            this.name = name;
        } else {
            this.name = "Invalid!";
        }
    }

    /**
     * get the list of courses
     * @return courses field
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * set a list of courses
     * @param courses list of courses
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                if (!students.contains(student)) {
                    students.add(student);
                }
            }
        }
    }

    /**
     * get the total number of college's students
     * @return population field
     */
    public int getPopulation() {
        return students.size();
    }

    /**
     * get the list of students
     * @return students field
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * add a course to the list of courses
     * @param course a course
     */
    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            for (Student student : course.getStudents()) {
                if (!students.contains(student)) {
                    students.add(student);
                }
            }
        }
    }

    /**
     * delete an existing course from the list of courses
     * @param course an existing course for delete
     */
    public void deleteCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            for (Student student : course.getStudents()) {
                if (students.contains(student)) {
                    students.remove(student);
                }
            }
        }
    }

    /**
     * checks if a name or lastname is valid
     * @param name a string that should be a name or lastname
     * @return if the name or lastname is valid or not
     */
    private boolean nameVerifier(String name) {
        if (name.length() >= 3) {
            for (char letter : name.toCharArray()) {
                if (!Character.isAlphabetic(letter)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * print the information of a college
     * @return the information
     */
    public String print() {
        StringBuilder info = new StringBuilder();
        info.append("\n").append(name).append("\t\tPopulation : ").append(getPopulation()).append("\n\nList of courses : ");
        for (Course course : courses) {
            info.append("\n").append(course.getName());
        }
        info.append("\n\n\nList of students : \n");
        for (Student student : students) {
            info.append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
        }
        return info.toString();
    }
}
