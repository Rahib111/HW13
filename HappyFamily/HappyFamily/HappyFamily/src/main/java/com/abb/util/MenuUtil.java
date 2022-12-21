package com.abb.util;

import com.abb.model.Human;

import java.util.Scanner;

public class MenuUtil
{
    private static final Scanner scanner = new Scanner(System.in);
    public static void printMenu()
    {
        System.out.println("Operations:\n" +
                "1. Display families\n" +
                "2. Display families where the number of people is greater than the your number\n" +
                "3. Display families where the number of people is less than the your number\n" +
                "4. Calculate the number of families where the number of members is\n" +
                "5. Create a new family\n" +
                "6. Delete a family by its index in families\n" +
                "7. Edit a family by its index in families\n" +
                "8. Remove all children over the age of majority\n" +
                "9. Exit\n");
    }

    public static int getInt(String message)
    {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static String getString(String message)
    {
        System.out.print(message);
        return scanner.next();
    }

    public static Human getHumanFor (String who)
    {
        String name = MenuUtil.getString(who + " name:");
        String lastName = MenuUtil.getString(who + " last name:");
        String birthYear = MenuUtil.getString(who + " birth year:");
        String birthMonth = MenuUtil.getString(who + " birth month:");
        String birthday = MenuUtil.getString(who + " birth day:");
        Integer iq = MenuUtil.getInt(who + " IQ:");
        String birthdate = birthday + '/' + birthMonth + '/' + birthYear;

        return new Human(name, lastName, birthdate, iq);
    }

    public static void breakLine ()
    {
        System.out.println("*****************************************************************");
    }
}
