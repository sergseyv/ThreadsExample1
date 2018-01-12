<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Factorial calculation speed - Google charts</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('number', 'number');
            data.addColumn('number', '1 thread');
            data.addColumn('number', '2 threads');
            <c:forEach var="chData" items="${chartData}">
                data.addRow([${chData.key}, ${chData.value1} , ${chData.value2}]);
            </c:forEach>
            var options = {
                title: 'Factorial calculation speed',
                curveType: 'function',
                legend: { position: 'bottom' },
                vAxis: {
                    title: 'Calculation time (milliseconds)',
                    logScale: false
                },
                hAxis: {
                    title: 'Number for factorial calculation',
                    logScale: false
                }
            };
            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
            chart.draw(data, options);
        }
    </script>
</head>

<body>

<table width=1000px border="1" cellpadding="10" bgcolor="#e0ffff">
    <tr>
        <td width="50%" valign="top">
            Графики показывают разницу в скорости вычисления факториала
            одним и двумя потоками.
            <p><b>Внимание!</b><br>
            Вычисление слишком больших факториалов может занять некоторое время!
        </td>
        <td valign="top">
            The graphs shows the difference in the speed of calculating factorial
            by one and two threads.
            <p><b>Warning:</b><br>
            Calculating too large factorials may take some time!
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center" valign="bottom">
            <form:form method="POST" action="calculate" modelAttribute="valInit">
                <table>
                    <tr>
                        <td><samp><b>Start value: </b></samp></td>
                        <td><form:input path="valStart"/></td>
                    </tr>
                    <tr>
                        <td><samp><b>Finish value: </b></samp></td>
                        <td><form:input path="valFinish"/></td>
                    </tr>

                    <tr>
                        <td><samp><b>Step: </b></samp></td>
                        <td><form:input path="valStep"/></td>
                    </tr>
                    <tr align="right">
                        <td colspan="2" align="right"><br><button class = "btn" type="submit">Calculate!</button></td>
                    </tr>
                </table>
            </form:form>

        </td>
    </tr>
</table>

<div class="chart" id="curve_chart" style="width: 1000px; height: 500px"></div>

</body>
</html>