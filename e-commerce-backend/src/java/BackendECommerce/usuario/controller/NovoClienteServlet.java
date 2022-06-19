package BackendECommerce.usuario.controller;

import BackendECommerce.usuario.model.Usuario;
import BackendECommerce.usuario.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BrunoVM
 */
public class NovoClienteServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean perfil_admin = false;
        String foto = "/BarbaBranca.jpg";
        /* processamento */
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario novoUsuario = null;
        try {
            usuarioDAO.inserirUsuario(nome, endereco, email, login, senha, perfil_admin,foto);
        } catch (Exception ex) {
            Logger.getLogger(NovoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Usuario> usuarios = null;
        try {
            usuarios = usuarioDAO.obterUsuarios();
        } catch (Exception ex) {
            usuarios = new ArrayList<Usuario>();
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
            for (int i = 0; i < usuarios.size(); i++) {
                out.print(usuarios.get(i).toJSON());
                if (i < usuarios.size() - 1) {
                    out.print(", ");
                }
            }
            out.print("]");
        }
        /* Linhas utilizadas para montar e enviar o JSON de retorno do Servlet - Fim */
    }
}
