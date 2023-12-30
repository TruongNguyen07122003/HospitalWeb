<%@page import="nurse.NurseDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <font color="red">Welcome, ${sessionScope.STAFF_INFO.name}</font>
    <h1>Search Nurse Staff</h1>

    <form action="DispatchServlet">
        Input Name of Nurse <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /><br/>
        <input type="submit" value="Search" name="btAction" />
    </form><br/>

    
    <form action="DispatchServlet" method="POST">
    <!-- Chỉ truyền txtSearchValue khi thực hiện tìm kiếm -->
    <input type="hidden" name="txtSearchValue" value="${empty param.btAction ? param.txtSearchValue : ''}" />

    <!-- Truyền giá trị btAction là DisplayAllNurse khi thực hiện hiển thị tất cả y tá -->
    <input type="submit" value="Display All Nurse" name="btAction" />
    <form action="DispatchServlet">
        <input type="submit" value="Create New Nurse Account" name="btAction" />
    </form>
</form>

    <c:set var="searchValue" value="${param.txtSearchValue}" />
    <c:choose>
        <c:when test="${not empty searchValue || param.btAction eq 'Display All Nurse'}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Full Name</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Staff ID</th>
                            <th>Department</th>
                            <th>Shift</th>
                            <th>Password</th>
                            <th>Salary</th>
                            <th>Delete</th>
                            <th>Update</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${result}" var="dto" varStatus="counter">
                            <form action="DispatchServlet" method="POST">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        <input type="text" name="updateID" value="${dto.id}" />
                                        
                                    </td>
                                    
                                    <td>
                                        <input type="text" name="updateName" value="${dto.name}" />
                                        
                                    </td>
                                    <td>
                                        <input type="text" name="updateAge" value="${dto.age}" />
                                        
                                    </td>
                                    <td>
                                        <input type="text" name="updateGender" value="${dto.gender}" />
                                        
                                    </td>
                                    <td>
                                        <input type="text" name="updateAddress" value="${dto.address}" />
                                        
                                    </td>
                                    <td>
                                        <input type="text" name="updatePhone" value="${dto.phone}" />
                                        
                                    </td>
                                    <td>
                                        ${dto.staffID}
                                        <input type="hidden" name="updateStaffID" value="${dto.staffID}" />
                                    </td>
                                    <td>
                                        
                                        
                                        <input type="text" name="updateDepartment" value="${dto.department}" />
                                    </td>
                                    <td>
                                        
                                        
                                        <input type="text" name="updateShift" value="${dto.shift}" />
                                    </td>
                                    <td>
                                        <input type="password" name="txtPassword" value="${dto.password}" />
                                        <input type="hidden" name="txtPassword" value="${dto.password}" />
                                    </td>
                                    <td>
                                        
                                        <input type="text" name="updateSalary" value="${dto.salary}"/>
                                    </td>
                                    <td>
                                        <a href="DispatchServlet?btAction=Delete&amp;pk=${dto.staffID}&amp;lastSearchValue=${searchValue}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="hidden" name="lastSearchValue" 
                                               value="${searchValue}" />
                                        <input type="hidden" name="updateStaffID" value="${dto.staffID}" />
                                        <input type="submit" value="Update" name="btAction" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty result}">
                <h2>No record is matched!!!</h2>
            </c:if>
               
        </c:when>
    </c:choose>
                
                
                <form action="DispatchServlet">
                    <input type="submit" value="Log Out" name="btAction" />
                </form>
</body>
</html>
