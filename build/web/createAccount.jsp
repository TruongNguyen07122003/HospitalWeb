<%-- 
    Document   : createAccount
    Created on : Dec 22, 2023, 12:20:03 PM
    Author     : GIGABYTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Nurse Account</h1>
        <form action="DispatchServlet" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br/>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required><br/>

            <label for="gender">Gender:</label>
            <select id="gender" name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select><br/>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br/>

            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required><br/>

            <label for="staffID">Staff ID:</label>
            <input type="text" id="staffID" name="staffID" required><br/>

            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required><br/>

            <label for="shift">Shift:</label>
            <select id="shift" name="shift">
                <option value="Day">Day</option>
                <option value="Night">Night</option>
                <option value="Evening">Evening</option>
            </select><br/>

            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" required><br/>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br/>
            
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required><br/>


            <label for="isAdmin">Is Admin:</label>
            <input type="checkbox" id="isAdmin" name="isAdmin" value="1"><br/>

            <input type="submit" value="Create Account" name="btAction">
        </form>
    </body>
</html>
