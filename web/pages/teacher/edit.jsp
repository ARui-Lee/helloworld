<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/14
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>教师信息</title>
</head>
<body>
<f:form action="${pageContext.request.contextPath}/teacher/editDB" modelAttribute="teacher">
    <f:hidden path="teaId"/>
    教师姓名：<f:input path="teaName"/><br/>
    教师年龄：<f:input path="teaAge"/><br/>
    教师性别：<f:radiobutton path="teaSex" value="男" label="男"/><f:radiobutton path="teaSex" value="女" label="女"/><br/>

    <input type="submit" value="提交"/>


</f:form>


</body>
</html>
