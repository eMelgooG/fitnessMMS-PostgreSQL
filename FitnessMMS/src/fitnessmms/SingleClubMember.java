
package fitnessmms;


public class SingleClubMember extends Member {
    
    public static final char type = 's';
    
    SingleClubMember(String name, double fees,int id, int mempoints) {
        super(name,fees,id,mempoints);
    }
    
    SingleClubMember(String name,double fees) {
        super(name,fees);
    }
    public char getType(){
        return type;
    }

    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
