package com.tripify.demo.users.clients.model;


import com.tripify.demo.company_roles.model.CompanyRoles;
import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.IdsGenerator;
import com.tripify.demo.consts.TablesNames;
import com.tripify.demo.roles.model.Roles;
import com.tripify.demo.users.clients.payloads.resquests.UserSignUpRequest;
import com.tripify.demo.users.types.UserTypes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = TablesNames.users)
@Data
public class User {

    public User() {
    }

    public User(UserSignUpRequest employee){
        setFirstName(employee.firstName);
        setLastName(employee.lastName);
        setPhone(employee.phone);
        setPassword(employee.password);
        setBirthday(employee.birthday);
        setAddress(employee.address);
        setType(UserTypes.EMPLOYEE.getType());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = IdsGenerator.userGenerator)
    @Column(name = ColumnsNames.id)
    Long id;

    @Column(name = ColumnsNames.firstName)
    String firstName;

    @Column(name = ColumnsNames.lastName, nullable = false)
    String lastName;

    @Column(name = ColumnsNames.phone, nullable = false)
    String phone;

    @Column(name = ColumnsNames.password, nullable = false)
    String password;

    @Column(name = ColumnsNames.address)
    String address;

    @Column(name = ColumnsNames.birthday)
    String birthday;

    @Column(name = ColumnsNames.type, nullable = false)
    String type;

    @Column(name = ColumnsNames.userId)
    Long userId;

    @ManyToOne
    @JoinTable(
            name = TablesNames.clientsRoles,
            joinColumns = @JoinColumn(name = ColumnsNames.userId,referencedColumnName = ColumnsNames.id),
            inverseJoinColumns = @JoinColumn(name = ColumnsNames.roleId,referencedColumnName = ColumnsNames.id))
    private CompanyRoles roles;
}
