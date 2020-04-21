package model;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// http://localhost:8080/Students-ejb/add
// http://localhost:8080/Students-ejb/remove
// http://localhost:8080/Students-ejb/find

@Singleton
public class StudentDAO {

    public List<Student> students;
    public List<Course> courses;

    public StudentDAO(){
        students = new ArrayList<>();
        courses = new ArrayList<>();

        courses.add(new Course(1, "Metrologia"));
        courses.add(new Course(2, "Metody numeryczne"));
        courses.add(new Course(3, "SOA w projektowaniu i implementacji oprogramowania"));
        courses.add(new Course(4, "Programowanie obiektowe"));

        students.add(new Student(1, "Karol", "Bialy", 22, 3, "Elektrotechnika", Arrays.asList(courses.get(0), courses.get(1)) ));
        students.add(new Student(2, "Daniel", "Biel", 23, 4, "Informatyka", Arrays.asList(courses.get(3)) ));
        students.add(new Student(3, "Mariusz", "Orzechowski", 23, 5, "Informatyka", Arrays.asList(courses.get(2), courses.get(3)) ));
    }


    public List<Student> getStudents(){
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student findStudentById(Integer id) {
        return students.stream()
                .filter(s -> s.id.equals(id))
                .findFirst()
                .get();
    }

    public List<Student> findStudentByName(String name) {
        return findStudents(p -> p.firstName.equals(name));
    }

    public List<Student> findStudentByLastName(String lastName) {
        return findStudents(s -> s.lastName.equals(lastName));
    }

    public List<Student> findStudentByAge(Integer age) {
        return findStudents(s -> s.age.equals(age));
    }

    public List<Student> findStudentByYearOfStudy(Integer yearOfStudy) {
        return findStudents(s -> s.yearOfStudy.equals(yearOfStudy));
    }

    public List<Student> findStudentByField(String field) {
        return findStudents(s -> s.field.equals(field));
    }

    public List<Student> findStudentByCourse(String course) {
        return findStudents(s -> s.courses.contains(course));
    }

    public List<Student> findStudents(Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Integer id) {
        Student student = findStudentById(id);
        students.remove(student);
    }

    public void updateStudent(Student temp_student){
        Student student = findStudentById(temp_student.id);
        student.firstName=temp_student.firstName;
        student.lastName=temp_student.lastName;
        student.age=temp_student.age;
        student.yearOfStudy=temp_student.yearOfStudy;
        student.field=temp_student.field;
    }



}
