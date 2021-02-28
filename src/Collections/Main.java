package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    /* Домашнее задание:
        Создайте класс с 2 полями, который будет использоваться при работе с коллекциями (например, класс User с полями age, name).
        1.  Реализовать метод, который принимает на вход 2 листа и возвращает лист, состоящий только из тех элементов, которые присутствуют в обоих листах.
        2.  Задание из 1го пункта, но вместо List нужно использовать Set.
        3.  Создайте ArrayList с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде: <индекс>: <элемент>
        4.  Создайте HashSet с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде: <элемент>
        5.  Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
            a.  итерация по значениям: <значение>
            b.  итерация по ключам: <ключ>: <значение>
            c.  итерация по парам: <ключ>: <значение> */

    public static void main(String[] args)
    {
        // Trying to work with Lists
        List<Student> firstList = new ArrayList<>();
        List<Student> secondList = new ArrayList<>();

        firstList.add(new Student("Ivan", 19));
        firstList.add(new Student("Oleg", 20));
        firstList.add(new Student("Oleg", 20));
        firstList.add(new Student("Pavel", 23));
        firstList.add(new Student("Eva", 20));

        secondList.add(new Student("Anna", 24));
        secondList.add(new Student("Oleg", 20));
        secondList.add(new Student("Pavel", 23));
        secondList.add(new Student("Pavel", 23));
        secondList.add(new Student("Olga", 20));

        // Checking the work of the 1st task
        System.out.println("Summary List of identical students:");
        for (Student student: identicalStudents(firstList, secondList)) {
            System.out.printf("Name: %s; Age: %d%n", student.name, student.age);
        }
        System.out.printf("%n");

        // Checking the work of the 3rd task
        System.out.println("Go through first ArrayList:");
        for (int index = 0; index < firstList.size(); index++) {
            System.out.printf("Index: %d; Name: %s; Age: %d%n", index, firstList.get(index).name, firstList.get(index).age);
        }
        System.out.printf("%n");


        ///////////////////////////////////////////////////////////////////////////
        // Trying to work with Sets
        Set<Student> firstSet = new HashSet<>();
        Set<Student> secondSet = new HashSet<>();

        firstSet.add(new Student("Ivan", 19));
        firstSet.add(new Student("Ivan", 19));
        firstSet.add(new Student("Oleg", 20));
        firstSet.add(new Student("Pavel", 23));
        firstSet.add(new Student("Eva", 20));

        secondSet.add(new Student("Anna", 24));
        secondSet.add(new Student("Ivan", 19));
        secondSet.add(new Student("Eva", 20));
        secondSet.add(new Student("Oleg", 20));


        // Checking the work of the 2nd task
        System.out.println("Summary Set of identical students:");
        for (Student student: identicalStudents(firstSet, secondSet)) {
            System.out.printf("Name: %s; Age: %d%n", student.name, student.age);
        }
        System.out.printf("%n");

        // Checking the work of the 5th task
        System.out.println("Go through first HashSet:");
        for (Student student : firstSet) {
            System.out.printf("Name: %s; Age: %d%n", student.name, student.age);
        }
        System.out.printf("%n");

        ///////////////////////////////////////////////////////////////////////////
        // Trying to work with Maps
        Map<String, Student> hashMap = new HashMap<>();

        hashMap.put("1st Student", new Student("Oleg", 20));
        hashMap.put("2nd Student", new Student("Olga", 18));
        hashMap.put("3nd Student", new Student("Ivan", 21));
        hashMap.put("4nd Student", new Student("Pavel", 25));
        hashMap.put("5nd Student", new Student("Pavel", 25));
        hashMap.put("5nd Student", new Student("Pavel", 25));

        System.out.println("Summary Set of identical students:");
        for (String key: hashMap.keySet()) {
                Student value = hashMap.get(key);
                System.out.printf("┌ Value - Name: %s; Age: %d%n", value.name, value.age);
                System.out.printf("│ Key - %s%n", key);
                System.out.printf("└ Key - %s; Value - Name: %s; Age: %d%n", key, value.name, value.age);
            }
        System.out.printf("%n");

    }

    private static List<Student> identicalStudents(List<Student> firstList, List<Student> secondList) {
        List<Student> summaryList = new ArrayList<>();

        for (Student studentFromFirstList: firstList) {
            for (Student studentFromSecondList: secondList) {
                if (studentFromFirstList.equals(studentFromSecondList)) {
                    boolean elemFound = false;
                    for(Student elem : summaryList){
                        if(elem.equals(studentFromFirstList)){
                            elemFound = true;
                            break;
                        }
                    }
                    if (!elemFound) { summaryList.add(studentFromFirstList); }
                }
            }
        }
        return summaryList;
    }

    private static Set<Student> identicalStudents(Set<Student> firstSet, Set<Student> secondSet) {
        Set<Student> summarySet = new HashSet<>();

        for (Student studentFromFirstSet: firstSet) {
            for (Student studentFromSecondSet: secondSet) {
                if (studentFromFirstSet.equals(studentFromSecondSet)) {
                    summarySet.add(studentFromFirstSet);
                }
            }
        }
        return summarySet;
    }
}
