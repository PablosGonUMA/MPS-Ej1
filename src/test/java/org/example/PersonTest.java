package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CASOS DE PRUEBA
 * (1) - Si se crea un objeto Person, su nombre debe coincidir con el que se pasó por parámetro;
 * (2) - Si se crea un objeto Person, su edad debe coincidir con la que se pasó por parámetro;
 * (3) - Si se crea un objeto Person, su género debe coincidir con el que se pasó por parámetro;
 * (4) - Si el género pasado por parámetro al constructor de Person no es ni "masculino" ni "femenino" saltará una excepción;
 * (5) - Si la edad pasada por parámetro al constructor de Person es negtiva saltará una excepción;
 *
 * (6) - Si al método averageAgePerGender se le pasa una lista vacía el resultado será [0,0]
 * (7) - Si al método averageAgePerGender se le pasa una lista de 1 solo hombre el resultado será {x, 0}, siendo x la edad del hombre
 * (8) - Si al método averageAgePerGender se le pasa una lista de 1 solo hombre el resultado será {0, x}, siendo x la edad de la mujer
 * (9) - Si al método averageAgePerGender se le pasa una lista de 1 hombre y 1 mujer el resultado será {x, y}, siendo x la edad del hombre e y la edad de la mujer
 * (10) - Si al método averageAgePerGender se le pasa una lista de varios hombres el resultado será {x, 0}, siendo x la edad media de los hombres
 * (11) - Si al método averageAgePerGender se le pasa una lista de varias mujeres el resultado será {0, x}, siendo x la edad media de las mujeres
 * (12) - Si al método averageAgePerGender se le pasa una lista con más elementos el resultado será {x, y}, siendo x la edad media de los hombres e y la edad media de las mujeres
 */
class PersonTest {

    Person person;

    @Test
    void personNameMatchesWithConstructorParameter(){

        String name = "Pablo";
        int age = 20;
        String gender = "masculino";

        person = new Person(name, age, gender);
        assertEquals(name, person.name());

    }

    @Test
    void personAgeMatchesWithConstructorParameter(){

        String name = "Pablo";
        int age = 20;
        String gender = "masculino";

        person = new Person(name, age, gender);
        assertEquals(age, person.age());
    }

    @Test
    void personGenderMatchesWithConstructorParameter(){

        String name = "Pablo";
        int age = 20;
        String gender = "masculino";

        person = new Person(name, age, gender);
        assertEquals(gender, person.gender());
    }

    @Test
    void notMaleOrFemaleGendersThrowException(){
        assertThrows(NonValidGenderException.class, () -> person = new Person("Pablo", 20, "random"));
    }

    @Test
    void negativeAgesThrowException(){
        assertThrows(NegativeAgeException.class, () -> person = new Person("Pablo", -20, "masculino"));
    }

    @Test
    void averageOfEmptyListIs00(){
        Person person = new Person("Pablo", 20, "masculino");
        List<Person> emptyList = new ArrayList<>();
        assertEquals(person.avergeAgePerGender(emptyList)[0], 0.0);
        assertEquals(person.avergeAgePerGender(emptyList)[1], 0.0);
    }

    @Test
    void averageOfOneManIsMansAge0(){
        Person person = new Person("Pablo", 20, "masculino");
        List<Person> list = new ArrayList<>();
        list.add(person);
        assertEquals(person.avergeAgePerGender(list)[0], person.age());
        assertEquals(person.avergeAgePerGender(list)[1], 0.0);
    }

    @Test
    void averageOfOneWomanIs0WomansAge(){
        Person person = new Person("Pablo", 20, "femenino");
        List<Person> list = new ArrayList<>();
        list.add(person);
        assertEquals(person.avergeAgePerGender(list)[0], 0.0);
        assertEquals(person.avergeAgePerGender(list)[1], person.age());
    }

    @Test
    void averageOfOneManAndOneWomanIsMansAgeWomansAge(){
        Person man = new Person("Pablo", 20, "masculino");
        Person woman = new Person("Pablo", 20, "femenino");
        List<Person> list = new ArrayList<>();
        list.add(man);
        list.add(woman);
        assertEquals(man.avergeAgePerGender(list)[0], man.age());
        assertEquals(man.avergeAgePerGender(list)[1], woman.age());
    }

    @Test
    void averageOfOnlyMenIsMenMean0(){
        Person man1 = new Person("Pablo", 20, "masculino");
        Person man2 = new Person("Pedro", 20, "masculino");
        List<Person> list = new ArrayList<>();
        list.add(man1);
        list.add(man2);
        assertEquals(man1.avergeAgePerGender(list)[0], (man1.age()+man2.age())/2);
        assertEquals(man1.avergeAgePerGender(list)[1], 0.0);
    }

    @Test
    void averageOfOnlyWomenIs0WomenMean(){
        Person woman1 = new Person("Pablo", 20, "femenino");
        Person woman2 = new Person("Pedro", 20, "femenino");
        List<Person> list = new ArrayList<>();
        list.add(woman1);
        list.add(woman2);
        assertEquals(woman1.avergeAgePerGender(list)[0], 0.0);
        assertEquals(woman1.avergeAgePerGender(list)[1], (woman1.age()+woman2.age())/2);
    }

    @Test
    void averageOfListWithMorePeopleIsMenMeanWomenMean(){
        Person man1 = new Person("Pablo", 20, "masculino");
        Person woman1 = new Person("Pablo", 20, "femenino");
        Person man2 = new Person("Pedro", 20, "masculino");
        Person woman2 = new Person("Pedro", 20, "femenino");
        List<Person> list = new ArrayList<>();
        list.add(man1);
        list.add(woman1);
        list.add(man2);
        list.add(woman2);
        assertEquals(man1.avergeAgePerGender(list)[0], (man1.age()+man2.age())/2);
        assertEquals(man1.avergeAgePerGender(list)[1], (woman1.age()+woman2.age())/2);
    }
}
