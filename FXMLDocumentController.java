
package recasdb;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDController implements Initializable {

    @FXML //textfield de adicion
    private TextField Aapelli;
    private TextField Aapell2;
    private TextField Aedad;
    private TextField Anom;
   
    @FXML//TEXTfield de busqueda
    private TextField Abusc;
    
    @FXML//Botones
    private Button ADD;
    private Button BuscT;
    private Button Busc;
    
    @FXML//Botonesradio
    private RadioButton one;
    private RadioButton all;
    
    @FXML //Tabla loca
    private TableView<?> Tabla;
    private TableColumn<?, ?> Tapell;
    private TableColumn<?, ?> Tapelli2;
    private TableColumn<?, ?> Tedad;
    private TableColumn<?, ?> Tidprop;
    private TableColumn<?, ?> Tnom;

    @FXML
    void Add(ActionEvent event) {

    }

    @FXML
    void Busca(ActionEvent event) {

    }

    @FXML
    void BuscaT(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
