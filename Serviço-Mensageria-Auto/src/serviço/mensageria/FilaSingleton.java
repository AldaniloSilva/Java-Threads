/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço.mensageria;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Alipio
 */
public class FilaSingleton {

    ThreadGestaoMensagemAuditoria threadRecebeMensagem;
    ThreadEnviaMensagem threadEnviaMensagem;

    public FilaSingleton(ThreadGestaoMensagemAuditoria threadR, ThreadEnviaMensagem threadM) {
        this.threadRecebeMensagem = threadR;
        this.threadEnviaMensagem = threadM;
    }

    private final static Object OBJETO = new Object();
    public static boolean LigaThread = true;
    public static FilaSingleton _instance;

    public static FilaSingleton Instancia() {
        if (_instance == null) {
            ThreadGestaoMensagemAuditoria threadR = new ThreadGestaoMensagemAuditoria();
            ThreadEnviaMensagem threadM = new ThreadEnviaMensagem();
            _instance = new FilaSingleton(threadR,threadM);
            
        }
        return _instance;
    }

    private final ConcurrentLinkedQueue<String> fila = new ConcurrentLinkedQueue<>();
    //private static String mensagem;

    public void EnvioMensagem(String mensagem) {
        synchronized (OBJETO) {
            this.fila.add(mensagem);
        }
    }

    public String ConsumirMensagem() {
        synchronized (OBJETO) {
            String mensagem = this.fila.remove();
            return mensagem;
        }
    }

    public int StatusFila() {
        synchronized (OBJETO) {
            return this.fila.size();
        }
    }

    public void AtivarThread() throws InterruptedException {
        LigaThread = true;
        threadRecebeMensagem.start();
        threadEnviaMensagem.start();
    }

    public void DesativarThread() {
        try {
            LigaThread = false;
            System.out.println("Finalizando o Programa");
            threadRecebeMensagem.join();
            threadEnviaMensagem.join();

        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }

    }

}
