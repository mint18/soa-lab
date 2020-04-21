package model;

import javax.xml.bind.annotation.XmlElement;

public class Course {

    @XmlElement
    public Integer id;
    @XmlElement
    public String name;

    public Course(){

    }

    public Course(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public  String toString(){
        return "Course{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }

}
