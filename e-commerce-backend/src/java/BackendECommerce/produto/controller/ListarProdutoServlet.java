package BackendECommerce.produto.controller;

import BackendECommerce.produto.model.Produto;
import BackendECommerce.produto.model.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author BrunoVM
 *
 * Servlet que implementa a ação de listar todos o produtos, retornando um JSON
 * como resultado da ação.
 */
public class ListarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = null;
        try {
            produtos = produtoDAO.obterProdutos();
        } catch (Exception ex) {
            produtos = new ArrayList<Produto>();
        }
        /* Linhas utilizadas para permitir CORS - Início */
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        /* Linhas utilizadas para permitir CORS - Fim */
        /* Linhas utilizadas para montar e enviar o JSON de retorno do Servlet - Início */
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("[");
            for (int i = 0; i < produtos.size(); i++) {
                out.print(produtos.get(i).toJSON());
                if (i < produtos.size() - 1) {
                    out.print(", ");
                }
            }
            out.print("]");
        }
        /* Linhas utilizadas para montar e enviar o JSON de retorno do Servlet - Fim */
    }

}
