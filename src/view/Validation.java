package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    private final Scanner sc = new Scanner(System.in);
    public int Menu(){
        showMes("\n\nMenu:\n"
                + "1.	Add Student \n"
                + "2.	Update Student\n"
                + "3.	Remove Student\n"
                + "4.	Search Student\n"
                + "5.  Display All Students\n"
                + "6.	Exit");
        showMes("\nYour choose: ");
        return validationChoice(6,1);

    }
    public int menuSearch(){
        showMes("\n\nMenu Search:\n"
                + "1.	Search By Name \n"
                + "2.	Search By ID\n"
                + "3.	Search By PhoneNumber\n"
                + "4.	Exit");
        showMes("\nYour choose: ");
        return validationChoice(4,1);

    }
    public int menuUpdateStudent(){
        showMes("\n\nMenu to Update:\n"
                + "1.	FistName \n"
                + "2.	LastName\n"
                + "3.	Phone\n"
                + "4.	Address\n"
                + "5.  Date Of Birth\n"
                + "6.  Sex\n"
                + "7.	Exit");
        showMes("\nYour choose: ");
        return validationChoice(7,1);
    }
    public int validationChoice(int max, int min) {
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                //Check out of range
                if (min > result || max < result) {
                    showWar("Input out of range! Please enter a value from " + min + " to " + max);
                    showMes("Enter again: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                showWar("Please enter an integer!");
                showMes("Enter again: ");
            }
        }
        return result;
    }
    public int inputInt(String mess,int max, int min) {
        int result = 0;
        showMes(mess);
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                //Check out of range
                if (min > result || max < result) {
                    showWar("Input out of range! Please enter a value from " + min + " to " + max);
                    showMes("Enter again: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                showWar("Please enter an integer!");
                showMes("Enter again: ");
            }
        }
        return result;
    }
    public String inputText(String mes) {
        String s;
        showMes(mes);
        while (true) {
            s = sc.nextLine();
            //Check empty
            if (s.isEmpty()) {
                showWar("Please enter something!");
                showMes("Enter again: ");
                continue;
            }
            return s;
        }
    }
    public String inputId() {
        return inputText("Enter ID: ");
    }

    public String inputFirstName() {
        return inputText("Enter First Name: ");
    }

    public String inputLastName() {
        return inputText("Enter Last Name: ");
    }
    public String inputPhone(){
        String phone = inputText("Enter Phone Number: ");
        while (true) {
            //10-11 so
            //so dau tien phai la 0
            if (phone.trim().matches("0[0-9]{9,10}")) {
                break;
            }else{
                phone = inputText("Enter Again: ");
            }
        }
        return phone;
    }
    public String inputAddress() {
        return inputText("Enter Address: ");
    }
    public Date getDate(){
        Date date;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        while(true){
            try {
                date = df.parse(inputText("Enter Date of Birth(dd/mm/yyyy): "));
                break;
            } catch (Exception e) {
                    showWar("Wrong format");
            }
        }
        return date;
    }
    public String inputSex(){
        String sex = inputText("Enter Sex(male/female): ");
        while(true){
            if (!sex.equalsIgnoreCase("Male")&&!sex.equalsIgnoreCase("Female")){
                showMes("Please enter male or female!\n");
                sex = inputText("Enter Again: ");
                continue;
            }else {
                return sex;
            }

        }
    }
    public boolean checkYesNo(String mes) {
        String s = inputText(mes);
        while (true) {

            if (s.equalsIgnoreCase("N") || s.equalsIgnoreCase("NO")) {
                return false;
            }
            if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("YES")) {
                return true;
            }
            s = inputText("Enter again: ");
        }
    }
    public void showMes(String mes) {
        System.out.print(mes);
    }

    public void showWar(String war) {
        try {
            System.err.println(war);
            Thread.sleep(500);
        }catch (Exception e){

        }

    }
}
