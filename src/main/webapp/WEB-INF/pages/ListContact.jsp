<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid col-md-10 col-md-offset-1">
	<div class="list list-border panel panel-primary">
		<div class="panel-heading">Contact List</div>
		<div class="panel-body">
			<div class="ibox-content">
				<div class="list row">
					<div class="col-sm-4 m-b-xs">
						<div id="tab" class="btn-group" data-toggle="buttons">
							<a href="#Contacts" class="btn list-bg list-border active"
								data-toggle="tab"> <input type="radio" />Contacts
							</a> <a href="#Groups" class="btn list-bg list-border"
								data-toggle="tab"> <input type="radio" />Groupes
							</a>
						</div>
					</div>
					<div class="col-sm-8 text-right">
						<a href="newContact"
							class="btn btn-sm btn-warning contact-bg contact-border">Add
							New Contact</a> <a href="newGroupe"
							class="btn btn-sm btn-info group-bg group-border">Add New
							Groupe</a>
					</div>
				</div>
				<div class="tab-content">
					<div id="Contacts" class="tab-pane fade in active table-responsive">

						<table class="table table-striped">
							<thead>
								<tr>
									<th>Last Name</th>
									<th>First Name</th>
									<th>Phone Number</th>
									<th>Email</th>
									<th>Group</th>
									<th class="text-right">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="contact" items="${contactList}">
									<tr>
										<td>${contact.nom}</td>
										<td>${contact.prenom}</td>
										<td>${contact.telephone}</td>
										<td>${contact.email}</td>
										<td>${contact.groupe.libelle }</td>
										<td class="text-right">
											<div class="btn-group">
												<a class="btn-primary btn btn-xs"
													href="editContact?id=${contact.idContact}">Edit</a> <a
													class="btn-danger btn btn-xs"
													href="deleteContact?id=${contact.idContact}">Delete</a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="Groups" class="tab-pane fade">
						<div class="container-fluid no-padding">
							<div class="col-sm-3">
								<h4>Groups</h4>
								<ul class="nav nav-tabs tabs-left">
									<c:forEach items="${map}" var="group">
										<li class="clearfix"><a class="col-xs-3 group-icon"
											href="editGroupe?id=${group.key.idGroupe}"> <span
												class="fa fa-pencil-square-o"></span>
										</a> <a href="#${group.key.libelle}" data-toggle="pill"
											class="col-xs-9"> <span
												class="label label-primary pull-right">${group.key.etat}
											</span> <span class="pull-left">${group.key.libelle} </span>
										</a></li>
									</c:forEach>
								</ul>
							</div>
							<div class="col-sm-9">
								<div class="tab-content" style="margin-top: 50px;">
									<c:forEach items="${map}" var="enreg">
										<div class="tab-pane" id="${enreg.key.libelle}">
											<c:if test="${enreg.value.size()>0}">
												<ul class="list-group">
													<c:forEach var="contact" items="${enreg.value}">
														<li class="list-group-item">${contact.nom}<a
															class="btn-danger btn btn-xs pull-right"
															href="deleteContact?id=${contact.idContact}">Delete</a> <a
															class="btn-primary btn btn-xs pull-right"
															href="editContact?id=${contact.idContact}">Edit</a>
														</li>
													</c:forEach>
												</ul>
											</c:if>
											<c:if test="${enreg.value.size()<=0}">
												<div class="alert alert-info">
													<strong>Info!</strong>This Group has no contacts yet.
												</div>

											</c:if>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>