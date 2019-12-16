package com.mycompany.exempelfx;

import com.mycompany.exempelfx.entities.Movie;
import com.mycompany.exempelfx.bean.SaveMovie;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

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
    private TextArea textTable;
    @FXML 
    private Button TableButton;
    @FXML 
    private TextField SearchMovie;

    

    public void ChangeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/SceneTable.fxml"));
        Scene scene2 = new Scene(root2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }

    public void MainMenu(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/Start.fxml"));
        Scene scene2 = new Scene(root2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }
    @FXML
    private void inputLista(ActionEvent event) {
        String name = inputName.getText();
        String released = inputRelease.getText();
        String box_office = inputboxOffice.getText();
        String genre = inputgenre.getText();
        String studio_id = inputstudioid.getText();

        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String query = String.format("INSERT INTO movies VALUES( NULL,'%s',%d,%d,'%s',%d)",
                    name, Integer.parseInt(released), Integer.parseInt(box_office), genre, Integer.parseInt(studio_id));
            int antalRaderPavarkade = stmt.executeUpdate(query); //1
            if (antalRaderPavarkade == 1) {
                System.out.println("Fungerar");
            } else {
                System.out.println("Nått jäkla fel..");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Nu har du lagt till!!"); 
    }
    @FXML
    private void ButtonSearchMovie(ActionEvent event) {
        System.out.println("Hello");
        String inputname = SearchMovie.getText();
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()){
            System.out.println("Hello2");
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM movies WHERE name = '%s'", inputname);
            ResultSet data = statement.executeQuery(sql);
            while (data.next()){
                int id = data.getInt("id");
                System.out.println("Hello3");
                    String name = data.getString("name");
                    int released = data.getInt("released");
                    int boxOff = data.getInt("box_office");
                    String genre = data.getString("genre");
                    int studioid = data.getInt("studio_Id");
                    Movie movie = new Movie (id,name,released,boxOff,genre,studioid);
                    movies.add(movie);
            }
            System.out.println(movies.size());
            String output="";
            for (Movie film:movies) {
                output += film;
                output += "\n";
            }
            textTable.setText(output);
        } catch (Exception e) {
        }
    }
    @FXML
    private void GetAllMovies(ActionEvent event) {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM movies";
            ResultSet data = stmt.executeQuery(sql);
                while (data.next()){
                    int id = data.getInt("id");
                    String name = data.getString("name");
                    int released = data.getInt("released");
                    int boxOff = data.getInt("box_office");
                    String genre = data.getString("genre");
                    int studioid = data.getInt("studio_Id");
                    Movie movie = new Movie (id,name,released,boxOff,genre,studioid);
                    movies.add(movie);
                }
                System.out.println(movies.size());
                String output="";
                for (Movie film:movies){
                    output += film;
                    output += "\n";
                }
                textTable.setText(output);
        }catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
