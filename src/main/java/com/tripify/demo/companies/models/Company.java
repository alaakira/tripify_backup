package com.tripify.demo.companies.models;

import com.tripify.demo.companies.payloads.requests.CompanyRequest;
import com.tripify.demo.companies.payloads.requests.EditCompanyRequest;
import com.tripify.demo.consts.ColumnsNames;
import com.tripify.demo.consts.TablesNames;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = TablesNames.company)
@Data
public class Company {

    public Company() {
    }

    public Company(CompanyRequest request) {
        if(request.getId() != null)
            id = request.getId();
        arName = request.getArName();
        enName = request.getEnName();
        address = request.getAddress();
        email = request.getEmail();
        certNum = request.getCertNum();
        phone = request.getPhone();
        landPhone = request.getLandPhone();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnsNames.id)
    private Long id;

    @Column(name = ColumnsNames.arName)
    private String arName;

    @Column(name = ColumnsNames.enName,nullable = false)
    private String enName;

    @Column(name = ColumnsNames.address)
    private String address;

    @Column(name = ColumnsNames.email)
    private String email;

    @Column(name = ColumnsNames.phone,nullable = false,unique = true)
    private String phone;

    @Column(name = ColumnsNames.landPhone)
    private String landPhone;

    @Column(name = ColumnsNames.logoId)
    private Long logoId;

    @Column(name = ColumnsNames.certNum,nullable = false,unique = true)
    private String certNum;

    @Column(name = ColumnsNames.ownerId)
    private Long ownerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public Long getLogoId() {
        return logoId;
    }

    public void setLogoId(Long logoPath) {
        this.logoId = logoPath;
    }

    public void update(EditCompanyRequest request) {
        if(request.getId() != null)
            id = request.getId();
        arName = request.getArName();
        enName = request.getEnName();
        address = request.getAddress();
        email = request.getEmail();
        phone = request.getPhone();
    }
}
