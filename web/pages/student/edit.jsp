<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/8
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>添加学生信息</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>
</head>
<body>
<%--跳转回controller，调用添加的方法，所以form表单的action为save   method默认post--%>
<f:form action="${pageContext.request.contextPath}/student/saveUpdate" modelAttribute="student">
    <f:hidden path="stuId"/>
    <%--<input  name="stuId" type="hidden" value="${student.stuId}">--%>
    学生姓名：<f:input path="stuName"/><br/>
    <%--<input name="stuName" value="${student.stuName}"/><br/>--%>
    学生性别：<f:radiobutton path="stuSex" value="男"/>男<f:radiobutton path="stuSex" value="女"/>女<br/>
    <%--<input  name="stuSex" type="radio" value="男" ${student.stuSex eq "男"?"checked='checked'":""}/>男,<input  name="stuSex" type="radio" value="女" ${student.stuSex eq "女"?"checked='checked'":""}/>女<br/>--%>
    学生状态：<f:radiobutton path="stuStatus" value="离校"/>离校<f:radiobutton path="stuStatus" value="在校"/>在校<br/>
    <%--<input  name="stuStatus" type="radio" value="离校" ${student.stuStatus eq "离校"?"checked='checked'":""}/>离校,<input  name="stuStatus" type="radio" value="在校"${student.stuStatus eq "在校"?"checked='checked'":""}/>在校<br/>--%>
    学生年龄：<f:input path="stuAge"/><br/>

    入学时间：<f:input path="stuDate" value="" onClick="WdatePicker();"/><br/>
    班主任${student.teaId}：${teacher.teaId}
    <select name="teaId">
        <option value="">请选择班主任</option>
        <c:forEach var="teacher" items="${teacherList}">
            <option value="${teacher.teaId}" ${student.teaId eq teacher.teaId?"selected='selected'":""} >${teacher.teaName}</option>
        </c:forEach>

    </select>
    <input type="submit" value="提交">
</f:form>

</body>
</html>
