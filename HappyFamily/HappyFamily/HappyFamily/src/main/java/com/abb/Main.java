package com.abb;

import com.abb.controller.FamilyController;
import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.util.MenuUtil;

public class Main
{
    public static void main (String[] args)
    {
        FamilyController familyController = new FamilyController();
        familyController.fetchData();

        System.out.println("********Welcome to happy family!***************");

        MenuUtil.printMenu();
        int operation = MenuUtil.getInt("Enter operation:");
        System.out.println();
        while (operation != 9)
        {
            switch (operation)
            {
                case 1:
                    familyController.displayAllFamilies();
                    MenuUtil.breakLine();
                    break;
                case 2:
                    int numberOfPeopleBigger = MenuUtil.getInt("Enter number of people:");
                    familyController.getFamiliesBiggerThan(numberOfPeopleBigger);
                    MenuUtil.breakLine();
                    break;
                case 3:
                    int numberOfPeopleLess = MenuUtil.getInt("Enter number of people:");
                    familyController.getFamiliesLessThan(numberOfPeopleLess);
                    MenuUtil.breakLine();
                    break;
                case 4:
                    int numberOfMember = MenuUtil.getInt("Enter number of members:");
                    System.out.println(familyController.countFamiliesWithMemberNumber(numberOfMember));
                    MenuUtil.breakLine();
                    break;
                case 5:
                    Human mother = MenuUtil.getHumanFor("Mother");
                    Human father = MenuUtil.getHumanFor("Father");

                    familyController.createNewFamily(father, mother);
                    MenuUtil.breakLine();
                    break;
                case 6:
                    int id = MenuUtil.getInt("Enter ID of the family: ");
                    if (familyController.deleteFamilyById(id))
                        System.out.println("Family is deleted successfully!");
                    else
                        System.out.println("Family could not be deleted!");
                    MenuUtil.breakLine();
                    break;
                case 7:
                    System.out.println("1. Give birth to baby\n" +
                            "2. Adopt a child\n" +
                            "3. Return main menu");
                    int op = MenuUtil.getInt("Enter operation: ");
                    if (op == 3)
                    {
                        MenuUtil.breakLine();
                        break;
                    }
                    int ID = MenuUtil.getInt("Enter ID of the family: ");
                    Family family = familyController.getFamilyById(ID);
                    if (op == 1)
                    {
                        String name = MenuUtil.getString("Enter name: ");
                        familyController.bornChild(family, name);
                    } else if (op == 2)
                    {
                        Human child = MenuUtil.getHumanFor("Child");
                        familyController.adoptChild(family, child);
                    }
                    MenuUtil.breakLine();
                    break;
                case 8:
                    int age = MenuUtil.getInt("Enter the age: ");
                    familyController.deleteAllChildrenOlderThan(age);
                    MenuUtil.breakLine();
                    break;
                default:
                    System.out.println("Please enter valid operation!");
                    MenuUtil.breakLine();
                    break;
            }
            MenuUtil.printMenu();
            operation = MenuUtil.getInt("Enter the operation: ");
        }
        MenuUtil.breakLine();
        System.out.println("Goodbye! :)");

        familyController.loadData(familyController.getAllFamilies());
    }
}