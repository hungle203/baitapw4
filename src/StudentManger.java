import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManger {

    ArrayList<Student> studentsList;
    Scanner scanner = new Scanner(System.in);

    public StudentManger() {
        this.studentsList = new ArrayList<>();
    }

    public Student createStudent(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập vào tên sinh vên");
        String name = scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên");
        int age = scanner.nextInt();
        if (age >= 18 && age <=60) {


        }
        scanner.nextLine();
        System.out.println("Nhập vào giới tính");
        String gen = scanner.nextLine();
        System.out.println("Nhập vào địa chỉ");
        scanner.nextLine();
        String address = scanner.nextLine();
        System.out.println("Nhập vào điểm trung bình");
        double poi = scanner.nextDouble();
        scanner.nextLine();

        return new Student(name, age, gen, address, poi);

    }

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public ArrayList<Student> deleteStudentByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student s : studentsList) {
            if (s.getName().equals(name)) {
                students.add(s);
                studentsList.removeAll(students);
            }
        }
        return students;

    }

    public Student  editStudent(String name) {
        Student studentUpdate = null;
        for (Student s : studentsList) {
            if (s.getName().equals(name)) {
                studentUpdate = s;
            }
        }
        if (studentUpdate != null) {
            System.out.println("Nhập vào tên sinh vên mới");
            String nameUpdate = scanner.nextLine();
            studentUpdate.setName(nameUpdate);
            System.out.println("Nhập vào tuổi sinh viên mới");
            int ageUpdate = scanner.nextInt();
            studentUpdate.setAge(ageUpdate);
            scanner.nextLine();
            System.out.println("Nhập vào giới tính mới");
            String genUpdate = scanner.nextLine();
            studentUpdate.setGender(genUpdate);
            System.out.println("Nhập vào địa chỉ mới");
            String addressUpdate = scanner.nextLine();
            studentUpdate.setAddress(addressUpdate);
            System.out.println("Nhập vào điểm trung bình mới");
            double pointUpdate = scanner.nextDouble();
            studentUpdate.setAvgPoint(pointUpdate);
            scanner.nextLine();
            return studentUpdate;

        }
        return null;

    }

    public void disPlayAll() {
        for (Student s : studentsList) {
            System.out.println(s);
        }
    }

    public void disPlayStudentByPoint() {
        ArrayList<Student> students = new ArrayList<>();
        for (Student s : studentsList) {
            if (s.getAvgPoint() >= 7.5) {
                students.add(s);
            }
        }
        System.out.println(students);

    }

    public void displayPointLeve() {
        for (Student s: studentsList) {
            if (s.getAvgPoint() >= 8) {
                System.out.println(s.getName() + "----" + s.getAvgPoint() + "----" +"Loại giỏi");
            }else if (s.getAvgPoint() >= 6 && s.getAvgPoint() < 8) {
                System.out.println(s.getName() + "----" + s.getAvgPoint() + "----" +"Loại khá");
            }else if (s.getAvgPoint() > 4.5 && s.getAvgPoint() < 6) {
                System.out.println(s.getName() + "----" + s.getAvgPoint() + "-----" + "Loại Trung bình");
            }else {
                System.out.println(s.getName() + "----" + s.getAvgPoint() + "----" + "Loại trung bình");
            }

        }

    }

    public void exportCsv() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter("D:\\IDEA\\Baitapw4\\src/test_%s.csv\", new Date().getTime()))))"))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tên,");
            sb.append("tuổi,");
            sb.append("giới tính,");
            sb.append("địa chỉ,");
            sb.append("điểm trung bình");
            sb.append('\n');

            if (studentsList.size() > 0) {
                for (Student s :
                        studentsList) {
                    sb.append(s.getName());
                    sb.append(',');
                    sb.append(s.getAge());
                    sb.append(',');
                    sb.append(s.getGender());
                    sb.append(',');
                    sb.append(s.getAddress());
                    sb.append(',');
                    sb.append(s.getAvgPoint());
                    sb.append('\n');
                }
            }
            bufferedWriter.write(sb.toString());
            System.out.println("Write successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
