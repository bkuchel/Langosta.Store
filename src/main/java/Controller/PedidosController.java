package Controller;

import Model.Clientes;
import Model.Pedidos;
import Model.Productos;
import Services.PedidoService;

import java.io.IOException;
import java.util.List;

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

public class PedidosController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Elementos del formulario
    @FXML
    TextField inputNifCliente;
    @FXML
    TextField inputCodProducto;
    @FXML
    TextField inputCantidad;
    @FXML
    Button btnGuardar;

    // Elementos de la tabla de datos
    @FXML
    ObservableList<Pedidos> pedidos;
    @FXML
    TableView<Pedidos> tablaPedidos;
    @FXML
    TableColumn<Productos, Integer> colCodigo;
    @FXML
    TableColumn<Productos, String> colNIFCliente;
    @FXML
    TableColumn<Productos, Float> colArticulo;
    @FXML
    TableColumn<Productos, Float> colCantidad;


    PedidoService bbdd = new PedidoService();

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
       inputCodProducto.getText().isEmpty() ||
       inputCantidad.getText().isEmpty());
       btnGuardar.setDisable(isDisabled);

    }

    public void nuevoPedido() {
            Pedidos pedido = new Pedidos();
            Clientes cliente = new Clientes();
            Productos producto = new Productos();

            cliente.setNif(inputNifCliente.getText());
            producto.setCodigo(Integer.parseInt(inputCodProducto.getText()));

            pedido.setCliente(cliente);
            pedido.setCodigoArticulo(producto);
            pedido.setCantidad(Integer.parseInt(inputCantidad.getText()));

            bbdd.addPedido(pedido);
            borrarForm();
            btnGuardar.setDisable(true);
            verPedidos();
        }

    public void borrarForm () {
        inputNifCliente.setText(null);
        inputCodProducto.setText(null);
        inputCantidad.setText(null);
    }

    public void verPedidos() {
        List<Pedidos> pedidosList;
        pedidosList = bbdd.getPedidos();
        pedidos = FXCollections.observableArrayList(pedidosList);
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNIFCliente.setCellValueFactory(new PropertyValueFactory<>("nifCliente"));
        colArticulo.setCellValueFactory(new PropertyValueFactory<>("codigoArticulo"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tablaPedidos.setItems(pedidos);
    }

    public void initialize() {
        btnGuardar.setDisable(true);
        verPedidos();
    }

    }

