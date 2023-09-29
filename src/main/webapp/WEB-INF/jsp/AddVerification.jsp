<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add Verification</title>

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
		select {
			margin-bottom: 10px;
			margin-top: 10px;
		}
	</style>
	<script>
			function validate(){
				var lab = document.verified.lab.value;
				if(lab.value=="0"){
					alert("Please select a lab");
					document.verified.lab.focus();
					return false;
				}
			}
	</script>

	<script>

		function extractYearMonth() {
			let inputMonth = document.getElementById("monthInputText").value;
			let year = parseInt(inputMonth.substring(0, 4));
			let month = parseInt(inputMonth.substring(5));

			// Set hidden fields to be submitted with the form
			document.getElementById("yearInput").value = year;
			document.getElementById("monthInput").value = month;
			console.log(year + " year ");
			console.log(month);
		}
	</script>

</head>
<body>

    <div class="container">

        <h1 class="text-center bg-success text-white-50"> Add Verification </h1>

        <form:form action="/saveVerification" method="post" modelAttribute="verification" name="verified" onsubmit="extractYearMonth()">

		<div class="row">
			<div hidden class="form-group col-md-12">
				<div  class="col-md-6">
					<form:hidden path="id" class="form-control input-sm" />
					<input type="number" name="yearInput" id="yearInput" path="year" class="form-control input-sm" />
					<input type="number"  name="monthInput" id="monthInput" path="month" class="form-control input-sm" />
				</div>
			</div>
		</div>

		<div class="row">
			<div>
				<table>
					<tr><td></td>
						<td><label  for="voucherNumber">Voucher Number:</label></td>
						<td><form:input type="text" path="voucherNumber" id="name" class="form-control input-sm" required="true" /></td></tr>

					<td></td>
					<tr><td></td>
						<td><label>Facility:</label></td>
						<td>
							<form:select  id="facility" name="facility" path="facility" cssClass="form-control" required="true">
								<form:option value="">--Select facility---</form:option>
								<c:forEach items="${facilityOptions}" var="facilityOption">

									<form:option value="${facilityOption.id}">${facilityOption.name} </form:option>
								</c:forEach>

							</form:select>

						</td>

					</tr>
					<tr><td></td>
						<td><label>lab:</label></td>
						<td>
							<form:select  id="lab" name="lab" path="lab" cssClass="form-control" required="true">
								<form:option value="">--Select Lab---</form:option>
								<c:forEach items="${labsOptions}" var="labOption">

									<form:option value="${labOption.id}">${labOption.name} </form:option>
								</c:forEach>

							</form:select>

						</td>

					</tr>

					<tr><td></td>

						<td>
							<label>Month:</label></td>
						<td><input type="month"  id="monthInputText" required="required" name="monthInputText" min="2023-7" class="form-control"></td>
					</tr>

				</table>


			</div>
		</div>

						<div class="row">
							<table class="table table-striped table-hover" border="1">
								<tr><td colspan="8" style="text-align: center"><b>lab Tests</b></td></tr>
								<tr>
									<td><label for="renalFunctionTestsVerified">Renal Function</label></td>
									<td><form:checkbox path="renalFunctionTestsVerified" id="renalFunctionTestsVerified"
													   class="form-control input-sm"/></td>

									<td><label for="liverFunctionTestsVerified">Liver Function</label></td>
									<td><form:checkbox path="liverFunctionTestsVerified" id="liverFunctionTestsVerified"
													   class="form-control input-sm"/></td>

									<td><label for="lipidProfileTestsVerified">Lipid Profile</label></td>
									<td><form:checkbox path="lipidProfileTestsVerified" id="lipidProfileTestsVerified"
													   class="form-control input-sm"/></td>
								</tr>
								<tr>
									<td><label for="urinalisysTestsVerified">Urinalisys</label></td>
									<td><form:checkbox path="urinalisysTestsVerified" id="urinalisysTestsVerified"
													   class="form-control input-sm"/></td>


									<td><label for="glucoseToleranceTest30Verified">Glucose Tolerance Test30</label></td>
									<td><form:checkbox path="glucoseToleranceTest30Verified" id="glucoseToleranceTest30Verified"
													   class="form-control input-sm"/></td>

									<td><label for="glucoseToleranceTest60Verified">Glucose Tolerance Test60</label></td>
									<td><form:checkbox path="glucoseToleranceTest60Verified" id="glucoseToleranceTest60Verified"
													   class="form-control input-sm"/></td>
								</tr>
								<tr>

									<td><label  for="glucoseToleranceTest90Verified">Glucose Tolerance Test90</label></td>
									<td><form:checkbox path="glucoseToleranceTest90Verified" id="glucoseToleranceTest90Verified"
													   class="form-control input-sm"/></td>

									<td><label  for="glucoseToleranceTest120Verified">Glucose Tolerance Test120</label></td>
									<td><form:checkbox path="glucoseToleranceTest120Verified" id="glucoseToleranceTest120Verified"
													   class="form-control input-sm"/></td>

									<td><label  for="glucoseToleranceTest180Verified">Glucose Tolerance Test180</label></td>
									<td><form:checkbox path="glucoseToleranceTest180Verified" id="glucoseToleranceTest180Verified"
													   class="form-control input-sm"/></td>
								</tr>
								<tr>

									<td><label for="hba1cTestVerified">hba1c </label></td>
									<td><form:checkbox path="hba1cTestVerified" id="hba1cTestVerified"
													   class="form-control input-sm"/></td>

									<td><label  for="fastingBloodGlucoseTestVerified">Fasting Blood Glucose</label></td>
									<td><form:checkbox path="fastingBloodGlucoseTestVerified" id="fastingBloodGlucoseTestVerified"
													   class="form-control input-sm"/></td>

									<td><label  for="urineMicroalbumintestVerified">Urine Microalbumin</label></td>
									<td><form:checkbox path="urineMicroalbumintestVerified" id="urineMicroalbumintestVerified"
													   class="form-control input-sm"/></td>

								</tr>



								<tr>

									<td><label for="twoHourPostPrandialTestVerified"> Two Hour Post Prandial</label></td>
									<td><form:checkbox path="twoHourPostPrandialTestVerified" id="twoHourPostPrandialTestVerified"
													   class="form-control input-sm"/></td>

									<td colspan="4"><label  for="notes">Notes</label>
									<form:textarea path="notes" id="notes"
													   class="form-control input-sm"/></td>


								</tr>



							</table>


						</div>










            	<div class="text-center m-2">
            		<button type="submit" value="Register" class="btn btn-success btn-block">Save</button>
				</div>


        </form:form>
	</div>

    </div>

	<script>

		const textToFind = document.getElementById("labNameDB").value
		var dd = document.getElementById('labName');
		for (var i = 0; i < dd.options.length; i++) {
			if (dd.options[i].text === textToFind) {
				dd.selectedIndex = i;
				break;
			}
		}

		const textToFindFac = document.getElementById("facilityDB").value
		var dd = document.getElementById('facility');
		for (var i = 0; i < dd.options.length; i++) {
			if (dd.options[i].text === textToFindFac) {
				dd.selectedIndex = i;
				break;
			}
		}
	</script>

		<script th:inline="javascript">
            window.onload = function() {

                var msg = "${message}";
                console.log(msg);
                if (msg == "Save Failure") {
    				Command: toastr["error"]("Something went wrong with the save.")
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

</body>

</html>