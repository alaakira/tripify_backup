package com.tripify.demo.dummy.Basic.controller;


import com.tripify.demo.consts.URLs;
import com.tripify.demo.dummy.Models.City;
import com.tripify.demo.dummy.Models.Company;
import com.tripify.demo.dummy.Models.Office;
import com.tripify.demo.dummy.Basic.Payload.Response.*;
import com.tripify.demo.dummy.Models.PassPoint;
import com.tripify.demo.dummy.auth.controller.DummyAuthController;
import com.tripify.demo.message_handler.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(URLs.DUMMY_PATH)
public class DummyBasicController {

    //Cities
    public static ArrayList<City> cities = new ArrayList<>(Arrays.asList(
            new City(1,"دمشق","Damascus"),
            new City(2,"السويداء","Swieda"),
            new City(3,"حماه","Hama")
    ));

    public static ArrayList<Office> offices = new ArrayList<>(Arrays.asList(
            new Office(1,1,"برامكة","Baramkah","Alabaramkah",32.0000d,33.0000d,1l,"0994942830"),
            new Office(2,2,"سويدا","Swieda","Alswieda city",32.0000d,33.0000d,1l,"0994942830"),
            new Office(3,1,"مزة","Mazah","Alabaramkah",32.0000d,33.0000d,1l,"0994942830"),
            new Office(4,3,"حماة","hama","hama city",32.0000d,33.0000d,1l,"0994942830"),
            new Office(5,3,"سلمية","salamia","salmaia",32.0000d,33.0000d,1l,"0994942830"),
            new Office(6,2,"شهبا","Shahba","Shahba",32.0000d,33.0000d,1l,"0994942830")

    ));


    //Company1 officess;
    public static ArrayList<Office> offices1 = new ArrayList<>(Arrays.asList(
            offices.get(0),offices.get(1)


    ));

    //Company2 officess;
    public static ArrayList<Office> offices2 = new ArrayList<>(Arrays.asList(
            offices.get(2),offices.get(3)

    ));

    //Company3 officess;
    public static ArrayList<Office> offices3 = new ArrayList<>(Arrays.asList(
            offices.get(4),offices.get(5)

    ));

    //Companies
    public static ArrayList<Company> companies = new ArrayList<>(Arrays.asList(
         new Company(1,"التوفيق","Altawfiq","https://cdn.icon-icons.com/icons2/2518/PNG/512/brand_instagram_icon_151534.png?fbclid=IwAR3jZIU3v52I2UKE7eKPg_9L5nSgFVN6sXYIJslVMkx21TX1NCH5wLLlqAY","0994942830","alswieda",offices),
            new Company(2,"الامل","alamal","https://cdn.icon-icons.com/icons2/2518/PNG/512/brand_instagram_icon_151534.png?fbclid=IwAR3jZIU3v52I2UKE7eKPg_9L5nSgFVN6sXYIJslVMkx21TX1NCH5wLLlqAY","0994942830","hama",offices2),
            new Company(3,"القدموس","alkadmous","https://cdn.icon-icons.com/icons2/2518/PNG/512/brand_instagram_icon_151534.png?fbclid=IwAR3jZIU3v52I2UKE7eKPg_9L5nSgFVN6sXYIJslVMkx21TX1NCH5wLLlqAY","0994942830","damascus",offices3)
    ));


    //Companies
    public static ArrayList<PassPoint> passPoints = new ArrayList<>(Arrays.asList(


            new PassPoint(1,"نقطة1","point","addddd",33.000d,33.000d),
            new PassPoint(2,"نقطة2","point","addddd",33.000d,33.000d),
            new PassPoint(3,"نقطة3","point","addddd",33.000d,33.000d),
            new PassPoint(4,"نقطة4","point","addddd",33.000d,33.000d)

    ));







    public DummyBasicController(){

    }

    @GetMapping(URLs.DUMMY_Get_Cities)
    public ResponseBody<GetCitiesResponse> getcities(){

        return new ResponseBody<>(new GetCitiesResponse(cities));

    }

    @GetMapping(URLs.DUMMY_Get_Companies)
    public ResponseBody<GetCompaniesResponse> getcompanies(){

        return new ResponseBody<>(new GetCompaniesResponse(companies));

    }

    @GetMapping(URLs.DUMMY_Get_Company)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<GetCompanyResponse> getcompany(@RequestParam int id){

        return new ResponseBody<>(new GetCompanyResponse(companies.get(id-1)));

    }

    @GetMapping(URLs.DUMMY_Get_Company_offices)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<GetCompanyOfficiesResponse> getcompanyofficies(@RequestParam int id){

        return new ResponseBody<>(new GetCompanyOfficiesResponse(companies.get(id-1).getOffices()));

    }

    @GetMapping(URLs.DUMMY_Get_office)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<GetOfficeResponse> getoffice(@RequestParam int id){

        return new ResponseBody<>(new GetOfficeResponse(offices.get(id-1)));

    }

    @GetMapping(URLs.DUMMY_Filtter_args)
    public ResponseBody<GetFillterArgs> getfillterargs() {

        return  new ResponseBody<>(new GetFillterArgs(companies,cities));
        
    }

    @GetMapping(URLs.DUMMY_Get_Profile)
    public ResponseBody<GetProfileResponse> getprofile() {

        return  new ResponseBody<>(new GetProfileResponse(DummyAuthController.users.get(0)));

    }







}
