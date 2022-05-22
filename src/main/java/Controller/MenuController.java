package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void linkProducto(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProductosView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void linkPedidos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PedidosView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void linkClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientesView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
    }


}
