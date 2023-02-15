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

        if(age < 0){
            throw new NegativeAgeException("Edad negativa");
        }

        if(gender == null || gender != "masculino" && gender != "femenino"){
            throw new NonValidGenderException("Género debe ser masculino o femenino");
        }

        if(name == null){
            throw new RuntimeException("El nombre no puede ser nulo");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;

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
    public double[] avergeAgePerGender(List<Person> persons)
    {
        double menMean = 0.0, womenMean = 0.0;
        int numberOfMen = 0, numberOfWomen = 0;
        double[] result;

        if(persons == null || persons.isEmpty()){
            result = new double[]{0.0, 0.0};
        } else if (persons.size() == 1 && persons.get(0).gender() == "masculino"){
            result = new double[]{persons.get(0).age(), 0.0};
        } else if (persons.size() == 1 && persons.get(0).gender() == "femenino"){
            result = new double[]{0.0, persons.get(0).age()};
        } else {

            for (Person p: persons) {
                if(p.gender() == "masculino"){
                    menMean += p.age();
                    numberOfMen++;
                } else {
                    womenMean += p.age();
                    numberOfWomen++;
                }
            }

            if(numberOfMen != 0){
                menMean = menMean/numberOfMen;
            }

            if(numberOfWomen != 0){
                womenMean = womenMean/numberOfWomen;
            }

            result = new double[]{menMean, womenMean};

        }



        return result;
    }

}
