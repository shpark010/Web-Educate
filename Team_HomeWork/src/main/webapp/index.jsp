<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jquery.ajax.dao.CommentDAO" %>
<%@ page import="com.jquery.ajax.dto.CommentDTO" %>
<%@ page import ="java.util.List" %>
<%
//글번호 
	int board_id = 1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CommentLIST</title>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			//데이터 출력
			function PrintData(data){
				$('#container').find("table tr").not(":first").remove();
				$.each(data, function(){
					//console.log(this);
					$('#container').find("table tr:last").after(
						"<tr>"
						+ " <td>" + this.reply_id + "</td>"
						+ " <td>" + this.reply_content + "</td>"
						+ " <td><button seq='" + this.reply_id +"'>삭제</button></td>"
						+ "</tr>"
					);
				});
				$('#comment').val();
			}

			function SelectReply() {
				$.ajax(
					{
						url : "/Web_Jquery_Board/select.reply",
						data : {"board_id" : <%=board_id%>},
						dataType : "JSON",
						success : function(data) {
							console.log(data);
							PrintData(data);
						}
					}
				);
			}
			//처음 화면 실행시 비동기로 리스트 출력
			SelectReply();
			
		});
	
	</script>
</head>
<body>
	<table width="700px" border="1">
		<tr>
			<th width="200px">번호</th>	
			<td>${board_id}</td>
		</tr>
		<tr>
			<th width="200px">제목</th>	
			<td>Jquery 넘 재미있어요</td>
		</tr>
		<tr>
			<th width="200px">내용</th>	
			<td>당황하지 않고 Jquery 보면...</td>
		</tr>
	</table>
	<br>
	<!-- 덧글 입력  -->
	<div>
		<input type="text" name="comment" id="comment" style="width: 600px;" placeholder="덧글을 입력하세요"> 
		<button id="addBtn">덧글등록</button>
		<br>
		<div id="container">
			<table border="1">
				<tr>
					<td>순번</td>
					<td>내용</td>
					<td>삭제</td>
					<td>수정</td> 
				</tr>
			</table>
		</div>
	</div>
	<hr>
	<table id="tbllist" border="1">
	</table>
</body>
</html>










