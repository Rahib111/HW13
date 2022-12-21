package com.abb.controller;

import com.abb.exception.FamilyOverflowException;
import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.model.Pet;
import com.abb.service.FamilyService;

import java.util.List;

public class FamilyController
{
    private static FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies ()
    {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies ()
    {
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan (int numberOfPeople)
    {
        familyService.getFamiliesBiggerThan(numberOfPeople);
    }

    public void getFamiliesLessThan (int numberOfPeople)
    {
        familyService.getFamiliesLessThan(numberOfPeople);
    }

    public int countFamiliesWithMemberNumber (int numberOfPeople)
    {
        return familyService.countFamiliesWithMemberNumber(numberOfPeople);
    }

    public void createNewFamily (Human father, Human mother)
    {
        familyService.createNewFamily(father, mother);
    }

    public boolean deleteFamilyByIndex (int index)
    {
        return familyService.deleteFamilyByIndex(index);
    }

    public boolean deleteFamilyById (int id)
    {
        return familyService.deleteFamilyById(id);
    }

    public Family bornChild (Family family, String name)
    {
        if (family.countFamily() >= 6)
            throw new FamilyOverflowException("Family members are greater than 6, so family can not give birth!");

        return familyService.bornChild(family, name);
    }

    public Family adoptChild (Family family, Human child)
    {
        if (family.countFamily() >= 6)
            throw new FamilyOverflowException("Family members are greater than 6, so family can not give birth!");

        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan (int age)
    {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count ()
    {
        return familyService.count();
    }

    public Family getFamilyByIndex (int index)
    {
        return familyService.getFamilyByIndex(index);
    }

    public Family getFamilyById (int id)
    {
        return familyService.getFamilyById(id);
    }

    public List<Pet> getPets (int index)
    {
        return familyService.getPets(index);
    }

    public void addPet (int index, Pet pet)
    {
        familyService.addPet(index, pet);
    }

    public void loadData (List<Family> families)
    {
        familyService.loadData(families);
    }

    public void fetchData ()
    {
        familyService.fetchData();
    }
}
