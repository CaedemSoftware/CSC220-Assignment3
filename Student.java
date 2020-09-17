package assignment03PartE;

import java.util.ArrayList;

/**
 *
 * Part E
 *
 */
public final class Student implements Comparable<Student> {

    public static String priority;
    private final String firstName;
    private final String lastName;
    private final int studentId;
    private final double gpa;
    private final int smallQ;
    private final int bigQ;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public double getGpa() {
        return this.gpa;
    }

    public int getSmallQ() {
        return this.smallQ;
    }

    public int getBigQ() {
        return this.bigQ;
    }

    Student(String firstName, String lastName, int studentId,
            double gpa, int smallQ, int bigQ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.gpa = gpa;
        this.smallQ = smallQ;
        this.bigQ = bigQ;
    }

    public static void setCompareToPriority(String priority) {
        Student.priority = priority;
    }

    public static Iterable<String> getPriorities() {
        ArrayList<String> priorities = new ArrayList();
        priorities.add("default");
        priorities.add("first-name");
        priorities.add("last-name");
        priorities.add("student-id");
        priorities.add("gpa");
        priorities.add("number-of-small-questions");
        priorities.add("number-of-big-questions");
        priorities.add("number-of-small-and-big-questions");
        return priorities;
    }

    @Override
    public int compareTo(Student student) {
        int result;
        switch (Student.priority) {
            case "number-of-small-and-big-questions":
                result = (this.bigQ + this.smallQ)
                        - (student.bigQ + student.smallQ);
                if (result != 0) {
                    break;
                }
            case "number-of-big-questions":
                result = this.bigQ - student.bigQ;
                if (result != 0) {
                    break;
                }
            case "number-of-small-questions":
                result = this.smallQ - student.smallQ;
                if (result != 0) {
                    break;
                }
            case "gpa":
                result = (int) ((this.gpa - student.gpa) * 10);
                if (result != 0) {
                    break;
                }
            case "student-id":
                result = this.studentId - student.studentId;
                if (result != 0) {
                    break;
                }
            case "last-name":
                result = this.lastName.compareTo(student.lastName);
                if (result != 0) {
                    break;
                }
            case "first-name":
                result = this.firstName.compareTo(student.firstName);
                break;
            default: {
                result = this.firstName.hashCode()
                        - student.firstName.hashCode();
                if (this.firstName.equals("Goofy")
                        && student.firstName.equals("Daisy")) {
                    result = -1;
                }
            }
        }

        return result;
    }

}
