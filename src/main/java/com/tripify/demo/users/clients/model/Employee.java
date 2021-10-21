package com.tripify.demo.users.clients.model;

import com.tripify.demo.company_roles.model.CompanyRoles;
import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.IdsGenerator;
import com.tripify.demo.consts.TablesNames;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = TablesNames.employees)
@Data
public class Employee {

    public Employee() {
    }

    public Employee(User userId) {
        this.userId = userId;
        this.roleId = userId.getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = IdsGenerator.employeeGenerator)
    @Column(name = ColumnsNames.id)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ColumnsNames.userId, referencedColumnName = ColumnsNames.id)
    public User userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ColumnsNames.roleId, referencedColumnName = ColumnsNames.id)
    public CompanyRoles roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
