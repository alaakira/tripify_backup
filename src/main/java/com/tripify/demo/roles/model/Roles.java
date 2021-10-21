package com.tripify.demo.roles.model;

import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.TablesNames;
import com.tripify.demo.privileges.model.Privilege;
import com.tripify.demo.users.admins.models.Admin;
import com.tripify.demo.users.clients.model.User;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = TablesNames.roles)
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = ColumnsNames.name)
    private String name;

    @OneToMany
    @JoinTable(
            name = TablesNames.clientsRoles,
            joinColumns = @JoinColumn(name = ColumnsNames.roleId,referencedColumnName = ColumnsNames.id),
            inverseJoinColumns = @JoinColumn(name = ColumnsNames.userId,referencedColumnName = ColumnsNames.id))
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = TablesNames.rolesPrivileges,
            joinColumns = @JoinColumn(name = ColumnsNames.roleId,referencedColumnName = ColumnsNames.id),
            inverseJoinColumns = @JoinColumn(name = ColumnsNames.privilegeId,referencedColumnName = ColumnsNames.id))
    private Collection<Privilege> privileges;

}
