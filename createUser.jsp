<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE html>

<html>

<head>

	<meta charset = "UTF-8"/>

	<link rel = "stylesheet" href = "css/style_main.css">
	<link rel = "stylesheet" href = "css/style_input.css">

	<title>ユーザー情報登録画面</title>

</head>

<body>

	<jsp:include page = "header.jsp" />

	<h1>ユーザー情報登録画面</h1>

	<s:if test = "listSei != null && listSei.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listSei">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "listMei != null && listMei.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listMei">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "listSeikana != null && listSeikana.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listSeikana">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "listMeikana != null && listMeikana.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listMeikana">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "listMail != null && listMail.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listMail">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "listUserId != null && listUserId.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listUserId">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "listPassword != null && listPassword.size() > 0">
		<div class = "errormessage">
			<s:iterator value = "listPassword">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<s:if test = "errorMessage != null && !(errorMessage.isEmpty())">
		<div class = "errormessage">
			<s:iterator value = "errorMessage">
				<p><s:property /></p>
			</s:iterator>
		</div>
	</s:if>

	<form action = "CreateUserConfirmAction" method = "post">

		<table>

			<tr>
				<th><label>姓</label></th>
				<td><input type = "text" name = "sei" placeholder="姓" value = "<s:property value = 'sei' />" /></td>
			</tr>

			<tr>
				<th><label>名</label></th>
				<td><input type = "text" name = "mei" placeholder="名" value = "<s:property value = 'mei' />"/></td>
			</tr>

			<tr>
				<th><label>姓ふりがな</label></th>
				<td><input type = "text" name = "seikana" placeholder="姓ふりがな" value = "<s:property value = 'seikana' />"/></td>
			</tr>

			<tr>
				<th><label>名ふりがな</label></th>
				<td><input type = "text" name = "meikana" placeholder="名ふりがな" value = "<s:property value = 'meikana' />"/></td>
			</tr>

			<tr>
				<th><label>性別</label></th>
				<td>
					<label><input type="radio" name = "seibetu" value = "0"<s:if test = 'seibetu == 0'> checked</s:if>>男性</label>
					<label><input type="radio" name = "seibetu" value = "1"<s:if test = 'seibetu == 1'> checked</s:if>>女性</label>
				</td>
			</tr>

			<tr>
				<th><label>メールアドレス</label></th>
				<td><input type = "text" name = "mail" placeholder="メールアドレス" value = "<s:property value = 'mail' />"/></td>
			</tr>

			<tr>
				<th><label>ユーザーID</label></th>
				<td><input type = "text" name = "userId" placeholder="ユーザーID" value = "<s:property value = 'userId' />"/></td>
			</tr>

			<tr>
				<th><label>パスワード</label></th>
				<td><input type = "password" name = "password" placeholder="パスワード" value = ""/></td>
			</tr>

		</table>

		<div id = "buttonArea">
			<input type = "submit" value = "確認"/>
		</div>

	</form>

</body>

</html>
