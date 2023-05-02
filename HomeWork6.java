import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HomeWork6 {
    public static void main(String[] args) {
        Laptop lenovo1 = new Laptop("Lenovo", 16, 512, "Windows", "silver", 500);
        Laptop lenovo2 = new Laptop("Lenovo", 32, 1024, "Windows", "black", 600);
        Laptop hp1 = new Laptop("HP", 8, 512, "Windows", "white", 350);
        Laptop hp2 = new Laptop("HP", 8, 256, "Windows", "white", 350);
        Laptop dell1 = new Laptop("DELL", 32, 1024, "Windows", "silver", 650);
        Laptop dell2 = new Laptop("DELL", 16, 512, "Windows", "silver", 550);
        Laptop mac1 = new Laptop("MAC", 32, 1024, "macOS", "silver", 650);
        Laptop mac2 = new Laptop("MAC", 16, 512, "macOS", "silver", 550);
        HashSet<Laptop> hashset = new HashSet<Laptop>(Arrays.asList(lenovo1,lenovo2,hp1,hp2,dell1,dell2,mac1,mac2));
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Would you like to add filter for laptop: y/n ");
        String filter = iScanner.nextLine();
        while (filter.equals("y")){
            HashSet<Laptop> laptopFiltered= filterLaptop(hashset);
            hashset = laptopFiltered;
            System.out.println("Would you like to add filter for laptop: y/n ");
            filter = iScanner.nextLine();
        }
        System.out.println("List of filtered laptops: ");
        hashset.stream().sorted((a, b) -> a.name.compareTo(b.name)).forEach(a -> a.printLaptop());      

    }
        public static HashSet<Laptop> filterLaptop(HashSet<Laptop> set) {
            System.out.println("Select filter: 1. RAM, 2. HardDrive, 3. Operating System, 4. Price");
            Scanner iScanner = new Scanner(System.in);
            Integer choice = Integer.parseInt(iScanner.nextLine());
            HashSet<Laptop> filteredlist = new HashSet<Laptop>();
            if (choice == 1 || choice == 2 || choice == 4) {
                System.out.println("Enter min value: ");
                Integer min = Integer.parseInt(iScanner.nextLine());
                System.out.println("Enter max value: ");
                Integer max = Integer.parseInt(iScanner.nextLine());
                for (Laptop lp : set) {
                    if (choice == 1) {
                        if (lp.getOpsMemory() >= min && lp.getOpsMemory() <= max)
                            filteredlist.add(lp);
                    }
                    else if (choice == 2) {
                        if (lp.getHardMemory() >= min && lp.getHardMemory() <= max)
                            filteredlist.add(lp);
                    }
                    else if (choice == 4){
                        if (lp.getPrice() >= min && lp.getPrice() <= max)
                            filteredlist.add(lp); 
                    }
                }
            }
            else {
                System.out.println("Enter OS: ");
                String os = iScanner.nextLine();
                for (Laptop lp : set) {
                    if (lp.operSystem.equals(os))  {
                        filteredlist.add(lp);
                    }
                }
            }
            if (filteredlist.size() > 0 )
                filteredlist.stream().sorted((a, b) -> a.name.compareTo(b.name)).forEach(a -> a.printLaptop());  
            else System.out.println("No laptops for required filters");
      
        return filteredlist;
       }
    }
class Laptop{
    String name;
    Integer opsMemory;
    Integer hardMemory;
    String operSystem;
    String color;
    Integer price;

    public Laptop(String name, Integer opsMemory, Integer hardMemory, String operSystem, String color, Integer price) {
    this.name = name;
    this.opsMemory = opsMemory;
    this.hardMemory = hardMemory;
    this.operSystem = operSystem;
    this.color = color;
    this.price = price;
    }
    public Laptop(){
    }
    public void printLaptop(){
        System.out.println(this.name + ", " + opsMemory + "GB RAM, Storage " + hardMemory+ "GB, "+ operSystem + ", " + color +", price is "+ price + "USD");
    }
    public Integer getOpsMemory(){
        return this.opsMemory;
    }
    public Integer getHardMemory(){
        return this.hardMemory;
    }
    public String getOperSystem(){
        return this.operSystem;
    }
    public Integer getPrice(){
        return this.price;
    }
    }

