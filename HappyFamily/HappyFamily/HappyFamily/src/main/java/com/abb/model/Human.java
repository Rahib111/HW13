package com.abb.model;

import com.abb.enums.DayOfWeek;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class Human implements Serializable
{
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String surname;
    private Long birthDate;
    private Integer iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private Map<DayOfWeek, String> schedule;

    public Human (String name, String surname, Long birthDate)
    {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human (String name, String surname, String birthDate, Integer iq)
    {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        try
        {
            this.birthDate = simpleDateFormat.parse(birthDate).getTime();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public Human (String name, String surname, Long birthDate, Human mother, Human father)
    {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public Human (String name, String surname, Long birthDate, Integer iq, Pet pet, Human mother, Human father,
                  Map<DayOfWeek, String> schedule)
    {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human ()
    {
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getSurname ()
    {
        return surname;
    }

    public void setSurname (String surname)
    {
        this.surname = surname;
    }

    public Long getBirthDate ()
    {
        return birthDate;
    }

    public void setBirthDate (Long birthDate)
    {
        this.birthDate = birthDate;
    }


    public Integer getIq ()
    {
        return iq;
    }

    public void setIq (Integer iq)
    {
        this.iq = iq;
    }

    public Pet getPet ()
    {
        return pet;
    }

    public void setPet (Pet pet)
    {
        this.pet = pet;
    }

    public Human getMother ()
    {
        return mother;
    }

    public void setMother (Human mother)
    {
        this.mother = mother;
    }

    public Human getFather ()
    {
        return father;
    }

    public void setFather (Human father)
    {
        this.father = father;
    }

    public Map<DayOfWeek, String> getSchedule ()
    {
        return schedule;
    }

    public void setSchedule (Map<DayOfWeek, String> schedule)
    {
        this.schedule = schedule;
    }

    public String describeAge ()
    {
        Date date = new Date(birthDate);
        return simpleDateFormat.format(date);
    }

    public void greetPet ()
    {
        System.out.println("Hello, " + pet.getNickname());
    }

    public void describePet ()
    {
        System.out.println(
                "I have a " + pet.getSpecies() + ", he is " + pet.getAge() + " years old, he is " + getTrickLevel());
    }

    private String getTrickLevel ()
    {
        if (pet.getTrickLevel() > 50)
            return "very sly";

        return "almost sly";
    }

    public String prettyFormat ()
    {
        return "{name='" + name + "', surname='" + surname + "', birthdate='" + describeAge() + "', iq=" + iq + ", " +
                "schedule=" + schedule + "}";
    }

    @Override
    public String toString ()
    {
        return "Human{\n" +
                "   name='" + name + '\'' + ",\n" +
                "   surname='" + surname + '\'' + ",\n" +
                "   birthDate=" + simpleDateFormat.format(birthDate) + ",\n" +
                "   iq=" + iq + ",\n" +
                "   pet=" + pet + ",\n" +
                "   mother=" + mother + ",\n" +
                "   father=" + father + ",\n" +
                "   schedule=" + schedule + '\n' +
                '}';
    }

    @Override
    public boolean equals (Object o)
    {
        if (!(o instanceof Human))//o == int
            return false;

        Human human = (Human) o;

        if (!this.name.equals(human.getName()))
            return false;
        if (!this.surname.equals(human.surname))
            return false;
        return this.birthDate.equals(human.birthDate);
    }

    @Override
    protected void finalize () throws Throwable
    {
        System.out.println("Human finalize method was called!");
        super.finalize();
    }
}
