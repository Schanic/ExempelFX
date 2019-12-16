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
    private String name;
    private int released;
    private int box_office;
    private String genre;
    private int studio_id;

    public Movie(int id, String name, int released, int box_office, String genre, int studio_id) {
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

    public String getName() {
        return name;
    }

    public int getReleased() {
        return released;
    }

    public int getBox_office() {
        return box_office;
    }

    public String getGenre() {
        return genre;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public void setBox_office(int box_office) {
        this.box_office = box_office;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + released + " " + box_office + " " + genre + " " + studio_id ;
    }

 
    
    
    
    
}
