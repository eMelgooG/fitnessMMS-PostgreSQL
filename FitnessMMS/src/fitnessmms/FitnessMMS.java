package fitnessmms;
import java.util.LinkedList;

public class FitnessMMS {

    public static void main(String[] args) {
      LinkedList<Member> m;
      DatabaseHandler db = new DatabaseHandler();
      ManagementSystem ms = new ManagementSystem();
      int choice;
      m = db.readDB();              // we read the database and retrieve the data into a LinkedList
      Member mem;                  // store a new member in order to append it to the database
      
      //from this point forward our program starts
        choice = ms.getChoice();      // we start the program
      
      while (choice!=-1) {                              // -1 to exit the program
          switch (choice) {
              case 1: mem = ms.addMember(m);          //add a member
                      int id = db.addDbEntry(mem);    // we append it to the database then we retrieve the memberID
                      m.getLast().setID(id);
                      break;
              case 2: int rid = ms.removeMember(m);   //remove a member
                       if (rid!=-1)                   // we remove the entry in DB only if there's and ID match
                      db.removeDbEntry(rid);
                      break;
              case 3: ms.displayMemInfo(m);              //display member information
                      break;
                       
              default: System.out.println("Invalid option!\n");
          }
          choice = ms.getChoice();
      }
      
        System.out.println("GoodBye!");
    }
    
}
