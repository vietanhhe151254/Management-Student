package controler;

import view.Validation;

public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        ManagementStudent managementStudent = new ManagementStudent();        int choice;
        while(true){
            choice = validation.Menu();
            switch (choice){
                case 1:
                    managementStudent.addStudent(validation.inputInt("Enter number of student: ",Integer.MAX_VALUE,1));
                    break;
                case 2:
                    managementStudent.updateStudent(validation.inputId());
                    break;
                case 3:
                    managementStudent.removeStudent(validation.inputId());
                    break;
                case 4:
                    managementStudent.searchStudent();
                    break;
                case 5:
                    managementStudent.DisplayAllStudents();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
