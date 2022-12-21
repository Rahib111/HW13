package com.abb.dao.impls;

import com.abb.dao.FamilyDao;
import com.abb.model.Family;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao
{
    private static final String fileName = "families.dat";
    private static final String filePath = "C:\\Users\\Public\\Documents\\HappyFamily";

    private static List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies ()
    {
        return families;
    }

    @Override
    public Family getFamilyByIndex (int index)
    {
        if (index >= families.size())
            return null;

        return families.get(index);
    }

    @Override
    public Family getFamilyById (int id)
    {
        for (Family family : families)
        {
            if (family.getId().equals(id))
                return family;
        }
        return null;
    }

    @Override
    public Boolean deleteFamily (int index)
    {
        if (index >= families.size())
            return false;

        families.remove(index);

        return true;
    }

    @Override
    public Boolean deleteFamilyById (int id)
    {
        for (Family family : families)
            if (family.getId().equals(id))
            {
                families.remove(family);
                return true;
            }
        return false;
    }

    @Override
    public Boolean deleteFamily (Family family)
    {
        if (!families.contains(family))
            return false;

        families.remove(family);

        return true;
    }

    @Override
    public void saveFamily (Family family)
    {
        if (families.contains(family))
        {
            Family oldFamily = families.get(families.indexOf(family));
            updateFamily(oldFamily, family);
            return;
        }

        families.add(family);
    }

    @Override
    public void loadData (List<Family> families)
    {
        File file = new File(filePath + "\\" + fileName);
        if (!file.exists())
        {
            try
            {
                File path = new File(filePath);
                path.mkdir();
                file.createNewFile();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(filePath + "\\" + fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            for (Family family : families)
                objectOutputStream.writeObject(family);
        } catch (IOException ignored)
        {
        }
    }

    @Override
    public void fetchData ()
    {
        File file = new File(filePath + "\\" + fileName);
        if (!file.exists())
            return;

        try (FileInputStream fileInputStream =
                     new FileInputStream(filePath + "\\" + fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            while (true)
            {
                Family family = (Family) objectInputStream.readObject();
                if (family != null)
                    families.add(family);
                else
                    break;
            }
        } catch (IOException | ClassNotFoundException ignored)
        {
        }
    }

    private void updateFamily (Family oldFamily, Family newFamily)
    {
        oldFamily.setFather(newFamily.getFather());
        oldFamily.setMother(newFamily.getMother());
        oldFamily.setChildren(newFamily.getChildren());
        oldFamily.setPet(newFamily.getPet());
    }
}
