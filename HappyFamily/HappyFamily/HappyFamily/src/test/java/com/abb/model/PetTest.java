package com.abb.model;

import com.abb.enums.Species;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTest
{

    @Test
    void testToString ()
    {
        Pet pet = new Pet(Species.DOG, "Rock", 5, 17, null);
        String expected = "Pet{\n" +
                "   species='" + Species.DOG + '\'' + ",\n" +
                "   nickname='Rock',\n" +
                "   age=5,\n" +
                "   trickLevel=17,\n" +
                "   habits=[null]\n" +
                '}';

        String actual = pet.toString();
        assertEquals(expected, actual);
    }
}