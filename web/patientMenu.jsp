<%@page import="patient.PatientDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <h1> Patient management system of NNT Hospital</h1>
        <form action="DispatchServlet">
            <div>To search patient information</div>
            Input your name if you are a patient</br>
            <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /><br/>
            <input type="submit" value="SearchPatient" name="btAction" />
            
            
            <input type="submit" value="Display All Patient" name="btAction" />
        </form>
        <body>
    

    
    

    <c:set var="searchValue" value="${param.txtSearchValue}" />
    <c:choose>
        <c:when test="${not empty searchValue || param.btAction eq 'Display All Patient'}">
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
                            <th>Diagnosis</th>
                            <th>Admission Date</th>
                            <th>Discharge Date</th>
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${result}" var="dto" varStatus="counter">
                            <form action="DispatchServlet" method="POST">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        ${dto.id}
                                        
                                    </td>
                                    
                                    <td>
                                       ${dto.name}
                                        
                                    </td>
                                    <td>
                                        ${dto.age}
                                        
                                    </td>
                                    <td>
                                        ${dto.gender}
                                        
                                    </td>
                                    <td>
                                        ${dto.address}
                                        
                                    </td>
                                    <td>
                                        ${dto.phone}
                                        
                                    </td>
                                    <td>
                                        ${dto.diagnosis}
                                        
                                    </td>
                                    
                                    <td>
                                        ${dto.admissionDate}
                                        
                                    </td>
                                    <td>
                                        ${dto.dischargeDate}
                                        
                                    </td>
                                    
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
                
                
                <a href="login.html">Return to login page!</a>
</body>
    </body>
    
</html>
