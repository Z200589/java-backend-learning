package Day02;

import java.util.Objects;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // TODO: 重写 equals()

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Student)){
            return false;
        }

        Student other = (Student) obj;
        return this.id == other.id;
    }

    // TODO: 重写 hashCode()

    public int hashCode(){
        return Objects.hash(id);
    }
}