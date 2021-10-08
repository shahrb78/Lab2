package Student;
/**
 * The Student class represents a student in a student
 administration system.
 * It holds the student details relevant in our context.
 *
 * @author s r
 * @version 0.0
 */

public class Student {

    // the student’s first name
    private String firstName;

    // the student’s last name
    private String lastName;

    // the student ID
    private String id;

    //the grade
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param firstName first name of student
     * @param lastName last name of student
     * @param ID student ID
     */
    public Student(String firstName, String lastName, String ID){
        setFirstName(firstName);
        setLastName(lastName);
        setId(ID);
        setGrade(0);
    }

    /**
     * get the first name of student
     * @return firstname field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set first name of a student
     * @param firstName first name of student
     */
    public void setFirstName(String firstName) {
        if (nameVerifier(firstName)) {
            this.firstName = firstName;
        } else {
            this.firstName = "Invalid!";
        }
    }

    /**
     * get the last name of student
     * @return lastname field
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set lastname of a student
     * @param lastName lastname of student
     */
    public void setLastName(String lastName) {
        if (nameVerifier(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = "Invalid!";
        }
    }

    /**
     * get the id of student
     * @return id field
     */
    public String getId() {
        return id;
    }

    /**
     * set the id of student
     * @param id student's id
     */
    public void setId(String id) {
        if (numberVerifier(id)) {
            this.id = id;
        } else {
            this.id = "Invalid!";
        }
    }

    /**
     * get the grade of a student
     * @return grade field
     */
    public int getGrade() {
        return grade;
    }

    /**
     * set the grade of student
     * @param grade student's grade
     */
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 20) {
            this.grade = grade;
        }
    }

    /**
     * print the information of a student
     * @return a string included the information
     */
    public String print() {
        return firstName + " " +
                lastName + ", student ID: " +
                id + ", grade: " + grade;
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
     * checks if an id is valid
     * @param num a string tht should be an id
     * @return if the id is valid or not
     */
    private boolean numberVerifier(String num) {
        if (num.length() == 7) {
            for (char letter : num.toCharArray()) {
                if (!Character.isDigit(letter)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;


    }
}
