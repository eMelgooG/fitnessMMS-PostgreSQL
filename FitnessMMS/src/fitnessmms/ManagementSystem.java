package fitnessmms;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ManagementSystem {
    private final Scanner input = new Scanner(System.in);
    
    private int getIntInput() {
        int  choice = 0;
        
        while (choice == 0) {
            try{
                choice = input.nextInt();              
                if (choice == 0) {
                    throw new InputMismatchException();
                }
                input.nextLine();
               
            } catch (InputMismatchException e) {
                     input.nextLine();
                        System.out.print("Invalid entry, please select a valid option: ");
                        }
            }
        return choice;
        }
    private void printClubOptions() {
        System.out.println("1)Mercury");
        System.out.println("2)Origin");
        System.out.println("3)Topogan");
        System.out.println("4)Multi Club Member");
    }
    
    public int getChoice() {
        int choice;
        System.out.println(" Welcome to Kombucha Fitness Centre!");
        System.out.println("=====================================");
        System.out.println("1)Add Member");
        System.out.println("2)Remove Member");
        System.out.println("3)Update membership points");
        System.out.println("4)Display Member Information\n");
        System.out.print("Please select an option: (Or enter -1 to exit): ");
        choice = getIntInput();
        return choice;
    }
    
    public Member addMember(LinkedList<Member> m) {
        Calculator<Integer> cal;
        String name;
        int id;
        double fees;
        int club;
        String member;
        Member mbr;
        
        System.out.print("Please enter a member name: ");
        name = input.nextLine();
        
        if (m.size() > 0) {
            id = m.getLast().getID() + 1;
        }
        else { id = 1; }
        
        printClubOptions();
        System.out.print("Please select a club: ");
        club = getIntInput();
        
        while (club < 1 || club > 4) {
            System.out.println("Invalid entry, please select a valid option: ");
            club = getIntInput();
        }
        
        if (club!= 4) {
        cal = (n) -> {
            switch (n) {
                case 1: return 600;
                case 2: return 750;     
                case 3: return 900;
                default: return -1;          
            } 
        };
        fees = cal.calculateFee(club);
        mbr = new SingleClubMember(name, fees);
        m.add(mbr);
    
            System.out.println("\t\t\t\t======Single club member added!======\n");
            return mbr;
    }  else {
            cal = (n) -> { if (n==4) return 1400; else return -1; };
            fees = cal.calculateFee(club);
            mbr = new MultiClubMember(name, fees);
            m.add(mbr);
          
            System.out.println("\t\t\t\t======Multi club member added!=====\n");
            return mbr;
        }
    }
    
    public int removeMember (LinkedList<Member> m) {
        int memberID;
        System.out.println("Please enter member id to remove: ");
        memberID = getIntInput();
        
        for (int i = 0 ; i < m.size() ; i++) {
            if (memberID == m.get(i).getID()) {
                m.remove(i);
                System.out.println("Member removed!");
                return memberID;
            }
        }
        System.out.println("Member id not found!");
        return -1;
    }
    
    public int[] updateMmPoints(LinkedList<Member> m){
        int[] data = new int[2];
         System.out.print("Please enter the member id: ");
        data[0] = getIntInput();
            for (int i = 0 ; i < m.size() ; i++) {
            if (data[0] == m.get(i).getID()) {
                System.out.println("Member name: " + m.get(i).getName());
                System.out.println("Membership points: " + m.get(i).getMemPoints() + "\n");
                System.out.print("How many points would you like to add: ");
                 int points = getIntInput();
                 m.get(i).addMmPoints(points);
                 data[1] = m.get(i).getMemPoints();
                 System.out.println("\n===Membership points updated!===\nYou now have " + data[1] + " points.\n");
                 return data;
            }             
            }
            System.out.println("\n\t\tMEMBER ID not found!\n");
            data[0] = -1;
            return data;
            }
    
    
    public void displayMemInfo(LinkedList<Member> m) {
        int memberID;
        System.out.print("Please enter a member id: ");
        memberID = getIntInput();
        
        for (int i = 0; i < m.size(); i++) {
            if (memberID == m.get(i).getID()) {
                String[] s = m.get(i).toString().split(", ");
                System.out.println("Member name: " + s[0]);
                System.out.println("Membership id: " + s[1]);
                System.out.println("Member fees: " + s[2]);
                    System.out.println("Membership points: " + s[3] + "\n");                 
                
                return;
            }
        }
        System.out.println("\n\t\tMEMBER ID not found!\n");
    }
    }

    
    

