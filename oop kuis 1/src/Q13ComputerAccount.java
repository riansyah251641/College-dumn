public class Q13ComputerAccount {
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

    // // Deklarasi Variable save data pasword to change
    String realName, userName, password, addpw;

    // fuction for input to data pasword to change
    public Q13ComputerAccount(String real, String user, String pw) {
        this.realName = real;
        this.userName = user;
        this.password = pw;
    }

    // Function for change a new data pasword to addpw ( data pasword to change)
    public void setPasword(String change) {
        this.password = change;
    }

    // getter data a new pasword
    public String getPasword() {
        return this.password;
    }

}