/* ***************************************************************
* Autor............: Joao Vitor Cangussu B Oliveira
* Matricula........: 202210559
* Inicio...........: 18/11/2023
* Ultima alteracao.: 04/12/2023
* Nome.............: Controladora do Problema Transito Autonomo
* Funcao...........: Controla os elementos da tela e as threads do programa
*************************************************************** */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import threads.Carro;

public class Controller implements Initializable {
  // Imagens dos carros
  @FXML
  private ImageView bmwImage;
  @FXML
  private ImageView ferrariImage;
  @FXML
  private ImageView bugattiImage;
  @FXML
  private ImageView gtrImage;
  @FXML
  private ImageView lamboImage;
  @FXML
  private ImageView mcLarenImage;
  @FXML
  private ImageView mercedesImage;
  @FXML
  private ImageView unoImage;

  // Botoes de Pause
  @FXML
  private ImageView bmwPauseButton;
  @FXML
  private ImageView ferrariPauseButton;
  @FXML
  private ImageView gtrPauseButton;
  @FXML
  private ImageView lamboPauseButton;
  @FXML
  private ImageView mcLarenPauseButton;
  @FXML
  private ImageView bugattiPauseButton;
  @FXML
  private ImageView mercedesPauseButton;
  @FXML
  private ImageView unoPauseButton;

  // Botoes de Mostrar Caminho
  @FXML
  private ImageView bmwTrackButton;
  @FXML
  private ImageView bugattiTrackButton;
  @FXML
  private ImageView ferrariTrackButton;
  @FXML
  private ImageView gtrTrackButton;
  @FXML
  private ImageView lamboTrackButton;
  @FXML
  private ImageView mcLarenTrackButton;
  @FXML
  private ImageView mercedesTrackButton;
  @FXML
  private ImageView unoTrackButton;

  //Imagens dos caminhos
  @FXML
  private ImageView unoTrackImage;
  @FXML
  private ImageView ferrariTrackImage;
  @FXML
  private ImageView mclarenTrackImage;
  @FXML
  private ImageView lamboTrackImage;
  @FXML
  private ImageView bmwTrackImage;
  @FXML
  private ImageView bugattiTrackImage;
  @FXML
  private ImageView gtrTrackImage;
  @FXML
  private ImageView mercedesTrackImage;

  //Sliders velocidade
  @FXML
  private Slider sliderBMW;
  @FXML
  private Slider sliderBugatti;
  @FXML
  private Slider sliderFerrari;
  @FXML
  private Slider sliderGTR;
  @FXML
  private Slider sliderLambo;
  @FXML
  private Slider sliderMcLaren;
  @FXML
  private Slider sliderMercedes;
  @FXML
  private Slider sliderUno;

  //funcao para mostrar ou esconder os caminhos dos carros
  @FXML
  void showTrack(MouseEvent event) {
    String id = event.getPickResult().getIntersectedNode().getId();//recebe o id do botao apertado
      if(id.equals("unoTrackButton")){
        if(unoTrackImage.isVisible()){
          unoTrackImage.setVisible(false);
          unoTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          unoTrackImage.setVisible(true);
          unoTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("ferrariTrackButton")){
        if(ferrariTrackImage.isVisible()){
          ferrariTrackImage.setVisible(false);
          ferrariTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          ferrariTrackImage.setVisible(true);
          ferrariTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("mcLarenTrackButton")){
        if(mclarenTrackImage.isVisible()){
          mclarenTrackImage.setVisible(false);
          mcLarenTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          mclarenTrackImage.setVisible(true);
          mcLarenTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("lamboTrackButton")){
        if(lamboTrackImage.isVisible()){
          lamboTrackImage.setVisible(false);
          lamboTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          lamboTrackImage.setVisible(true);
          lamboTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("bmwTrackButton")){
        if(bmwTrackImage.isVisible()){
          bmwTrackImage.setVisible(false);
          bmwTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          bmwTrackImage.setVisible(true);
          bmwTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("bugattiTrackButton")){
        if(bugattiTrackImage.isVisible()){
          bugattiTrackImage.setVisible(false);
          bugattiTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          bugattiTrackImage.setVisible(true);
          bugattiTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("gtrTrackButton")){
        if(gtrTrackImage.isVisible()){
          gtrTrackImage.setVisible(false);
          gtrTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          gtrTrackImage.setVisible(true);
          gtrTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
      if(id.equals("mercedesTrackButton")){
        if(mercedesTrackImage.isVisible()){
          mercedesTrackImage.setVisible(false);
          mercedesTrackButton.setImage(new Image("/img/showTrackButton.png"));
        } else {
          mercedesTrackImage.setVisible(true);
          mercedesTrackButton.setImage(new Image("/img/hideTrackButton.png"));
        }
      }
  }

  //funcao para pausar carro
  @FXML
  void pausarCarro(MouseEvent event) {
    String id = event.getPickResult().getIntersectedNode().getId();//recebe o id do botao apertado

    if(id.equals("unoPauseButton")){
      if(uno.pausarOuDespausar()){
        unoPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        unoPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("ferrariPauseButton")){
      if(ferrari.pausarOuDespausar()){
        ferrariPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        ferrariPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("mcLarenPauseButton")){
      if(mclaren.pausarOuDespausar()){
        mcLarenPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        mcLarenPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("lamboPauseButton")){
      if(lambo.pausarOuDespausar()){
        lamboPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        lamboPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("bmwPauseButton")){
      if(bmw.pausarOuDespausar()){
        bmwPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        bmwPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("bugattiPauseButton")){
      if(bugatti.pausarOuDespausar()){
        bugattiPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        bugattiPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("gtrPauseButton")){
      if(gtr.pausarOuDespausar()){
        gtrPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        gtrPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
    if(id.equals("mercedesPauseButton")){
      if(mercedes.pausarOuDespausar()){
        mercedesPauseButton.setImage(new Image("/img/resumeButton.png"));
      } else {
        mercedesPauseButton.setImage(new Image("/img/pauseButton.png"));
      }
    }
  }

  //Threads
  private Carro uno;
  private Carro ferrari;
  private Carro mclaren;
  private Carro lambo;
  public Carro bmw;
  private Carro bugatti;
  private Carro gtr;
  private Carro mercedes;

  //Arrays de Comandos
  /*Legenda:
    e - esquerda
    b - baixo
    d - direita
    c - cima
    a/x/y - acquire/outro carro/zona critica
    r/x/y - release/outro carro/zona critica
    f - final 
   */
  private String[] unoComandos = {"e", "b", "b", "a/5/0", "b", "r/0/0", "r/5/0", "b", "a/2/0", "a/0/1", "b", "d", "a/5/1", "r/1/0", "r/0/1", "r/6/0", "c", "a/0/2", "r/0/2", "c", "a/0/3",
                                  "a/6/1", "r/2/0", "r/5/1", "r/6/1", "d", "a/1/1", "a/3/0", "a/4/0", "r/0/3", "c", "a/0/4", "a/6/2", "r/6/2", "r/1/1", "r/4/0", "d", "a/2/1", "a/6/3", "r/0/4",
                                  "b", "a/4/1", "a/0/5", "r/2/1", "r/3/0", "d", "a/5/2", "r/6/3", "b", "r/0/5", "b", "a/0/6", "a/3/1", "r/4/1", "r/5/2", "d", "a/3/2", "r/3/1", "c", "c", "a/6/4",
                                  "a/5/3", "c", "r/0/6", "r/5/3", "c", "a/4/2", "a/1/0", "a/2/2", "a/0/7", "c", "e", "a/5/4", "e", "r/0/7", /*"r/4/2",*/ /*"r/5/4",*/ "b", "a/0/8", "r/2/2",
                                  "r/3/2", "e", /*"a/5/5",*//*"a/4/3",*/ "r/0/8", "r/6/4", "c", "a/6/0", "a/0/0", "a/2/3", "r/4/2", "e", "r/2/3", "r/5/4", "f"};

  private String[] ferrariComandos = {"e", "a/4/0", "a/5/0", "r/4/0", "r/5/0", "e", "a/0/8", "a/2/0", "a/3/0", "a/6/0", "r/2/0", "r/3/0", "e", "a/1/0", "a/4/1", "r/0/8", "r/1/0", "r/4/1",
                                      "r/6/0", "e", "a/2/1", "a/5/1", "b", "a/6/1", "r/2/1", "r/5/1", "d", "a/0/4", "a/1/1", "a/4/2", "r/1/1", "r/4/2", "r/6/1", "d", "a/2/2", "a/3/1", "r/2/2",
                                      "r/3/1", "r/0/4", "d", "a/0/6", "a/4/3", "a/3/2", "a/5/2", "a/6/2", "r/4/3", "d", "r/6/2", "b", "r/5/2", "b", "b", "e", "a/4/4", "a/5/3", "r/0/6", "e",
                                      "a/2/3", "a/1/2", "a/0/1", "r/3/2", "e", "a/6/3", "r/4/4", "e", "r/2/3", "r/5/3", "e", "c", "r/0/1", "r/1/2", "r/6/3", "d", "a/0/2", "a/2/4", "a/5/4",
                                      "r/0/2", "r/2/4", "r/5/4", "d", "a/4/5", "a/6/4", "a/1/3", "r/1/3", "r/4/5", "d", "a/2/5", "a/3/3", "r/2/5", "r/3/3", "r/6/4", "d", "a/5/5", "a/0/5",
                                      "a/4/6", "c", "a/6/5", "r/4/6", "r/5/5", "e", "a/2/6", "a/3/4", "r/2/6", "r/3/4", "r/0/5", "r/6/5", "e", "a/0/3", "a/1/4", "a/4/7", "r/1/4", "r/4/7", "e",
                                      "a/1/5", "a/6/6", "a/2/7", "a/5/6", "r/0/3", "r/2/7", "e", "a/0/0", "r/6/6", "c", "r/5/6", "c", "c", "d", "a/2/8", "a/5/7", "d", "a/4/8", "r/0/0", "r/1/5",
                                      "d", "a/0/7", "a/3/5", "a/6/7", "r/2/8", "d", "r/4/8", "r/5/7", "d", "b", "r/0/7", "r/3/5", "r/6/7", "f"};

  private String[] mclarenComandos = {"c", "a/0/1", "a/1/4", "r/1/4", "c", "a/1/1", "a/5/0", "r/0/1", "r/1/1", "c", "a/0/0", "a/1/0", "r/1/0", "r/5/0", "c", "a/1/5", "a/2/0", "a/4/0", "r/3/0",
                                      "e", "r/2/0", "r/4/0", "e", "b", "b", "a/5/1", "a/4/1", "b", "r/4/1", "r/1/5", "b", "a/3/0", "a/1/2", "b", "d", "a/2/1", "a/4/2", "r/0/0", "d", "r/1/2",
                                      "r/4/2", "r/2/1", "c", "a/1/3", "r/1/3", "r/5/1", "f"};

  private String[] lamboComandos = {"b", "a/0/0", "a/1/7", "a/5/0", "r/6/0", "r/1/7", "b", "a/1/4", "r/1/4", "b", "a/3/0", "a/6/1", "a/1/3", "a/2/1", "r/0/0", "d", "a/4/0", "r/2/1", "r/6/1",
                                    "d", "r/1/3", "r/4/0", "r/5/0", "c", "a/6/2", "a/1/5", "r/1/5", "c", "a/0/1", "a/1/6", "r/1/6", "r/6/2", "c", "a/1/2", "r/0/1", "r/1/2", "c", "a/6/3",
                                    "a/0/2", "a/1/0", "r/1/0", "c", "a/5/1", "a/1/8", "a/4/1", "r/0/2", "r/3/0", "r/6/3", "e", "a/0/3", "a/2/0", "r/4/1", "e", "r/0/3", "r/1/8", "r/2/0", "b",
                                    "a/1/1", "b", "a/6/0", "r/1/1", "r/5/1", "f"};

  private String[] bmwComandos = {"b", "a/1/2", "a/3/0", "a/4/0", "r/2/0", "d", "a/0/1", "r/3/0", "r/4/0", "d", "a/0/2", "r/0/1", "c", "c", "a/2/0", "a/5/0", "a/4/1", "c", "r/1/2", "r/4/1",
                                  "c", "a/1/5", "c", "e", "a/4/2", "a/3/1", "e", "r/1/5", "r/3/1", "r/4/2", "b", "a/1/0", "r/0/2", "r/1/0", "r/5/0", "b", "a/0/0", "a/1/1", "r/1/1", "b", "a/1/4",
                                  "a/5/1", "r/0/0", "r/1/4", "b", "a/1/3", "r/5/1", "r/1/3", "f"};

  private String[] bugattiComandos = {"c", "a/0/2", "a/2/0", "a/4/1", "a/6/0", "a/1/8", "e", "a/3/1", /*"r/0/2",*/ "r/4/1", "r/6/0", "e", /*"a/0/3",*/ "r/5/0", "r/1/8", "r/3/1", "b", "a/6/1",
                                      "a/1/1", "r/0/2", "r/1/1", "b", "a/0/0", "a/1/2", "r/1/2", "r/6/1", "b", "a/1/7", "r/0/0", "r/1/7", "b", "a/1/5", "a/6/2", "r/1/5", "b", "a/0/1", "a/5/1",
                                      "a/3/0", "a/1/4", "r/2/0", "r/6/2", "d", "a/4/0", "r/3/0", "d", "r/1/4", "r/4/0", "c", "a/1/6", "c", "a/6/3", "r/5/1", "r/0/1", "r/1/6", "c", "a/1/3",
                                      "a/5/0", "r/6/3", "r/1/3", "c", "a/1/0", "r/1/0", "f"};

  private String[] gtrComandos = {"e", "a/0/2", "a/1/5", "a/3/0", "a/5/1", "a/6/0", "r/6/0", "b", "r/1/5", "b", "a/1/3", "a/4/0", "r/0/2", "e", "a/6/1", "r/4/0", "e", "a/2/2", "r/5/1", "e",
                                  "a/0/1", "r/1/3", "r/2/2", "r/6/1", "c", "a/1/4", "r/1/4", "c", "a/1/6", "a/2/1", "a/6/2", "r/0/1", "r/3/0", "e", "a/0/0", "r/6/2", "c", "r/0/0", "r/1/6",
                                  "r/2/1", "d", "a/1/1", "a/3/1", "a/6/3", "r/6/3", "c", "r/1/1", "c", "a/5/0", "a/0/4", "a/1/7", "a/4/2", "a/2/0", "d", /*"r/0/5",*/ "r/2/0", "d",
                                  /*"a/0/4",*/ "a/6/4", "r/3/1", "d", "r/0/4", "r/1/7", "r/4/2", "r/6/4", "b", "a/1/0", "r/1/0", "b", "a/1/2", "a/4/1", "a/6/5", "r/5/0", "d", "a/0/3", "r/6/5",
                                  "b", "r/0/3", "r/1/2", "r/4/1", "f"};

  private String[] mercedesComandos = {"d", "a/0/4", "a/2/0", "a/5/1", "a/0/2", "a/3/3", "r/0/2", "r/1/1", "c", "a/1/0", "r/2/0", "r/5/1", "d", "a/4/0", "r/1/0", "c", "a/1/7", "a/5/0", "a/6/4",
                                      "r/3/3", "d", "r/5/0", "r/6/4", "d", "b", "r/1/7", "b", "a/1/2", "a/5/3", "a/6/5", "r/0/4", "r/4/0", "e", "r/1/2", "a/0/3", "r/6/5", "b", "a/1/5", "a/6/0",
                                      "r/5/3", "r/6/0", "e", "a/3/2", "a/4/1", "r/0/3", "r/1/5", "b", "a/1/4", "r/3/2", "r/4/1", "e", "a/2/1", "a/5/2", "r/1/4", "b", "a/0/0", "a/1/3", "a/3/1",
                                      "a/6/1", "r/5/2", "e", "r/3/1", "r/6/1", "e", "c", "r/1/3", "c", "a/1/6", "a/3/0", "a/6/2", "r/0/0", "r/2/1", "d", "a/0/1", "r/0/1", "r/1/6", "r/6/2", "c",
                                      "a/1/1", "a/6/3", "r/3/0", "r/6/3", "f"};

  //Semaforos
  //Semaforos uno/ferrari
  private Semaphore[] semaforos0e1 = new Semaphore[9];
  //Semaforos uno/mclaren
  private Semaphore[] semaforos0e2 = new Semaphore[2];
  //Semaforos uno/lambo
  private Semaphore[] semaforos0e3 = new Semaphore[4];
  //Semaforos uno/bmw
  private Semaphore[] semaforos0e4 = new Semaphore[3];
  //Semaforos uno/bugatti
  private Semaphore[] semaforos0e5 = new Semaphore[3];//tirei um
  //Semaforos uno/gtr
  private Semaphore[] semaforos0e6 = new Semaphore[5];//tirei um
  //Semaforos uno/mercedes
  private Semaphore[] semaforos0e7 = new Semaphore[5];

  //Semaforos ferrari/mclaren
  private Semaphore[] semaforos1e2 = new Semaphore[6];
  //Semaforos ferrari/lambo
  private Semaphore[] semaforos1e3 = new Semaphore[9];
  //Semaforos ferrari/bmw
  private Semaphore[] semaforos1e4 = new Semaphore[6];
  //Semaforos ferrari/bugatti
  private Semaphore[] semaforos1e5 = new Semaphore[9];
  //Semaforos ferrari/gtr
  private Semaphore[] semaforos1e6 = new Semaphore[8];
  //Semaforos ferrari/mercedes
  private Semaphore[] semaforos1e7 = new Semaphore[8];  

  //Semaforos mclaren/lambo
  private Semaphore[] semaforos2e3 = new Semaphore[2];
  //Semaforos mclaren/bugatti
  private Semaphore[] semaforos2e5 = new Semaphore[1];
  //Semaforos mclaren/gtr
  private Semaphore[] semaforos2e6 = new Semaphore[3];
  //Semaforos mclaren/mercedes
  private Semaphore[] semaforos2e7 = new Semaphore[2];
  
  //Semaforos lambo/bmw
  private Semaphore[] semaforos3e4 = new Semaphore[1];
  //Semaforos lambo/bugatti
  private Semaphore[] semaforos3e5 = new Semaphore[2];
  //Semaforos lambo/gtr
  private Semaphore[] semaforos3e6 = new Semaphore[2];
  //Semaforos lambo/mercedes
  private Semaphore[] semaforos3e7 = new Semaphore[4];

  //Semaforos bmw/bugatti
  private Semaphore[] semaforos4e5 = new Semaphore[2];
  //Semaforos bmw/gtr
  private Semaphore[] semaforos4e6 = new Semaphore[3];
  //Semaforos bmw/mercedes
  private Semaphore[] semaforos4e7 = new Semaphore[2];

  //Semaforos bugatti/gtr
  private Semaphore[] semaforos5e6 = new Semaphore[2];
  //Semaforos bugatti/mercedes
  private Semaphore[] semaforos5e7 = new Semaphore[4];

  //Semaforos gtr/mercedes
  private Semaphore[] semaforos6e7 = new Semaphore[6];

  //matriz de semaforos para cado carro
  private Semaphore[][] semaforosUno = new Semaphore[7][];
  private Semaphore[][] semaforosFerrari = new Semaphore[7][];
  private Semaphore[][] semaforosMclaren = new Semaphore[6][];
  private Semaphore[][] semaforosLambo = new Semaphore[7][];
  private Semaphore[][] semaforosBmw = new Semaphore[6][];
  private Semaphore[][] semaforosBugatti = new Semaphore[7][];
  private Semaphore[][] semaforosGtr = new Semaphore[7][];
  private Semaphore[][] semaforosMercedes = new Semaphore[7][];
  
  //funcao para iniciar todos os semaforos
  //os semaforos de carros que comecam em regiao critica devem ser iniciados com 0
  private void iniciarSemaforos(){
    for(int i = 0; i < semaforos0e1.length; i++){
      semaforos0e1[i] = new Semaphore(1);
      if(i == 0){
        semaforos0e1[i] = new Semaphore(0);//Carro 0 comeca na zona critica com o 1
      }
    }
    for(int i = 0; i < semaforos0e2.length; i++){
      semaforos0e2[i] = new Semaphore(1);
      if(i == 0){
        semaforos0e2[i] = new Semaphore(0);//Carro 0 comeca na zona critica com o 2
      }
    }
    for(int i = 0; i < semaforos0e3.length; i++){
      semaforos0e3[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos0e4.length; i++){
      semaforos0e4[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos0e5.length; i++){
      semaforos0e5[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos0e6.length; i++){
      semaforos0e6[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos0e7.length; i++){
      semaforos0e7[i] = new Semaphore(1);
      if(i == 0){
        semaforos0e7[i] = new Semaphore(0);//Carro 1 comeca na zona critica com o 7
      }
    }
    for(int i = 0; i < semaforos1e2.length; i++){
      semaforos1e2[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos1e3.length; i++){
      semaforos1e3[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos1e4.length; i++){
      semaforos1e4[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos1e5.length; i++){
      semaforos1e5[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos1e6.length; i++){
      semaforos1e6[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos1e7.length; i++){
      semaforos1e7[i] = new Semaphore(1);
      if(i == 1){
        semaforos1e7[i] = new Semaphore(0);//Carro 7 comeca na zona critica com o 1
      }
    }
    for(int i = 0; i < semaforos2e3.length; i++){
      semaforos2e3[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos2e5.length; i++){
      semaforos2e5[i] = new Semaphore(1);
      if(i == 0){
        semaforos2e5[i] = new Semaphore(0);//Carro 2 comeca na zona critica com o 5
      }
    }
    for(int i = 0; i < semaforos2e6.length; i++){
      semaforos2e6[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos2e7.length; i++){
      semaforos2e7[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos3e4.length; i++){
      semaforos3e4[i] = new Semaphore(1);
      if(i == 0){
        semaforos3e4[i] = new Semaphore(0);//Carro 4 comeca na zona critica com o 3
      }
    }
    for(int i = 0; i < semaforos3e5.length; i++){
      semaforos3e5[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos3e6.length; i++){
      semaforos3e6[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos3e7.length; i++){
      semaforos3e7[i] = new Semaphore(1);
      if(i == 0){
        semaforos3e7[i] = new Semaphore(0);//Carro 3 comeca na zona critica com o 7
      }
    }
    for(int i = 0; i < semaforos4e5.length; i++){
      semaforos4e5[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos4e6.length; i++){
      semaforos4e6[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos4e7.length; i++){
      semaforos4e7[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos5e6.length; i++){
      semaforos5e6[i] = new Semaphore(1);
      if(i == 0){
        semaforos5e6[i] = new Semaphore(0);//Carro 5 comeca na zona critica com o 6
      }
    }
    for(int i = 0; i < semaforos5e7.length; i++){
      semaforos5e7[i] = new Semaphore(1);
    }
    for(int i = 0; i < semaforos6e7.length; i++){
      semaforos6e7[i] = new Semaphore(1);
    }

    semaforosUno[0] = semaforos0e1;//ferrari
    semaforosUno[1] = semaforos0e2;//mclaren
    semaforosUno[2] = semaforos0e3;//lambo
    semaforosUno[3] = semaforos0e4;//bmw
    semaforosUno[4] = semaforos0e5;//bugatti
    semaforosUno[5] = semaforos0e6;//gtr
    semaforosUno[6] = semaforos0e7;//mercedes

    semaforosFerrari[0] = semaforos0e1;//uno
    semaforosFerrari[1] = semaforos1e2;//mclaren
    semaforosFerrari[2] = semaforos1e3;//lambo
    semaforosFerrari[3] = semaforos1e4;//bmw
    semaforosFerrari[4] = semaforos1e5;//bugatti
    semaforosFerrari[5] = semaforos1e6;//gtr
    semaforosFerrari[6] = semaforos1e7;//mercedes

    semaforosMclaren[0] = semaforos0e2;//uno
    semaforosMclaren[1] = semaforos1e2;//ferrari
    semaforosMclaren[2] = semaforos2e3;//lambo
    semaforosMclaren[3] = semaforos2e5;//bugatti
    semaforosMclaren[4] = semaforos2e6;//gtr
    semaforosMclaren[5] = semaforos2e7;//mercedes

    semaforosLambo[0] = semaforos0e3;//uno
    semaforosLambo[1] = semaforos1e3;//ferrari
    semaforosLambo[2] = semaforos2e3;//mclaren
    semaforosLambo[3] = semaforos3e4;//bmw
    semaforosLambo[4] = semaforos3e5;//bugatti
    semaforosLambo[5] = semaforos3e6;//gtr
    semaforosLambo[6] = semaforos3e7;//mercedes

    semaforosBmw[0] = semaforos0e4;//uno
    semaforosBmw[1] = semaforos1e4;//ferrari
    semaforosBmw[2] = semaforos3e4;//lambo
    semaforosBmw[3] = semaforos4e5;//bugatti
    semaforosBmw[4] = semaforos4e6;//gtr
    semaforosBmw[5] = semaforos4e7;//mercedes

    semaforosBugatti[0] = semaforos0e5;//uno
    semaforosBugatti[1] = semaforos1e5;//ferrari
    semaforosBugatti[2] = semaforos2e5;//mclaren
    semaforosBugatti[3] = semaforos3e5;//lambo
    semaforosBugatti[4] = semaforos4e5;//bmw
    semaforosBugatti[5] = semaforos5e6;//gtr
    semaforosBugatti[6] = semaforos5e7;//mercedes

    semaforosGtr[0] = semaforos0e6;//uno
    semaforosGtr[1] = semaforos1e6;//ferrari
    semaforosGtr[2] = semaforos2e6;//mclaren
    semaforosGtr[3] = semaforos3e6;//lambo
    semaforosGtr[4] = semaforos4e6;//bmw
    semaforosGtr[5] = semaforos5e6;//bugatti
    semaforosGtr[6] = semaforos6e7;//mercedes

    semaforosMercedes[0] = semaforos0e7;//uno
    semaforosMercedes[1] = semaforos1e7;//ferrari
    semaforosMercedes[2] = semaforos2e7;//mclaren
    semaforosMercedes[3] = semaforos3e7;//lambo
    semaforosMercedes[4] = semaforos4e7;//bmw
    semaforosMercedes[5] = semaforos5e7;//bugatti
    semaforosMercedes[6] = semaforos6e7;//gtr
  }

  //funcao para inicializar o programa
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //inicializa os semaforos
    iniciarSemaforos();

    //seta os trajetos como nao visiveis
    unoTrackImage.setVisible(false);
    ferrariTrackImage.setVisible(false); 
    mclarenTrackImage.setVisible(false);
    lamboTrackImage.setVisible(false);
    bmwTrackImage.setVisible(false);
    bugattiTrackImage.setVisible(false);
    gtrTrackImage.setVisible(false);
    mercedesTrackImage.setVisible(false);
    
    //seta as velocidades iniciais dos carros
    sliderUno.setValue(50);
    sliderFerrari.setValue(50);
    sliderMcLaren.setValue(50);
    sliderLambo.setValue(50);
    sliderBMW.setValue(50);
    sliderBugatti.setValue(50);
    sliderGTR.setValue(50);
    sliderMercedes.setValue(50);
    
    //cria as instancias dos carros
    uno = new Carro(0, unoImage, sliderUno, unoComandos, semaforosUno);
    ferrari = new Carro(1, ferrariImage, sliderFerrari, ferrariComandos, semaforosFerrari);
    mclaren = new Carro(2, mcLarenImage, sliderMcLaren, mclarenComandos, semaforosMclaren);
    lambo = new Carro(3, lamboImage, sliderLambo, lamboComandos, semaforosLambo);
    bmw = new Carro(4, bmwImage, sliderBMW, bmwComandos, semaforosBmw);
    bugatti = new Carro(5, bugattiImage, sliderBugatti, bugattiComandos, semaforosBugatti);
    gtr = new Carro(6, gtrImage, sliderGTR, gtrComandos, semaforosGtr);
    mercedes = new Carro(7, mercedesImage, sliderMercedes, mercedesComandos, semaforosMercedes);

    //inicia as threads
    uno.start();
    ferrari.start();
    mclaren.start();
    lambo.start();
    bmw.start();
    bugatti.start();
    gtr.start();
    mercedes.start();
  }

  @FXML
  private ImageView resetButton;
  //funcao para resetar o programa
  @FXML
  void resetAll(MouseEvent event) {
    //finaliza as threads
    uno.finalizar();
    ferrari.finalizar();
    mclaren.finalizar();
    lambo.finalizar();
    bmw.finalizar();
    bugatti.finalizar();
    gtr.finalizar();
    mercedes.finalizar();
    
    //deixa os trajetos nao visiveis
    unoTrackImage.setVisible(false);
    ferrariTrackImage.setVisible(false); 
    mclarenTrackImage.setVisible(false);
    lamboTrackImage.setVisible(false);
    bmwTrackImage.setVisible(false);
    bugattiTrackImage.setVisible(false);
    gtrTrackImage.setVisible(false);
    mercedesTrackImage.setVisible(false);

    //reseta a imagem para o botao de mostrar trajeto
    unoTrackButton.setImage(new Image("/img/showTrackButton.png"));
    ferrariTrackButton.setImage(new Image("/img/showTrackButton.png"));
    mcLarenTrackButton.setImage(new Image("/img/showTrackButton.png"));
    lamboTrackButton.setImage(new Image("/img/showTrackButton.png"));
    bmwTrackButton.setImage(new Image("/img/showTrackButton.png"));
    bugattiTrackButton.setImage(new Image("/img/showTrackButton.png"));
    gtrTrackButton.setImage(new Image("/img/showTrackButton.png"));
    mercedesTrackButton.setImage(new Image("/img/showTrackButton.png"));
    
    //reseta as velocidades para a inicial
    sliderUno.setValue(50);
    sliderFerrari.setValue(50);
    sliderMcLaren.setValue(50);
    sliderLambo.setValue(50);
    sliderBMW.setValue(50);
    sliderBugatti.setValue(50);
    sliderGTR.setValue(50);
    sliderMercedes.setValue(50);

    //reseta a imagem para o botao de pausa
    unoPauseButton.setImage(new Image("/img/pauseButton.png"));
    ferrariPauseButton.setImage(new Image("/img/pauseButton.png"));
    mcLarenPauseButton.setImage(new Image("/img/pauseButton.png"));
    lamboPauseButton.setImage(new Image("/img/pauseButton.png"));
    bmwPauseButton.setImage(new Image("/img/pauseButton.png"));
    bugattiPauseButton.setImage(new Image("/img/pauseButton.png"));
    gtrPauseButton.setImage(new Image("/img/pauseButton.png"));
    mercedesPauseButton.setImage(new Image("/img/pauseButton.png"));

    //inicia todos os semaforos novamnete
    iniciarSemaforos();
    
    //cria novas instancias de cada thread
    uno = new Carro(0, unoImage, sliderUno, unoComandos, semaforosUno);
    ferrari = new Carro(1, ferrariImage, sliderFerrari, ferrariComandos, semaforosFerrari);
    mclaren = new Carro(2, mcLarenImage, sliderMcLaren, mclarenComandos, semaforosMclaren);
    lambo = new Carro(3, lamboImage, sliderLambo, lamboComandos, semaforosLambo);
    bmw = new Carro(4, bmwImage, sliderBMW, bmwComandos, semaforosBmw);
    bugatti = new Carro(5, bugattiImage, sliderBugatti, bugattiComandos, semaforosBugatti);
    gtr = new Carro(6, gtrImage, sliderGTR, gtrComandos, semaforosGtr);
    mercedes = new Carro(7, mercedesImage, sliderMercedes, mercedesComandos, semaforosMercedes);
    
    //inicia as novas threads
    uno.start();
    ferrari.start();
    mclaren.start();
    lambo.start();
    bmw.start();
    bugatti.start();
    gtr.start();
    mercedes.start();
  }
}
