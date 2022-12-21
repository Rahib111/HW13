package com.abb.dao;

import com.abb.model.Family;

import java.util.List;

public interface FamilyDao
{
    List<Family> getAllFamilies ();

    Family getFamilyByIndex (int index);
    Family getFamilyById (int id);

    Boolean deleteFamily (int index);
    Boolean deleteFamilyById (int id);

    Boolean deleteFamily (Family family);

    void saveFamily (Family family);

    void loadData (List<Family> families);
    void fetchData ();
}
