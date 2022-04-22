package controler;

import model.Student;
import view.Validation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ManagementStudent {
    private final Validation validation = new Validation();
    private final ArrayList<Student> listStudent = new ArrayList<>();

    public ManagementStudent() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            listStudent.add(new Student("He151254", "Nguyen Nhu", "Viet Anh", "0367511108", "Ha Noi", df.parse("20/02/2001"), "FeMale"));
            listStudent.add(new Student("He120254", "Nguyen Nhu", "Phuong Anh", "0367511108", "Ha Noi", df.parse("26/03/2001"), "Male"));
        } catch (Exception ex) {
            validation.showWar("Err");
        }
    }

    public void DisplayAllStudents() {
        if (listStudent.isEmpty()) {
            validation.showWar("===========Empty===========");
        } else {
            attributes();
        }
        for (Student list : listStudent) {
            display(list);
        }
    }

    public void addStudent(int x) {
        while (true) {
            listStudent.add(inputStudent());
            x--;
            if (x <= 0) {
                break;
            }
        }
    }

    public void display(Student x) {
        System.out.printf("\n%-10s%-25s%-12s%-15s%-12s%s\n", x.getId(), x.fullName(), x.getPhone(), x.getAddress(), x.formatDate(), x.getSex());
    }

    public void display(ArrayList<Student> list) {
        for (Student x : list) {
            display(x);
        }
    }

    public void attributes() {
        System.out.printf("\n%-10s%-25s%-12s%-15s%-12s%s\n", "ID", "Name", "Phone", "Address", "DOB", "Sex");
    }

    private Student reportExistID(String id) {
        for (Student x : listStudent) {
            if (x.getId().equalsIgnoreCase(id)) {
                return x;
            }
        }
        return null;
    }

    public Student inputStudent() {
        while (true) {
            String Id = validation.inputId();
            if (reportExistID(Id) != null) {
                validation.showWar("This ID has existed!");
                continue;
            }
            String firstName = validation.inputFirstName();
            String lastName = validation.inputLastName();
            String phone = validation.inputPhone();
            String address = validation.inputAddress();
            Date dob = validation.getDate();
            String sex = validation.inputSex();
            return new Student(Id, firstName, lastName, phone, address, dob, sex);

        }
    }

    public void updateStudent(String id) {
        int choice;
        if (null == reportExistID(id)) {
            validation.showWar("This ID not exits:");
        } else {
            for (Student st : listStudent) {
                if (st.getId().equalsIgnoreCase(id)) {
                    attributes();
                    display(st);
                    while (true) {
                        choice = validation.menuUpdateStudent();
                        switch (choice) {
                            case 1:
                                String newfirstName = validation.inputFirstName();
                                st.setFistname(newfirstName);
                                break;
                            case 2:
                                String newlastName = validation.inputLastName();
                                st.setFistname(newlastName);
                                break;
                            case 3:
                                String newPhone = validation.inputPhone();
                                st.setPhone(newPhone);
                                break;
                            case 4:
                                String newAdrress = validation.inputAddress();
                                st.setAddress(newAdrress);
                                break;
                            case 5:
                                Date newDOB = validation.getDate();
                                st.setDob(newDOB);
                                break;
                            case 6:
                                String newSex = validation.inputSex();
                                st.setSex(newSex);
                                break;
                            case 7:
                                break;
                        }
                        if (!validation.checkYesNo("\nDo you have another update(Y/N)?")) {
                            validation.showMes("\n----------UPDATE DONE!----------\n");
                            break;
                        }
                    }
                }
            }
        }
    }

    public void removeStudent(String id) {
        if (null == reportExistID(id)) {
            validation.showWar("This ID not exits:");
        } else {
            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getId().equalsIgnoreCase(id)) {
                    listStudent.remove(i);
                    validation.showMes("--------REMOVE DONE!--------\n");
                    return;
                }
            }
        }
    }

    public void searchStudent() {
        while (true) {
            int choice = validation.menuSearch();
            switch (choice) {
                case 1:
                    String name = validation.inputText("Enter name: ");
                    if (searchByName(name).isEmpty()) {
                        validation.showMes("Name not in list");
                    } else {
                        attributes();
                        display(searchByName(name));
                    }
                    break;
                case 2:
                    String id = validation.inputText("Enter ID: ");
                    if (searchByID(id).isEmpty()) {
                        validation.showMes("ID not in list");
                    } else {
                        attributes();
                        display(searchByID(id));
                    }
                    break;
                case 3:
                    String phone = validation.inputText("Enter PhoneNumber: ");
                    if (searchByPhone(phone).isEmpty()) {
                        validation.showMes("Phone not in list");
                    } else {
                        attributes();
                        display(searchByPhone(phone));
                    }
                    break;
                case 4:
                    break;
            }
            if (!validation.checkYesNo("\nDo you have another Search(Y/N)?")) {
                break;
            }
        }
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> listSearch = new ArrayList<>();
        for (Student st : listStudent) {
            if ((st.getFistname() + " " + st.getLastname()).toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(st);
            }
        }
        return listSearch;
    }

    public ArrayList<Student> searchByID(String id) {
        ArrayList<Student> listSearchByID = new ArrayList<>();
        for (Student st : listStudent) {
            if (st.getId().toUpperCase().contains(id.toUpperCase())) {
                listSearchByID.add(st);
            }
        }
        return listSearchByID;
    }

    public ArrayList<Student> searchByPhone(String phone) {
        ArrayList<Student> listSearchByPhone = new ArrayList<>();
        for (Student st : listStudent) {
            if (st.getPhone().contains(phone)) {
                listSearchByPhone.add(st);
            }
        }
        return listSearchByPhone;
    }
}

