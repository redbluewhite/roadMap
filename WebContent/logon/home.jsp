<%@ page contentType="text/html;charset=euc-kr" %>

<%@ page import="com.roadmap.domain.User" %>	 

<!-- ////////////////////////////////////////   �� �� ��  �� ��  //////////////////////////////////////////////////////////
	 �� Model2 Web Arch. ���� �� ::  JSP�� View ���� ��..  
	 �� Work Flow Control �κ��� Control �� ���                                                  
     �� �Ʒ��� �ּ� ó�� ������ Control �� ����ϴ� ControlServlet ���� ó��   
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- 	#. �� �α����� ȸ���̸�...	-->
<%	User user = (User)session.getAttribute("user");	%>

<%	//if ( user == null  ||  ! user.isActive() )  { %>
		<%-- <jsp:forward page="logon.jsp" /> --%>
<% //} %>

<!-- 	#. �α����� ȸ���̸�...	-->
<html>
	<head><title>Home Page</title></head>
	<body>
	
	<!-- ///////////// �� �� ��  �� ��(~~Controller �� �����ϴ� Message ���)  ////////////-->
		[ ��  info ] :: ${ requestScope.message } <br/><br/>
	<!-- /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	
		<p>Simple Model2 Examples</p>
		<p> ȯ���մϴ�.  : <%= user.getUserName()%>��</p>
		<br/><br/>
		<a href = "logout.do">logout</a>
		
	</body>
</html>