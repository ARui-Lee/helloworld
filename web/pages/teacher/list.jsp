<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/14
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>教师列表</title>
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>


<f:form action="${pageContext.request.contextPath}/teacher/list" modelAttribute="teacher">
    教师姓名：<f:input path="teaName"/><br/>
    教师性别：<f:radiobutton path="teaSex" value=""/>不限<f:radiobutton path="teaSex" value="男"/>男<f:radiobutton path="teaSex" value="女"/>女<br/>
    教师年龄：<f:input path="teaAgeBegin" />至<f:input path="teaAgeEnd"/>岁<br/>
    <input type="submit" value="查找"/>
</f:form>
<br/>


<a href="${pageContext.request.contextPath}/teacher/edit">添加教师信息</a>


<%--要批量提交，需要向请求域中传入批量的id数组，使用form表单--%>
<form id="delBatch" action="${pageContext.request.contextPath}/teacher/deleteBatch" method="post">
<table align="center" border="1px" cellspacing="0px" cellpadding="10px">
    <tr>
        <%--点击按钮触发事件，在事件内进行表单提交比较好，如果直接设置提交按钮，点击的时候没有选中任何一个CheckBox，就会空指针异常--%>
        <%--如果使用button标签的函数提交，不必要在<form>标签内，在哪里提交都可以--%>
        <td><input type="checkbox" id="selectAll" value="${teacher.teaId}"/>全选/取消<input type="button" id="deleteBatch" value="删除全部"/></td>
        <td>教师编号</td>
        <td>教师姓名</td>
        <td>教师年龄</td>
        <td>教师性别</td>
        <td colspan="1" align="center">学生信息操作</td>
    </tr>

    <tr>  <c:forEach items="${teacherList}" var="teacher">

        <td> <input type="checkbox" name="teaIds" value="${teacher.teaId}"/></td>
        <td>${teacher.teaId}</td>
        <td>${teacher.teaName}</td>
        <td>${teacher.teaAge }</td>
        <td>${teacher.teaSex eq "男"?"男":"女"}</td>
        <td><a href="${pageContext.request.contextPath}/teacher/edit?teaId=${teacher.teaId}">修改教师信息</a></td>
        <%--所以要在局部变量内使用teacher，将参数在局部变量作用域中获取到，传入javascript函数--%>
        <td><a href="javascript:del(${teacher.teaId});">删除教师信息</a></td></tr>
    </c:forEach>
</table>
</form>

当前第${pages.no}页
共${pages.totalPageNo}页
共有${pages.totalRowCount}条记录
<%--no=1拼接进地址栏中--%>
<c:if test="${pages.no gt 1}">
<a href="${pageContext.request.contextPath}/teacher/list?no=1">首页</a>
</c:if>
<c:if test="${pages.no le 1}">
    首页
</c:if>
<c:if test="${pages.no gt 1}">
    <a href="${pageContext.request.contextPath}/teacher/list?no=${pages.no-1}">上一页</a>
</c:if>
<c:if test="${pages.no le 1}">
    上一页
</c:if>

<c:if test="${pages.no lt pages.totalPageNo}">
    <a href="${pageContext.request.contextPath}/teacher/list?no=${pages.no+1}">下一页</a>
</c:if>
<c:if test="${pages.no ge pages.totalPageNo}">
    下一页
</c:if>
<c:if test="${pages.no lt pages.totalPageNo}">
    <a href="${pageContext.request.contextPath}/teacher/list?no=${pages.no+1}">尾页</a>
</c:if>
<c:if test="${pages.no ge pages.totalPageNo}">
    尾页
</c:if>
去<input onchange="changePage(this)"  oninput="value=value.replace(/[^\d]/g,'')"/>页
去<select onchange="window.location.href = '${pageContext.request.contextPath}/teacher/list?no='+this.value;">
    <c:forEach  begin="1" end="${pages.totalPageNo}" var="i">
        <option value="${i}" ${pages.no eq i ? "selected=selected":""}>${i}</option>
    </c:forEach>

</select>页
</body>

<script>
    <%--el表达书不可用，因为teacher是局部变量，如果使用${teacher.teaId},明显找不到teacher --%>
    function del(id) {
        if (confirm("确定删除吗？")==true){
            window.location.href = "${pageContext.request.contextPath}/teacher/delete?teaId="+id;
        }
    }

    function changePage(input) {
        //1.确保用户输入的值是纯数字：/^\d+$/
        //2.确保用户输入的页号介于第一和最后一页之间
        //3.跳转
        window.location.href = "${pageContext.request.contextPath}/teacher/list?no="+input.value;
    }


    <%--$("#deleteBatch").click(function () {--%>

        <%--if ($("[name='teaIds']:checked").length>0) {--%>
            <%--if (confirm("确定删除吗？")==true){--%>
                <%--&lt;%&ndash;window.location.href = "${pageContext.request.contextPath}/teacher/deleteBatch?teaId="+id;&ndash;%&gt;--%>
            <%--}--%>
        <%--}--%>
        <%--else {--%>
            <%--alert("请至少选择一项进行删除")--%>
        <%--}--%>
    <%--})--%>

    $("#selectAll").click(function () {
        $("[name='teaIds']").prop("checked",this.checked)
    });



    <%--批量删除--%>
    $("#deleteBatch").click(function () {
        if ($("[name='teaIds']:checked").length>0) {
            if (confirm("确定要删除吗")) {
                $("#delBatch").submit();
            }
        }else{
            alert("请至少选择一项进行删除");
        }
    });
</script>
</html>
