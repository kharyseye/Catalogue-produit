<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Produit</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container col-md-8 col-md-offset-2">
		<div class="card">
			<div class="card-header bg-primary text-center text-white">Ajouter un Produit</div>
			<div class="card-body">
				<form action="ajouter.php" method="post">
				<div class="form-group">
					<label class="form-label">D�signation</label> 
					<input type="text" class="form-control" name="designation" value="${produit.designation}" required="required"/>
				</div>
				<div class="form-group">
					<label class="form-label">Prix :</label> 
					<input type="text" class="form-control" name="prix" value="${produit.prix}">
				</div>
				<div class="form-group">
					<label class="form-label">Quantit� :</label> 
					<input type="text" class="form-control" name="quantite" value="${produit.quantite}">
				</div>
				<p></p> 
				<div>
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
				</form> 
				
				
			</div>


		</div>
	</div>

</body>
</html>