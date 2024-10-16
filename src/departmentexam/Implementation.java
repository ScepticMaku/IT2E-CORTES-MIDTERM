package departmentexam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Implementation extends config{
    Scanner sc = new Scanner(System.in);
    
    String sql, confirm;
    String depName, depHead, location, email;
    int pnum, id;
    
    public void addDepartment(){
        System.out.print("Enter department name: ");
        depName = sc.nextLine();
        
        System.out.print("Enter department head: ");
        depHead = sc.nextLine();
        
        System.out.print("Enter location: ");
        location = sc.nextLine();
        
        System.out.print("Enter phone number: ");
        pnum = sc.nextInt();
        
        System.out.print("Enter email: ");
        email = sc.next();
        
        sql = "INSERT INTO departments (department_name, department_head, location, phone_number, email) VALUES (?, ?, ?, ?, ?)";
        addRecord(sql, depName, depHead, location, pnum, email);
    }
    
    public void viewDepartment(){
        sql = "SELECT * FROM departments";
        String[] depHeaders = {"ID", "Name", "Head","Location", "Phone Number", "Email"};
        String[] depColumns = {"department_id", "department_name", "department_head", "location", "phone_number", "email"};

        viewRecords(sql, depHeaders, depColumns);
    }
    
    public void updateDepartment(){
        System.out.print("Enter ID you want to edit: ");
        id = sc.nextInt();
        
        System.out.print("Select what you want to edit: "
                + "\n1. Department Name "
                + "\n2. Department Head"
                + "\n3. Location"
                + "\n4. Phone Number"
                + "\n5. Email"
                + "\nEnter selection: ");
        
        try{
            int select = sc.nextInt();
        
            switch(select){
                case 1:
                    System.out.print("Enter new Department Name: ");
                    sc.nextLine();
                    String newName = sc.nextLine();
                    sql = "UPDATE departments SET department_name = ? WHERE department_id = ?";
                    updateRecord(sql, newName, id);
                    break;
                case 2:
                    System.out.print("Enter new Department Head: ");
                    sc.nextLine();
                    String newHead = sc.nextLine();
                    sql = "UPDATE departments SET department_head = ? WHERE department_id = ?";
                    updateRecord(sql, newHead, id);
                    break;
                case 3:
                    System.out.print("Enter new Location: ");
                    sc.nextLine();
                    String newLocation = sc.nextLine();
                    sql = "UPDATE departments SET location = ? WHERE department_id = ?";
                    updateRecord(sql, newLocation, id);
                    break;
                case 4:
                    System.out.print("Enter new Phone Number: ");
                    int newNumber = sc.nextInt();
                    sql = "UPDATE departments SET phone_number = ? WHERE department_id = ?";
                    updateRecord(sql, newNumber, id);
                    break;
                case 5:
                    System.out.print("Enter new Email: ");
                    String newEmail = sc.next();
                    sql = "UPDATE departments SET email = ? WHERE department_id = ?";
                    updateRecord(sql, newEmail, id);
                    break;
                default: System.out.println("Error: Invalid selection.");
            }
        } catch(InputMismatchException e){
            System.out.println("Error: Must only be a number.");
        }
    }
    
    public void deleteDepartment(){
        System.out.print("Enter ID you want to delete: ");
        
        try{
            id = sc.nextInt();

            System.out.print("Confirm delete? [y/n]: ");
            confirm = sc.next();

            if(confirm.equalsIgnoreCase("y")){
                sql = "DELETE FROM departments WHERE department_id = ?";
                deleteRecord(sql, id);
                System.out.println("Deletion successfull!");
            } else{
                System.out.println("Deletion cancelled.");
            }
        } catch(InputMismatchException e){
            System.out.println("Error: Must only be a number.");
        }
    }
}
