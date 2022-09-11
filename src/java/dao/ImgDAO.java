/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import model.Img;
import util.Conexao;

/**
 *
 * @author Meu_PC
 */
public class ImgDAO {
    private Connection conexao;
    
        public ImgDAO() throws ClassNotFoundException, SQLException {
        conexao = Conexao.abrirConexao();
    }
    public void Cadastra(String imagem, String nomeImg) throws SQLException{
         String sql = "insert INTO cadastroImg(codigo, imagem, nomeImg) values (default, ?, ?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, imagem);
            stmt.setString(2, nomeImg);
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao cadastrar imagem");
        } 
        Conexao.encerrarConexao(conexao, stmt);
    }
    

    public Object acharImage(int codigo) throws SQLException {
        String sql = "select * from cadastroImg where codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Img img = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                img = new Img(rs.getInt("codigo"), rs.getString("imagem"), rs.getString("nomeImg"));
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao encontrar a imagem");
        } finally {
            Conexao.encerrarConexao(conexao, stmt, rs);
        }
        return img;

    }
}
