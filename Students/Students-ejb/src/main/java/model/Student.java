package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
import java.util.Objects;

public class Student {

    @XmlElement
    public Integer id;
    @XmlElement
    public String firstName;
    @XmlElement
    public String lastName;
    @XmlElement
    public Integer age;
    @XmlElement
    public Integer yearOfStudy;
    @XmlElement
    public String field;
    @XmlElementWrapper
    @XmlElement(name = "course")
    public List<Course> courses;

    public Student(){

    }

    public Student(Integer id, String firstName, String lastName, Integer age, Integer yearOfStudy, String field, List<Course> courses){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.age = age;
        this.yearOfStudy=yearOfStudy;
        this.field=field;
        this.courses=courses;
    }

    @Override
    public  String toString(){
        return "Student{" +
                "id= " + id +
                ", firstname=" + firstName +
                ", courses=" + courses  +
                "}";
    }

    public boolean containsCourseID(Integer course_id){
        for (Course course : courses ) {
            if(course.id.equals(course_id)) return true;
        }
        return false;
    }

    public boolean containsCourseName(String course_name){
        for (Course course : courses ) {
            if(course.name.toLowerCase().equals(course_name.toLowerCase())) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, yearOfStudy, field, courses);
    }

}
