package Projeto_Raizen;

/**
 *
 * @author BrunoVM
 */


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteDeClasse{
    public static void main(String[] args) throws SQLException {
        CategoriaDAOTeste catDAOT = new CategoriaDAOTeste();
            catDAOT.inserir("navio");
            CategoriaTeste p;
            try {
                p = catDAOT.obter(3);
                System.out.println(p.getDescricao());
            } catch (SQLException ex) {
                Logger.getLogger(TesteDeClasse.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
}

