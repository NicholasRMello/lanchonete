/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.nicholas.lanchonete;

import br.com.nicholas.lanchonete.controller.Banco;
import br.com.nicholas.lanchonete.model.Lanche;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
public class Lanchonete {

    public static void main(String[] args) {
        Banco b = new Banco();
        Connection conexao = b.conectar();
        
        Lanche l = new Lanche("Café Gelado", 9.90);
        
        b.salvar(l, conexao);
        
    }
}
