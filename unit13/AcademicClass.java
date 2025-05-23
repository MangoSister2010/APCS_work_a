import java.util.ArrayList;

class Student
{
    private String name; 
    private int favoriteNumber;
    
    public Student(String name, int favoriteNumber)
    {
        this.name = name; 
        this.favoriteNumber = favoriteNumber;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public int getFavoriteNumber()
    {
        return favoriteNumber;
    }
}

class Teacher 
{
    private String name;
    private String subject; 
    
    public Teacher(String name, String subject)
    {
        this.name = name; 
        this.subject = subject;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getSubject()
    {
        return subject;
    }
}

public class AcademicClass
{
    private Teacher teacher;
    private ArrayList<Student> students;
    
    public AcademicClass(Teacher teacher)
    {
        this.teacher = teacher; 
        this.students =  new ArrayList<>();
    }
    
    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher; 
    }
    
    public void addStudent(Student student)
    {
        students.add(student);
    }
    
    public void printClassInfo()
    {
        if(teacher != null)
        {
            System.out.println("Teacher: " + teacher.getName() + " - Subject:" + teacher.getSubject());
        }
        else
        {
            System.out.println("No teacher assigned");
        }
    }
    
    public ArrayList<String> studentsWithFavoriteNumber(int n)
    {
        ArrayList<String> result = new ArrayList<>();
        for(Student student : students)
        {
            if(student.getFavoriteNumber() == n)
            {
                result.add(student.getName());
            }
        }
        
        return result;
    }
    
    public ArrayList<String> studentWithOddFavoriteNumbers()
    {
        ArrayList<String> result = new ArrayList<>();
        for(Student student: students)
        {
            if(student.getFavoriteNumber() % 2 != 0)
            {
                result.add(student.getName());
            }
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
    Teacher teacher = new Teacher("Ms. Kim", "Math");
    
    AcademicClass mathClass = new AcademicClass(teacher);
    
    Student s1 = new Student("Alice", 3);
    Student s2 = new Student("Bob", 8);
    Student s3 = new Student("Charlie", 3);
    Student s4 = new Student("Daisy", 7);
    
    mathClass.addStudent(s1);
    mathClass.addStudent(s2);
    mathClass.addStudent(s3);
    mathClass.addStudent(s4);
    
    mathClass.printClassInfo();
    
    System.out.println("Students with favorite number 3: " + mathClass.studentsWithFavoriteNumber(3));
    
      
    System.out.println("Students with favorite odd numbers: " + mathClass.studentWithOddFavoriteNumbers());
    
    }
}

