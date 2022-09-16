<%@page import="dao.ImgDAO" %>
<%@page import="model.Img" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <!<!-- Essa parte e responsavel por recuperar a imagem apartir do caminho de contexto, com o nome da imagem -->
              <img src="<%= (String) request.getContextPath() + "/imagens/" + request.getAttribute("img") %>"/>
        
            <form action="RecuperarImagem" method="post">
                <label for="codigo">Código da imagem:</label>
                 <input class="form-control" type="text" id="codigo" name="codigo"/>
                <button class="btn btn-success" type="submit">Pesquisar imagem</button>
        </form>
                
            <a href="index.jsp">Voltar</a>
    </body>
</html>
