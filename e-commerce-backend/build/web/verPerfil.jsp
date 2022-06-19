<%-- 
    Document   : verPerfil
    Author     : bruno
--%>
<%@include file="cabecalho.jsp" %>

<h3>Dados do Usu�rio</h3>

<div>Nome:</div>
<div><jsp:getProperty name="usuario" property="nome" /></div>
<div>Endere�o:</div>
<div><jsp:getProperty name="usuario" property="endereco" /></div>
<div>E-mail:</div>
<div><jsp:getProperty name="usuario" property="email" /></div>
<div>Login:</div>
<div><jsp:getProperty name="usuario" property="login" /></div>
<div>Tipo de Usu�rio:</div>
<div><%= usuario.getAdministrador() ? "Administrador" : "Cliente" %></div>

<%@include file="rodape.jsp" %>
