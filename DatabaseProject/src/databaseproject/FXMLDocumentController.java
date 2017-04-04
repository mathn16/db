package databaseproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable{
    
    private Connection con;
    private DatabaseProject dbProject = new DatabaseProject();
    
    private String nameOfComponents;
    private String kindOfComponents;
    private String priceOfComponents;
    private String currentStockOfComponents;
    private String minStockOfComponents;
    private String prefStockOfComponents;
    private int firsttime = 0;
    
    private ArrayList<String> listOfNames = new ArrayList<>();
    private ArrayList<String> listOfKinds = new ArrayList<>();
    private ArrayList<Double> listOfPrices = new ArrayList<>();
    private ArrayList<Integer> listOfCurrentStock = new ArrayList<>();
    private ArrayList<Integer> listOfMinimumStock = new ArrayList<>();
    private ArrayList<Integer> listOfPrefStock = new ArrayList<>();
    private ArrayList<String> listOfSpcfcNames = new ArrayList<>();
    private ArrayList<Double> listOfBusspeed = new ArrayList<>();
    private ArrayList<String> listOfRamType = new ArrayList<>();
    private ArrayList<Double> listOfSpcfPrice = new ArrayList<>();
    private ArrayList<String> listOfSocket = new ArrayList<>();
    private ArrayList<Boolean> listOfGrphics = new ArrayList<>();
    private ArrayList<String> listOfFormFactors = new ArrayList<>();
    private ArrayList<String> listOfSystems = new ArrayList<>();
    private ArrayList<String> listOfSysComponents = new ArrayList<>();
    private ArrayList<Integer> sysChecker = new ArrayList<>();
    private ArrayList<String> listOfSystemsPurchase = new ArrayList<>();
    private ArrayList<String> listOfSystemNamesPurchase = new ArrayList<>();
    private ArrayList<String> listOfSysComponentsPurchase = new ArrayList<>();
    private ArrayList<String> listOfSysPrice = new ArrayList<>();
    private ArrayList<String> comboBoxRamList = new ArrayList<>();
    private ArrayList<String> listOfSys = new ArrayList<>();
    private HashMap<String, Integer> restockMap = new HashMap<>();
        
    
    
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
        detailsNameTA.setEditable(false);
        detailsBusSTA.setEditable(false);
        detailsSocket.setEditable(false);
        detailsRAMTA.setEditable(false);
        detailsFormTA.setEditable(false);
        detailsMBGraphics.setEditable(false);
        detailsPriceTA.setEditable(false);
        salesPageQuantityTA.setEditable(false);
        salesPagePriceTA.setEditable(false);
        salesPageLastTA.setEditable(false);
        ramCB.setEditable(false);
        cpuCB.setEditable(false);
        mbCB.setEditable(false);
        gcCB.setEditable(false);
        ccCB.setEditable(false);
        systemCB.setEditable(false);
        restockTA.setEditable(false);
        
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
        ccCB.getItems().addAll(dbProject.getSpecificComponentName(con, "computercase"));
        gcCB.getItems().addAll(dbProject.getSpecificComponentName(con, "graphicscard"));
        ramCB.getItems().addAll(dbProject.getSpecificComponentName(con, "ram"));
        cpuCB.getItems().addAll(dbProject.getSpecificComponentName(con, "cpu"));
        mbCB.getItems().addAll(dbProject.getSpecificComponentName(con, "mainboard"));
        systemCB.getItems().addAll(dbProject.getSystemsInStock(con));
        sysQuantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1));
        ramQSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1));
        cpuQSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1));
        mbQSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1));
        gcQSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1));
        cCQSpin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1));
    }
    
    
    @FXML
    private TextArea restockTA;
    
    @FXML
    private ComboBox ccCB;
    
    @FXML
    private ComboBox ramCB;
    
    @FXML
    private ComboBox cpuCB;
    
    @FXML
    private ComboBox mbCB;
    
    @FXML
    private ComboBox gcCB;
    
    @FXML
    private ComboBox systemCB;
    
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
    private TextArea salesPageLastTA;
    
    @FXML
    private Spinner<Integer> sysQuantitySpinner;
    
    @FXML
    private Spinner<Integer> ramQSpin;
    
    @FXML
    private Spinner<Integer> cpuQSpin;
    
    @FXML
    private Spinner<Integer> mbQSpin;
    
    @FXML
    private Spinner<Integer> gcQSpin;
    
    @FXML
    private Spinner<Integer> cCQSpin;

    
    @FXML
    void fetchComponentsInStock(ActionEvent event) {
        listOfNames.clear();
        listOfPrices.clear();
        listOfCurrentStock.clear();
        listOfMinimumStock.clear();
        
        nameOfComponents = "";
        priceOfComponents = "";
        currentStockOfComponents = "";
        minStockOfComponents = "";
        prefStockOfComponents = "";
        kindOfComponents = "";
        
        listOfNames = dbProject.getComponentName(con);
        for(int i = 0; i < listOfNames.size(); i++){
            nameOfComponents += listOfNames.get(i) + "\n";
        }stockPageName.setText(nameOfComponents);
        
        listOfPrices = dbProject.getComponentPrice(con);
        for(int i = 0; i < listOfPrices.size(); i++){
            priceOfComponents += listOfPrices.get(i) + "\n";
        }stockPagePrice.setText(priceOfComponents);
        
        listOfCurrentStock = dbProject.getComponentStock(con);
        for(int i = 0; i < listOfCurrentStock.size(); i++){
            currentStockOfComponents += listOfCurrentStock.get(i) + "\n";
        }stockPageStock.setText(currentStockOfComponents);
        
        listOfMinimumStock = dbProject.getComponentMinStock(con);
        for(int i = 0; i < listOfMinimumStock.size(); i++){
            minStockOfComponents += listOfMinimumStock.get(i) + "\n";
        }stockPageMin.setText(minStockOfComponents);
        
        listOfPrefStock = dbProject.getComponentPrefStock(con);
        for(int i = 0; i < listOfPrefStock.size(); i++){
            prefStockOfComponents += listOfPrefStock.get(i) + "\n";
        }stockPagePref.setText(prefStockOfComponents);
        
        listOfKinds = dbProject.getComponentKind(con);
        for(int i = 0; i < listOfKinds.size(); i++){
            kindOfComponents += listOfKinds.get(i) + "\n";
        }stockPageKind.setText(kindOfComponents);
    }

    @FXML
    void fetchSales(ActionEvent event) {
        if(firsttime == 0){
            salesPageTA.setText("Welcome to the salespage!\nTo buy a piece of equipment/system, simply select the system/component\n Set the amount, and press buy.");
            firsttime = 1;
        }
        String sysInStock = "";
        listOfSystemsPurchase = dbProject.getSystemsInStock(con);
        for(String s : listOfSystemsPurchase){
            sysInStock += s + "\n";
        }salesPageTA.setText(sysInStock);
        
        String amountsInStock = "";
        for(String s : listOfSystemsPurchase){
            int temp = 50;
            listOfSysComponentsPurchase = dbProject.getSystemComponents(con, s);
            for(int p = 0; p < listOfSysComponentsPurchase.size(); p++){
                if(dbProject.getComponentStock(con, listOfSysComponentsPurchase.get(p)) < temp){
                    temp = dbProject.getComponentStock(con, listOfSysComponentsPurchase.get(p));
                }
            }amountsInStock += temp + "\n";
        }salesPageQuantityTA.setText(amountsInStock);
        
        String priceForLot = "";
        for(String l : listOfSystemsPurchase){
            double priceOfSystem = 0.0;
            listOfSysPrice = dbProject.getSystemComponents(con, l);
            for(String p : listOfSysPrice){
                priceOfSystem += dbProject.getSystemPrice(con, p);
            }priceForLot += (int)(priceOfSystem*1.3/100) + "95" + "\n";
        }salesPagePriceTA.setText(priceForLot);
    }

    @FXML
    void fetchSysInStock(ActionEvent event) {
        sysInStockPageTA.clear();
        sysInStockPageTA1.clear();
        
        listOfSystems.clear();
        listOfSysComponents.clear();
        
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
        
        listOfSpcfcNames.clear();
        listOfBusspeed.clear();
        listOfRamType.clear();
        listOfSpcfPrice.clear();
        listOfSocket.clear();
        
        if(detailsRAMBtn.isSelected()){
            String ramNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "ram");
            for (int i = 0; i < listOfSpcfcNames.size(); i++) {
                ramNames +=  listOfSpcfcNames.get(i) + "\n";
            }detailsNameTA.setText(ramNames);
            
            String ramBSpeed = "";
            listOfBusspeed = dbProject.getSpecificComponentBusSpeed(con, "ram");
            for (int i = 0; i < listOfBusspeed.size(); i++) {
                ramBSpeed +=  listOfBusspeed.get(i) + " MHz\n";
            }detailsBusSTA.setText(ramBSpeed);
            
            String ramType = "";
            listOfRamType = dbProject.getSpecificRamType(con, "ram");
            for (int i = 0; i < listOfRamType.size(); i++) {
                ramType +=  listOfRamType.get(i) + "\n";
            }detailsRAMTA.setText(ramType);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "ram");
            for(int i = 0; i < listOfSpcfPrice.size(); i++){
                prices += listOfSpcfPrice.get(i) + "\n";
            }detailsPriceTA.setText(prices);
            
            detailsSocket.setText("N/A");
            detailsFormTA.setText("N/A");
            detailsMBGraphics.setText("N/A");
            
            
        }else if(detailsCPUbtn.isSelected()){
            String _CPUNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "cpu");
            for (int i = 0; i < listOfSpcfcNames.size(); i++) {
                _CPUNames +=  listOfSpcfcNames.get(i) + "\n";
            }detailsNameTA.setText(_CPUNames);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "cpu");
            for(int i = 0; i < listOfSpcfPrice.size(); i++){
                prices += listOfSpcfPrice.get(i) + "\n";
            }detailsPriceTA.setText(prices);
            
            String cpuBSpeed = "";
            listOfBusspeed = dbProject.getSpecificComponentBusSpeed(con, "cpu");
            for (int i = 0; i < listOfBusspeed.size(); i++) {
                cpuBSpeed +=  listOfBusspeed.get(i) + " GHz\n";
            }detailsBusSTA.setText(cpuBSpeed);
            
            String socket = "";
            listOfSocket = dbProject.getSpecificSocket(con, "cpu");
            for (int i = 0; i < listOfSocket.size(); i++) {
                socket +=  listOfSocket.get(i) + "\n";
            }detailsSocket.setText(socket);
            
            detailsFormTA.setText("N/A");
            detailsMBGraphics.setText("N/A");
            detailsRAMTA.setText("N/A");
            
        }else if(detailsMBbtn.isSelected()){
            String mainboardNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "mainboard");
            for (int i = 0; i < listOfSpcfcNames.size(); i++) {
                mainboardNames +=  listOfSpcfcNames.get(i) + "\n";
            }detailsNameTA.setText(mainboardNames);
            
            String socket = "";
            listOfSocket = dbProject.getSpecificSocket(con, "mainboard");
            for (int i = 0; i < listOfSocket.size(); i++) {
                socket +=  listOfSocket.get(i) + "\n";
            }detailsSocket.setText(socket);
            
            String ramType = "";
            listOfRamType = dbProject.getSpecificRamType(con, "mainboard");
            for (int i = 0; i < listOfRamType.size(); i++) {
                ramType +=  listOfRamType.get(i) + "\n";
            }detailsRAMTA.setText(ramType);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "mainboard");
            for(int i = 0; i < listOfSpcfPrice.size(); i++){
                prices += listOfSpcfPrice.get(i) + "\n";
            }detailsPriceTA.setText(prices);
            
            String onBGrphcs = "";
            listOfGrphics = dbProject.getMBGraphics(con, "mainboard");
            for(int i = 0; i < listOfGrphics.size(); i++){
                if(listOfGrphics.get(i) == true){
                    onBGrphcs += "yes\n";
                }else if(listOfGrphics.get(i) != true){
                    onBGrphcs += "no\n";
                }
            }detailsMBGraphics.setText(onBGrphcs);
            
            String formFactor = "";
            listOfFormFactors = dbProject.getSpecificFormFactor(con, "mainboard");
            for(int i = 0; i < listOfFormFactors.size(); i++){
                formFactor += listOfFormFactors.get(i) + "\n";
            }detailsFormTA.setText(formFactor);
            
            detailsBusSTA.setText("N/A");
            
        }else if(detailsGcBtn.isSelected()){
            String graphicsCardNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "graphicscard");
            for (int i = 0; i < listOfSpcfcNames.size(); i++) {
                graphicsCardNames +=  listOfSpcfcNames.get(i) + "\n";
            }detailsNameTA.setText(graphicsCardNames);
            
            String grphcsBusSpeed = "";
            listOfBusspeed = dbProject.getSpecificComponentBusSpeed(con, "graphicscard");
            for (int i = 0; i < listOfBusspeed.size(); i++) {
                grphcsBusSpeed +=  listOfBusspeed.get(i) + " GB\n";
            }detailsBusSTA.setText(grphcsBusSpeed);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "graphicscard");
            for(int i = 0; i < listOfSpcfPrice.size(); i++){
                prices += listOfSpcfPrice.get(i) + "\n";
            }detailsPriceTA.setText(prices);
            
            detailsFormTA.setText("N/A");
            detailsMBGraphics.setText("N/A");
            detailsRAMTA.setText("N/A");
            detailsSocket.setText("N/A");
            
        }else if(detailsCcasebtn.isSelected()){
            String caseNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "computercase");
            for (int i = 0; i < listOfSpcfcNames.size(); i++) {
                caseNames +=  listOfSpcfcNames.get(i) + "\n";
            }detailsNameTA.setText(caseNames);
            
            String prices = "";
            listOfSpcfPrice = dbProject.getSpecificComponentPrice(con, "computercase");
            for(int i = 0; i < listOfSpcfPrice.size(); i++){
                prices += listOfSpcfPrice.get(i) + "\n";
            }detailsPriceTA.setText(prices);
            
            String formFactor = "";
            listOfFormFactors = dbProject.getSpecificFormFactor(con, "mainboard");
            for(int i = 0; i < listOfFormFactors.size(); i++){
                formFactor += listOfFormFactors.get(i) + "\n";
            }detailsFormTA.setText(formFactor);
            
            detailsMBGraphics.setText("N/A");
            detailsRAMTA.setText("N/A");
            detailsSocket.setText("N/A");
            detailsBusSTA.setText("N/A");
        }
    }
    
    @FXML
    void completePurchases(ActionEvent event) {
        int compSales = 0;
        int sysSales = 0;
        String soldOut = "";
        boolean compInStock = true;
        if(systemCB == null && ramCB == null && cpuCB == null && mbCB == null && gcCB == null && ccCB == null){
            salesPageLastTA.setText("No items where selected.\nTo order - Select a component or system, and press \"Buy.\"");
        }else{
            if(systemCB.getSelectionModel().getSelectedIndex() != -1){
                listOfSys = dbProject.getSystemComponents(con, (String)systemCB.getSelectionModel().getSelectedItem());
                for(String s : listOfSys){
                    if(dbProject.getComponentStock(con, s) < sysQuantitySpinner.getValue()){
                        compInStock = false;
                        salesPageLastTA.setText("Insufficient components for chosen system(s).");
                    }
                }if(compInStock == true){
                    for(String s : listOfSys){
                        dbProject.sellComponent(con, sysQuantitySpinner.getValue() ,s);
                    }
                }sysSales++;
            }if(ramCB.getSelectionModel().getSelectedIndex() != -1){
                if(dbProject.getComponentStock(con, (String)ramCB.getSelectionModel().getSelectedItem()) > 0){
                    dbProject.sellComponent(con, ramQSpin.getValue() ,(String)ramCB.getSelectionModel().getSelectedItem());
                    compSales++;
                }else{
                    soldOut += (String)ramCB.getSelectionModel().getSelectedItem() + " is sold out, or not in the selected quantity \nCheck details for more info.";
                }
            }if(cpuCB.getSelectionModel().getSelectedIndex() != -1){
                if(dbProject.getComponentStock(con, (String)cpuCB.getSelectionModel().getSelectedItem()) > 0){
                dbProject.sellComponent(con, cpuQSpin.getValue() ,(String)cpuCB.getSelectionModel().getSelectedItem());
                compSales++;
                }else{
                    soldOut += (String)cpuCB.getSelectionModel().getSelectedItem() + "is sold out \n";
                }
            }if(mbCB.getSelectionModel().getSelectedIndex() != -1){
                if(dbProject.getComponentStock(con, (String)mbCB.getSelectionModel().getSelectedItem()) > 0){
                dbProject.sellComponent(con, mbQSpin.getValue() ,(String)mbCB.getSelectionModel().getSelectedItem());
                compSales++;
                }else{
                    soldOut += (String)mbCB.getSelectionModel().getSelectedItem() + "is sold out \n";
                }
            }if(gcCB.getSelectionModel().getSelectedIndex() != -1){
                if(dbProject.getComponentStock(con, (String)gcCB.getSelectionModel().getSelectedItem()) > 0){
                dbProject.sellComponent(con, gcQSpin.getValue() ,(String)gcCB.getSelectionModel().getSelectedItem());
                compSales++;
                }else{
                    soldOut += (String)gcCB.getSelectionModel().getSelectedItem() + "is sold out \n";
                }
            }if(ccCB.getSelectionModel().getSelectedIndex() != -1){
                if(dbProject.getComponentStock(con, (String)ccCB.getSelectionModel().getSelectedItem()) > 0){
                dbProject.sellComponent(con, cCQSpin.getValue() ,(String)ccCB.getSelectionModel().getSelectedItem());
                compSales++;
                }else{
                    soldOut += (String)ccCB.getSelectionModel().getSelectedItem() + "is sold out \n";
                }
            }salesPageLastTA.setText("You have purchased "+ compSales +" components.\nAnd " + sysSales + " Computersystems.");
        }
    }
    
    @FXML
    void fetchRestock(ActionEvent event) {
        restockMap = dbProject.getRestockList(con);
        for (HashMap.Entry<String, Integer> entry : restockMap.entrySet()){
            restockTA.setText("Component: " + entry.getKey() + " needs retocking of: " + entry.getValue() + " components.");
        }if(restockTA.getText().isEmpty()){
            restockTA.setText("Nothing needs restocking at the moment.");
        }
    }
}