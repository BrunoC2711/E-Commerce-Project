package BackendECommerce.usuario.model;

import java.io.Serializable;

/**
 *
 * @author BrunoVM
 */
public class Usuario implements Serializable{
    private Integer id;
    private String email;
    private String nome;
    private String endereco;
    private String login;
    private String senha;
    private String foto;
    private Boolean perfil_admin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getPerfil_admin() {
        return perfil_admin;
    }

    public void setPerfil_admin(Boolean perfil_admin) {
        this.perfil_admin = perfil_admin;
    }
    public String toJSON() {
    String json = "";
    json += "{";
        json += "\"id\":" + id + ", ";
        json += "\"perfil_admin\":\"" + perfil_admin + "\", ";
        json += "\"email\":\"" + email + "\", ";
        json += "\"nome\":\"" + nome + "\", ";
        json += "\"endereco\":\"" + endereco + "\", ";
        json += "\"foto\":\"" + foto + "\", ";
        json += "\"login\":\"" + login + "\", ";
        json += "\"senha\":\"" + senha + "\"";
    json += "}";
    return json;
    }
}
