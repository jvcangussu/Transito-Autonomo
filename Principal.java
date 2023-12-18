/* ***************************************************************
* Autor............: Joao Vitor Cangussu B Oliveira
* Matricula........: 202210559
* Inicio...........: 18/11/2023
* Ultima alteracao.: 
* Nome.............: Principal do Problema Transito Autonomo
* Funcao...........: Realiza as importacoes necessarias carrega o
fxml da primeira tela e inicia o programa
*************************************************************** */
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import control.Controller;//importando o controlador da tela principal para poder compilar

public class Principal extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/backgroundScreen.fxml"));//Carrega o fxml da tela primaria salvando na variavel root
    Scene scene = new Scene(root);//Cria uma nova cena definindo nela o fxml carregado

    stage.setTitle("Transito Autonomo");//Define o titulo da janela da aplicacao
    stage.setScene(scene);//Seta a cena com o fxml carregado no stage
    stage.setResizable(false);//Define a tela como nao redimensionavel
    stage.show();//Mostra o stage
  }

  public static void main(String[] args) throws Exception {
    launch(args);
  }
}//fim classe Principal