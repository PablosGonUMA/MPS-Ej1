package org.example;

import java.util.List;

public class Person {

    private final String name;
    private final int age;
    private final String gender;

    /**
     * Construye un objeto Person a partir de un nombre, una edad y un género
     * @param name Nombre de la persona
     * @param age Edad de la persona
     * @param gender Género de la persona
     */
    public Person(String name, int age, String gender){

    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String gender(){
        return gender;
    }

    /**
     * Computa la edad media por géneros en una lista y devuelve el resultado en un array de 2 elementos.
     * @param persons
     * @return
     */
    public double[] avergeAgePerGender(List<Person> persons){
        return null;
    }

}
