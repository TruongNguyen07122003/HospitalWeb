<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <font color="red"></font>
    <h1>The information of Nurse Updating</h1>

    <c:forEach items="${result}" var="dto" varStatus="counter">
        <form action="DispatchServlet" method="POST">
            <tr>
                <td>${counter.count}</td>
                <td>${dto.id}</td>
                <td>${dto.name}</td>
                <td>${dto.age}</td>
                <td>${dto.gender}</td>
                <td>${dto.address}</td>
                <td>${dto.phone}</td>
                <td>${dto.staffID}</td>
                <td>${dto.department}</td>
                <td>${dto.shift}</td>
                <td>${dto.salary}</td>
                <td>${dto.password}</td>
                
                <td>
                    <!-- Add a condition to display Update button for the nurse to be updated -->
                    <c:if test="${dto.staffID eq param.updateStaffID}">
                        <input type="submit" value="Update" name="btAction" />
                    </c:if>
                </td>
            </tr>
        </form>
    </c:forEach>
</body>
</html>
