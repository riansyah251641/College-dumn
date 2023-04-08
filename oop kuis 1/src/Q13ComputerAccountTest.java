import java.util.Scanner;

public class Q13ComputerAccountTest {
    /**
     * Insturction
     * make a user data string consist realname, username,and pasword ->take no
     * arguments
     * using constructor file name Q13ComputerAccount.java to create fuction change
     * pasword in user data consist function public, getter, and setter.
     * dispay a new user data after change pasword
     * 
     * Steps
     * 1. declere static user data for example
     * realname = rian
     * username = riansyah
     * pasword = rian1234
     * 
     * 2. make construktor to create fuction void change pasword using scanner then
     * save in data string.
     * 3. set data new pasword to last pasword
     * 4. display the result
     */

    public static void main(String[] args) throws Exception {
        Q13ComputerAccount dataUser = new Q13ComputerAccount("rian", "Riansyah", "Rian1641");
        System.out.println("User Data");
        System.out.println("Realname\t: " + dataUser.realName);
        System.out.println("Username\t: " + dataUser.userName);
        System.out.println("pasword\t\t: " + dataUser.password);
        System.out.println("---------------------------");
        System.out.print("Change Pasword = ");
        Scanner changePW = new Scanner(System.in);

        String getNewPasword = changePW.nextLine();
        dataUser.setPasword(getNewPasword);
        System.out.println("\nUpdate User Data");
        System.out.println("Realname\t: " + dataUser.realName);
        System.out.println("Username\t: " + dataUser.userName);
        System.out.println("pasword\t\t: " + dataUser.password);
        System.out.println("---------------------------");
    }
}
