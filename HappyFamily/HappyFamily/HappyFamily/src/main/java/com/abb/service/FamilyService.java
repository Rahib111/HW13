package com.abb.service;

import com.abb.dao.FamilyDao;
import com.abb.dao.impls.CollectionFamilyDao;
import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.model.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService
{
    private static final FamilyDao familyDao = new CollectionFamilyDao();
    private static int idCounter = 1;

    public List<Family> getAllFamilies ()
    {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies ()
    {
        List<Family> families = familyDao.getAllFamilies();

        families.forEach(family -> System.out.println(family.prettyFormat()));
    }

    public void getFamiliesBiggerThan (int numberOfPeople)
    {
        List<Family> families = familyDao.getAllFamilies();

        families.forEach(family ->
        {
            if (family.countFamily() > numberOfPeople)
                System.out.println(family);
        });
    }

    public void getFamiliesLessThan (int numberOfPeople)
    {
        List<Family> families = familyDao.getAllFamilies();

        families.forEach(family ->
        {
            if (family.countFamily() < numberOfPeople)
                System.out.println(family);
        });
    }

    public int countFamiliesWithMemberNumber (int numberOfPeople)
    {
        List<Family> families = familyDao.getAllFamilies();

        List<Family> result = families.stream().filter(family -> family.countFamily() == numberOfPeople).collect(
                Collectors.toList());

        return result.size();
    }

    public Family createNewFamily (Human father, Human mother)
    {
        Family family = new Family(mother, father);
        family.setId(idCounter);
        idCounter++;
        familyDao.saveFamily(family);
        return family;
    }

    public boolean deleteFamilyByIndex (int index)
    {
        return familyDao.deleteFamily(index);
    }

    public boolean deleteFamilyById (int id)
    {
        return familyDao.deleteFamilyById(id);
    }

    public Family bornChild (Family family, String name)
    {
        Human child = new Human();
        child.setSurname(family.getFather().getSurname());
        child.setBirthDate(System.currentTimeMillis());
        child.setName(name);

        family.addChild(child);

        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild (Family family, Human child)
    {
        familyDao.getFamilyByIndex(familyDao.getAllFamilies().indexOf(family)).addChild(child);

        return family;
    }

    public void deleteAllChildrenOlderThan (int age)
    {
        List<Family> families = familyDao.getAllFamilies();

        families.forEach(family ->
        {
            List<Human> children = family.getChildren();
            children = children.stream()
                    .filter(child -> ((System.currentTimeMillis() - child.getBirthDate()) / 31557600000L) <= age)
                    .collect(Collectors.toList());
            family.setChildren(children);
        });
    }

    public int count ()
    {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyByIndex (int index)
    {
        return familyDao.getFamilyByIndex(index);
    }

    public Family getFamilyById (int id)
    {
        return familyDao.getFamilyById(id);
    }

    public List<Pet> getPets (int index)
    {
        Family family = familyDao.getFamilyByIndex(index);

        return new ArrayList<>(family.getPet());
    }

    public void addPet (int index, Pet pet)
    {
        Family family = familyDao.getFamilyByIndex(index);

        family.getPet().add(pet);
    }

    public void loadData (List<Family> families)
    {
        familyDao.loadData(families);
    }

    public void fetchData ()
    {
        familyDao.fetchData();
        idCounter = getAllFamilies().get(getAllFamilies().size() - 1).getId() + 1;
    }
}
