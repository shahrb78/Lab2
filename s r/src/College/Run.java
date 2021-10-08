package College;

import Student.Student;

public class Run {
    public static void main(String[] args) {
        Student std1 = new Student("Ehsan","Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");

        std1.setGrade(15);
        std2.setGrade(11);
        std3.setGrade(18);

        Course course1 = new Course("Programming", 45);
        Course course2 = new Course("Mathematics", 45);
        Course course3 = new Course("Computer Workshop", 12);

        course1.enrollStudent(std1);
        course1.enrollStudent(std2);
        course1.enrollStudent(std3);

        course2.enrollStudent(std2);
        course2.enrollStudent(std3);

        course3.enrollStudent(std1);
        course3.enrollStudent(std2);

        College college = new College("ComputerEngineering");

        college.enrollCourse(course1);
        college.enrollCourse(course2);
        college.enrollCourse(course3);

        System.out.println(college.print());
    }
}
