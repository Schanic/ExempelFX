/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exempelfx.bean;

import com.mycompany.exempelfx.ConnectionFactory;
import com.mycompany.exempelfx.entities.Movie;
import com.mysql.jdbc.Connection;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Johan
 */

public class SaveMovie {
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputRelease;
    @FXML
    private TextField inputboxOffice;
    @FXML
    private TextField inputgenre;
    @FXML
    private TextField inputstudioid;
    @FXML
    private Button TableButton;
    
     public int saveMovie(Movie movie) {
        String id = inputstudioid.getText();
        String name = inputName.getText();
        String released = inputRelease.getText();
        String box_office = inputboxOffice.getText();
        String genre = inputgenre.getText();
        String studio_id = inputstudioid.getText();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO movies (id,name,released,box_office,genre,studio_Id)",
                    Integer.parseInt(id), name, Integer.parseInt(released), Integer.parseInt(box_office), genre, Integer.parseInt(studio_id));
        }
        catch (Exception e){
                System.out.println("Error: " + e.getMessage());
                }

        return 0;
    }
}
