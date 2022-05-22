package Controller;

import Model.*;
import Services.ClienteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ClienteController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Elementos del formulario
    @FXML
    TextField inputNifCliente;
    @FXML
    TextField inputNombre;
    @FXML
    TextField inputEmail;
    @FXML
    TextField inputDomicilio;
    @FXML
    Button btnGuardar;

    // Elementos de la tabla de datos
    @FXML
    ObservableList<Clientes> clientes;
    @FXML
    TableView<Clientes> tablaClientes;
    @FXML
    TableColumn<Productos, String> colNiFCliente;
    @FXML
    TableColumn<Productos, String> colNombreCliente;
    @FXML
    TableColumn<Productos, String> colEmail;
    @FXML
    TableColumn<Productos, String> colDomicilio;
    @FXML
    RadioButton radioEstandar, radioPremium;


    ClienteService bbdd = new ClienteService();

    public void nuevoCliente() {
        if(radioEstandar.isSelected()){
            Estandar estandar = new Estandar();
            estandar.setNif(inputNifCliente.getText());
            estandar.setNombre(inputNombre.getText());
            estandar.setEmail(inputEmail.getText());
            estandar.setDomicilio(inputDomicilio.getText());
            bbdd.addCliente(estandar);
            verClientes();

        } else {
            Premium premium = new Premium();
            premium.setNif(inputNifCliente.getText());
            premium.setNombre(inputNombre.getText());
            premium.setEmail(inputEmail.getText());
            premium.setDomicilio(inputDomicilio.getText());
            bbdd.addCliente(premium);
            verClientes();
        }
    }


    public void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void checkIsEmpty() {
        boolean isDisabled = (
                inputNifCliente.getText().isEmpty() ||
                inputNombre.getText().isEmpty() ||
                inputDomicilio.getText().isEmpty() ||
                inputEmail.getText().isEmpty());
        btnGuardar.setDisable(isDisabled);

    }


    public void verClientes() {
        List<Clientes> clientesList;
        clientesList = bbdd.getClientes();
        clientes = FXCollections.observableArrayList(clientesList);
        colNiFCliente.setCellValueFactory(new PropertyValueFactory<>("nif"));
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
       tablaClientes.setItems(clientes);
    }

    public void initialize() {
        btnGuardar.setDisable(true);
        verClientes();
    }


}