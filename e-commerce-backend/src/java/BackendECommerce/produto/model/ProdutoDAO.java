package BackendECommerce.produto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BrunoVM
 *
 * Classe que implementa o padrão DAO para a entidade produto
 */
public class ProdutoDAO {
    
    /**
     * Método utilizado para obter todos os produtos
     *
     * @return
     * @throws Exception
     */
    public List<Produto> obterProdutos() throws Exception {
        List<Produto> produtos = new ArrayList<Produto>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, fotos, titulo, preco, quantidade FROM produto");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
           Produto produto = new Produto();
           produto.setId(resultSet.getInt("id"));
           produto.setDescricao(resultSet.getString("descricao"));
           produto.setPreco(resultSet.getDouble("preco"));
           produto.setFotos(resultSet.getString("fotos"));
           produto.setTitulo(resultSet.getString("titulo"));
           produto.setQuantidade(resultSet.getInt("quantidade"));
           produtos.add(produto);
       }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (produtos.isEmpty()) {
            throw new Exception("Produto não encontrado");
        }
        return produtos;
    }


    /**
     * Método utilizado para obter uma lista de produtos disponíveis em estoque
     *
     * @return
     * @throws Exception
     */
    public List<Produto> obterProdutosEmEstoque() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/smdecommerce", "postgres", "admin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, fotos, titulo, preco, quantidade FROM produto WHERE quantidade > 0");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
           Produto produto = new Produto();
           produto.setId(resultSet.getInt("id"));
           produto.setDescricao(resultSet.getString("descricao"));
           produto.setPreco(resultSet.getDouble("preco"));
           produto.setFotos(resultSet.getString("fotos"));
           produto.setTitulo(resultSet.getString("titulo"));
           produto.setQuantidade(resultSet.getInt("quantidade"));
           produtos.add(produto);
       }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (produtos.isEmpty()) {
            throw new Exception("Produto não encontrado");
        }
        return produtos;
    }


    public Produto obter(int id) throws Exception {
        Produto produto = null;
        
        Class.forName("org.postgresql.Driver");  
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","admin");
        
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,titulo,descricao,preco,fotos,quantidade FROM produto WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setFotos(resultSet.getString("fotos"));
            produto.setTitulo(resultSet.getString("titulo"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (produto == null) {
            throw new Exception("Produto não encontrado");
        }
        return produto;
    }

    /**
     * @param titulo
     * @return
     * @throws Exception
     */
    public Produto obter(String titulo) throws Exception {
        Produto produto = null;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","admin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,titulo,descricao,preco,fotos,quantidade FROM produto WHERE titulo = ?");
        preparedStatement.setString(1, titulo);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setFotos(resultSet.getString("fotos"));
            produto.setTitulo(resultSet.getString("titulo"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (produto == null) {
            throw new Exception("Produto não encontrado");
        }
        return produto;
    }

    /**
     * @param descricao
     * @param preco
     * @param fotos
     * @param quantidade

     * @throws Exception
     */
    public void inserir(String descricao, Double preco, String fotos, Integer quantidade,String titulo) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","admin");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (descricao,preco,fotos,quantidade,titulo) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, descricao);
        preparedStatement.setDouble(2, preco);
        preparedStatement.setString(3, fotos);
        preparedStatement.setInt(4, quantidade);
        preparedStatement.setString(5, titulo);
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel inserir o produto");
        }
    }
    public void atualizar(int id, String descricao, Double preco, String fotos, Integer quantidade,String titulo) throws Exception {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao = ? , preco = ?, fotos = ?, quantidade = ?, titulo = ? WHERE id = ?");
            preparedStatement.setString(1, descricao);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setString(3, fotos);
            preparedStatement.setInt(4, quantidade);
            preparedStatement.setString(5, titulo);
            preparedStatement.setInt(6, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel atualizar o produto");
        }
    }

    public void remover(int id) throws Exception {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel deletar o produto");
        }
    }

}
