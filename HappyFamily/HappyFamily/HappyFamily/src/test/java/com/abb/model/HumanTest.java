package com.abb.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        Human human = new Human("Michael","Karleone", "10/09/1971", 70 );
        String expected = "Human{\n" +
                "   name='Michael',\n" +
                "   surname='Karleone',\n" +
                "   birthDate=10/09/1971,\n" +
                "   iq=70,\n" +
                "   pet=null,\n" +
                "   mother=null,\n" +
                "   father=null,\n" +
                "   schedule=null\n" +
                '}';

        String actual = human.toString();
        assertEquals(expected, actual);


    }
}