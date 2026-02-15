
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container">
    <div class="row">
        <div class="col-2">
        </div>
        <div class="col-6">
            <p style="text-align: center">CALCULATOR</p>
            <FORM ACTION="/calc" method="post">
                <input name="num1" type="number" step="0.01" id = "num1" placeholder="num1" >
                <select name="operations">
                    <option selected value="plus">+</option>
                    <option value="minus">-</option>
                    <option value="div">/</option>
                    <option value="multi">*</option>
                </select>
                <input name="num2" type="number" step="0.01" id = "num2" placeholder="num2">
                <button type="submit">Calculate</button>
            </FORM>
            <span>${result}</span>
        </div>
        <div class="col-2">

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
