/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.nicholas.lanchonete;

import br.com.nicholas.lanchonete.controller.Banco;
import br.com.nicholas.lanchonete.model.Lanche;
import br.com.nicholas.lanchonete.view.GUIMenu;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
public class Lanchonete {
/*
    public static void main(String[] args) {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
        Lanche l = new Lanche("Café Gelado", 9.90);
        
        b.salvar(l, conexao);
        
    } */
    
    public static void main(String args[]) {
        GUIMenu janelaPrincipal = new GUIMenu();
        Banco b = new Banco();
        b.inicializarBanco();
        b = null;
        

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                janelaPrincipal.setVisible(true);
                janelaPrincipal.getJInternalFrameCadastroLanche().setVisible(false);
            }
        });
    }
}
