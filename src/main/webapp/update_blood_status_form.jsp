<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.04.2023
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Blood Status</title>
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

            <form action="AdminServlet" method="get">
                <input type="hidden" name="command" value="UPDATE_STATUS"/>
                <input type="hidden" name="bloodStatusID" value="${BLOOD_STATUS.id}"/>
                <div class="form-group">
                    <label for="rhdPlusA">RhdPlusA</label>
                    <select class="form-control" id="rhdPlusA" name="rhdPlusAInput">
                        <option value="Niski" ${BLOOD_STATUS.rhdPlusA == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdPlusA == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdPlusA == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdPlusB">RhdPlusB</label>
                    <select class="form-control" id="rhdPlusB" name="rhdPlusBInput">
                        <option value="Niski" ${BLOOD_STATUS.rhdPlusB == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdPlusB == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdPlusB == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdPlusAB">RhdPlusAB</label>
                    <select class="form-control" id="rhdPlusAB" name="rhdPlusABInput">
                        <option value="Niski" ${BLOOD_STATUS.rhdPlusAB == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdPlusAB == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdPlusAB == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdPlus0">RhdPlus0</label>
                    <select class="form-control" id="rhdPlus0" name="rhdPlus0Input">
                        <option value="Niski" ${BLOOD_STATUS.rhdPlus0 == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdPlus0 == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdPlus0 == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdMinusA">RhdMinusA</label>
                    <select class="form-control" id="rhdMinusA" name="rhdMinusAInput">
                        <option value="Niski" ${BLOOD_STATUS.rhdMinusA == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdMinusA == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdMinusA == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdMinusB">RhdMinusB</label>
                    <select class="form-control" id="rhdMinusB" name="rhdMinusBInput">
                        <option value="Niski" ${BLOOD_STATUS.rhdMinusB == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdMinusB == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdMinusB == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdMinusAB">RhdMinusAB</label>
                    <select class="form-control" id="rhdMinusAB" name="rhdMinusABInput">
                        <option value="Niski" ${BLOOD_STATUS.rhdMinusAB == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdMinusAB == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdMinusAB == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="rhdMinus0">RhdMinus0</label>
                    <select class="form-control" id="rhdMinus0" name="rhdMinus0Input">
                        <option value="Niski" ${BLOOD_STATUS.rhdMinus0 == "Niski" ? 'selected' : ''}>Niski</option>
                        <option value="Średni" ${BLOOD_STATUS.rhdMinus0 == "Średni" ? 'selected' : ''}>Średni</option>
                        <option value="Wysoki" ${BLOOD_STATUS.rhdMinus0 == "Wysoki" ? 'selected' : ''}>Wysoki</option>
                    </select>
                </div>
                <div class="d-flex justify-content-evenly">
                    <button type="submit" class="btn btn-lg btn-success mt-3 mx-2" style="width: 300px">Zmień dane</button><br>
                    <a href="AdminServlet" class="btn btn-lg btn-primary mt-3 mx-2" style="width: 300px" role="button"
                       aria-disabled="true">Wróć do zestawienia</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
