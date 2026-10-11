
public class Student {

    private String name;
    private int age;
    private int studentID;
    
    //constructor
    public Student(String name, int age, int studentID){
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }
    
    public String getName() { return name; }

    public int getAge() { return age; }

    public int getStudentID() { return studentID; }
    
   /*
    * Produces a string representation of the contents of the object.
    * This exists for debugging purposes only.
    */
    public String toString() { 
        return studentID + " - " + name + " (" + age + ")" ; 
  }
}
