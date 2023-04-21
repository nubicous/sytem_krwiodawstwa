<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*,back.BloodStation" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Zmiana danych stacji krwiodastwa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="Bootstrap.css">
</head>
<body>
<div class="bg-image"></div>
<div class="d-flex justify-content-center align-items-center">
    <div class="container">
        <div class="row justify-content-center align-self-center">

        <h1>Zmień dane punktu krwiodastwa</h1>

        </div>

        <div class="row justify-content-center align-self-center mt-3">
            <form action="AdminServlet" method="get">
                <input type="hidden" name="command" value="UPDATE"/>
                <input type="hidden" name="bloodStationID" value="${BLOOD_STATION.id}"/>
                <div class="form-group">
                    <label for="name">Nazwa stacji</label>
                    <input type="text" class="form-control" id="name" name="nameInput" value="${BLOOD_STATION.name}"/>
                </div>
                <div class="form-group">
                    <label for="city">Miasto</label>
                    <input type="text" class="form-control" id="city" name="cityInput" value="${BLOOD_STATION.city}"/>
                </div>
                <div class="form-group">
                    <label for="zipCode">Zip code</label>
                    <input type="text" class="form-control" id="zipCode" name="zipCodeInput" value="${BLOOD_STATION.zipCode}"/>
                </div>
                <div class="form-group">
                    <label for="street">Ulica</label>
                    <input type="text" class="form-control" id="street" name="streetInput" value="${BLOOD_STATION.street}"/>
                </div>
                <div class="form-group">
                    <label for="buildinNumber">Numer budynku</label>
                    <input type="text" class="form-control" id="buildinNumber" name="buildingNumberInput" value="${BLOOD_STATION.buildingNumber}"/>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Numer telefonu</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumberInput" value="${BLOOD_STATION.phoneNumber}"/>
                </div>
                <div class="form-group">
                    <label for="email">e-mail</label>
                    <input type="text" class="form-control" id="email" name="emailInput" value="${BLOOD_STATION.email}"/>
                </div>
                <div class="form-group">
                    <label for="website">Strona</label>
                    <input type="text" class="form-control" id="website" name="websiteInput" value="${BLOOD_STATION.website}"/>
                </div>
                <button type="submit" class="btn btn-success">Zmień dane</button>
            </form>
        </div>

        <div class="row justify-content-center align-self-center mt-3">
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
