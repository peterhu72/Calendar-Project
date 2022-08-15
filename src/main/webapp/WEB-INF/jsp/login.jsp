<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
        <!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="/css/main.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
<body>
    <div class="container">
    	<h1>Calendar</h1>
    	
    	<div class="d-flex main">
    		<div class="col-9 register">
    			<h2>Register</h2>
    			<form:form action="/register" method="post" modelAttribute="newUser">
    				<div class="form-group">
    					<form:label path = "firstName">First Name:</form:label>
    					<form:input type ="text" path="firstName"/>
    					<form:errors class="text-danger" path="firstName"/>                                                                                                          
    				</div>
    				<div class="form-group">
    					<form:label path = "lastName">Last Name:</form:label>
    					<form:input type ="text" path="lastName"/>
    					<form:errors class="text-danger" path="lastName"/>                                                                                                          
    				</div>
    				<div class="form-group">
    					<form:label path = "email">Email:</form:label>
    					<form:input type ="text" path="email"/>
    					<form:errors class="text-danger" path="email"/>                                                                                                          
    				</div>
    				<div class="form-group">
    					<form:label path = "password">Password:</form:label>
    					<form:input type ="password" path="password"/>
    					<form:errors class="text-danger" path="password"/>                                                                                                          
    				</div>
    				<div class="form-group">
    					<form:label path = "confirmPassword">Confirm Password:</form:label>
    					<form:input type ="password" path="confirmPassword"/>
    					<form:errors class="text-danger" path="confirmPassword"/>                                                                                                          
    				</div>
    				<input type="submit" value="Register" class="btn btn-outline-primary"/>
    			</form:form>
    			
    		</div>
    		<div class="col-9 login">
    			<h2>Login</h2>
    			<form:form action="/login" method="post" modelAttribute="newLogin">
    				<div class="form-group">
    					<form:label path = "email">Email:</form:label>
    					<form:input type ="text" path="email"/>					                                                                                                         
    				</div>
    				<div class="form-group">
    					<form:label path = "password">Password:</form:label>
    					<form:input type ="password" path="password"/>                                                                                              
    				</div>
    				<input type="submit" value="Login" class="btn btn-outline-primary"/>
    				<form:errors class="text-danger" path="password"/>
    				<form:errors class="text-danger" path="email"/> 
    			</form:form>
    			
    		</div>
    	</div>
    	<h3 class="text-danger"><c:out value="${error}"/></h3>
    </div>
</body>
</html>