package Collections;

import java.util.Objects;

public class Student {

    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name)+Objects.hashCode(age);
    }
}