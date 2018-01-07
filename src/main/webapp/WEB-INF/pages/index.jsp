<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
                title: 'Company Performance',
                curveType: 'function',
                legend: { position: 'bottom' }

            };

            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div id="curve_chart" style="width: 1500px; height: 500px"></div>
</body>
</html>