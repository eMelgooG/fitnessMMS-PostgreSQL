package fitnessmms;


public class MultiClubMember extends Member {
    private int membershipPoints = 100;
    private final char type = 'm';
    
   public MultiClubMember (String name, int id, double fees, int club){
       super(name,id,fees,club);
   }
   public MultiClubMember (String name, int id, double fees, int club, int mmPoints){
       super(name,id,fees,club);
       this.membershipPoints = mmPoints;     
    }
    
   @Override
   public String toString() {
       return this.type + ", " + super.toString() + ", " + this.membershipPoints;
   }
   }
    

