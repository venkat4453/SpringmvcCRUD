<%-- 
    Document   : index
    Created on : Dec 21, 2019, 4:54:58 PM
    Author     : admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Emp Page</title>
        
    </head>
    <body>
        <h1>
            Add an Emp
        </h1>

        <c:url var="addAction" value="/emp/add" ></c:url>

        <form:form action="${addAction}" commandName="Emp">
            <table>
                <c:if test="${!empty Emp.name}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" size="8"  disabled="true" />
                            <form:hidden path="id" />
                        </td> 
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="name">
                            <spring:message text="Name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name" />
                    </td> 
                </tr>
                <tr>
                    <td>
                        <form:label path="country">
                            <spring:message text="Country"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="country" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${!empty Emp.name}">
                            <input type="submit"
                                   value="<spring:message text="Edit Emp"/>" />
                        </c:if>
                        <c:if test="${empty Emp.name}">
                            <input type="submit"
                                   value="<spring:message text="Add Emp"/>" />
                        </c:if>
                    </td>
                </tr>
            </table>	
        </form:form>
        <br>
        <h3>Emps List</h3>
        <c:if test="${!empty listEmps}">
            <table class="tg">
                <tr>
                    <th width="80">Emp ID</th>
                    <th width="120">Emp Name</th>
                    <th width="120">Emp Country</th>
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listEmps}" var="Emp">
                    <tr>
                        <td>${EmpEmp.id}</td>
                        <td>${Emp.name}</td>
                        <td>${Emp.country}</td>
                        <td><a href="<c:url value='/edit/${Emp.id}' />" >Edit</a></td>
                        <td><a href="<c:url value='/remove/${Emp.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
