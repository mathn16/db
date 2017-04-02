/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Thisen
 */
public class DatabaseProject extends Application {
    
    private String[] listOfNames = new String[30];
    private String[] listOfKinds = new String[30];
    private double[] listOfPrices = new double[30];
    private int[] listOfCurrentStock = new int[30];
    private int[] listOfMinStock = new int[30];
    private int[] listOfPrefStock = new int[30];
    private String[] detListOfNames = new String[6];
    private double[] specificBuSpeed = new double[6];
    private String[] ramTypeList = new String[6];
    private double[] spcfPrice = new double[6];
    private String[] spcfSocket = new String[6];
    private boolean[] spcfMbGrphcs = new boolean[6];
    private String[] spcfFormFactor = new String[6];
    private ArrayList<String> listOfSystemsInStock = new ArrayList<>();
    private ArrayList<String> listOfSysComponents = new ArrayList<>();
    private int[] amountOfSys = new int[8];
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }
    public String[] getComponentName(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select name from component as name";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String componentName = rs.getString("name");
                listOfNames[i] = componentName;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfNames;
    }
    public String[] getSpecificComponentName(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select name from " + type + " as name";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String scpfComponentName = rs.getString("name");
                detListOfNames[i] = scpfComponentName;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return detListOfNames;
    }
    public double[] getSpecificComponentBusSpeed(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select busspeed from " + type + " as busspeed";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                double scpfComponentBusSpeed = rs.getDouble("busspeed");
                specificBuSpeed[i] = scpfComponentBusSpeed;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return specificBuSpeed;
    }
    public String[] getSpecificRamType(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select ramtype from " + type + " as ramtype";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String scpfRamType = rs.getString("ramtype");
                ramTypeList[i] = scpfRamType;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return ramTypeList;
    }
    public double[] getSpecificComponentPrice(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select price from component where kind='"+type+"'";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                double scpfComponentPrice = rs.getDouble("price");
                spcfPrice[i] = scpfComponentPrice;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfPrice;
    }
    public String[] getSpecificSocket(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select cpusocket from " + type + " as cpusocket";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String scpfSocket = rs.getString("cpusocket");
                spcfSocket[i] = scpfSocket;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfSocket;
    }
    public boolean[] getMBGraphics(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select onboardgraphics from " + type + " as onboardgraphics";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                boolean onBGrphcs = rs.getBoolean("onboardgraphics");
                spcfMbGrphcs[i] = onBGrphcs;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfMbGrphcs;
    }
    public String[] getSpecificFormFactor(Connection con, String type){
        try {
            Statement st = con.createStatement();
            String queri = "select formfactor from " + type + " as formfactor";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String formFactor = rs.getString("formfactor");
                spcfFormFactor[i] = formFactor;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfFormFactor;
    }
    public String[] getComponentKind(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select kind from component as kind";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String componentlKind = rs.getString("kind");
                listOfNames[i] = componentlKind;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfNames;
    }
    public double[] getComponentPrice(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select price from component as price";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                double componentPrice = rs.getDouble("price");
                listOfPrices[i] = componentPrice;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfPrices;
    }
    public int[] getComponentStock(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select stock from component as stock";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                int currentStock = rs.getInt("stock");
                listOfCurrentStock[i] = currentStock;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfCurrentStock;
    }
    public int[] getComponentMinStock(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select minimumstock from component as minimumstock";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                int componentMinStock = rs.getInt("minimumstock");
                listOfMinStock[i] = componentMinStock;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfMinStock;
    }
    public int[] getComponentPrefStock(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select preferedstock from component as prefstock";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                int componentPrefStock = rs.getInt("preferedstock");
                listOfPrefStock[i] = componentPrefStock;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfPrefStock;
    }
    public ArrayList<String> getSystemsInStock(Connection con){
        try {
            Statement st = con.createStatement();
            String queri = "select systemname from computersystem as systemname";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String sysIntStock = rs.getString("systemname");
                listOfSystemsInStock.add(i, sysIntStock);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfSystemsInStock;
    }
    public ArrayList<String> getSystemComponents(Connection con, String sysName){
        try {
            listOfSysComponents.clear();
            Statement st = con.createStatement();
            String queri = "select componentname as componentname from contains where computersystemname ='"+sysName+"'";
            ResultSet rs = st.executeQuery(queri);
            int i=0;
            while (rs.next()) {
                String sysComponents = rs.getString("componentname");
                listOfSysComponents.add(i, sysComponents);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfSysComponents;
    }
    public int getComponentStock(Connection con, String compName){
        int i = 0;
        try {
            Statement st = con.createStatement();
            String queri = "select stock as stock from component where name ='"+ compName +"'";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                int currentStock = rs.getInt("stock");
                i = currentStock;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return i;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
