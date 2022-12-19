package Abduvaliev_Abbos;

import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
public class Person {

    @Pattern(regexp = "[a-zA-Z]\s[a-zA-Z]",message = "Введите Фамилию и Имя")
    private String name;

    @Min(value = 1,message = "Возраст больше 0")
    private int age;

    @Size(min=1,message = "Хотя бы одна карта")
    private Card cards;


    public void setName( String name) {
        this.name = name;
    }

    public String getName( ) {
        return name;
    }

    public void setAge(  int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCards( Card cards) {
        this.cards = cards;
    }

    public Card getCards() {
        return cards;
    }

    public void showAll(){

        System.out.println(name +" "+ age +" ");
        cards.showAll();
    }
}


