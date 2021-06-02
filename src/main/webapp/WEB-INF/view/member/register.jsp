<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		var contextPath = "${contextPath}";
		$("#cancel").click(function(e){
			e.preventDefault();
			window.location.href = contextPath + "/read?id="+id;
		});
		$("#register").click(function(){
			var data = {
					id:$("#id").val(),
					email:$("#email").val(),
					name:$("#name").val(),
					password:$("#password").val(),
			};
			alert("data >"+data.id)
			$.ajax({
				url : contextPath + "api/members",
				type : 'post',
				contentType : "application/json; charset=utf-8",
				dataType : 'json',
				cache : false,
				data : JSON.stringify(data),
				success : function(res) {
					alert(res);
					window.location.href = contextPath + "/memberlist";
				},
				error : function(request, status, error) {
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					window.location.href = contextPath + "/memberlist";
				}
			});
		});

	});
</script>
</head>
<body>
	<form:form>
		<p><label>아이디:<input id="id" type="number" value="${id }"/> </label></p>
		<p><label> 이메일:<input id="email" type="email" /> </label></p>
		<p><label> 이름:<input id="name" type="text" /> </label></p>
		<p><label> 비밀번호:<input id="password" type="password" /> </label></p>
		<p><label> 가입일:<input id="registerDateTime" type="date" /> </label></p>
		<button id="register">추가</button><button id="cancel">취소</button>
	</form:form>
</body>
</html>