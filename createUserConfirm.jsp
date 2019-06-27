<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE html>

<html>

<head>

	<meta charset = "UTF-8"/>

	<link rel = "stylesheet" href = "css/style_main.css">
	<link rel = "stylesheet" href = "css/style_confirm.css">

	<title>ユーザー情報入力確認画面</title>

</head>

<body>

	<jsp:include page = "header.jsp" />

	<script src = "./js/button.js"></script>

	<h1>ユーザー情報入力確認画面</h1>

	<form method = "post">

		<table>
			<tr>
				<th><label>姓</label></th>
				<td><s:property value = "sei" /></td>
			</tr>

			<tr>
				<th><label>名</label></th>
				<td><s:property value = "mei" /></td>
			</tr>

			<tr>
				<th><label>姓ふりがな</label></th><td><s:property value = "seikana" /></td>
			</tr>

			<tr>
				<th><label>名ふりがな</label></th>
				<td><s:property value = "meikana"/></td>
			</tr>

			<tr>
				<th><label>性別</label></th>
				<td><s:if test = 'seibetu == 0'>男性</s:if><s:elseif test = 'seibetu == 1'>女性</s:elseif></td>
			</tr>

			<tr>
				<th><label>メールアドレス</label></th>
				<td><s:property value = "mail"/></td>
			</tr>

			<tr>
				<th><label>ユーザーID</label></th>
				<td><s:property value = "userId"/></td>
			</tr>

			<tr>
				<th><label>パスワード</label></th>
				<td><s:property value = "concealPassword"/></td>
			</tr>
		</table>

		<div id = "buttonArea">
			<div id = "topButton"><input type = "button" onclick = "formSubmit(this, 'CreateUserCompleteAction')" value = "登録"/></div>
			<div id = "bottomButton"><input type = "button" onclick = "formSubmit(this, 'CreateUserAction')" value = "戻る"/></div>
		</div>

	</form>

</body>

</html>
