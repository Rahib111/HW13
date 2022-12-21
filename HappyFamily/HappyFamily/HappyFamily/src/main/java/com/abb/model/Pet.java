package com.abb.model;

import com.abb.enums.Species;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

public class Pet implements Serializable
{//pojo, bean
    private Species species;
    private String nickname;
    private Integer age;
    private Integer trickLevel;
    private Set<String> habits;

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits ()
    {
        return habits;
    }

    public void setHabits (Set<String> habits)
    {
        this.habits = habits;
    }

    public Pet (Species species, String nickname, Integer age, Integer trickLevel, Set<String> habits)
    {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet (Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet() {
    }

    public void eat ()
    {
        System.out.println("I am eating");
    }

    public void respond ()
    {
        System.out.println("Hello, owner. I am - " + nickname + ". I miss you!");
    }

    public void foul ()
    {
        System.out.println("I need to cover it up");
    }

    public String prettyFormat ()
    {
        return "{species=" + species.name() + ", nickname='" + nickname + "', age=" + age + ", trickLevel=" +
                trickLevel + ", habits=" + habits + "}";
    }

    @Override
    public String toString() {
        return "Pet{\n" +
                "   species='" + species + '\'' + ",\n" +
                "   nickname='" + nickname + '\'' + ",\n" +
                "   age=" + age + ",\n" +
                "   trickLevel=" + trickLevel + ",\n" +
                "   habits=" + Arrays.asList(habits).toString() + '\n' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet finalize method was called!");
        super.finalize();
    }
}
