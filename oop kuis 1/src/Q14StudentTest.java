public class Q14StudentTest {
    /**
     * Description Question
     * - Make file Q14Student consist name, Student ID, The Degree Programme
     * - make toString then display it in main fuction in file Q14StudentTest.java
     * - with format ex : "[Sri Purwaningsih, ID: 1000001, Bachelor Informatics]"
     * 
     * Solution
     * - save name, Student ID, and the Degree Programme, into variavle String type.
     * - place it in file Q14Student.java
     * - make fuction getter , with costuctor to get data
     * - then display in fuction main in Q14StudentTest.java
     * 
     */
    public static void main(String[] args) throws Exception {
        Q14Student data = new Q14Student("Sri Purwaningsih", 1000001, "Bachelor Informatics");
        System.out.println(data.toString());
    }
}
