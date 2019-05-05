
package fitnessmms;


public class SingleClubMember extends Member {
    
    private final char type = 's';
    private int club;
    
    SingleClubMember(String name, int id, double fees, int club) {
        super(name,id,fees);
        this.club = club;
    }

    
    @Override
    public String toString() {
        return this.type + ", " + super.toString() + ", " + this.club;
    }
    
}
