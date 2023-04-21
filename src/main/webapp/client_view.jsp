
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
        import="java.util.*,back.BloodStatus,back.BloodStation" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Punkty</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="Bootstrap.css">
</head>

<body>
<div class="bg-image"></div> p
<div class="d-flex justify-content-center align-items-center">
    <div class="container">
        <div class="row justify-content-center align-self-center">
            <h1>Nasze Punkty</h1>
        </div>

        <div class="row justify-content-center align-self-center">
            <form action="ClientServlet" method="get">
                <div class="form-group w-500">
                    <label for="filter">Filtruj po:</label>
                    <select name="filter" id="filter" class="form-control" style="width: 300px">
                        <option value="name">Nazwa</option>
                        <option value="city">Miasto</option>
                    </select>
                </div>
                <div class="form-group w-500 mt-3">
                    <label for="search">Search:</label>
                    <input type="text" name="search" id="search" class="form-control" placeholder="search" style="width: 300px">
                </div>
                <button type="submit" class="btn btn-primary mt-3" style="width: 150px">Filter</button>
            </form>
        </div>


        <div class="row justify-content-center align-self-center">
            <table class="table table-strpied">

                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nazwa</th>
                    <th scope="col">Miasto</th>
                    <th scope="col">Kod pocztowy</th>
                    <th scope="col">Ulica</th>
                    <th scope="col">Numer budynku</th>
                    <th scope="col">Numer telefonu</th>
                    <th scope="col">email</th>
                    <th scope="col">website</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="tmpPoint" items="${BLOOD_STATIONS}">

                    <tr>
                        <th scope="row">${tmpPoint.id}</th>
                        <td>${tmpPoint.name}</td>
                        <td>${tmpPoint.city}</td>
                        <td>${tmpPoint.zipCode}</td>
                        <td>${tmpPoint.street}</td>
                        <td>${tmpPoint.buildingNumber}</td>
                        <td>${tmpPoint.phoneNumber}</td>
                        <td>${tmpPoint.email}</td>
                        <td>${tmpPoint.website}</td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row justify-content-center align-self-center">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">RhD (+) A</th>
                    <th scope="col">RhD (+) B</th>
                    <th scope="col">RhD (+) AB</th>
                    <th scope="col">RhD (+) 0</th>
                    <th scope="col">RhD (-) A</th>
                    <th scope="col">RhD (-) B</th>
                    <th scope="col">RhD (-) AB</th>
                    <th scope="col">RhD (-) 0</th>
                </tr>
                </thead>
                <tbody>

                <c:set var="tmpStatus" value="${BLOOD_STATUS}"></c:set>

                <tr>
                    <td>${tmpStatus.rhdPlusA}</td>
                    <td>${tmpStatus.rhdPlusB}</td>
                    <td>${tmpStatus.rhdPlusAB}</td>
                    <td>${tmpStatus.rhdPlus0}</td>
                    <td>${tmpStatus.rhdMinusA}</td>
                    <td>${tmpStatus.rhdMinusB}</td>
                    <td>${tmpStatus.rhdMinusAB}</td>
                    <td>${tmpStatus.rhdMinus0}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="row justify-content-center align-self-center">
            <div class="container-fluid">
                <div class="col-sm-9">
                    <a href="index.html" class="btn btn-lg btn-primary" role="button" aria-disabled="true">Wróć do strony głównej</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>