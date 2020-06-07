package Legacy.Algorithms.Search;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
    public String name;
    public double gradePointAverage;


    public Student(String name, double gradePointAverage) {
        this.name = name;
        this.gradePointAverage = gradePointAverage;
    }
}


public class BinarySearchLibrary {
    final Comparator<Student> compGPA = (a,b) -> {
        // compare grade point average if they are not equal
        if (a.gradePointAverage != b.gradePointAverage) {
            return Double.compare(a.gradePointAverage, b.gradePointAverage);
        }
        // compare the name if the grade point average is equal
        return a.name.compareTo(b.name);
    };

    public boolean SearchStudent(List<Student> students, Student target, Comparator<Student> compGPA)
    {
        return Collections.binarySearch(students,target,compGPA) >= 0;
    }
}
