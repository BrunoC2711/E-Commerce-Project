package BackendECommerce.usuario.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BrunoVM
 */
public class UsuarioDAO {
        /**
     * Método utilizado para obter todos os usuários
     *
     * @return
     * @throws Exception
     */
    public List<Usuario> obterUsuarios() throws Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, email, login, senha, perfil_admin, foto FROM usuario");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEndereco(resultSet.getString("endereco"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPerfil_admin(resultSet.getBoolean("perfil_admin"));
            usuarios.add(usuario);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (usuarios.isEmpty()) {
            throw new Exception("Usuario não encontrado");
        }
        return usuarios;
    }
    /**
     * Método utilizado para obter um usuário pelo seu identificador
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Usuario obter(int id) throws Exception {
        Usuario usuario = null;
        
        Class.forName("org.postgresql.Driver");  
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","admin");
        
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, email, login, senha, perfil_admin, foto FROM usuario WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEndereco(resultSet.getString("endereco"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPerfil_admin(resultSet.getBoolean("perfil_admin"));
            usuario.setFoto(resultSet.getString("foto"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (usuario == null) {
            throw new Exception("Usuário não encontrado");
        }
        return usuario;
    }

    /**
     * Método utilizado para obter um usuário pelo seu login
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Usuario obter(String login) throws Exception {
        Usuario usuario = null;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","admin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, email, login, senha, perfil_admin,foto FROM usuario WHERE login = ?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEndereco(resultSet.getString("endereco"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPerfil_admin(resultSet.getBoolean("perfil_admin"));
            usuario.setFoto(resultSet.getString("foto"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (usuario == null) {
            throw new Exception("Usuário não encontrado");
        }
        return usuario;
    }
    /**
     * Método utilizado para inserir um novo usuário
     * @param nome
     * @param endereco
     * @param email
     * @param login
     * @param senha
     * @param perfil_admin
     * @param foto
     * @throws Exception
     */
    public void inserirUsuario(String nome, String endereco, String email, String login, String senha, boolean perfil_admin, String foto) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db","postgres","admin");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario (nome, endereco, email, login, senha, perfil_admin,foto) VALUES (?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, endereco);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, login);
        preparedStatement.setString(5, senha);
        preparedStatement.setBoolean(6, perfil_admin);
        preparedStatement.setString(7, foto);
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel inserir o usuário");
        }
    }
        public void atualizar(int id, String nome, String endereco, String email, String login, String senha, boolean perfil_admin, String foto) throws Exception {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usuario SET nome = ? , endereco = ?, email = ?, login = ?, senha = ?, perfil_admin = ?, foto = ? WHERE id = ?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, endereco);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, senha);
            preparedStatement.setBoolean(6, perfil_admin);
            preparedStatement.setString(7, foto);
            preparedStatement.setInt(8, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel atualizar o usuario");
        }
    }

    public void remover(int id) throws Exception {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/e-commerce_db", "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        if (resultado != 1) {
            throw new Exception("Não foi possí­vel deletar o usuario");
        }
    }
}
