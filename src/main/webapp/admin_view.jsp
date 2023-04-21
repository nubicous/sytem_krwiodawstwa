
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*,back.BloodStation" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel admina</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="Bootstrap.css">
</head>

<body>
<div class="bg-image"></div>
<div class="d-flex justify-content-center align-items-center">
    <div class="container">
        <div class="row justify-content-center align-self-center mt-3">
            <table class="table table-striped">

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

                <c:forEach var="tmpPoint" items="${BLOOD_STATIONS_LIST}">

                            <%-- definiowanie linkow--%>
                    <c:url var="updateLink" value="AdminServlet">
                        <c:param name="command" value="LOAD"></c:param>
                        <c:param name="bloodStationID" value="${tmpPoint.id}"></c:param>
                    </c:url>

                    <c:url var="deleteLink" value="AdminServlet">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="bloodStationID" value="${tmpPoint.id}"></c:param>
                    </c:url>


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
                        <td>
                            <div class="btn-group">
                            <a href="${updateLink}">
                            <button type="button" class="btn btn-sm btn-success mx-2">Zmień dane</button>
                            </a>
                            <a href="${deleteLink}"
                               onclick="if(!(confirm('Czy na pewno chcesz usunąć ten punkt?'))) return false">
                                <button type="button" class="btn btn-sm btn-danger mx-2">Usuń</button>
                            </a>
                            </div>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row justify-content-center align-self-center">
            <div class="container-fluid">
                <div class="col-sm-9">
                    <a class="btn btn-lg btn-primary btn-info mt-3" href="add_station_form.jsp" role="button">Dodaj punkt</a>
                </div>
            </div>
        </div>

        <div class="row justify-content-center align-self-center mt-3">
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

                <%-- definiowanie linkow--%>
                <c:url var="updateLink" value="AdminServlet">
                    <c:param name="command" value="LOAD_STATUS"></c:param>
                </c:url>

                <tr>
                    <td>${tmpStatus.rhdPlusA}</td>
                    <td>${tmpStatus.rhdPlusB}</td>
                    <td>${tmpStatus.rhdPlusAB}</td>
                    <td>${tmpStatus.rhdPlus0}</td>
                    <td>${tmpStatus.rhdMinusA}</td>
                    <td>${tmpStatus.rhdMinusB}</td>
                    <td>${tmpStatus.rhdMinusAB}</td>
                    <td>${tmpStatus.rhdMinus0}</td>
                    <td>
                        <a href="${updateLink}">
                            <button type="button" class="btn btn-sm btn-success">Zmień dane</button>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="row justify-content-center align-self-center mt-3">
            <div class="container-fluid">
                <div class="col-sm-9">
                    <a href="index.html" class="btn btn-lg btn-primary" role="button" aria-disabled="true">Wróć do strony
                        głównej</a>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</body>
</html>