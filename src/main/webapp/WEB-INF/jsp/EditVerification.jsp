<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Verification</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js">
		</script>
	<style>
		select {
			margin-bottom: 10px;
			margin-top: 10px;
		}
	</style>
	<script src=
					"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	</script>

	<script type="text/javascript">
		$(document).ready(()=>{
			$("#facility").val('2');
		});
	</script>
</head>
<body>

    <div class="container">

        <h1 class="text-center bg-success text-white-50"> Edit Verification </h1>

        <form:form action="/editSaveVerification" method="post" modelAttribute="verification">


                    	<div class="form-group col-md-12">
                    		<div class="col-md-6">
                    			<form:hidden path="id" class="form-control input-sm" />
                    		</div>
                    	</div>


		<div class="row">
			<div>
				<table class="table table-striped table-hover">
					<tr><td></td><td></td>

						<td><label for="voucherNumber">Voucher Number:</label></td>
						<td><form:input type="text" path="voucherNumber" id="name" class="form-control input-sm" required="required" /></td></tr>


					<td><label for="voucherNumber">facility:</label></td>
					<td><form:input type="text" path="facilityId" id="FacilityId" class="form-control input-sm" required="required" /></td></tr>

					<tr><td></td><td></td>
						<td><label>Facility:</label></td>
						<td>
							<form:select  id="facility" name="facility" path="facility" cssClass="form-control" required="true">

								<c:forEach items="${facilityOptions}" var="facilityOption">

									<form:option value="${facilityOption.id}">${facilityOption.name} </form:option>
								</c:forEach>

							</form:select>

						</td>

					</tr>


					<tr><td></td><td></td>
						<td><label>lab:</label></td>
						<td>
							<form:select  id="lab.name" name="lab.name" path="lab.name" cssClass="form-control" required="true">
								<option value="">--Select Lab---</option>
								<c:forEach items="${labsOptions}" var="labOption">

									<option value="${labOption.id}">${labOption.name} </option>
								</c:forEach>

							</form:select>

						</td>

					</tr>


					<tr><td></td><td></td>

					</tr>


				</table>



					</div>







								<table>

								</table>


							<table class="table table-striped table-hover" border="1">
								<tr><td colspan="8" style="text-align: center"><b>lab Tests</b></td></tr>
								<tr>
									<td><label for="renalFunctionTestsVerified">Renal</label></td>
									<td><form:checkbox path="renalFunctionTestsVerified" id="renalFunctionTestsVerified"
													   class="form-control input-sm"/></td>

									<td><label for="liverFunctionTestsVerified">Liver</label></td>
									<td><form:checkbox path="liverFunctionTestsVerified" id="liverFunctionTestsVerified"
													   class="form-control input-sm"/></td>

									<td><label for="lipidProfileTestsVerified">Lipid</label></td>
									<td><form:checkbox path="lipidProfileTestsVerified" id="lipidProfileTestsVerified"
													   class="form-control input-sm"/></td>

									<td><label for="urinalisysTestsVerified">Urinalisys</label></td>
									<td><form:checkbox path="urinalisysTestsVerified" id="urinalisysTestsVerified"
													   class="form-control input-sm"/></td>
								</tr>
								<tr>
									<td><label for="glucoseToleranceTest30Verified">30</label></td>
									<td><form:checkbox path="glucoseToleranceTest30Verified" id="glucoseToleranceTest30Verified"
													   class="form-control input-sm"/></td>

									<td><label for="glucoseToleranceTest60Verified">60</label></td>
									<td><form:checkbox path="glucoseToleranceTest60Verified" id="glucoseToleranceTest60Verified"
													   class="form-control input-sm"/></td>

									<td><label  for="glucoseToleranceTest90Verified">90</label></td>
									<td><form:checkbox path="glucoseToleranceTest90Verified" id="glucoseToleranceTest90Verified"
													   class="form-control input-sm"/></td>
									<td><label  for="glucoseToleranceTest120Verified">120</label></td>
									<td><form:checkbox path="glucoseToleranceTest120Verified" id="glucoseToleranceTest120Verified"
													   class="form-control input-sm"/></td>
								</tr>
								<tr>
									<td><label  for="glucoseToleranceTest180Verified">180</label></td>
									<td><form:checkbox path="glucoseToleranceTest180Verified" id="glucoseToleranceTest180Verified"
													   class="form-control input-sm"/></td>

									<td><label for="hba1cTestVerified">Hba1c</label></td>
									<td><form:checkbox path="hba1cTestVerified" id="hba1cTestVerified"
													   class="form-control input-sm"/></td>

									<td><label  for="fastingBloodGlucoseTestVerified">FBG</label></td>
									<td><form:checkbox path="fastingBloodGlucoseTestVerified" id="fastingBloodGlucoseTestVerified"
													   class="form-control input-sm"/></td>

								</tr>
							</table>





 			<table class="table table-striped table-hover">
			<tr><td rowspan="7">


                    		<button type="submit" value="Register" class="btn btn-success btn-block btn-group-lg">Save</button>
			</td></tr>
 			</table>

                </form:form>

    </div>
	<script>

		const textToFind = document.getElementById("labNameDB").value
		var dd = document.getElementById('lab.name');
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

		const textToFindHR = document.getElementById("HealthRegionDB").value
		var dd = document.getElementById('healthRegion');
		for (var i = 0; i < dd.options.length; i++) {
			if (dd.options[i].text === textToFindHR) {
				dd.selectedIndex = i;
				break;
			}
		}
	</script>
    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Edit Failure") {
        				Command: toastr["error"]("Something went wrong with the edit.")
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