package BackendECommerce.venda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author BrunoVM
 */
public class VendaDAO {
    public Venda obter(int id) throws Exception {
        Venda venda = null;
        
        Class.forName("org.postgresql.Driver");  
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","1234");
        
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,data_hora FROM venda WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            venda = new Venda();
            venda.setId(resultSet.getInt("id"));
            venda.setData_hora(resultSet.getString("data_hora"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (venda == null) {
            throw new Exception("Venda não encontrada");
        }
        return venda;
    }

    /**

     * @param titulo

     * @throws Exception
     */
    public void inserir(String titulo) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda (titulo) VALUES (?)");
        preparedStatement.setString(1, titulo);

        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel realizar a venda");
        }
    }
}
