<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		var contextPath = "${contextPath}";
		var id = ${id};
		/*  */
		$.get(contextPath + "/api/members/" + id, function(json) {
			var sCont = "";
			sCont += "<tr>";
			sCont += "<td id='id'>" + json.id + "</td>";
			sCont += "<td>" + json.name + "</td>";
			sCont += "<td>" + json.email + "</td>";
			sCont += "<td>" + json.registerDateTime + "</td>";
			sCont += "</tr>";
			$("#load:last-child").append(sCont);
		});
		
		/*목록*/
		$('#list').click(function(){
			window.location.href = contextPath+"/memberlist";
		});
		
		$('#modify').click(function(){
			window.location.href = contextPath+"/update?id="+id;
		});
		
		/*삭제*/
		$('#remove').click(function(){
			$.ajax({
				url: contextPath+"api/members/"+id,
				type: 'DELETE',
				success: function(res){
					alert(res);
					window.location.href = contextPath+"/memberlist";
				}
			});
		});
	});
</script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody id="load"></tbody>
	</table>
	<button id="remove">삭제</button>
	<button id="modify">수정</button>
	<button id="list">목록</button>
</body>
</html>