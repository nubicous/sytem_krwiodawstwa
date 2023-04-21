<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.04.2023
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add a point</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="Bootstrap.css">
</head>
<body>
<div class="bg-image"></div>
<div class="d-flex justify-content-center align-items-center">
    <div class="container">
        <div class="row justify-content-center align-self-center">
            <h1>Wpisz dane nowego telefonu</h1>
        </div>

        <div class="row justify-content-center align-self-center">
            <form action="AdminServlet" method="get">
                <input type="hidden" name="command" value="ADD">
                <div class="form-group">
                    <label for="name">Nazwa stacji</label>
                    <input type="text" class="form-control" id="name" name="nameInput"/>
                </div>
                <div class="form-group">
                    <label for="city">Miasto</label>
                    <input type="text" class="form-control" id="city" name="cityInput"/>
                </div>
                <div class="form-group">
                    <label for="zipCode">Zip code</label>
                    <input type="text" class="form-control" id="zipCode" name="zipCodeInput"/>
                </div>
                <div class="form-group">
                    <label for="street">Ulica</label>
                    <input type="text" class="form-control" id="street" name="streetInput"/>
                </div>
                <div class="form-group">
                    <label for="buildinNumber">Numer budynku</label>
                    <input type="text" class="form-control" id="buildinNumber" name="buildingNumberInput"/>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Numer telefonu</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumberInput"/>
                </div>
                <div class="form-group">
                    <label for="email">e-mail</label>
                    <input type="text" class="form-control" id="email" name="emailInput"/>
                </div>
                <div class="form-group">
                    <label for="website">Strona</label>
                    <input type="text" class="form-control" id="website" name="websiteInput"/>
                </div>
                <button type="submit" class="btn btn-info">Dodaj</button>
            </form>
        </div>

        <div class="row justify-content-center align-self-center">
            <div class="container-fluid">

                <div class="col-sm-9">
                    <a href="AdminServlet" class="btn btn-lg btn-primary" role="button" aria-disabled="true">Wróć do zestawienia</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
