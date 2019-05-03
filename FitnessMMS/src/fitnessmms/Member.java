
package fitnessmms;

public class Member {
    private String name;
    private int id;
    private int club;
    private double fees;
    Member(String name, int id, double fees, int club) {
        this.name = name;
        this.id = id;
        this. fees = fees;
        this.club = club;
    }
    
    public void setName (String name) {
            this.name = name;
    }
    public String getName () {
        return this.name;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }
    
    public void setFees(double fees) {
        this.fees = fees;
    }
    public double getFees() {
        return this.fees;
    }
    
    public void setClub(int club) {
        this.club = club;
    }
    public int getClub () {
        return this.club;
    }
    
    public String toString() {
        return this.name + ", " + this.id + ", " + this.fees + ", " + this.club;
    }
    
}
