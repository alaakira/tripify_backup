package com.tripify.demo.dummy.Trips.controller;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.dummy.Basic.Payload.Response.GetOfficeResponse;
import com.tripify.demo.dummy.Basic.controller.DummyBasicController;
import com.tripify.demo.dummy.Models.Reservation;
import com.tripify.demo.dummy.Models.Trip;
import com.tripify.demo.dummy.Models.Tripslog;
import com.tripify.demo.dummy.Trips.Payload.Request.AddReservationRequest;
import com.tripify.demo.dummy.Trips.Payload.Request.FillterRequest;
import com.tripify.demo.dummy.Trips.Payload.Response.AddReservationResponse;
import com.tripify.demo.dummy.Trips.Payload.Response.FillterResponse;
import com.tripify.demo.dummy.Trips.Payload.Response.GetTripResponse;
import com.tripify.demo.dummy.Trips.Payload.Response.PreviousTripsResponse;
import com.tripify.demo.exceptions.NoEnoughSeatsException;
import com.tripify.demo.exceptions.NoIdException;
import com.tripify.demo.message_handler.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(URLs.DUMMY_PATH)
public class DummyTripsController {


    public DummyTripsController() {
    }

    public static ArrayList<Trip> trips = new ArrayList<>(Arrays.asList(
            new Trip(1,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(2,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,2,2.6,"2000"),
            new Trip(3,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(4,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(5,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(6,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(7,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(8,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(9,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(10,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(11,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(12,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(13,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(14,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(15,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(16,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(17,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(18,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(19,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(20,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(21,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(22,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(23,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(24,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(25,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(26,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(27,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(28,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(29,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000"),
            new Trip(30,1,DummyBasicController.cities.get(0),1,DummyBasicController.offices.get(0),2,DummyBasicController.cities.get(0),2,DummyBasicController.offices.get(0),"2-7-2021","5:000pm",1,DummyBasicController.companies.get(0),DummyBasicController.passPoints,25,2.6,"2000")





            ));


    public static ArrayList<Reservation> reservations = new ArrayList<>(Arrays.asList(
          new Reservation(1l,1l,3l,trips.get(3),2,true),
            new Reservation(2l,1l,5l,trips.get(5),2,false),
            new Reservation(1l,1l,3l,trips.get(3),2,true),
            new Reservation(1l,1l,3l,trips.get(3),2,true),
            new Reservation(1l,1l,3l,trips.get(3),2,false),
            new Reservation(1l,1l,3l,trips.get(3),2,true)


            ));


    @GetMapping(URLs.DUMMY_Get_previous_trips)
    public ResponseBody<PreviousTripsResponse> getprevios(@RequestParam (defaultValue = "0") Integer pageNo,
                                                          @RequestParam (defaultValue = "2") Integer pageSize) {
        int nextelements=(reservations.size()-(pageNo*pageSize));
        double nextpages=Math.ceil(Double.valueOf(nextelements)/pageSize.doubleValue());
        int allelements=reservations.size();
        double allpages=Math.ceil(Double.valueOf(allelements)/pageSize.doubleValue());

        if(nextelements<0)
        {
            nextelements=0;
        }
        if (nextpages<0)
        {
            nextpages=0;
        }


        if(pageNo>allpages)
        {
            List<Reservation> reservations1= new ArrayList<>();
            reservations1.add(reservations.get(0));
            reservations1.remove(0);
            return  new ResponseBody<>(new PreviousTripsResponse(pageNo, pageSize, (int) nextpages, nextelements, allelements, (int) allpages, 0,reservations1 ));


        }
        else if (pageSize*pageNo>allelements)
        {
            return  new ResponseBody<>(new PreviousTripsResponse(pageNo,pageSize,(int)nextpages,nextelements,allelements,(int)allpages,reservations.subList((pageNo*pageSize-pageSize),reservations.size()).size(),reservations.subList((pageNo*pageSize-pageSize),reservations.size())));

        }

        else
        {
            return  new ResponseBody<>(new PreviousTripsResponse(pageNo,pageSize,(int)nextpages,nextelements,allelements,(int)allpages,reservations.subList((pageNo*pageSize-pageSize),(pageNo*pageSize)).size(),reservations.subList((pageNo*pageSize-pageSize),(pageNo*pageSize))));

        }

    }


    @GetMapping(URLs.DUMMY_Get_upcoming_trips)
    public ResponseBody<PreviousTripsResponse> getupcoming(@RequestParam (defaultValue = "0") Integer pageNo,
                                                          @RequestParam (defaultValue = "2") Integer pageSize) {
        int nextelements=(reservations.size()-(pageNo*pageSize));
        double nextpages=Math.ceil(Double.valueOf(nextelements)/pageSize.doubleValue());
        int allelements=reservations.size();
        double allpages=Math.ceil(Double.valueOf(allelements)/pageSize.doubleValue());

        if(nextelements<0)
        {
            nextelements=0;
        }
        if (nextpages<0)
        {
            nextpages=0;
        }


        if(pageNo>allpages)
        {
            List<Reservation> reservations1= new ArrayList<>();
            reservations1.add(reservations.get(0));
            reservations1.remove(0);
            return  new ResponseBody<>(new PreviousTripsResponse(pageNo, pageSize, (int) nextpages, nextelements, allelements, (int) allpages, 0, reservations1));


        }
        else if (pageSize*pageNo>allelements)
        {
            return  new ResponseBody<>(new PreviousTripsResponse(pageNo,pageSize,(int)nextpages,nextelements,allelements,(int)allpages,reservations.subList((pageNo*pageSize-pageSize),reservations.size()).size(),reservations.subList((pageNo*pageSize-pageSize),reservations.size())));

        }

        else
        {
            return  new ResponseBody<>(new PreviousTripsResponse(pageNo,pageSize,(int)nextpages,nextelements,allelements,(int)allpages,reservations.subList((pageNo*pageSize-pageSize),(pageNo*pageSize)).size(),reservations.subList((pageNo*pageSize-pageSize),(pageNo*pageSize))));

        }

    }

    @GetMapping(URLs.DUMMY_Get_trip)
    public ResponseBody<GetTripResponse> gettrip(@RequestParam int id) {

        for (Trip trip : trips)
        {
            if(trip.getId()==id)
            {
                return new ResponseBody<>(new GetTripResponse(trip));
            }
        }

        throw new NoIdException();



    }

    @PostMapping(URLs.DUMMY_Filtter)

    public ResponseBody<FillterResponse> fillter(@RequestBody FillterRequest fillterRequest,
                                                 @RequestParam (defaultValue = "0") Integer pageNo,
                                                 @RequestParam (defaultValue = "2") Integer pageSize) {
        int nextelements=(trips.size()-(pageNo*pageSize));
        double nextpages=Math.ceil(Double.valueOf(nextelements)/pageSize.doubleValue());
        int allelements=trips.size();
        double allpages=Math.ceil(Double.valueOf(allelements)/pageSize.doubleValue());

        if(nextelements<0)
        {
            nextelements=0;
        }
        if (nextpages<0)
        {
            nextpages=0;
        }
        if(pageNo>allpages)
        {
            List<Trip> trips1= new ArrayList<>();
            trips1.add(trips.get(0));
            trips1.remove(0);
            return  new ResponseBody<>(new FillterResponse(pageNo, pageSize, (int) nextpages, nextelements, allelements, (int) allpages, 0,trips1 ));

        }
        else if (pageSize*pageNo>allelements)
        {
            return  new ResponseBody<>(new FillterResponse(pageNo,pageSize,(int)nextpages,nextelements,allelements,(int)allpages,trips.subList((pageNo*pageSize-pageSize),trips.size()).size(),trips.subList((pageNo*pageSize-pageSize),trips.size())));

        }

        else
        {
            return  new ResponseBody<>(new FillterResponse(pageNo,pageSize,(int)nextpages,nextelements,allelements,(int)allpages,trips.subList((pageNo*pageSize-pageSize),(pageNo*pageSize)).size(),trips.subList((pageNo*pageSize-pageSize),(pageNo*pageSize))));

        }


    }



    @PostMapping(URLs.DUMMY_Add_Reservation)

    public ResponseBody<AddReservationResponse> AddReservation(@RequestBody AddReservationRequest request) {

        int seats= trips.get(request.getTripId().intValue()-1).getSeats();


        if(seats>=request.getSeatsNumber())
        {
            trips.get(request.getTripId().intValue()-1).setSeats(seats-request.getSeatsNumber());
            reservations.add(new Reservation((long)reservations.size()+1,1l,request.getTripId(),trips.get(request.getTripId().intValue()),request.getSeatsNumber(),false));
            System.out.println(reservations.size()+" "+reservations.toString());
            return   new ResponseBody<>(new AddReservationResponse(true,"Reservation Added "));

        }

        throw new NoEnoughSeatsException();

    }


    @GetMapping(URLs.DUMMY_Remove_Reservation)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<AddReservationResponse> removeReservation(@RequestParam int id){

        for(Reservation reservation : reservations)
        {
            if(reservation.getId()==id)
            {
                trips.get(reservation.getTripId().intValue()-1).setSeats(trips.get(reservation.getTripId().intValue()-1).getSeats()+reservation.getSeatsNumber());
                reservations.remove(reservation);

                return new ResponseBody<>(new AddReservationResponse(true,"Reservation Removed"));
            }
        }
        throw new NoIdException();

    }

    @GetMapping(URLs.DUMMY_Rate)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody<AddReservationResponse> rate(@RequestParam int tripid,@RequestParam double rate){

        for(Trip trip : trips)
        {
            // System.out.println(reservation.getId());
            if(trip.getId()==tripid)
            {
                trip.setRate((trip.getRate()+rate)/2);
                return new ResponseBody<>(new AddReservationResponse(true,"Thank you for rating"));


            }
        }
        throw new NoIdException();

    }
}

