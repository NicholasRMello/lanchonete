/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.nicholas.lanchonete.controller;

import br.com.nicholas.lanchonete.model.Lanche;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
public class Banco {
    private String url;
    private String usuario;
    private String senha;
    
    public Banco() {
        url = "jdbc:mysql://localhost:3306/lanchonete";
        usuario = "root";
        senha = "senha123";
    }
    
    public Connection conectar() {
        try {
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            System.out.println("Conexão com banco de dados estabelecida com sucesso!");
            
            return conexao;
        } catch(SQLException e) {
            
            System.out.println("Não foi possível conectar no banco de dados!");
            return null;
        }
        
    }
    
    public void salvar(Lanche lanche, Connection conexao) {
        String sql = "INSERT INTO lanche (nome, preco) VALUES(?, ?)";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, lanche.getNome());
            stmt.setDouble(2, lanche.getPreco());
            
            int linhaAfetadas = stmt.executeUpdate();
            
            if (linhaAfetadas > 0) {
                System.out.println("Lanche foi salvo com sucesso!");
            }
        } catch(SQLException e) {
            System.out.println("Lanche NÃO foi salvo no banco de dados!");
            
        }
    }
    
}
