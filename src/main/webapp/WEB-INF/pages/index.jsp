<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid text-center">
	<div class="row vertical-align">
		<a href="contactList" class="col-md-4 btn slide contact-list elt-icon">
			<span class="fa fa-address-book-o fa-5x"></span>
			<span class="elt-title">View Contacts</span>
		</a>
		<a href="newContact" class="col-md-4 btn slide contact-add elt-icon">
			<span class="fa fa-user-plus fa-5x"></span>
			<span class="elt-title">Add Contact</span>
		</a>
		<a href="newGroupe" class="col-md-4 btn slide group-add elt-icon">
			<span class="fa fa-users fa-5x"></span>
			<span class="elt-title">Add Group</span>
		</a>
	</div>
</div>
</body>
</html>