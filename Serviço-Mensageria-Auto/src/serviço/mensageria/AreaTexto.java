/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço.mensageria;

import javafx.scene.control.TextArea;

/**
 *
 * @author Alipio
 */
public class AreaTexto {

        TextArea text = new TextArea();

    public static AreaTexto _instanceText;

    public static AreaTexto Instancia() {
        if (_instanceText == null) {
            _instanceText = new AreaTexto();
            _instanceText.AjustaAreaTexto();

        }
        return _instanceText;
    }

    public void AjustaAreaTexto() {
        text.setPrefHeight(300);
        text.setPrefWidth(300);
        text.setEditable(false);
        text.autosize();
    }
    
    public TextArea getAreaTexto(){
        return text;
    }
    
    public void AdicionarTexto(String texto){
        text.appendText(texto);
    }
    

}
