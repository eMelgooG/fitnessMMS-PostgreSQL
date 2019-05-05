
package fitnessmms;
import java.io.*;
import java.util.LinkedList;


public class FileHandler {
    
    public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList();
        Member mbr;
        String line;
        String[] splitline;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            line = reader.readLine();
            while (line!=null) {
                splitline = line.split(", ");
                if (splitline[0].equals("s")) {
                    mbr = new SingleClubMember (splitline[1], Integer.parseInt(splitline[2]), Double.parseDouble(splitline[3]), Integer.parseInt(splitline[4]));
                    m.add(mbr);
                } else {
                     mbr = new MultiClubMember (splitline[1], Integer.parseInt(splitline[2]), Double.parseDouble(splitline[3]), Integer.parseInt(splitline[4]));
                    m.add(mbr);
                }
                line = reader.readLine();
            }        
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
         return m;
    }
    
    public void appendFile(String member) {
        
        
        try (BufferedWriter writer = new BufferedWriter (new FileWriter("members.csv", true))){
            writer.write(member + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void removeFile(LinkedList <Member> m) {
        String member;
        
        try (BufferedWriter writer = new BufferedWriter (new FileWriter("members.temp", false))) {
            for (int i = 0; i<m.size(); i++) {
                member = m.get(i).toString();
                writer.write(member + "\n");  
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            File f = new File("members.csv");
            File fh = new File("members.temp");
            f.delete();
            fh.renameTo(f);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
