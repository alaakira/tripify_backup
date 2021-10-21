package com.tripify.demo.privileges.services;

import com.tripify.demo.exceptions.IdNotFoundException;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.privileges.payloads.responses.PrivilegeResponse;
import com.tripify.demo.privileges.repositories.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrivilegeCRUDService {

    @Autowired
    private PrivilegeRepository repository;

    public PrivilegeResponse getPrivilegeById(Long id){
        Privilege result = repository.findById(id).orElseThrow(IdNotFoundException::new);
        return new PrivilegeResponse(result.getId(),result.getDescription());
    }

    public List<PrivilegeResponse> getAllPrivileges(){
        List<PrivilegeResponse> responseList = new ArrayList<>();
        List<Privilege> result = repository.findAll();
        result.forEach(privilege -> responseList.add(new PrivilegeResponse(privilege.getId(), privilege.getDescription())));
        return responseList;
    }

}
