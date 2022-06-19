/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackendECommerce.produto.model;

import java.io.Serializable;

/**
 *
 * @author BrunoVM
 */
public class Produto implements Serializable {
    private Integer id;
    private String descricao;
    private Double preco;
    private String fotos;
    private Integer quantidade;
    private String titulo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String toJSON() {
    String json = "";
    json += "{";
        json += "\"id\":" + id + ", ";
        json += "\"descricao\":\"" + descricao + "\", ";
        json += "\"preco\":" + preco + ", ";
        json += "\"fotos\":\"" + fotos + "\", ";
        json += "\"titulo\":\"" + titulo + "\", ";
        json += "\"quantidade\":" + quantidade;
    json += "}";
    return json;
    }
}
