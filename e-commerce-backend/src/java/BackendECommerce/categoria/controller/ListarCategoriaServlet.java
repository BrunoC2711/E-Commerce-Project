package BackendECommerce.categoria.controller;

import BackendECommerce.categoria.model.Categoria;
import BackendECommerce.categoria.model.CategoriaDAO;
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
 * @author Bruno
 */
public class ListarCategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = null;
        try {
            categorias = categoriaDAO.obterCategorias();
        } catch (Exception ex) {
            categorias = new ArrayList<Categoria>();
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
            for (int i = 0; i < categorias.size(); i++) {
                out.print(categorias.get(i).toJSON());
                if (i < categorias.size() - 1) {
                    out.print(", ");
                }
            }
            out.print("]");
        }
        /* Linhas utilizadas para montar e enviar o JSON de retorno do Servlet - Fim */
    }

}