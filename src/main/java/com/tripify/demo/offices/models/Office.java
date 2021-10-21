package com.tripify.demo.offices.models;

import com.tripify.demo.companies.models.Company;
import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.TablesNames;
import com.tripify.demo.offices.payloads.requests.OfficeRequest;
import com.tripify.demo.users.admins.models.Admin;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = TablesNames.offices)
@Data
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = ColumnsNames.name)
    private String name;

    @Column(name = ColumnsNames.lng)
    private Double lng;

    @Column(name = ColumnsNames.lat)
    private Double lat;

    @ManyToOne
    @JoinColumn(name = ColumnsNames.companyId, nullable = false)
    private Company company;

    public Office() {
    }

    public Office(OfficeRequest request, Company companyObj) {
        id = request.id;
        name = request.name;
        lat = request.lat;
        lng = request.lng;
        company = companyObj;
    }
}
