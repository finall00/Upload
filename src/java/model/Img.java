/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

/**
 *
 * @author Meu_PC
 */
public class Img {
    private int codigo;
    private String imagem;
    private String nomeImg; 

    public Img(int codigo, String imagem, String nomeImg) {
        this.codigo = codigo;
        this.imagem = imagem;
        this.nomeImg = nomeImg;
    }

    public Img(File filePath, String nomeImg) {
        this.imagem = imagem;
        this.nomeImg = nomeImg;
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }

    

    
    
    
}
