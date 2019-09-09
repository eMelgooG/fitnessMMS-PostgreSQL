
package fitnessmms;

public class Member {
    private String name;
    private int id;
    private double fees;
    private int memPoints;
    Member(String name,double fees,int id,int mempoints) {
        this.name = name;
        this.id = id;
        this.fees = fees;
        this.memPoints = mempoints;
      
    }
    
      Member(String name,double fees) {
        this.name = name;
        this.fees = fees;
      
    }
    
    
    public void setMemPoints (int memPoints) {
            this.memPoints = memPoints;
    }
    public int getMemPoints () {
        return this.memPoints;
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
    
    
    public String toString() {
        return this.name + ", " + this.id + ", " + this.fees + ", " + this.memPoints;
    }
    
}
