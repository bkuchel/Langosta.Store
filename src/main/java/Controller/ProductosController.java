package Controller;


import Model.Productos;
import Services.ProductoService;
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
import java.util.ArrayList;
import java.util.List;

public class ProductosController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Elementos del formulario
    @FXML
    TextField inputProducto;
    @FXML
    TextField inputPVP;
    @FXML
    TextField inputGastosEnvio;
    @FXML
    TextField inputTiempoPreparacion;
    @FXML
    Button btnGuardar;



    // Elementos de la tabla de datos
    @FXML
    ObservableList<Productos> productos;
    @FXML
    TableView<Productos> tablaProductos;
    @FXML
    TableColumn<Productos, Integer> colCodigo;
    @FXML
    TableColumn<Productos, String> colNombre;
    @FXML
    TableColumn<Productos, Float> colPVP;
    @FXML
    TableColumn<Productos, Float> colGastosEnvio;
    @FXML
    TableColumn<Productos, Integer> colTiempoPreparacion;


    ProductoService bbdd = new ProductoService();
    //ProductosView menuProducto = new ProductosView();





        public void nuevoProducto() {
        Productos producto = new Productos();
            producto.setNombre(inputProducto.getText());
            producto.setPvp(Float.parseFloat(inputPVP.getText()));
            producto.setGastosEnvio(Float.parseFloat(inputGastosEnvio.getText()));
            producto.setTiempoPreparacion(Integer.parseInt(inputTiempoPreparacion.getText()));
            bbdd.addProducto(producto);
            borrarForm();
            btnGuardar.setDisable(true);
            verProductos();
        }



        public void borrarForm () {
            inputProducto.setText(null);
            inputPVP.setText(null);
            inputGastosEnvio.setText(null);
            inputTiempoPreparacion.setText(null);
        }

        public void checkIsEmpty() {
            boolean isDisabled = (
            inputProducto.getText().isEmpty() ||
            inputPVP.getText().isEmpty() ||
            inputGastosEnvio.getText().isEmpty() ||
            inputTiempoPreparacion.getText().isEmpty());
            btnGuardar.setDisable(isDisabled);

        }


        public void verProductos() {

            List<Productos> productosList = new ArrayList<>();
            productosList = bbdd.getProductos();
            productos = FXCollections.observableArrayList(productosList);
            colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colPVP.setCellValueFactory(new PropertyValueFactory<>("pvp"));
            colGastosEnvio.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
            colTiempoPreparacion.setCellValueFactory(new PropertyValueFactory<>("tiempoPreparacion"));
            tablaProductos.setItems(productos);
        }

    public void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void initialize() {
            btnGuardar.setDisable(true);
            verProductos();
    }


}
