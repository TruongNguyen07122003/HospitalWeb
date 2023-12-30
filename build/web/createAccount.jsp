<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERRORS}"/>

            ID * <input type="text" name="id" value="" />(6 - 30 chars)<br/>
            <c:if test="${not empty errors.userIDLengthErr}">
                <font color="red">
                    ${errors.userIDLengthErr}
                </font><br/>
            </c:if>
            Name * <input type="text" name="name" value="" />(6 - 20 chars)<br/>
            <c:if test="${not empty errors.fullNameLengthErr}">
                <font color="red">
                    ${errors.fullNameLengthErr}
                </font><br/>
            </c:if>
            Age * <input type="text" name="age" value="" /><br/>
            <c:if test="${not empty errors.ageLengthErr}">
                <font color="red">
                    ${errors.ageLengthErr}
                </font><br/>
            </c:if>
            Gender * <select name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select><br/>
            Address * <input type="text" name="address" value=""><br/>
            <c:if test="${not empty errors.addressLengthErr}">
                <font color="red">
                    ${errors.addressLengthErr}
                </font><br/>
            </c:if>
            Phone * <input type="text" name="phone" value=""><br/>
            <c:if test="${not empty errors.phoneLengthErr}">
                <font color="red">
                    ${errors.phoneLengthErr}
                </font><br/>
            </c:if>
            Staff ID * <input type="text" name="staffID" value=""><br/>
            <c:if test="${not empty errors.staffIDErr}">
                <font color="red">
                    ${errors.staffIDErr}
                </font><br/>
            </c:if>
            Department * <input type="text" name="department" value=""><br/>
            <c:if test="${not empty errors.departmentLengthErr}">
                <font color="red">
                    ${errors.departmentLengthErr}
                </font><br/>
            </c:if>
            Shift * <select id="shift" name="shift">
                <option value="Day">Day</option>
                <option value="Night">Night</option>
                <option value="Evening">Evening</option>
            </select><br/>
            Salary * <input type="number" name="salary" value=""><br/>
            <c:if test="${not empty errors.salaryErr}">
                <font color="red">
                    ${errors.salaryErr}
                </font><br/>
            </c:if>
            Password * <input type="password" name="password" value=""><br/>
            <c:if test="${not empty errors.passworrdLengthErr}">
                <font color="red">
                    ${errors.passworrdLengthErr}
                </font><br/>
            </c:if>
            Confirm Password * <input type="password" name="confirmPassword" value=""><br/>
            <c:if test="${not empty errors.confirmLengthErr}">
                <font color="red">
                    ${errors.confirmLengthErr}
                </font><br/>
            </c:if>

            <input type="submit" value="Create Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
        <a href="login.html">Click here to return to LOGIN Page</a><br/>
        <a href="DispatchServlet?btAction=Search">Search</a>
    </body>

</html>
