<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html;charset=euc-kr" %>

<%@page import="com.roadmap.domain.User"%>

<%
	String userEmail = "아이디입력";
	String password = "패스워등입력";
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// Command Object 동작 방식을 이해를 위한...
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
		[ ■  info ] :: ${ requestScope.message } <br/><br/>
		
		<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////-->
		<!-- /// referenceData() Method 동작 방식 이해를 위한...-->
		<hr/>
		 <h3>${ requestScope.referenceDataMap.message01 }</h3>
		 <h5>${ referenceDataMap.message02 }</h5>
		 <hr><hr/>
		 <h3>${ requestScope.referenceDataList[0] }</h3>
		 <h5>${ referenceDataList[1] }</h5>
		 <hr/>
		<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////////-->
		
		<form  method="post" action="logonAction.do">

			아  이  디 : <input type="text" name="userId" value="<%= userEmail %>"><br/><br/>
			패스워드 : <input type="text" name="password" value="<%= password %>"><br/><br/>
			<input type="submit" name="submit" value="Enter"/>

		</form>
		
		<a href = "test01.do?abc=1&amp;def=test">/test01.do?abc=1&amp;def=test</a><br/><br/>
		<a href = "test01.do?abc=1">/test01.do?abc=1</a> error 발생 함.<br/><br/>
		<a href = "test02.do?abc=2">/test02.do?abc=2</a><br/><br/>
		<a href = "test02.do">/test02.do</a> error 발생 함. <br/><br/>
		<a href = "test03.do">/test03.do</a><br/><br/>
		
	</body>
</html>