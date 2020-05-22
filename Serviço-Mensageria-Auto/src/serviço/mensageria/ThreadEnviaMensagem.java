/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço.mensageria;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alipio
 */
public class ThreadEnviaMensagem extends Thread {
    
    private Random sorteio = new Random();
    
    private List<String> mensagem = new ArrayList<>(
            Arrays.asList(new String[] {
                "Email", "Pedido de Compra", "Pedido de Produção"}));
    
    private List<Integer> tempo = new ArrayList<>(
            Arrays.asList(new Integer[] {
                1000,2000,5000,10000}));
    
    
    @Override
    public void run(){
    try{
        //while(true){
        while(FilaSingleton.LigaThread){
        String texto = mensagem.get(sorteio.nextInt(mensagem.size()));
        //System.out.printf("%s - %s\n", Instant.now().toString(), "Enviando " + texto + " ...");
        AreaTexto.Instancia().AdicionarTexto(Instant.now().toString() + " - " + "Enviando " + texto + " ...\n" );
        //FilaSingleton.Instancia().EnvioMensagem(Instant.now().toString() + " - " + texto + " Recebido!");
        Thread.sleep(tempo.get(sorteio.nextInt(tempo.size())));
        FilaSingleton.Instancia().EnvioMensagem(Instant.now().toString() + " - " + texto + " Recebido!");
        }
    }catch (InterruptedException ex) {
            Logger.getLogger(ThreadGestaoMensagemAuditoria.class.getName()).log(
                    Level.SEVERE, null, ex);
    }
}
    
    
}
