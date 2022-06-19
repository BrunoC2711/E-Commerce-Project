package BackendECommerce.usuario.controller;

import BackendECommerce.usuario.model.Usuario;
import BackendECommerce.usuario.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author BrunoVM
 *
 * Classe que implementa a ação de login de um usuário do tipo cliente
 */
public class LoginClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        /* processamento */
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = null;
        try {
            usuarios = usuarioDAO.obterUsuarios();
        } catch (Exception ex) {
            usuarios = new ArrayList<Usuario>();
        }
        boolean sucesso = false;
        String mensagem = null;
        try {
            Usuario usuario = usuarioDAO.obter(login);
            if (usuario.getSenha().equals(senha)) {
                sucesso = true;
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
            } else {
                sucesso = false;
                mensagem = "Login ou senha inválida";
            }
        } catch (Exception ex) {
            sucesso = false;
            mensagem = ex.getMessage();
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
