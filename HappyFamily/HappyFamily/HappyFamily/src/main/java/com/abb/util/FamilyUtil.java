package com.abb.util;

import com.abb.enums.DayOfWeek;
import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.service.FamilyService;

import java.util.HashMap;
import java.util.Map;

public class FamilyUtil
{
    private static final FamilyService familyService = new FamilyService();

    private static final Human father1 = new Human("Tom", "Carlson", "10/09/1971", 70);
    private static final Human father2 = new Human("Noah", "Jackson", "10/08/1973", 75);
    private static final Human mother1 = new Human("Olivia", "Carlson", "10/09/1974", 78);
    private static final Human mother2 = new Human("Sophia", "Jackson", "10/09/1980", 70);
    private static final Human child1 = new Human("Emma", "Jackson", "10/09/2000", 89);
    private static final Human child2 = new Human("Olivier", "Jackson", "10/09/2005", 70);
    private static final Human child3 = new Human("Amelia", "Carlson", "10/09/2004", 78);
    private static final Human child4 = new Human("James", "Carlson", "10/09/2001", 79);
    private static final Human child5 = new Human("Lucas", "Carlson", "10/09/2001", 77);
    private static final Human child6 = new Human("Jake", "Jackson", "10/09/2003", 76);
    private static Family family1;
    private static Family family2;

    public static void fillTestData ()
    {
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.FRIDAY, "Go to work");
        schedule.put(DayOfWeek.SUNDAY, "Sleep");
        father1.setSchedule(schedule);

        family1 = familyService.createNewFamily(father1, mother1);
        family2 = familyService.createNewFamily(father2, mother2);

        familyService.adoptChild(family2, child1);
        familyService.adoptChild(family2, child2);
        familyService.adoptChild(family1, child3);
        familyService.adoptChild(family1, child4);
        familyService.adoptChild(family1, child5);
    }
}
