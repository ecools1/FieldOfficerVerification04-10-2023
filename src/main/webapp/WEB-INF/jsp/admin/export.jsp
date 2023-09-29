<%@ page import="java.io.*,java.sql.*"%>
<html>
<head>
    <title>export</title>
</head>
<body>
    <%
        String filename = "c:\\csv\\csv_file.csv";
        FileWriter fw = new FileWriter(filename);
        try{


            fw.append("Voucher Number");
            fw.append(',');
            fw.append("Health Region");
            fw.append(',');
            fw.append("ghfghFacility");
            fw.append(',');
            fw.append("City Name");
            fw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
        out.println("File successfully Created Csv file.");

        }
    %>

</body>
</html>