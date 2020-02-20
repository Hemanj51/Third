<%@page import="java.io.*"%>
<%@page import="com.itextpdf.text.Document,com.itextpdf.text.*,com.itextpdf.text.pdf.*"%>
<%@page import="com.itextpdf.text.List,java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*,com.space.db.*,java.io.*,java.util.*"%>
<%
	Connection con = SpaceDBUtil.getConnection();
	PreparedStatement pss = con.prepareStatement("select userid from userdetails where username=?");
	pss.setString(1, (String) session.getAttribute("un"));
	ResultSet rss = pss.executeQuery();
	rss.next();
	int userId = rss.getInt(1);
	PreparedStatement ps8 = con.prepareStatement("select * from reservations where userid=?");
	ps8.setInt(1, userId);
	ResultSet rs8 = ps8.executeQuery();
	ResultSetMetaData rsmd8 = rs8.getMetaData();

	try {

		OutputStream file = new FileOutputStream(
				new File("D:\\respdf\\res.pdf"));
		Document document = new Document();
		PdfWriter.getInstance(document, file);

		//Inserting Image in PDF
		Image image = Image
				.getInstance("C:\\Users\\RAVI\\Desktop\\project\\CoWorkingspace\\src\\main\\webapp\\img\\workspaceLogo.PNG");
		image.scaleAbsolute(120f, 60f);//image width,height	

		//Inserting Table in PDF
		PdfPTable table = new PdfPTable(8);

		PdfPCell cell = new PdfPCell(new Paragraph("COWORKSPACE"));

		cell.setColspan(8);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(10.0f);
		cell.setBackgroundColor(new BaseColor(140, 221, 8));

		table.addCell(cell);

		table.addCell("RID");
		table.addCell("SDATE");
		table.addCell("EDATE");
		table.addCell("OFFICEID");
		table.addCell("BRANCHID");
		table.addCell("USERID");
		table.addCell("NO_SEATS");
		table.addCell("AMOUNT");
		
		/* table.addCell(rsmd8.getColumnName(1));
		table.addCell(rsmd8.getColumnName(2));
		table.addCell(rsmd8.getColumnName(3));
		table.addCell(rsmd8.getColumnName(4));
		table.addCell(rsmd8.getColumnName(5));
		table.addCell(rsmd8.getColumnName(6));
		table.addCell(rsmd8.getColumnName(7));
		table.addCell(rsmd8.getColumnName(8)); */


		if (rs8 != null) {
			while (rs8.next()) {
				table.addCell(rs8.getString(1));
				table.addCell(rs8.getString(2));
				table.addCell(rs8.getString(3));
				table.addCell(rs8.getString(4));
				table.addCell(rs8.getString(5));
				table.addCell(rs8.getString(6));
				table.addCell(rs8.getString(8));
				table.addCell(rs8.getString(7));
			}
		}
		table.setSpacingBefore(30.0f); // Space Before table starts, like margin-top in CSS
		table.setSpacingAfter(30.0f); // Space After table starts, like margin-Bottom in CSS								          

		//Inserting List in PDF
		List list = new List(true, 30);
		list.add(new ListItem("CoreJava"));
		list.add(new ListItem("Advanced Java"));
		list.add(new ListItem("Some Thing..."));

		//Text formating in PDF
		Chunk chunk = new Chunk("Welecome To CoWorkSpace. Your Reservation Successfully Done");
		chunk.setUnderline(+1f, -2f);//1st co-ordinate is for line width,2nd is space between
		Chunk chunk1 = new Chunk("sudaksha.com");
		chunk1.setUnderline(+4f, -8f);
		chunk1.setBackground(new BaseColor(17, 46, 193));

		//Now Insert Every Thing Into PDF Document
		document.open();//PDF document opened........			       

		document.add(image);

		document.add(Chunk.NEWLINE); //Something like in HTML 🙂

		document.add(new Paragraph("Dear CoWorkspace"));
		document.add(new Paragraph("Document Generated On - " + new Date().toString()));

		document.add(table);

		document.add(chunk);
		document.add(chunk1);

		document.add(Chunk.NEWLINE); //Something like in HTML 🙂							    

		document.newPage(); //Opened new page
		document.add(list); //In the new page we are going to add list

		document.close();

		file.close();

		System.out.println("Pdf created successfully..");
		out.println("Pdf Created Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("./User.jsp");
		rd.include(request, response);

	} catch (Exception e) {
		e.printStackTrace();
	}
%>