package departmentexam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    
    static boolean isSelected = false;
    public static void main(String[] args) {    
        Implementation implement = new Implementation();
        
        int select;
        boolean numberValidate = false;
        
        do{
            System.out.println("Department CRUD Exam:"
                    + "\n1. ADD"
                    + "\n2. EDIT"
                    + "\n3. DELETE"
                    + "\n4. VIEW"
                    + "\n5. EXIT");
             System.out.print("\nEnter selection: ");
             
             try{
                 select = sc.nextInt();
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
                    case 5:
                        isSelected = true;
                        break;
                    default: System.out.println("Error: Invalid selection.");
                }
             } catch(InputMismatchException e){
                 System.out.println("Error: Must only be a number");
                 break;
             }
        } while(!isSelected);
    }
}
