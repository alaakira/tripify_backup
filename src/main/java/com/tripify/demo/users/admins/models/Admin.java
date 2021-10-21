package com.tripify.demo.users.admins.models;

import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.TablesNames;
import com.tripify.demo.roles.model.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = TablesNames.admins)
@Data
public class Admin {

    public Admin() {
    }

    public Admin(long id, String phone, String password) {
        this.id = id;
        this.phone = phone;
        this.password = password;
    }
    public Admin(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnsNames.id)
    private long id;

    @Column(name = ColumnsNames.phone,nullable = false,unique = true)
    private String phone;

    @Column(name = ColumnsNames.password,nullable = false)
    private String password;
}
