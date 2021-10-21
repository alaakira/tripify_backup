package com.tripify.demo.privileges.model;

import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.TablesNames;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = TablesNames.privileges)
@Data
public class Privilege {

    public Privilege() {
    }

    public Privilege(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = ColumnsNames.name,unique = true)
    private String name;

    @Column(name = ColumnsNames.description)
    private String description;

}
