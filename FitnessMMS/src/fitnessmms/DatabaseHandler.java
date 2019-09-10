package fitnessmms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;


public class DatabaseHandler {
    
    private final String url = "jdbc:postgresql://localhost/fitnessMMS";
    private final String user = "postgres";
    private final String password = "root";

        public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
            
        
        public LinkedList<Member> readDB() {
        LinkedList<Member> m = new LinkedList();
        Member mbr;
        
        String SQL = "SELECT * FROM members";
 
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            while(rs.next()) {
                if (rs.getString("memtype").equals("m")) {
                    mbr = new MultiClubMember (rs.getString("name"), rs.getDouble("fees"),  rs.getInt("member_id"),rs.getInt("mempoints"));
                    m.add(mbr);
                } else  {
                     mbr = new SingleClubMember (rs.getString("name"), rs.getDouble("fees"), rs.getInt("member_id"), rs.getInt("mempoints"));
                    m.add(mbr);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }
        
        
        public int addDbEntry(Member mem) {
            String SQL = "INSERT INTO members (name, fees, mempoints, memtype) " +
                    "VALUES (?,?,?,?)";
            long id = 0;
             try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
 
            pstmt.setString(1, mem.getName());
            pstmt.setDouble(2, mem.getFees());
            pstmt.setInt(3, mem.getMemPoints());
            if (mem.getFees()<1400){
            pstmt.setString(4,String.valueOf(SingleClubMember.type));
            } else  {
                 pstmt.setString(4,String.valueOf(MultiClubMember.type));
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());                      
        }   
             return (int)id;
       
}
        
        public void removeDbEntry(int id) {
            String SQL = "DELETE FROM members WHERE member_id = ?";
            
             try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                 pstmt.setInt(1,id);
                 pstmt.executeUpdate();
             } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
             }
 
        }
        
        public void updateDbPoints(int id, int points) {
            String SQL = "UPDATE members " + "SET mempoints = ? " + "WHERE member_id = ?";
            
            try (Connection conn = connect(); 
                    PreparedStatement pstmt = conn.prepareStatement(SQL)) {
                pstmt.setInt(1,points);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
            } catch (SQLException ex)
            { System.out.println(ex.getMessage());          
            }
        }
        
}
