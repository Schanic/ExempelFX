/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exempelfx.entities;

/**
 *
 * @author T4User
 */
public class Movie {
    private int id;
    private int name;
    private String released;
    private String box_office;
    private int genre;
    private int studio_id;

    public Movie(int id, int name, String released, String box_office, int genre, int studio_id) {
        this.id = id;
        this.name = name;
        this.released = released;
        this.box_office = box_office;
        this.genre = genre;
        this.studio_id = studio_id;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public String getReleased() {
        return released;
    }

    public String getBox_office() {
        return box_office;
    }

    public int getGenre() {
        return genre;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setBox_office(String box_office) {
        this.box_office = box_office;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

 
    
    
    
    
}
