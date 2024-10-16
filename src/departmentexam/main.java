package departmentexam;

import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {    
        Implementation implement = new Implementation();
         
        System.out.print("Department CRUD Exam:"
                + "\n1. ADD"
                + "\n2. EDIT"
                + "\n3. DELETE"
                + "\n4. VIEW"
                + "\nEnter selection: ");
        int select = sc.nextInt();
        
        switch(select){
            case 1:
                implement.addDepartment();
                break;
            case 2:
                implement.updateDepartment();
                break;
            case 3:
                implement.deleteDepartment();
                break;
            case 4:
                implement.viewDepartment();
                break;
            default: System.out.println("Error: Invalid selection.");
        }
    }
}
