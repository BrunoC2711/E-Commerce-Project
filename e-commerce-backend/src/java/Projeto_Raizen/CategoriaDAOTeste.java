package Projeto_Raizen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOTeste {
    
    public List<CategoriaTeste> obterTodas() throws SQLException {
        List<CategoriaTeste> resultado = new ArrayList<CategoriaTeste>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, descricao FROM categoria");
            while (resultSet.next()) {
                CategoriaTeste p = new CategoriaTeste();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
                resultado.add(p);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        return resultado;
    }

    public CategoriaTeste obter(int id) throws SQLException {
        CategoriaTeste p = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao FROM categoria WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new CategoriaTeste();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (p == null) {
            throw new SQLException("Registro não encontrado");
        }
        return p;
    }

    public void inserir(String descricao) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categoria (descricao) VALUES (?)");
            preparedStatement.setString(1, descricao);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro não foi inserido com sucesso");
        }
    }

    public void atualizar(String descricao, int id) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categoria SET descricao = ? WHERE id = ?");
            preparedStatement.setString(1, descricao);
            preparedStatement.setInt(2, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro não foi atualizado com sucesso");
        }
    }

    public void remover(int id) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro não foi removido com sucesso");
        }
    }

}
