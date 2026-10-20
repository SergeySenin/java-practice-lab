
package org.study.javarush.java.core.level12.tasks12.b;

import java.util.ArrayList;
import java.util.List;

public class Solution214 {
    public static void main(String[] args) {

        List<String> invitedGuests = new ArrayList<>();

        invitedGuests.add("Анна");
        invitedGuests.add("Иван");
        invitedGuests.add("Петр");
        invitedGuests.add("Мария");

        boolean isPetrInvited = invitedGuests.contains("Петр");
        boolean isSergeyInvited = invitedGuests.contains("Сергей");

        System.out.println(isPetrInvited);
        System.out.println(isSergeyInvited);
    }
}
