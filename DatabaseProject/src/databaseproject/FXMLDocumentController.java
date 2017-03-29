package databaseproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stockPageName.setEditable(false);
        stockPagePrice.setEditable(false);
        stockPageStock.setEditable(false);
        stockPageMin.setEditable(false);
        stockPagePref.setEditable(false);
        stockPageKind.setEditable(false);
        sysInStockPageTA.setEditable(false);
        priceListPageTA.setEditable(false);
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
    private Label stockPageLabel;

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
    private Label stockPageLabel1;

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
    private Label sysInStockLabel;

    @FXML
    private TextArea sysInStockPageTA;

    @FXML
    private Button sysInStockButton;

    @FXML
    private Label priceListLabel;

    @FXML
    private TextArea priceListPageTA;

    @FXML
    private Button priceListButton;

    @FXML
    private Label salesPageLabel;

    @FXML
    private TextArea salesPageTA;

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
    void fetchPriceList(ActionEvent event) {

    }

    @FXML
    void fetchSales(ActionEvent event) {

    }

    @FXML
    void fetchSysInStock(ActionEvent event) {

    }

    @FXML
    void selectKind(ActionEvent event) {

    }

    @FXML
    void showDetails(ActionEvent event) {
        detailsNameTA.clear();
        if(detailsRAMBtn.isSelected()){
            String ramNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "ram");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                ramNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(ramNames);
            
        }else if(detailsCPUbtn.isSelected()){
            String _CPUNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "cpu");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                _CPUNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(_CPUNames);
            
        }else if(detailsMBbtn.isSelected()){
            String mainboardNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "mainboard");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                mainboardNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(mainboardNames);
            
        }else if(detailsGcBtn.isSelected()){
            String craphicsCardNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "graphicscard");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                craphicsCardNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(craphicsCardNames);
            
        }else if(detailsCcasebtn.isSelected()){
            String caseNames = "";
            listOfSpcfcNames = dbProject.getSpecificComponentName(con, "computercase");
            for (int i = 0; i < listOfSpcfcNames.length; i++) {
                caseNames +=  listOfSpcfcNames[i] + "\n";
            }detailsNameTA.setText(caseNames);
        }
    }
}
