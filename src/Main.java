import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManger studentManger = new StudentManger();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("------Menu-----");
            System.out.println("1. Thêm 1 sinh viên");
            System.out.println("2. Xóa sinh viên theo tên");
            System.out.println("3. Sửa sinh viên theo tên");
            System.out.println("4. Hiển thị tất cả sinh viên");
            System.out.println("5. Hiển thị tất cả sinh viên có điêm trung bình trên 7.5");
            System.out.println("6. Hiển thị sinh viên theo sếp loại");
            System.out.println("7. ghi file Csv");
            System.out.println("Nhập vào lựa chọn của bạn");
            System.out.println("---------------------------");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Student student = studentManger.createStudent(scanner);
                    studentManger.addStudent(student);

                    break;
                case 2:
                    System.out.println("Nhập vào tên sinh viên muốn xóa");
                    scanner.nextLine();
                    String nameDelete = scanner.nextLine();
                    ArrayList<Student> studentsDelete = studentManger.deleteStudentByName(nameDelete);
                    System.out.println(studentsDelete);
                    break;
                case 3:
                    System.out.println("Nhập vào tên sinh viên muốn sửa");
                    scanner.nextLine();
                    String nameUpdate = scanner.nextLine();
                    studentManger.editStudent(nameUpdate);
                    break;
                case 4:
                    System.out.println("Tất cả sinh viên là");
                    studentManger.disPlayAll();
                    break;
                case 5:
                    System.out.println("Tất cả sinh viên có điểm trung bình trên 7.5 là");
                    studentManger.disPlayStudentByPoint();
                    break;
                case 6:
                    studentManger.displayPointLeve();
                    break;
                case 7:
                    studentManger.exportCsv();
                    break;
            }
        } while (choice != 0);
    }
}
