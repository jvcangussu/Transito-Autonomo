/* ***************************************************************
* Autor............: Joao Vitor Cangussu B Oliveira
* Matricula........: 202210559
* Inicio...........: 18/11/2023
* Ultima alteracao.: 03/12/2023
* Nome.............: Carro
* Funcao...........: Classe que simulara um carro do transito autonomo
*************************************************************** */
package threads;

import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class Carro extends Thread {
  //atributos
  private int id;
  private ImageView imagem;
  private Slider sliderVelocidade;
  private boolean pausado = false;
  private boolean finalizado = false;
  private String[] comandos;
  private Semaphore[][] semaforos;

  //construtor
  public Carro(int id, ImageView imagem, Slider sliderVelocidade, String[] comandos, Semaphore[][] semaforos){
    setDaemon(true);//comando para a thread finalizar quando o programa for fechado
    this.id = id;
    this.imagem = imagem;
    this.sliderVelocidade = sliderVelocidade;
    this.comandos = comandos;
    this.semaforos = semaforos;
    setPosicaoInicial();
  }
  
  //metodo run da thread
  @Override
  public void run(){
    while(true){
      movimentoCarros();
      if(finalizado){
        break;
      }
    }
  }

  //metodo para movimentacao dos carros
  //o movimento de um carro funciona atraves da iteracao em um array de comandos proprio para cada carro
  public void movimentoCarros(){
    try{
      //o primeiro for eh chamado quando o carro esta no inicio de uma rua
      for(int comando = 0; comando < comandos.length; comando++){
        if(finalizado){
          break;
        }
        //quando o carro esta no inicio de uma rua ele pode dar up em semaforos necessarios ou ir para o final da rua
        switch(comandos[comando].charAt(0)){
          case 'e':{//caso o movimento for para a esquerda
            moveEsquerda(44);
            for(int proxComando = comando + 1; proxComando < comandos.length; proxComando++){//o proximo for acontece quando o carro esta no final de uma rua
              if(finalizado){
                  break;
              }
              if(comandos[proxComando].charAt(0) == 'a'){//se o proximo comando comeca com a o carro deve dar down em um semaforo
                int carro = Character.getNumericValue(comandos[proxComando].charAt(2));
                int semaforo = Character.getNumericValue(comandos[proxComando].charAt(4));
                semaforos[carro][semaforo].acquire();
              }
              //as proximas condicoes testam a direcao da proxima rua e movem o carro ate o inicio dela
              //apos o carro voltar para o inicio de uma rua o primeiro for eh chamado novamente
              if(comandos[proxComando].charAt(0) == 'e'){//caso a proxima rua for para esquerda
                moveEsquerda(74);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'b'){//caso a proxima rua for para baixo
                moveEsquerda(37);
                moveBaixo(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'c'){//caso a proxima rua for para cima
                moveEsquerda(37);
                moveCima(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'f'){//caso o proximo movimento for o final eh comparado com a primeira rua do movimento
                if(comandos[0].charAt(0) == 'e'){
                  moveEsquerda(74);
                  break;
                }
                if(comandos[0].charAt(0) == 'b'){
                  moveEsquerda(37);
                  moveBaixo(37);
                  break;
                }
                if(comandos[0].charAt(0) == 'c'){
                  moveEsquerda(37);
                  moveCima(37);
                  break;
                }
              }
            }
            break;
          }
          case 'b':{//caso o movimento for para baixo
            moveBaixo(44);
            for(int proxComando = comando + 1; proxComando < comandos.length; proxComando++){
              if(finalizado){
                  break;
              }
              if(comandos[proxComando].charAt(0) == 'a'){
                int carro = Character.getNumericValue(comandos[proxComando].charAt(2));
                int semaforo = Character.getNumericValue(comandos[proxComando].charAt(4));
                semaforos[carro][semaforo].acquire();
              }
              if(comandos[proxComando].charAt(0) == 'e'){
                moveBaixo(37);
                moveEsquerda(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'd'){
                moveBaixo(37);
                moveDireita(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'b'){
                moveBaixo(74);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'f'){
                if(comandos[0].charAt(0) == 'e'){
                  moveBaixo(37);
                  moveEsquerda(37);
                  break;
                }
                if(comandos[0].charAt(0) == 'd'){
                  moveBaixo(37);
                  moveDireita(37);
                  break;
                }
                if(comandos[0].charAt(0) == 'b'){
                  moveBaixo(74);
                  break;
                }
              }
            }
            break;
          }
          case 'd':{//caso o movimento for para a direita
            moveDireita(44);
            for(int proxComando = comando + 1; proxComando < comandos.length; proxComando++){
              if(finalizado){
                  break;
              }
              if(comandos[proxComando].charAt(0) == 'a'){
                int carro = Character.getNumericValue(comandos[proxComando].charAt(2));
                int semaforo = Character.getNumericValue(comandos[proxComando].charAt(4));
                semaforos[carro][semaforo].acquire();
              }
              if(comandos[proxComando].charAt(0) == 'd'){
                moveDireita(74);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'b'){
                moveDireita(37);
                moveBaixo(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'c'){
                moveDireita(37);
                moveCima(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'f'){
                if(comandos[0].charAt(0) == 'd'){
                  moveDireita(74);
                  break;
                }
                if(comandos[0].charAt(0) == 'b'){
                  moveDireita(37);
                  moveBaixo(37);
                  sleep(200);
                  break;
                }
                if(comandos[0].charAt(0) == 'c'){
                  moveDireita(37);
                  moveCima(37);
                  break;
                }
              }
            }
            break;
          }
          case 'c':{//caso o movimento for para cima
            moveCima(44);
            for(int proxComando = comando + 1; proxComando < comandos.length; proxComando++){
              if(finalizado){
                  break;
              }
              if(comandos[proxComando].charAt(0) == 'a'){
                int carro = Character.getNumericValue(comandos[proxComando].charAt(2));
                int semaforo = Character.getNumericValue(comandos[proxComando].charAt(4));
                semaforos[carro][semaforo].acquire();
              }
              if(comandos[proxComando].charAt(0) == 'e'){
                moveCima(37);
                moveEsquerda(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'd'){
                moveCima(37);
                moveDireita(37);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'c'){
                moveCima(74);
                break;
              }
              if(comandos[proxComando].charAt(0) == 'f'){
                if(comandos[0].charAt(0) == 'e'){
                  moveCima(37);
                  moveEsquerda(37);
                  break;
                }
                if(comandos[0].charAt(0) == 'd'){
                  moveCima(37);
                  moveDireita(37);
                  break;
                }
                if(comandos[0].charAt(0) == 'c'){
                  moveCima(74);
                  break;
                }
              }
            }
            break;
          }
          case 'r':{//caso para dar up nos semaforos necessarios
            int carro = Character.getNumericValue(comandos[comando].charAt(2));
            int semaforo = Character.getNumericValue(comandos[comando].charAt(4));
            semaforos[carro][semaforo].release();
            break;
          }
        }
      }
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  //metodo para andar x pixels para cima
  public void moveCima(int pixels){
    Platform.runLater(() -> imagem.setRotate(270));
    for(int i = 0; i < pixels; i++){
      if(finalizado){
        break;
      }
      while(pausado && !finalizado){
        try{
          sleep(1);
        } catch(Exception e){
          e.printStackTrace();
        }
      }
      Platform.runLater(() -> imagem.setLayoutY(imagem.getLayoutY() - 1));
      try{
        int velocidade = (int)sliderVelocidade.getValue();
        sleep(37 - (10 + (velocidade/4)));
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  //metodo para andar x pixels para baixo
  public void moveBaixo(int pixels){
    Platform.runLater(() -> imagem.setRotate(90));
    for(int i = 0; i < pixels; i++){
      if(finalizado){
        break;
      }
      while(pausado && !finalizado){
        try{
          sleep(1);
        } catch(Exception e){
          e.printStackTrace();
        }
      }
      Platform.runLater(() -> imagem.setLayoutY(imagem.getLayoutY() + 1));
      try{
        int velocidade = (int)sliderVelocidade.getValue();
        sleep(37 - (10 + (velocidade/4)));
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  //metodo para andar x pixels para direita
  public void moveDireita(int pixels){
    Platform.runLater(() -> imagem.setRotate(0));
    for(int i = 0; i < pixels; i++){
      if(finalizado){
        break;
      }
      while(pausado && !finalizado){
        try{
          sleep(1);
        } catch(Exception e){
          e.printStackTrace();
        }
      }
      Platform.runLater(() -> imagem.setLayoutX(imagem.getLayoutX() + 1));
      try{
        int velocidade = (int)sliderVelocidade.getValue();
        sleep(37 - (10 + (velocidade/4)));
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  //metodo para andar x pixels para esquerda
  public void moveEsquerda(int pixels){
    Platform.runLater(() -> imagem.setRotate(180));
    for(int i = 0; i < pixels; i++){
      if(finalizado){
        break;
      }
      while(pausado && !finalizado){
        try{
          sleep(1);
        } catch(Exception e){
          e.printStackTrace();
        }
      }
      Platform.runLater(() -> imagem.setLayoutX(imagem.getLayoutX() - 1));
      try{
        int velocidade = (int)sliderVelocidade.getValue();
        sleep(37 - (10 + (velocidade/4)));
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  //metodo de pausa
  public boolean pausarOuDespausar(){
    if(pausado){
      pausado = false;
    } else {
      pausado = true;
    }
    return pausado;
  }

  //metodo para finalizar o run da thread e ela morrer
  public void finalizar(){
    finalizado = true;
  }

  //metodo para colocar um carro em sua posicao inicial
  public void setPosicaoInicial(){
    switch(id){
      case 0:{
        Platform.runLater(() -> imagem.setLayoutX(78));
        Platform.runLater(() -> imagem.setLayoutY(-5));
        Platform.runLater(() -> imagem.setRotate(180));
        break;
      }
      case 1:{
        Platform.runLater(() -> imagem.setLayoutX(550));
        Platform.runLater(() -> imagem.setLayoutY(115));
        Platform.runLater(() -> imagem.setRotate(180));
        break;
      }
      case 2:{
        Platform.runLater(() -> imagem.setLayoutX(233));
        Platform.runLater(() -> imagem.setLayoutY(433));
        Platform.runLater(() -> imagem.setRotate(270));
        break;
      }
      case 3:{
        Platform.runLater(() -> imagem.setLayoutX(115));
        Platform.runLater(() -> imagem.setLayoutY(271));
        Platform.runLater(() -> imagem.setRotate(90));
        break;
      }
      case 4:{
        Platform.runLater(() -> imagem.setLayoutX(351));
        Platform.runLater(() -> imagem.setLayoutY(507));
        Platform.runLater(() -> imagem.setRotate(90));
        break;
      }
      case 5:{
        Platform.runLater(() -> imagem.setLayoutX(469));
        Platform.runLater(() -> imagem.setLayoutY(78));
        Platform.runLater(() -> imagem.setRotate(270));
        break;
      }
      case 6:{
        Platform.runLater(() -> imagem.setLayoutX(550));
        Platform.runLater(() -> imagem.setLayoutY(352));
        Platform.runLater(() -> imagem.setRotate(180));
        break;
      }
      case 7:{
        Platform.runLater(() -> imagem.setLayoutX(152));
        Platform.runLater(() -> imagem.setLayoutY(233));
        Platform.runLater(() -> imagem.setRotate(0));
        break;
      }
    }
  }
}
