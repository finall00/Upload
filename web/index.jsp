<%-- 
    Document   : index
    Created on : 05/09/2022, 19:20:53
    Author     : smili08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
            select File to Upload:<input type="file" name="file" id="file">
            
        <br>
        <input type="submit" value="Upload file" name="upload" id="upload">
        </form>
        <h2>Teste</h2>
        
        <form action="RecuperarImagem" method="post">
                <label for="codigo">Código:</label>
                 <input class="form-control" type="text" id="codigo" name="codigo"/>
                <button class="btn btn-success" type="submit">Pesquisar imagem</button>
        </form>
        
    </body>
</html>
