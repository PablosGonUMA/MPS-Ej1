package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CASOS DE PRUEBA
 * (1) - Si se crea un objeto Person, su nombre debe coincidir con el que se pasó por parámetro;
 * (2) - Si se crea un objeto Person, su edad debe coincidir con la que se pasó por parámetro;
 * (3) - Si se crea un objeto Person, su género debe coincidir con el que se pasó por parámetro;
 * (4) - Si el género pasado por parámetro no es ni "masculino" ni "femenino" saltará una excepción;
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
    void notMaleorFemaleGendersThrowException(){
        assertThrows(NonValidGenderException.class, () -> person = new Person("Pablo", 20, "random"));
    }


}
