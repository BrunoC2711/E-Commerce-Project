package BackendECommerce.categoria.model;

import java.io.Serializable;

/**
 *
 * @author BrunoVM
 */
public class Categoria implements Serializable{
    private Integer id;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String toJSON() {
    String json = "";
    json += "{";
        json += "\"id\":" + id + ", ";
        json += "\"descricao\":\"" + descricao + "\"";
    json += "}";
    return json;
    }
}


