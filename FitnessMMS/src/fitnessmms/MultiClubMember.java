package fitnessmms;


public class MultiClubMember extends Member {
    private int membershipPoints = 100;
    private final char type = 'm';
    
   public MultiClubMember (String name, int id, double fees){
       super(name,id,fees);
   }
   public MultiClubMember (String name, int id, double fees, int mmPoints){
       super(name,id,fees);
       this.membershipPoints = mmPoints;     
    }
    
   @Override
   public String toString() {
       return this.type + ", " + super.toString() + ", " + this.membershipPoints;
   }
   }
    

