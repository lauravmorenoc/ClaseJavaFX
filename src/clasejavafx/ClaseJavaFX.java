/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasejavafx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author lamorenoca
 */

/*Layout: Conjunto de clases en java. Organizacion de los componentes de las escenas de una ventana.
VBox, BorderPane, se pueden hacer combinaciones de estos*/
public class ClaseJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{
        Button bt1 =new Button("OK");
        Button bt2 =new Button("Not Ok");
        Button bt3 =new Button("Ok, but not Ok");
        
        FileInputStream input=new FileInputStream("image.jpg"); //Así se agregan imágenes
        Image image = new Image(input);
        //Podemos agregar un "label" (mensaje que aparece en la scena)
        Label label1 = new Label("Search");
        //Label label2= new Label("Search", new ImageView(image));
        Label label2=new Label("Numero 1");
        
        HBox hlayout=new HBox(bt1, bt2, bt3); //Pone los botones de forma horizontal, seguidos;
        VBox vlayout=new VBox(); //Pone los botones de forma horizontal, seguidos;
        //Podemos combinarlos de la siguiente forma
        vlayout.getChildren().add(hlayout);
        vlayout.getChildren().add(bt3);
        
       vlayout.getChildren().add(label1);
        hlayout.getChildren().add(label2);
        
        //Con lo siguiente vamos a agregar una tabla
        TableView table =new TableView();
        table.setEditable(true);
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        //Con lo siguiente agregamos un botón de opciones
        ObservableList<String> options =
        FXCollections.observableArrayList(
        "Option 1","Option 2","Option 3");
        ComboBox comboBox = new ComboBox(options);
        
        
        vlayout.getChildren().add(comboBox);
        vlayout.getChildren().add(table);
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(new Label("First Name:"), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("MI:"), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 3);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        
        vlayout.getChildren().add(pane);
        
        GridPane gridpane = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        gridpane.getColumnConstraints().addAll(col1,col2,col2,col1);
        Label text = new Label("Digite su direccion, para facilidades del robo");
        gridpane.add(text, 0, 0, 4, 1); // (Columna 0, Fila 0)and colspan 4
        GridPane.setHalignment(text, HPos.CENTER);
        Label direccion = new Label("Direccion");
        gridpane.add(direccion, 0, 1, 1, 1); // (Columna 0, Fila 1) andcolspan 1
        GridPane.setHalignment(direccion, HPos.RIGHT);
        TextField txtDireccion = new TextField();
        gridpane.add(txtDireccion, 1, 1, 4, 1); // (Columna 0, Fila 1)and colspan 1
        Label direccion2 = new Label("Direccion");
        TextField txtDireccion2 = new TextField();
        gridpane.add(direccion2, 0, 2, 1, 2); // (Columna 0, Fila 1)and colspan 1
        gridpane.add(txtDireccion2, 1, 2, 4, 2); // (Columna 0, Fila 1)and colspan 1
        
        vlayout.getChildren().add(gridpane);
        
        Scene scene = new Scene(vlayout, 1000, 700);
        primaryStage.setTitle("My JavaFX");
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
