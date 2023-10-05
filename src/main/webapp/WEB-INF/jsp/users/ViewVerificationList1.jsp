<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Verification List </title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>
<!--<div style="text-align:center; width:100%">
-->
 <div>
    <div>
		<div class="bg-primary text-white-50" style="text-align:center; width:100%">

        <h1 class="p-1" > Verification List</h1>
		</div>

        	<form:form>
            <table class="table table-bordered table-striped table-hover">
            	<tr class="bg-dark text-white">
					<th>Voucher Number</th>
					<th>Month</th>
					<th>Year</th>
					<th>facility</th>
					<th>lab name</th>




					<th>renalFunction</th>
					<th>liverFunction</th>
					<th>lipidProfile</th>
					<th>urinalisysTests</th>
					<th>glucoseToleranceTest30</th>
					<th>glucoseToleranceTest30</th>
					<th>glucoseToleranceTest60</th>
					<th>glucoseToleranceTest90</th>
					<th>verification.glucoseToleranceTest120</th>
					<th>glucoseToleranceTest180</th>
					<th>Hba1c</th>
					<th>fastingBloodGlucose</th>
					<th>urineMicroalbumintest</th>
					<th>twoHourPostPrandialTes</th>

					<th>Edit</th>
					<th>Delete</th>
            	</tr>

            	<c:forEach var="verification" items="${verificationList}">
                    <tr>
                		<td>${verification.voucherNumber}</td>
						<td>${verification.month}</td>


						<td>${verification.year}</td>

						<td>${verification.facility.name}</td>
						<td>${verification.lab.name}</td>

						<td>${verification.renalFunctionTestsVerified}</td>
						<td>${verification.liverFunctionTestsVerified}</td>
						<td>${verification.lipidProfileTestsVerified}</td>
						<td>${verification.urinalisysTestsVerified}</td>
						<td>${verification.glucoseToleranceTest30Verified}</td>
						<td>${verification.glucoseToleranceTest60Verified}</td>

						<td>${verification.glucoseToleranceTest90Verified}</td>
						<td>${verification.glucoseToleranceTest120Verified}</td>
						<td>${verification.glucoseToleranceTest180Verified}</td>

						<td>${verification.hba1cTestVerified}</td>
						<td>${verification.fastingBloodGlucoseTestVerified}</td>
						<td>${verification.urineMicroalbumintestVerified}</td>

						<td>${verification.twoHourPostPrandialTestVerified}</td>



						<td>${verification.lastUpdatedBy}</td>




                		<td><button type="button" class="btn btn-success">
                		    <a href="/editVerification/${verification.id}">Edit</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete?')"  >
                			<a href="/deleteVerification/${verification.id}">Delete</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>

		<div style="text-align:center; width:100%">

        <button type="button" class="btn btn-primary btn-block">
        	<a href="/addVerification">Add New Verification</a>
        </button>


		</div>
    </div>
	 <div class="text-center p-2">
		 <button class="bg-dark text-white" type="button" onclick="tableToCSV()">
			 download CSV
		 </button>
	 </div>

</div>
    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Save Success") {
        				Command: toastr["success"]("Verification added successfully!!")
        			} else if (msg == "Delete Success") {
        				Command: toastr["success"]("Verification deleted successfully!!")
        			} else if (msg == "Delete Failure") {
        			    Command: toastr["error"]("Some error occurred, couldn't delete userEntity")
        			} else if (msg == "Edit Success") {
        				Command: toastr["success"]("Verification updated successfully!!")
        			}

        			toastr.options = {
                          "closeButton": true,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": true,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "showDuration": "300",
                          "hideDuration": "1000",
                          "timeOut": "5000",
                          "extendedTimeOut": "1000",
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }
        	    }
            </script>

<script type="text/javascript">
	function tableToCSV() {

		// Variable to store the final csv data
		var csv_data = [];

		// Get each row data
		var rows = document.getElementsByTagName('tr');
		for (var i = 0; i < rows.length; i++) {

			// Get each column data
			var cols = rows[i].querySelectorAll('td,th');

			// Stores each csv row data
			var csvrow = [];
			for (var j = 0; j < cols.length -2; j++) {

				// Get the text data of each cell
				// of a row and push it to csvrow
				csvrow.push(cols[j].innerHTML);
			}

			// Combine each column value with comma
			csv_data.push(csvrow.join(","));
		}

		// Combine each row data with new line character
		csv_data = csv_data.join('\n');

		// Call this function to download csv file
		downloadCSVFile(csv_data);

	}

	function downloadCSVFile(csv_data) {

		// Create CSV file object and feed
		// our csv_data into it
		CSVFile = new Blob([csv_data], {
			type: "text/csv"
		});

		// Create to temporary link to initiate
		// download process
		var temp_link = document.createElement('a');

		// Download csv file
		temp_link.download = "GfG.csv";
		var url = window.URL.createObjectURL(CSVFile);
		temp_link.href = url;

		// This link should not be displayed
		temp_link.style.display = "none";
		document.body.appendChild(temp_link);

		// Automatically click the link to
		// trigger download
		temp_link.click();
		document.body.removeChild(temp_link);
	}
</script>

</body>

</html>