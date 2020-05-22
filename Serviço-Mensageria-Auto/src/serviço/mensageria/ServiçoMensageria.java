/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço.mensageria;

import java.time.Instant;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

/**
 *
 * @author Alipio
 */
public class ServiçoMensageria extends Application {

    @Override
    public void start(Stage tela) throws InterruptedException {

        FilaSingleton.Instancia().AtivarThread();

// <editor-fold defaultstate="collapsed" desc="Criando Elementos da Tela">
        
 //       TextArea text = new TextArea();
//        text.setPrefHeight(300);  
//        text.setPrefWidth(300); 
//        text.setEditable(false);
//        text.appendText(Instant.now().toString());

        
  //      text.autosize();
        VBox vb = new VBox(10);
        
        vb.getChildren().add(AreaTexto.Instancia().getAreaTexto());
        Scene scene = new Scene(vb, 300, 300);
        tela.setTitle("Serviço de Mensageria");
        tela.setScene(scene);
        tela.show();

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Eventos dos Botões">
        //Ajustando evento do Botão de Email        
        /* btnEmail.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.printf("%s - Email Enviado!\n", Instant.now().toString());
                FilaSingleton.Instancia().EnvioMensagem(Instant.now().toString() + " - Email Recebido!");

            }
        });

        //Ajustando evento do Botão de Pedido
        btnPedido.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.printf("%s - Pedido Enviado!\n", Instant.now().toString());
                FilaSingleton.Instancia().EnvioMensagem(Instant.now().toString() + " - Pedido Recebido!");
                //System.out.println(FilaSingleton.Instancia().ConsumirMensagem());

            }
        });*/
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Evento fechar a Tela">
        tela.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                t.consume();
                // Coloque aqui o código a ser executado ao fechar o sistema.
                FilaSingleton.Instancia().DesativarThread();
                tela.close();
                Platform.exit();
                System.exit(0);

            }
        });
        // </editor-fold>
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
