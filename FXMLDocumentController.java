/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaodev1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author emin
 */
public class FXMLDocumentController implements Initializable {
    @FXML private TableView<virus> tablo;
    @FXML private TableColumn<virus, String> ulkekolon;
    @FXML private TableColumn<virus, Integer> topvakakolon;
    @FXML private TableColumn<virus, Integer> vakakolon;
    @FXML private TableColumn<virus, Integer> topolukolon;
    @FXML private TableColumn<virus, Integer> olukolon; 
    @FXML private TableColumn<virus, Integer> nufuskolon;
    @FXML private TableColumn<virus, String> olumorankolon;
    @FXML private TableColumn<virus, String> saldirikolon;      
    @FXML private LineChart virusgrafigi;
    @FXML private TextField urlgetir;
   
    private final ObservableList<virus> data =FXCollections.observableArrayList();
    private final String [][][] corona=new String [300][300][11];
    private final int [] songun= new int [300];
     @FXML  private void grafik1()
    {
        try{
        virusgrafigi.getData().clear();      
        virusgrafigi.setTitle("Günler grafik, 2020");
        virusgrafigi.setLegendSide(Side.BOTTOM);
        virusgrafigi.legendVisibleProperty().setValue(Boolean.TRUE);
        virusgrafigi.setVerticalGridLinesVisible(true);       
        
       int sec = tablo.getSelectionModel().getSelectedItems().size();
         
        for (int c=0;c<sec;c++)
            for (int h=0;h<164;h++)
       {            
        String ulkeler= tablo.getSelectionModel().getSelectedItems().get(c).getulke();
        if (ulkeler.equals(corona[h][0][0]))
            {
            XYChart.Series seri = new XYChart.Series();              
             seri.setName(corona[h][0][0]);    
             for (int f=30;f>0;f--)
               {
                if (corona[h][f][1]==null)corona[h][f][1]=" ";  
                if (corona[h][f][2]==null)corona[h][f][2]=Integer.toString(0);
                seri.getData().add(new XYChart.Data(corona[h][f][1], Integer.parseInt(corona[h][f][2])));
               }                     
            virusgrafigi.getData().addAll(seri);
            }
       }
        
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    @FXML  private void grafik2()
    {
        try{            
        Stage sahne=new Stage();
        CategoryAxis xAxis = new CategoryAxis();  
        NumberAxis yAxis = new NumberAxis();
        StackedBarChart<String, Number> stackedBarChart = 
        new StackedBarChart<>(xAxis, yAxis);           
      Scene scene = new Scene(stackedBarChart, 1000, 800);      
      ObservableList<String> gunler = FXCollections.observableArrayList();
           for (int g=1;g<45;g++)
           {
              if (corona[0][g][1]==null)corona[0][g][1]=" ";              
              gunler.add(corona[0][g][1]);       
           }
      xAxis.setCategories(FXCollections.observableArrayList(gunler)); 
      xAxis.setLabel("KITALAR"); yAxis.setLabel("Vaka");      
       stackedBarChart.autosize();
      stackedBarChart.setTitle("Co - Vid 19 Kıtalar Grafiği"); 
        XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
        XYChart.Series<String, Number> series2 = new XYChart.Series<>(); 
        XYChart.Series<String, Number> series3 = new XYChart.Series<>(); 
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        XYChart.Series<String, Number> series5 = new XYChart.Series<>();
        series1.setName("Europe"); 
        series2.setName("Asia");
        series3.setName("Africa");
        series4.setName("America");
        series5.setName("Oceania");  
      for (int k=0;k<60;k++) 
      {            
        for (int w=0;w<164;w++)
        {
            if (corona[w][k][2]==null||Integer.parseInt(corona[w][k][2])<=0)corona[w][k][2]="0";
            if (corona[w][k][1]==null)corona[w][k][1]=" ";
           if (corona[w][k][6]==null||corona[w][k][6]=="")corona[w][k][6]="Diger";
       if (corona[w][k][6].equals("Europe")) series1.getData().add(new XYChart.Data<String, Number>(corona[w][k][1],Integer.parseInt(corona[w][k][2])));
       if (corona[w][k][6].equals("Asia")) series2.getData().add(new XYChart.Data<String, Number>(corona[w][k][1], Integer.parseInt(corona[w][k][2])));
       if (corona[w][k][6].equals("Africa")) series3.getData().add(new XYChart.Data<String, Number>(corona[w][k][1],Integer.parseInt(corona[w][k][2])));
       if (corona[w][k][6].equals("America")) series4.getData().add(new XYChart.Data<String, Number>(corona[w][k][1], Integer.parseInt(corona[w][k][2])));
       if (corona[w][k][6].equals("Oceania")) series5.getData().add(new XYChart.Data<String, Number>(corona[w][k][1], Integer.parseInt(corona[w][k][2])));       
            
        }
        stackedBarChart.getData().addAll(series1,series2,series3,series4,series5);
      }     
       
      sahne.setTitle("Co-Vid 19 KITALAR GRAFİĞİ"); 
      sahne.setScene(scene); 
      sahne.show();      
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }  
    
    @FXML
     private void getdata (ActionEvent event)throws Exception {
         try {
       ulkekolon.setCellValueFactory(cellData -> cellData.getValue().ulkeProperty());
       vakakolon.setCellValueFactory(cellData -> cellData.getValue().vakaProperty().asObject());
       olukolon.setCellValueFactory(cellData -> cellData.getValue().oluProperty().asObject());
       topvakakolon.setCellValueFactory(cellData -> cellData.getValue().topvakaProperty().asObject());
       topolukolon.setCellValueFactory(cellData -> cellData.getValue().topoluProperty().asObject());
       nufuskolon.setCellValueFactory(cellData -> cellData.getValue().nufusProperty().asObject()); 
       olumorankolon.setCellValueFactory(cellData -> cellData.getValue().olumoranProperty());
       saldirikolon.setCellValueFactory(cellData -> cellData.getValue().saldiriProperty());          
        URL oracle = new URL(urlgetir.getText());
        tablo.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));        
        String ssatir;  
        int say=0,bas=0,son=0,ulke=0, topolu=0,topvaka=0,gun=-1;
        while ((ssatir = in.readLine()) != null)
        {
            say++;
            if (ssatir.indexOf("<dateRep>")>0)
                {                      
                    gun=gun+1;                             
                    bas=ssatir.indexOf(">"); 
                    son=ssatir.indexOf("</dateRep>");                                
                    corona[ulke][gun][1]=ssatir.substring(bas+1, son);  
                    if (corona[ulke][gun][1]==null)corona[ulke][gun][1]=" ";                                     
                }
            if (ssatir.indexOf("<countriesAndTerritories>")>0)
            {    
                bas=ssatir.indexOf(">");
                son=ssatir.indexOf("</countriesAndTerritories>");                               
                if (corona[ulke][gun][0]== null) corona[ulke][gun][0]=ssatir.substring(bas+1, son);                
                if (corona[ulke][0][0].compareTo(ssatir.substring(bas+1, son)) != 0) 
                {
                    songun[ulke]=gun;
                    corona[ulke][songun[ulke]][5]=Integer.toString(topolu);
                    corona[ulke][songun[ulke]][3]=Integer.toString(topvaka);                    
                    ulke++;topolu=0;topvaka=0;gun=0;
                    corona[ulke][gun][0]=ssatir.substring(bas+1, son);                   
                }                         
            }
            
            if (ssatir.indexOf("<cases>")>0)
            {              
                bas=ssatir.indexOf(">");
                son=ssatir.indexOf("</cases>");                   
                corona[ulke][gun][2]=ssatir.substring(bas+1, son);   
                if (corona[ulke][gun][2]==null)corona[ulke][gun][2]="0";                
                topvaka=topvaka+Integer.parseInt(corona[ulke][gun][2]);
               
            }
            if (ssatir.indexOf("<deaths>")>0)
            {      
                bas=ssatir.indexOf(">"); 
                son=ssatir.indexOf("</deaths>");                                
                corona[ulke][gun][4]=ssatir.substring(bas+1, son);   
                if (corona[ulke][gun][4]==null)corona[ulke][gun][4]="0";               
                topolu=topolu+Integer.parseInt(corona[ulke][gun][4]);                
            }
            if (ssatir.indexOf("<continentExp>")>0)
            {      
                bas=ssatir.indexOf(">"); 
                son=ssatir.indexOf("</continentExp>");                                
                corona[ulke][gun][6]=ssatir.substring(bas+1, son);  
                if (corona[ulke][gun][6]==null||corona[ulke][gun][6]=="")corona[ulke][gun][6]="Diger";                    
            }
            
            if (ssatir.indexOf("<popData2018>")>0)
            {      
                bas=ssatir.indexOf(">"); 
                son=ssatir.indexOf("</popData2018>");                 
                corona[ulke][gun][7]=ssatir.substring(bas+1, son);   
                if (corona[ulke][gun][7]==null)corona[ulke][gun][7]="0";                   
            }
            
            if (say==205000) break;    
        }       
        corona[5][0][7]="15094";corona[24][0][7]="20104";
        corona[62][0][7]="3214000";corona[66][0][7]="2840";corona[191][0][7]="11570000";  //nüfusu belli olmayan ülkeler google dan eklendi.
      
        for (int y=0;y<164;y++)
        {                                       
           double Mortality=Double.valueOf(corona[y][songun[y]][5])/Double.valueOf(corona[y][songun[y]][3]);           
           double attackrate=Double.valueOf(corona[y][songun[y]][3])/Double.valueOf(corona[y][0][7]);         
        data.add(new virus(corona[y][0][0],Integer.parseInt(corona[y][songun[y]][3]),Integer.parseInt(corona[y][1][2]),
                 Integer.parseInt(corona[y][songun[y]][5]),Integer.parseInt(corona[y][songun[y]][4]),
                 Integer.parseInt(corona[y][0][7]),Double.toString(Mortality),Double.toString(attackrate)));      //df.format(Mortality),df.format(attackrate)
        tablo.setItems(data);      
        } 
        in.close();
                     
                } catch (IOException e) {
                    e.printStackTrace();
                } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
       
    }       
}
