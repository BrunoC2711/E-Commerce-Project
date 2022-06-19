<%-- 
    Document   : index
    Author     : bruno
--%>

<%@page import="BackendECommerce.carrinho.model.CarrinhoCompraItem"%>
<%@page import="BackendECommerce.produto.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SMD E-commerce</title>
    </head>
    <body>
        <h1>SMD E-commerce</h1>
        <% if (request.getAttribute("mensagem") != null) {%>
        <hr/>
        <div><%= request.getAttribute("mensagem")%></div>
        <% } %>
        <hr/>
        <h3>Identificação do Cliente</h3>
        <form action="LoginCliente" method="post">
            <input type="text" name="login" placeholder="Entre com seu login de cliente" /><br/>
            <input type="password" name="senha" placeholder="Entre com sua senha de cliente" /><br/>
            <input type="submit" value="Entrar" />
        </form>
        <a href="novoCliente.jsp">Novo Cliente</a>
        <hr/>
        <h3>Produtos Disponíveis</h3>
        <%
            List<Produto> produtosDisponiveis = (List<Produto>) request.getAttribute("produtosDisponiveis");
            if (produtosDisponiveis == null || produtosDisponiveis.size() == 0) {
        %>
        <div>Não existem produtos disponíveis</div>
        <%
        } else {
            for (int i = 0; i < produtosDisponiveis.size(); i++) {
                Produto p = produtosDisponiveis.get(i);
        %>
        <div>Descrição: <%= p.getDescricao()%></div>
        <div>Preço: <%= p.getPreco()%></div>
        <div>Quantidade: <%= p.getQuantidade()%></div>
        <div><a href="AdicionarProdutoCarrinhoCompra?produtoId=<%= p.getId()%>">Adicionar ao Carrinho de Compras</a></div>
            <%
                        if (i < produtosDisponiveis.size() - 1) {
                            out.println("<br/>");
                        }
                    }
                }
            %>
        <hr/>
        <h3>Carrinho de Compras</h3>
        <%
            List<CarrinhoCompraItem> carrinhoCompraItens = (List<CarrinhoCompraItem>) request.getAttribute("carrinhoCompraItens");
            if (carrinhoCompraItens == null || carrinhoCompraItens.size() == 0) {
        %>
        <div>Não existem produtos no seu carrinho compras</div>
        <%
        } else {
            double total = 0;
            for (int i = 0; i < carrinhoCompraItens.size(); i++) {
                CarrinhoCompraItem carrinhoCompraItem = carrinhoCompraItens.get(i);
        %>
        <div>Descrição: <%= carrinhoCompraItem.getProduto().getDescricao()%></div>
        <div>Preço: <%= carrinhoCompraItem.getProduto().getPreco()%></div>
        <div>Quantidade: <%= carrinhoCompraItem.getQuantidade()%></div>
        <div><a href="RemoverProdutoCarrinhoCompra?produtoId=<%= carrinhoCompraItem.getProduto().getId()%>">Remover do Carrinho de Compras</a></div>
        <%
                total += carrinhoCompraItem.getProduto().getPreco() * carrinhoCompraItem.getQuantidade();
                if (i < carrinhoCompraItens.size() - 1) {
                    out.println("<br/>");
                }
            }
        %>
        <br/>
        <div>Total R$ <%= total%></div>
        <%
            }
        %>

    </body>
</html>
