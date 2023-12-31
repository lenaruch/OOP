package study_group;

import study_group.service.Service;
import study_group.student.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student>{

    Service servise = new Service();
    private List<Student> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    class StudentIterator implements Iterator<Student>{
        private int index;

        @Override
        public boolean hasNext() {
            return studentList.size() > index;
        }

        @Override
        public Student next() {
            return studentList.get(index++);
        }
    }
}
