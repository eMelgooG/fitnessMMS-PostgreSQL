
package fitnessmms;
import java.util.LinkedList;

public class FitnessMMS {

    public static void main(String[] args) {
      LinkedList<Member> m;
      FileHandler fh = new FileHandler();
      ManagementSystem ms = new ManagementSystem();
      int choice;
      m = fh.readFile();
      choice = ms.getChoice();
      String member;
      
      while (choice!=-1) {
          switch (choice) {
              case 1: member = ms.addMember(m);
                      fh.appendFile(member);
                      break;
              case 2: ms.removeMember(m);
                      fh.removeFile(m);
                      break;
              case 3: ms.displayMemInfo(m);
                      break;
                       
              default: System.out.println("Invalid option!\n");
          }
          choice = ms.getChoice();
      }
      
        System.out.println("GoodBye!");
    }
    
}
