package com.tripify.demo.privileges.services;

import com.tripify.demo.privileges.model.Privilege;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Component
public class PrivilegeManager {

    public static final HashMap<String, Privilege> privilegeHashMap = new HashMap<>();

    public static void addToRepository(Privilege privilege) {
        if (!privilegeHashMap.containsKey(privilege.getName())) {
            privilegeHashMap.put(privilege.getName(), privilege);
        }
    }

    @SafeVarargs
    public static void setupManager(Pair<String,String>... names){
        Arrays.stream(names).forEach(pair -> addToRepository(new Privilege(pair.getFirst(), pair.getSecond())));
    }
}
