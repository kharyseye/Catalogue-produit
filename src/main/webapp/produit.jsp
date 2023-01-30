<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
	<p></p>
	<div class="container col-md-10 col-md-offset-1">
		<div class="card">
			<div class="card-header bg-success text-center text-white">Rechercher
				des produits</div>
			<div class="card-body">
				<form action="chercher.php" method="get">
					<label>Mot clé</label> 
					<input type="text" name="motcle" value="${model.motCle}" />
					<button type="submit" class="btn btn-success">Chercher</button>
				</form>
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>DESIGNATION</th>
						<th>PRIX</th>
						<th>QUANTITE</th>
					</tr>

					<c:forEach items="${model.produit}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.designation}</td>
							<td>${p.prix}</td>
							<td>${p.quantite}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>