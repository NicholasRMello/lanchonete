package br.com.nicholas.lanchonete.controller;

import br.com.nicholas.lanchonete.model.Lanche;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

public class Banco {
    private String url;
    private String usuario;
    private String senha;

    public Banco() {
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "senha123";

       
    }

    public Connection conectar() {
        try {
            url = "jdbc:mysql://localhost:3306/lanchonete";
            usuario = "root";
            senha = "senha123";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão com banco de dados estabelecida com sucesso!");

            return conexao;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar no banco de dados!");
            e.printStackTrace();
            return null;
        }
    }

    public void salvar(String nome, double preco, Connection conexao) {
        String sql = "INSERT INTO lanche (nome, preco) VALUES(?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setDouble(2, preco);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Lanche foi salvo com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Lanche NÃO foi salvo no banco de dados!");
            e.printStackTrace();
        }
    }

    public void inicializarBanco() {
        url = "jdbc:mysql://localhost:3306";
        usuario = "root";
        senha = "senha123";
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement()) {

            InputStream is = getClass().getClassLoader().getResourceAsStream("banco.sql");
            if (is == null) {
                System.out.println("Arquivo banco.sql não encontrado no classpath!");
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String linha;
            StringBuilder sql = new StringBuilder();

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                sql.append(linha).append("\n");

                if (linha.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0);
                }
            }

            System.out.println("Banco inicializado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados no método inicializarBanco");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo banco.sql");
            e.printStackTrace();
        }
    }
}



 
    
