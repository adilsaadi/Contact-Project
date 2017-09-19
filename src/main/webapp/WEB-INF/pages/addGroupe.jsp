<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<div
	class="container-fluid col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
	<div class="group group-border panel panel-primary">
		<div class="panel-heading">${page} Group</div>
		<div class="panel-body">
			<form class="form-horizontal" action="saveGroupe" method="post"
				data-toggle="validator" role="form">
				<input type="hidden" name="id" value="${groupeID}" />
				<div class="form-group">
					<label class="control-label col-sm-5">Group Name:</label>
					<div class="col-sm-7">
						<input type="text" class="form-control"
							placeholder="Enter group name" name="libelle"
							value="${groupe.libelle}" required
							data-required-error="the goup name is required">
						<div class="help-block with-errors"></div>
					</div>
				</div>
				<c:set var="_page" scope="session" value="Edit" />
				<c:if test="${page.equals(_page) }">
					<c:set var="_etat" scope="session" value="inactive" />
					<c:if test="${groupe.etat.equals(_etat)}">
						<div
							class="alert alert-warning alert-dismissable col-sm-10 pull-right">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Warning!</strong> This group is inactive, if
							you want to use it change its state to active.
						</div>
					</c:if>
				</c:if>
				<c:set var="_page" scope="session" value="Add" />
				<c:if test="${page.equals(_page) }">
					<div
						class="alert alert-warning alert-dismissable col-sm-10 pull-right">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Warning!</strong> The group is inactive by default, if you
						want to use it change its state to active.
					</div>
				</c:if>
				<div class="form-group">
					<label class="control-label col-sm-5" for="state">Group
						State:</label>
					<div class="col-sm-7">
						<select class="form-control" name="etat">
							<option value="inactive" ${inactive}>inactive</option>
							<option value="active" ${active}>active</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit"
							class="btn btn-primary pull-right group-bg group-border"
							value="Save">Save</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>