import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        ManagerStudent managerStudent = new ManagerStudent();

        do {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Student student = inputStudent();
                    int result = managerStudent.addStudent(student);
                    if (result == -1) {
                        System.out.println("Sinh vien da ton tai");
                    } else if (result == 0) {
                        System.out.println("Vuot qua so luong");
                    } else if (result == 1) {
                        System.out.println("Sinh vien da duoc them");
                    }
                    break;
                }

                case 2: {
                    Student student = inputStudent();
                    boolean result = managerStudent.editStudent(student);
                    if (result) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Khong tim thay sv");
                    }
                    break;
                }

                case 3:
                    System.out.println("Nhap ID");
                    int id = input.nextInt();
                   boolean check = managerStudent.remoStudent(id);
                   if(check) {
                       System.out.println("Sinh vien da duoc xoa");
                   } else {
                       System.out.println("Khong tim thay sinh vien");
                   }
                   break;

                case 4:
                    managerStudent.sortStudent();
                    break;

                case 5:
                    for (int i = 0; i < managerStudent.count; i ++ ) {
                        System.out.println("ID: " + managerStudent.students[i].getId() + " | Name: " + managerStudent.students[i].getName()+" | Age: "+managerStudent.students[i].getAge()+" | Address: "+managerStudent.students[i].getAddress()+" | GPA: " + managerStudent.students[i].getGpa() +"\n" );
                    }
            }
        } while (choice != 0);

    }

    private static void menu() {
        System.out.println("\n-Quan ly sinh vien-");
        System.out.println("1. Them moi");
        System.out.println("2. Sua");
        System.out.println("3. Xoa");
        System.out.println("4. Sap xep");
        System.out.println("5. Hien thi");
        System.out.println("0. Thoat");
        System.out.println("Nhap vao chon lua: ");
    }

    private static Student inputStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID :");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Nhap ten :");
        String name = input.nextLine();
        System.out.println("Nhap tuoi");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Nhap dia chi :");
        String address = input.nextLine();
        System.out.println("Nhap GPA");
        float gpa = input.nextFloat();
        Student student = new Student(id,name,age,address,gpa);
        return student;

    }
}
