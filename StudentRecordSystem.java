import java.util.ArrayList;
import java.util.Scanner;

// Base Class Person 
class Person {
    String name;
}

// Student Class inherits Person
class Student extends Person {
    int rollNo;
    String course;
    double marks;
    char grade;

    // Default Constructor
    Student() {
        this.rollNo = 0;
        this.name = "";
        this.course = "";
        this.marks = 0.0;
        this.grade = 'D';
    }

    // Parameterized Constructor
    Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    // Method to take input from user
    public void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();

        calculateGrade();
    }

    // Calculate Grade based on marks
    public void calculateGrade() {
        if (marks >= 90)
            grade = 'A';
        else if (marks >= 75)
            grade = 'B';
        else if (marks >= 60)
            grade = 'C';
        else
            grade = 'D';
    }

    // Display all student details
    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------------------");
    }
}


// Main Class
public class StudentRecordSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.inputDetails();
                    students.add(s);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found!");
                    } else {
                        for (Student st : students) {
                            st.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
