package fitnessmms;


public class MultiClubMember extends Member {
    public static final char type = 'm';
    

   public MultiClubMember (String name, double fees, int id, int mempoints){
       super(name,fees,id,mempoints);
    }
    
    public MultiClubMember (String name, double fees){
       super(name,fees);
    }
    
   @Override
   public String toString() {
       return super.toString();
   }
   }
    

