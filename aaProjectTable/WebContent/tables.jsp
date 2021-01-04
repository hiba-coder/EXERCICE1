<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Chercher la table <small>(<i class="glyphicon glyphicon-filter"></i>)</small></h1>
    	<div class="row">
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Developers</h3>
						<!--  <div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip" title="Toggle table filter" data-container="body">
								<i class="glyphicon glyphicon-filter"></i>
							</span>
						</div>-->
					</div>
					<form action="ConrollerTable" method="get">
					<div class="panel-body">
						<input type="text" value="${table.nameTable}" name="nameTable" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table"  placeholder="Table" />
					</div>
					</form>
					<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
							<th>#</th>
							<c:forEach items="${table.columns}" var="c">
								<th>${c.nameColumn }</th>
								
							 </c:forEach> 
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${table.enregistremts}" var="e">
					           <tr>
					            <th></th>
					           	 <c:forEach items="${e.enreg}" var="en">
								<th>${en }</th>
								 </c:forEach> 
					           </tr>
					        </c:forEach> 
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>