<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html;charset=euc-kr" %>

<%@page import="com.roadmap.domain.User"%>

<%
	String userEmail = "���̵��Է�";
	String password = "�н������Է�";
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// Command Object ���� ����� ���ظ� ����...
	User user = (User)request.getAttribute("user");
	if(user != null){
		userEmail = user.getUserEmail();
		password = user.getPassword();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
%>

<html>
	<head><title>Logon Page</title></head>
	<body>
		[ ��  info ] :: ${ requestScope.message } <br/><br/>
		
		<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////-->
		<!-- /// referenceData() Method ���� ��� ���ظ� ����...-->
		<hr/>
		 <h3>${ requestScope.referenceDataMap.message01 }</h3>
		 <h5>${ referenceDataMap.message02 }</h5>
		 <hr><hr/>
		 <h3>${ requestScope.referenceDataList[0] }</h3>
		 <h5>${ referenceDataList[1] }</h5>
		 <hr/>
		<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////-->
		
		<form  method="post" action="logonAction.do">

			��  ��  �� : <input type="text" name="userId" value="<%= userEmail %>"><br/><br/>
			�н����� : <input type="text" name="password" value="<%= password %>"><br/><br/>
			<input type="submit" name="submit" value="Enter"/>

		</form>
		
		<a href = "test01.do?abc=1&amp;def=test">/test01.do?abc=1&amp;def=test</a><br/><br/>
		<a href = "test01.do?abc=1">/test01.do?abc=1</a> error �߻� ��.<br/><br/>
		<a href = "test02.do?abc=2">/test02.do?abc=2</a><br/><br/>
		<a href = "test02.do">/test02.do</a> error �߻� ��. <br/><br/>
		<a href = "test03.do">/test03.do</a><br/><br/>
		
	</body>
</html>