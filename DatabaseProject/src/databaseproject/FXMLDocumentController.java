package databaseproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable{
    
    private Connection con;
    private DatabaseProject dbProject = new DatabaseProject();;
    
    private String nameOfComponents = "";
    private String kindOfComponents = "";
    private String priceOfComponents = "";
    private String currentStockOfComponents = "";
    private String minStockOfComponents = "";
    private String prefStockOfComponents = "";
    
    private String[] listOfNames = new String[30];
    private String[] listOfKinds = new String[30];
    private double[] listOfPrices = new double[30];
    private int[] listOfCurrentStock = new int[30];
    private int[] listOfMinimumStock = new int[30];
    private int[] listOfPrefStock = new int[30];
    private String[] listOfSpcfcNames = new String [6];
    private double[] listOfBusspeed = new double[6];
    private String[] listOfRamType = new String[6];
    private double[] listOfSpcfPrice = new double[6];
    private String[] listOfSocket = new String[6];
    private boolean[] listOfGrphics = new boolean[6];
    private String[] listOfFormFactors = new String[6];
    private ArrayList<String> listOfSystems = new ArrayList<>();
    private ArrayList<String> listOfSysComponents = new ArrayList<>();
    private ArrayList<Integer> sysChecker = new ArrayList<>();
    private ArrayList<String> listOfSystemsPurchase = new ArrayList<>();
    private ArrayList<String> listOfSystemNamesPurchase = new ArrayList<>();
        
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stockPageName.setEditable(false);
        stockPagePrice.setEditable(false);
        stockPageStock.setEditable(false);
        stockPageMin.setEditable(false);
        stockPagePref.setEditable(false);
        stockPageKind.setEditable(false);
        sysInStockPageTA.setEditable(false);
        sysInStockPageTA1.setEditable(false);
        salesPageTA.setEditable(false);
        


        String url = "jdbc:postgresql://localhost:5432/dbProject";
        String user = "postgres";
        String password = "123";
        con = null;

        //CONNECTING
        try {
                con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(DatabaseProject.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
        }
    }
    


    @FXML
    private TextArea stockPageName;

    @FXML
    private Button stockButton;

    @FXML
    private TextArea stockPagePrice;

    @FXML
    private TextArea stockPageStock;

    @FXML
    private TextArea stockPageMin;

    @FXML
    private TextArea stockPagePref;

    @FXML
    private TextArea stockPageKind;

    @FXML
    private TextArea detailsNameTA;

    @FXML
    private Button detailsButton;

    @FXML
    private TextArea detailsSocket;

    @FXML
    private TextArea detailsRAMTA;

    @FXML
    private TextArea detailsFormTA;

    @FXML
    private TextArea detailsBusSTA;

    @FXML
    private RadioButton detailsRAMBtn;

    @FXML
    private ToggleGroup toggleKind;

    @FXML
    private RadioButton detailsCPUbtn;

    @FXML
    private RadioButton detailsMBbtn;

    @FXML
    private RadioButton detailsGcBtn;

    @FXML
    private RadioButton detailsCcasebtn;

    @FXML
    private TextArea detailsMBGraphics;

    @FXML
    private TextArea detailsPriceTA;

    @FXML
    private TextArea sysInStockPageTA;
    
    @FXML
    private TextArea sysInStockPageTA1;

    @FXML
    private Button sysInStockButton;

    @FXML
    private TextArea salesPageTA;
    
    @FXML
    private TextArea salesPageQuantityTA;
    
    @FXML
    private TextArea salesPagePriceTA;

    @FXML
    private Button salePageButton;

    
    @FXML
    void fetchComponentsInStock(ActionEvent event) {
        
        listOfNames = dbProject.getComponentName(con);
        for(int i = 0; i < listOfNames.length; i++){
            nameOfComponents += listOfNames[i] + "\n";
        }stockPageName.setText(nameOfComponents);
        
        listOfPrices = dbProject.getComponentPrice(con);
        for(int i = 0; i < listOfPrices.length; i++){
            priceOfComponents += listOfPrices[i] + "\n";
        }stockPagePrice.setText(priceOfComponents);
        
        listOfCurrentStock = dbProject.getComponentStock(con);
        for(int i = 0; i < listOfCurrentStock.length; i++){
            currentStockOfComponents += listOfCurrentStock[i] + "\n";
        }stockPageStock.setText(currentStockOfComponents);
        
        listOfMinimumStock = dbProject.getComponentMinStock(con);
        for(int i = 0; i < listOfMinimumStock.length; i++){
            minStockOfComponents += listOfMinimumStock[i] + "\n";
        }stockPageMin.setText(minStockOfComponents);
        
        listOfPrefStock = dbProject.getComponentPrefStock(con);
        for(int i = 0; i < listOfPrefStock.length; i++){
            prefStockOfComponents += listOfPrefStock[i] + "\n";
        }stockPagePref.setText(prefStockOfComponents);
        
        listOfKinds = dbProject.getComponentKind(con);
        for(int i = 0; i < listOfKinds.length; i++){
            kindOfComponents += listOfKinds[i] + "\n";
        }stockPageKind.setText(kindOfComponents);
    }

    @FXML
    void fetchSales(ActionEvent event) {
        String sysInStock = "";
        listOfSystemsPurchase = dbProject.getSystemsInStock(con);
        for(String s : listOfSystemsPurchase){
            sysInStock += s + "\n";
        }salesPageTA.setText(sysInStock);
        
        String amountsInStock = "";
        listOfSystemNamesPurchase = dbProject.getSystemsInStock(con);
        for(String s : listOfSystemNamesPurchase)
            dbProject.getAmountOfSystems(con, s)
    }

    @FXML
    void fetchSysInStock(ActionEvent event) {
        sysInStockPageTA.clear();
        sysInStockPageTA1.clear();
        
        String sysInStock = "";
        listOfSystems = dbProject.getSystemsInStock(con);
        for(String s : listOfSystems){
            listOfSysComponents = dbProject.getSystemComponents(con, s);
            sysInStock += s +" (";
            for(String p : listOfSysComponents){
                sysInStock += p + ", ";
            }
            sysInStock += ")\n";
        }sysInStockPageTA.setText(sysInStock);
        String amountOfSys = "";
        for (String i : listOfSystems) {
            int temp = 50;
            listOfSysComponents = dbProject.getSystemComponents(con, i);
            for(int p = 0; p<listOfSysComponents.size(); p++){
                if(dbProject.getComponentStock(con, listOfSysComponents.get(p)) < temp){
                    temp = dbProject.getComponentStock(con, listOfSysComponents.get(p));
                }
            }
            amountOfSys += temp + "\n";
        }sysInStockPageTA1.setText(amountOfSys);
    }

    @FXML
    void selectKind(ActionEvent event) {

    }

    @FXML
    void showDetails(ActionEvent event) {
        detailsNameTA.clear();
        detailsBusSTA.clear();
        detailsSocket.clear();
        detailsRAMTA.clear();
        detailsFormTA.clear();
        detailsMBGraphics.clear();
        detailsPriceTA.clear();
        
        if(detailsRAMBtn.isSelected()){
            String ramNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "ram");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                ramNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(ramNames);
            
            String ramBSpeed = "";
            listOfBusspeed = dbProject.getSpecificComponentBusSpeed(con, "ram");
            for (int i = 0; i < listOfBusspeed.length; i++) {
                ramBSpeed +=  listOfBusspeed[i] + " MHz\n";
            }detailsBusSTA.setText(ramBSpeed);
            
            String ramType = "";
            listOfRamType = dbProject.getSpecificRamType(con, "ram");
            for (int i = 0; i < listOfRamType.length; i++) {
                ramType +=  listOfRamType[i] + "\n";
            }detailsRAMTA.setText(ramType);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "ram");
            for(int i = 0; i < listOfSpcfPrice.length; i++){
                prices += listOfSpcfPrice[i] + "\n";
            }detailsPriceTA.setText(prices);
            
            detailsSocket.setText("N/A");
            detailsFormTA.setText("N/A");
            detailsMBGraphics.setText("N/A");
            
            
        }else if(detailsCPUbtn.isSelected()){
            String _CPUNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "cpu");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                _CPUNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(_CPUNames);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "cpu");
            for(int i = 0; i < listOfSpcfPrice.length; i++){
                prices += listOfSpcfPrice[i] + "\n";
            }detailsPriceTA.setText(prices);
            
            String cpuBSpeed = "";
            listOfBusspeed = dbProject.getSpecificComponentBusSpeed(con, "cpu");
            for (int i = 0; i < listOfBusspeed.length; i++) {
                cpuBSpeed +=  listOfBusspeed[i] + " GHz\n";
            }detailsBusSTA.setText(cpuBSpeed);
            
            String socket = "";
            listOfSocket = dbProject.getSpecificSocket(con, "cpu");
            for (int i = 0; i < listOfSocket.length; i++) {
                socket +=  listOfSocket[i] + "\n";
            }detailsSocket.setText(socket);
            
            detailsFormTA.setText("N/A");
            detailsMBGraphics.setText("N/A");
            detailsRAMTA.setText("N/A");
            
        }else if(detailsMBbtn.isSelected()){
            String mainboardNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "mainboard");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                mainboardNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(mainboardNames);
            
            String socket = "";
            listOfSocket = dbProject.getSpecificSocket(con, "mainboard");
            for (int i = 0; i < listOfSocket.length; i++) {
                socket +=  listOfSocket[i] + "\n";
            }detailsSocket.setText(socket);
            
            String ramType = "";
            listOfRamType = dbProject.getSpecificRamType(con, "mainboard");
            for (int i = 0; i < listOfRamType.length; i++) {
                ramType +=  listOfRamType[i] + "\n";
            }detailsRAMTA.setText(ramType);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "mainboard");
            for(int i = 0; i < listOfSpcfPrice.length; i++){
                prices += listOfSpcfPrice[i] + "\n";
            }detailsPriceTA.setText(prices);
            
            String onBGrphcs = "";
            listOfGrphics = dbProject.getMBGraphics(con, "mainboard");
            for(int i = 0; i < listOfGrphics.length; i++){
                if(listOfGrphics[i] == true){
                    onBGrphcs += "yes\n";
                }else if(listOfGrphics[i] == false){
                    onBGrphcs += "no\n";
                }
            }detailsMBGraphics.setText(onBGrphcs);
            
            String formFactor = "";
            listOfFormFactors = dbProject.getSpecificFormFactor(con, "mainboard");
            for(int i = 0; i < listOfFormFactors.length; i++){
                formFactor += listOfFormFactors[i] + "\n";
            }detailsFormTA.setText(formFactor);
            
            detailsBusSTA.setText("N/A");
            
        }else if(detailsGcBtn.isSelected()){
            String graphicsCardNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "graphicscard");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                graphicsCardNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(graphicsCardNames);
            
            String grphcsBusSpeed = "";
            listOfBusspeed = dbProject.getSpecificComponentBusSpeed(con, "graphicscard");
            for (int i = 0; i < listOfBusspeed.length; i++) {
                grphcsBusSpeed +=  listOfBusspeed[i] + " GB\n";
            }detailsBusSTA.setText(grphcsBusSpeed);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "graphicscard");
            for(int i = 0; i < listOfSpcfPrice.length; i++){
                prices += listOfSpcfPrice[i] + "\n";
            }detailsPriceTA.setText(prices);
            
            detailsFormTA.setText("N/A");
            detailsMBGraphics.setText("N/A");
            detailsRAMTA.setText("N/A");
            detailsSocket.setText("N/A");
            
        }else if(detailsCcasebtn.isSelected()){
            String caseNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "computercase");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                caseNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(caseNames);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "computercase");
            for(int i = 0; i < listOfSpcfPrice.length; i++){
                prices += listOfSpcfPrice[i] + "\n";
            }detailsPriceTA.setText(prices);
            
            String formFactor = "";
            listOfFormFactors = dbProject.getSpecificFormFactor(con, "mainboard");
            for(int i = 0; i < listOfFormFactors.length; i++){
                formFactor += listOfFormFactors[i] + "\n";
            }detailsFormTA.setText(formFactor);
            
            detailsMBGraphics.setText("N/A");
            detailsRAMTA.setText("N/A");
            detailsSocket.setText("N/A");
            detailsBusSTA.setText("N/A");
        }
    }               //done
}