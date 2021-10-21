package com.tripify.demo;

import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.privileges.repositories.PrivilegeRepository;
import com.tripify.demo.privileges.services.PrivilegeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event){
        PrivilegeManager.privilegeHashMap.forEach((s, privilege) -> {
            if(privilegeRepository.findByName(s).isEmpty()) {
                Privilege result = privilegeRepository.save(privilege);
                PrivilegeManager.privilegeHashMap.put(s,result);
            }
        });
    }

}
