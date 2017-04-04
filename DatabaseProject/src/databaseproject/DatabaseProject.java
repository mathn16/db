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
import java.util.HashMap;
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
    
    private ArrayList<String> listOfNames = new ArrayList<>();
    private String[] listOfKinds = new String[31];
    private ArrayList<Double> listOfPrices = new ArrayList<>();
    private ArrayList<Integer> listOfCurrentStock = new ArrayList<>();
    private ArrayList<Integer> listOfMinStock = new ArrayList<>();
    private ArrayList<Integer> listOfPrefStock = new ArrayList<>();
    private ArrayList<String> detListOfNames = new ArrayList<>();
    private ArrayList<Double> specificBuSpeed = new ArrayList<>();
    private ArrayList<String> ramTypeList = new ArrayList<>();
    private ArrayList<Double> spcfPrice = new ArrayList<>();
    private ArrayList<String> spcfSocket = new ArrayList<>();
    private ArrayList<Boolean> spcfMbGrphcs = new ArrayList<>();
    private ArrayList<String> spcfFormFactor = new ArrayList<>();
    private ArrayList<String> listOfSystemsInStock = new ArrayList<>();
    private ArrayList<String> listOfSysComponents = new ArrayList<>();
    private ArrayList<Double> listOfSystemPrices = new ArrayList<>();
    private HashMap<String, Integer> restockList = new HashMap<>();
    private double _price;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }
    
    public ArrayList<String> getComponentName(Connection con){
        try {
            listOfNames.clear();
            Statement st = con.createStatement();
            String queri = "select name from component as name";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String componentName = rs.getString("name");
                listOfNames.add(componentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfNames;
    }
    public ArrayList<String> getSpecificComponentName(Connection con, String type){
        try {
            detListOfNames.clear();
            Statement st = con.createStatement();
            String queri = "select name from " + type + " as name";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String scpfComponentName = rs.getString("name");
                detListOfNames.add(scpfComponentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return detListOfNames;
    }
    public ArrayList<Double> getSpecificComponentBusSpeed(Connection con, String type){
        try {
            specificBuSpeed.clear();
            Statement st = con.createStatement();
            String queri = "select busspeed from " + type + " as busspeed";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                double scpfComponentBusSpeed = rs.getDouble("busspeed");
                specificBuSpeed.add(scpfComponentBusSpeed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return specificBuSpeed;
    }
    public ArrayList<String> getSpecificRamType(Connection con, String type){
        try {
            ramTypeList.clear();
            Statement st = con.createStatement();
            String queri = "select ramtype from " + type + " as ramtype";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String scpfRamType = rs.getString("ramtype");
                ramTypeList.add(scpfRamType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return ramTypeList;
    }
    public ArrayList<Double> getSpecificComponentPrice(Connection con, String type){
        try {
            spcfPrice.clear();
            Statement st = con.createStatement();
            String queri = "select price from component where kind='"+type+"'";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                double scpfComponentPrice = rs.getDouble("price");
                spcfPrice.add(scpfComponentPrice * 1.3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfPrice;
    }
    public ArrayList<String> getSpecificSocket(Connection con, String type){
        try {
            spcfSocket.clear();
            Statement st = con.createStatement();
            String queri = "select cpusocket from " + type + " as cpusocket";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String scpfSocket = rs.getString("cpusocket");
                spcfSocket.add(scpfSocket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfSocket;
    }
    public ArrayList<Boolean> getMBGraphics(Connection con, String type){
        try {
            spcfMbGrphcs.clear();
            Statement st = con.createStatement();
            String queri = "select onboardgraphics from " + type + " as onboardgraphics";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                boolean onBGrphcs = rs.getBoolean("onboardgraphics");
                spcfMbGrphcs.add(onBGrphcs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfMbGrphcs;
    }
    public ArrayList<String> getSpecificFormFactor(Connection con, String type){
        try {
            spcfFormFactor.clear();
            Statement st = con.createStatement();
            String queri = "select formfactor from " + type + " as formfactor";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String formFactor = rs.getString("formfactor");
                spcfFormFactor.add(formFactor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return spcfFormFactor;
    }
    public ArrayList<String> getComponentKind(Connection con){
        try {
            listOfNames.clear();
            Statement st = con.createStatement();
            String queri = "select kind from component as kind";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String componentKind = rs.getString("kind");
                listOfNames.add(componentKind);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfNames;
    }
    public ArrayList<Double> getComponentPrice(Connection con){
        try {
            listOfPrices.clear();
            Statement st = con.createStatement();
            String queri = "select price from component as price";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                double componentPrice = rs.getDouble("price");
                listOfPrices.add(componentPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfPrices;
    }
    public ArrayList<Integer> getComponentStock(Connection con){
        try {
            listOfCurrentStock.clear();
            Statement st = con.createStatement();
            String queri = "select stock from component as stock";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                int currentStock = rs.getInt("stock");
                listOfCurrentStock.add(currentStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfCurrentStock;
    }
    public ArrayList<Integer> getComponentMinStock(Connection con){
        try {
            listOfMinStock.clear();
            Statement st = con.createStatement();
            String queri = "select minimumstock from component as minimumstock";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                int componentMinStock = rs.getInt("minimumstock");
                listOfMinStock.add(componentMinStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfMinStock;
    }
    public ArrayList<Integer> getComponentPrefStock(Connection con){
        try {
            listOfPrefStock.clear();
            Statement st = con.createStatement();
            String queri = "select preferedstock from component as prefstock";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                int componentPrefStock = rs.getInt("preferedstock");
                listOfPrefStock.add(componentPrefStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return listOfPrefStock;
    }
    public ArrayList<String> getSystemsInStock(Connection con){
        try {
            listOfSystemsInStock.clear();
            Statement st = con.createStatement();
            String queri = "select systemname from computersystem as systemname";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String sysIntStock = rs.getString("systemname");
                listOfSystemsInStock.add(sysIntStock);
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
            while (rs.next()) {
                String sysComponents = rs.getString("componentname");
                listOfSysComponents.add(sysComponents);
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
        }catch (SQLException e) {
            e.printStackTrace();
        }return i;
    }
    public double getSystemPrice(Connection con, String compName){
        try {
            Statement st = con.createStatement();
            String queri = "select price as price from component where name='" + compName + "'";
            ResultSet rs = st.executeQuery(queri);
            _price = 0;
            while (rs.next()) {
                double componentPrice = rs.getDouble("price");
                _price += componentPrice;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return _price;
    }
    public double getSystemNamePrice(Connection con, ArrayList<String> system){
        try {
            _price = 0;
            for(String s : system){
                Statement st = con.createStatement();
                String queri = "select price as price from component where name='" + s + "'";
                ResultSet rs = st.executeQuery(queri);
                while (rs.next()) {
                    double componentPrice = rs.getDouble("price");
                    _price += componentPrice;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return _price;
    }
    public void sellComponent(Connection con, int quantity, String compName){
        try {
            Statement st = con.createStatement();
            String queri = "update component set stock = stock - "+ quantity +" where name ='" + compName + "'";
            st.executeUpdate(queri);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public HashMap<String, Integer> getRestockList(Connection con){
        try {
            listOfSysComponents.clear();
            Statement st = con.createStatement();
            String queri = "select preferedstock - stock as needed, name from component where stock < minimumstock";
            ResultSet rs = st.executeQuery(queri);
            while (rs.next()) {
                String lowComps = rs.getString("name");
                int compsNeeded = rs.getInt("needed");
                restockList.put(lowComps, compsNeeded);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return restockList;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
