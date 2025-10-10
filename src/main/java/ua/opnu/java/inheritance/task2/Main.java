package ua.opnu.java.inheritance.task2;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Іваненко", "Петро", 20, "АІ-243", "СК11223344");
        Student student2 = new Student("Петренко", "Марія", 19, "АІ-244", "СК44332211");

        Lecturer lecturer1 = new Lecturer("Коваленко", "Олександр", 45, "Інформаційні системи", 25000);
        Lecturer lecturer2 = new Lecturer("Сидоренко", "Марія", 38, "Інформаційні технології", 22000);

        Person[] people = new Person[4];

        people[0] = student1;
        people[1] = student2;
        people[2] = lecturer1;
        people[3] = lecturer2;

        System.out.println("Інформація про всіх людей:");
        for (Person person : people) {
            System.out.println(person.toString());
        }
        System.out.println("-----");
        System.out.println("Студент " + student1.getLastName() + " навчається в групі " + student1.getGroup());
        System.out.println("Студент " + student2.getLastName() + " має студентський квиток: " + student2.getStudentId());
        System.out.println("Викладач " + lecturer1.getLastName() + " працює на кафедрі: " + lecturer1.getDepartment());
        System.out.println("Викладач " + lecturer2.getLastName() + " має зарплату: " + lecturer2.getSalary() + " грн");
    }
}