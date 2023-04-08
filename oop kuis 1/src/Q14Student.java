public class Q14Student {
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

    // Deklarasi Variable
    String name, Degree_program;
    long Student_id;

    // Make Konstruktor with Parameter
    public Q14Student(String nama, long id, String jurusan) {
        this.name = nama;
        this.Student_id = id;
        this.Degree_program = jurusan;
    }

    // getter data to string
    public String toString() {
        return "[" + name + ", ID: " + Student_id + ", " + Degree_program + "]";
    }
}
