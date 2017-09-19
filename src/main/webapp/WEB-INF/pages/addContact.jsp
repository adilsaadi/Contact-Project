<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<div
	class="container-fluid col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
	<div class="contact contact-border panel panel-primary">
		<div class="panel-heading">${page}
			Contact</div>
		<div class="panel-body">
			<form class="form-horizontal" action="saveContact" method="post"
				data-toggle="validator" role="form">
				<input type="hidden" name="id" value="${contactID}" />
				<div class="form-group">
					<label class="control-label col-sm-5">Last Name:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control"
							placeholder="Enter Last Name" name="nom" value="${contact.nom}"
							required data-required-error="the name is required">
						<div class="help-block with-errors"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="firstname">First
						Name:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="firstname"
							placeholder="Enter First Name" name="prenom"
							value="${contact.prenom}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="phonenumber">Phone
						Number:</label>
					<div class="col-sm-7">
						<input type="tel" class="form-control" id="phonenumber"
							placeholder="Enter Phone Num" name="telephone"
							value="${contact.telephone}" minlength="2" maxlength="10"
							data-error="phone number should 3 digit minimum"
							data-required-error="the phone number is required" required>
						<div class="help-block with-errors"></div>

					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="email">Email:</label>
					<div class="col-sm-7">
						<input type="email" class="form-control" id="email"
							placeholder="Enter mail Address" name="email"
							value="${contact.email}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="firstname">Group:</label>
					<div class="col-sm-7">
						<select class="form-control" name="idGroupe">
							<c:forEach var="groupe" items="${listGroupe}">
								<c:set var="active" scope="session" value="active" />
								<c:if test="${groupe.etat.equals(active)}">
									<option value="${groupe.idGroupe}">${groupe.libelle}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary pull-right contact-border contact-bg"
							value="Save">Save</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>