package com.tripify.demo.dummy.Trips.Payload.Response;

import com.tripify.demo.dummy.Models.Reservation;

import java.util.List;

public class PreviousTripsResponse {

    int pageno;
    int pagesize;
    int nextpages;
    int nextelements;
    int allelements;
    int allpages;
    int elementsinthispage;
    List<Reservation> tripslogs;


    public PreviousTripsResponse(int pageno, int pagesize, int nextpages, int nextelements, int allelements, int allpages, int elementsinthispage, List<Reservation> tripslogs) {
        this.pageno = pageno;
        this.pagesize = pagesize;
        this.nextpages = nextpages;
        this.nextelements = nextelements;
        this.allelements = allelements;
        this.allpages = allpages;
        this.elementsinthispage = elementsinthispage;
        this.tripslogs = tripslogs;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getNextpages() {
        return nextpages;
    }

    public void setNextpages(int nextpages) {
        this.nextpages = nextpages;
    }

    public int getNextelements() {
        return nextelements;
    }

    public void setNextelements(int nextelements) {
        this.nextelements = nextelements;
    }

    public int getAllelements() {
        return allelements;
    }

    public void setAllelements(int allelements) {
        this.allelements = allelements;
    }

    public int getAllpages() {
        return allpages;
    }

    public void setAllpages(int allpages) {
        this.allpages = allpages;
    }

    public int getElementsinthispage() {
        return elementsinthispage;
    }

    public void setElementsinthispage(int elementsinthispage) {
        this.elementsinthispage = elementsinthispage;
    }

    public List<Reservation> getTripslogs() {
        return tripslogs;
    }

    public void setTripslogs(List<Reservation> tripslogs) {
        this.tripslogs = tripslogs;
    }

}
