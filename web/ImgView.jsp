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
        <h1>Era pra ter uma imagen aqui</h1>

        <h1 value="${img.nomeImg}"></h1>
        
<!--   Isso recupera a imagem pelo caminho que a aplicação roda, porem tem que colocar o nome da imagem
<img src="<%= (String) request.getContextPath() + "/images/c.png" %>" />-->
        
        
        
        <img src="<%= (String) request.getContextPath() + "/images" + "/${img.nomeImg}"%>"/>
        
            <label for="codigo">Código:</label>
            <input class="form-control" type="text" id="codigo" name="codigo" readonly value="${img.imagem}"/>
                
            <a href="index.jsp">Voltar</a>
    </body>
</html>
