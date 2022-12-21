package com.abb.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    Human mother = new Human("Jane", "Karleone", "10/09/1970", 70);
    Human father = new Human("Vito ", "Karleone ", "10/09/1965", 70);
    Family family = new Family(mother, father);
    Human child1 = new Human("Michael", "Karleoone", "10/09/1990", 70);
    Human child2 = new Human("Sunny", "Karleoone", "10/09/1993", 70);
    Human child3 = new Human("Orxan", "Mehmanov", "10/09/1994", 70);

    @Test
    void testToString() {

        String expected = "Family{\n" +
                "   mother=" + mother + ",\n" +
                "   father=" + father + ",\n" +
                "   children=[],\n" +
                "   pet=[]\n" +
                '}';

        String actual = family.toString();
        assertEquals(expected, actual);

    }
    @Test
    void testDeleteChild_whenValidIndex(){

        family.addChild(child1);
        family.addChild(child2);
        List<Human> arrayHuman = new ArrayList<>(family.getChildren());
        family.deleteChild(1);
        List<Human> arrayHuman2 = family.getChildren();
        assertNotEquals(arrayHuman, arrayHuman2);
    }
    @Test
    void testDeleteChild_whenInvalidIndex(){
        family.addChild(child1);
        family.addChild(child2);
        List<Human> arrayHuman = family.getChildren();
        family.deleteChild(3);
        List<Human> arrayHuman2 = family.getChildren();
        assertEquals(arrayHuman, arrayHuman2);
    }
    @Test
    void testDeleteChild_whenValidHuman(){
        family.addChild(child1);
        family.addChild(child2);
        List<Human> humanList = new ArrayList<>(family.getChildren());
        family.deleteChild(child1);
        List<Human> humanList2 = family.getChildren();
        assertNotEquals(humanList, humanList2);
    }
    @Test
    void testDeleteChild_whenInValidHuman(){
        family.addChild(child1);
        family.addChild(child2);
        List<Human> arrayHuman = family.getChildren();
        family.deleteChild(child3);
        List<Human> arrayHUman2 = family.getChildren();
        assertEquals(arrayHuman, arrayHUman2);
    }
    @Test
    void testAddChild(){
        int lengthChildren = family.getChildren().size();
        family.addChild(child1);
        int lengthChildren02 = family.getChildren().size();
        int difference = lengthChildren02 - lengthChildren;
        int expected = 1;
        assertEquals(expected, difference);

    }
    @Test
    void testCountFamily(){
        int countChildren = family.getChildren().size();
        int expected = countChildren + 2;
        int actual = family.countFamily();
        assertEquals(expected, actual);
    }


}