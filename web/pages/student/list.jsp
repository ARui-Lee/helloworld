<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/8
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生列表</title>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>

<form action="${pageContext.request.contextPath}/student/list" method="post">
    <%--学生姓名：<input name="stuName" value="${param.stuName}"><br/>
                                                            getParameter()方法
    学生性别：  <input name="stuSex" type="radio" value=""  ${empty student.stuSex ?"checked='checked'":""}  />不限
                <input name="stuSex" type="radio" value="男" ${param.stuSex eq"男"?"checked='checked'":"''"}>男
                <input name="stuSex" type="radio" value="女" ${param.stuSex eq"女"?"checked='checked'":"''"}>女<br/>
    学生状态：<input name="stuStatus" type="radio" value=""  ${empty student.stuStatus ?"checked='checked'":""}  />不限
                <input name="stuStatus" type="radio" value="在校" ${param.stuStatus eq"在校"?"checked='checked'":"''"}>在校
                <input name="stuStatus" type="radio" value="离校"${param.stuStatus eq"离校"?"checked='checked'":"''"}>离校<br/>--%>

                                        <%--student被放入请求，可以直接取出--%>

                                                            <%--getattribute()方法--%>
        学生姓名：<input name="stuName" value="${student.stuName}"><br/>

        学生性别：  <input name="stuSex" type="radio" value=""  ${empty student.stuSex ?"checked='checked'":""}  />不限
        <input name="stuSex" type="radio" value="男" ${student.stuSex eq"男"?"checked='checked'":""}>男
        <input name="stuSex" type="radio" value="女" ${student.stuSex eq"女"?"checked='checked'":""}>女<br/>

        学生状态：<input name="stuStatus" type="radio" value=""  ${empty student.stuStatus ?"checked='checked'":""}  />不限
        <input name="stuStatus" type="radio" value="在校" ${student.stuStatus eq"在校"?"checked='checked'":""}>在校
        <input name="stuStatus" type="radio" value="离校"${student.stuStatus eq"离校"?"checked='checked'":""}>离校<br/>

        学生年龄：<input name="stuAgeBegin" value="${student.stuAgeBegin}">至<input name="stuAgeEnd" value="${student.stuAgeEnd}">岁<br/>

        学生入学日期：<input name="stuDateBegin" class="Wdate"   value="${student.stuDateBegin}" onClick="WdatePicker();">(年-月-日) 至 <input onClick="WdatePicker();" name="stuDateEnd"class="Wdate" value="${student.stuDateEnd}">(年-月-日)<br/>


    <input type="submit" value="查找">
</form>
<a href="${pageContext.request.contextPath}/student/edit" >添加学生信息</a><br/>

<form id="stuForm" action="${pageContext.request.contextPath}/student/deleteBatch" method="post">


    <table border="1px" cellspacing="0px" cellpadding="10px">
        <tr>
            <td> <input type="checkbox" id="selectAll">全选/取消
                <a href="javascript:delBatch();">批量删除</a> </td>
            <td>学生编号</td>
            <td>学生姓名</td>
            <td>学生性别</td>
            <td>在校状态</td>
            <td>学生年龄</td>
            <td>入学时间</td>
            <td>班主任</td>
            <td colspan="2" align="center">学生信息操作</td>
        </tr>

          <tr>  <c:forEach items="${studentList}" var="student">
              <td> <input type="checkbox" name="stuIds" value="${student.stuId}"/></td>
              <td>${student.stuId}</td>
              <td>${student.stuName}</td>
              <td>${student.stuSex eq "男"?"男":"女"}</td>
              <td>${student.stuStatus eq "离校"?"离校":"在校"}</td>
              <td>${student.stuAge }</td>
              <td>${student.stuDate}</td>
              <td>${student.teaId}</td>
                <td><a href="${pageContext.request.contextPath}/student/edit?stuId=${student.stuId}">修改学生信息</a></td>
                <td><a href="${pageContext.request.contextPath}/student/del?stuId=${student.stuId}" onclick="javascript:return warning()">删除学生信息</a></td></tr>
            </c:forEach>


    </table>
</form>
<script>
    function warning() {
        if (confirm('确定要删除吗')==true){


            return true;
        } else{
            return false;
        }
    }

    function delBatch() {
        if ($("[name=\"stuIds\"]:checked").length>0){
            if (confirm("确定删除吗？")) {
                $("#stuForm").submit();
            }
        }else {
            alert("至少选择一项进删除")
        }
    }

    $(function() {
      $("#selectAll").click(function () {
          // $("[name=\"stuIds\"]").prop("checked",$(this).prop("checked"));
          $("[name=\"stuIds\"]").prop("checked",this.checked);
      })
    })
</script>
</body>
</html>
