
package fitnessmms;


public class SingleClubMember extends Member {
    
    private final char type = 's';
    
    SingleClubMember(String name, int id, double fees, int club) {
        super(name,id,fees,club);
    }
    
    @Override
    public String toString() {
        return this.type + ", " + super.toString();
    }
    
}
