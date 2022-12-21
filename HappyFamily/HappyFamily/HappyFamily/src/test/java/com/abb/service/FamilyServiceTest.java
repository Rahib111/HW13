package com.abb.service;

import com.abb.model.Family;
import com.abb.model.Human;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FamilyServiceTest
{
    private static final FamilyService familyService = new FamilyService();

    private static Family family1;
    private static Family family2;
    private static Human father1;
    private static Human father2;
    private static Human mother1;
    private static Human mother2;
    private static Human child1;
    private static Human child2;
    private static Human child3;
    private static Human child4;
    private static Human child5;
    private static Human child6;

    @BeforeAll
    public static void beforeAll ()
    {
        father1 = new Human("Tom", "Carlson", "10/09/1971", 70);
        father2 = new Human("Noah", "Jackson", "10/08/1973", 75);
        mother1 = new Human("Olivia", "Carlson", "10/09/1974", 78);
        mother2 = new Human("Sophia", "Jackson", "10/09/1980", 70);
        child1 = new Human("Emma", "Jackson", "10/09/2000", 89);
        child2 = new Human("Olivier", "Jackson", "10/09/2005", 70);
        child3 = new Human("Amelia", "Carlson", "10/09/2004", 78);
        child4 = new Human("James", "Carlson", "10/09/2001", 79);
        child5 = new Human("Lucas", "Carlson", "10/09/2001", 77);
        child6 = new Human("Jake", "Jackson", "10/09/2003", 76);
    }

    @BeforeEach
    public void setUp ()
    {
        family1 = new Family(mother1, father1);
        family2 = new Family(mother2, father2);

        family1.addChild(child1);
        family1.addChild(child2);
        family2.addChild(child3);
        family2.addChild(child4);
        family2.addChild(child5);
        familyService.getAllFamilies().clear();

        familyService.getAllFamilies().add(family1);
        familyService.getAllFamilies().add(family2);
    }

    @Test
    public void getAllFamilies ()
    {
        List<Family> expected = Arrays.asList(family1, family2);
        List<Family> actual = familyService.getAllFamilies();

        assertEquals(expected, actual);
    }

    @Test
    public void countFamiliesWithMemberNumber ()
    {
        int numberOfPeople = 4;

        int expected = 1;
        int actual = familyService.countFamiliesWithMemberNumber(numberOfPeople);

        assertEquals(expected, actual);
    }

    @Test
    public void createNewFamily ()
    {
        familyService.deleteFamilyByIndex(1);

        int oldSize = familyService.getAllFamilies().size();

        familyService.createNewFamily(father2, mother2);

        int newSize = familyService.getAllFamilies().size();

        assertEquals(1, newSize - oldSize);
    }

    @Test
    public void deleteFamilyByIndex ()
    {
        int oldSize = familyService.getAllFamilies().size();
        int index = 1;

        boolean flag = familyService.deleteFamilyByIndex(index);
        int newSize = familyService.getAllFamilies().size();

        assertTrue(flag);
        assertEquals(1, oldSize - newSize);
    }

    @Test
    public void bornChild ()
    {
        int oldSize = family1.countFamily();

        Family family = familyService.bornChild(family1, "Jane");
        int newSize = family.countFamily();

        assertEquals(1, newSize - oldSize);
    }

    @Test
    public void adoptChild ()
    {
        int oldSize = family1.countFamily();

        Family family = familyService.adoptChild(family1, child6);
        int newSize = family.countFamily();

        assertEquals(1, newSize - oldSize);
    }

    @Test
    public void count ()
    {
        int expected = familyService.getAllFamilies().size();
        int actual = familyService.count();

        assertEquals(expected, actual);
    }

    @Test
    public void getFamilyById ()
    {
        Family expected = family1;
        Family actual = familyService.getFamilyByIndex(0);

        assertEquals(expected, actual);
    }
}