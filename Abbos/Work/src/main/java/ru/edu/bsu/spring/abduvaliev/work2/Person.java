package ru.edu.bsu.spring.abduvaliev.work2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private List<Card> cards  = new ArrayList<>();
    public Person(Person person) {
        this.name = person.name;
        this.age = person.age;
        this.cards = person.cards;
    }
}

