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
		
		<link href="/css/style.css" rel="stylesheet">
		
		<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>
	    <link
	      href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
	      rel="stylesheet"/>
    </head>
<body>
	<nav class="nav-bar">
		<h1 class="header">${user.firstName}'s Calendar</h1>
		<button class="event-button button" id="button">Add an Event!</button>
    <button class="event-button button"><a href="/events" class="remove">See Your Events!</a></button>
	</nav>
    <div class="container">
      <div class="calendar">
        <div class="month">
          <i class="fas fa-angle-left prev"></i>
          <div class="date">
            <h1></h1>
            <p></p>
          </div>
          <i class="fas fa-angle-right next"></i>
        </div>
        <div class="weekdays">
          <div>Sun</div>
          <div>Mon</div>
          <div>Tue</div>
          <div>Wed</div>
          <div>Thu</div>
          <div>Fri</div>
          <div>Sat</div>
        </div>
        <div class="days"></div>
      </div>
    </div>
    <div class="popup">
        <div class="popup-content">
        	<form:form action="/event/create" method="post" modelAttribute="events">
	        	<form:input type="text" placeholder="Event Title" path="title"/>
	        	<form:input type="date" placeholder="Event Date" path="date"/>
	        	<form:input type="time" placeholder="Event Time" path="time"/>
	        	<form:input type="text" placeholder="Event Location" path="location"/>
	        	<form:input type="text" placeholder="Event Description" path="description"/>
	        	<input type="submit" value="Submit"></input>
	        	
	        </form:form>
          <button class="close">Close</button>
        </div>
    </div>
    
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>