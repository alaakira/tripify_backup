package com.tripify.demo.privileges.payloads.responses;

import lombok.Data;

@Data
public class PrivilegeResponse {

    public Long id;

    public String description;

    public PrivilegeResponse(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
