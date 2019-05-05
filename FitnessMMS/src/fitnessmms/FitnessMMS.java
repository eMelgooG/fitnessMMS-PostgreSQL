
package fitnessmms;
import java.util.LinkedList;

public class FitnessMMS {

    public static void main(String[] args) {
      LinkedList<Member> m;
      FileHandler fh = new FileHandler();
      ManagementSystem ms = new ManagementSystem();
      int choice;
      m = fh.readFile();              // we read the csv file and store it into a LinkedList
      String member;                  // store the a new added member and then append it to the csv file
        choice = ms.getChoice();      // we start the program
      
      while (choice!=-1) {                              // -1 to exit the program
          switch (choice) {
              case 1: member = ms.addMember(m);          //add a member
                      fh.appendFile(member);
                      break;
              case 2: ms.removeMember(m);                //remove a member
                      fh.removeFile(m);
                      break;
              case 3: ms.displayMemInfo(m);              //display member info
                      break;
                       
              default: System.out.println("Invalid option!\n");
          }
          choice = ms.getChoice();
      }
      
        System.out.println("GoodBye!");
    }
    
}
