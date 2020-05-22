/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço.mensageria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alipio
 */
public class ThreadGestaoMensagemAuditoria extends Thread {    
    @Override
    public void run(){
    try{
        //while(true){
        while(FilaSingleton.LigaThread){
        if (FilaSingleton.Instancia().StatusFila() != 0){            
            System.out.println(FilaSingleton.Instancia().ConsumirMensagem());            
        }
        else{
            System.out.println(".........");
        }
        
        Thread.sleep(1000);
        }
    }catch (InterruptedException ex) {
            Logger.getLogger(ThreadGestaoMensagemAuditoria.class.getName()).log(
                    Level.SEVERE, null, ex);
    }
}
    
}

    