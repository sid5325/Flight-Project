package com.demo.utility;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.demo.entities.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	public void pdfGenerator(User user) {

		Document document = new Document();
		String path = "D:\\pdf Generator\\";
		System.out.println("Inside pdf");
		try {
			FileOutputStream fos = new FileOutputStream("D:\\\\pdf Generator\\\\" + user.getPnrNumber() + ".pdf");
			PdfWriter.getInstance(document, fos);
			document.open();
			Paragraph title = new Paragraph("BOOKING DETAILS",
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(20, 255, 255)));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			document.add(new Paragraph(" "));
			Paragraph pnr = new Paragraph("PNR  " + " " + user.getPnrNumber());
			document.add(pnr);
			System.out.println("para started");
			Paragraph fname = new Paragraph("AIRLINE  " + " ");
			fname.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(fname);

			Paragraph fNum = new Paragraph("Flight No. " + " " + (user.getFlightNumber()));
			fname.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(fNum);
			Paragraph seat = new Paragraph("SEAT BOOKED " + " " + (user.getPassenger().size()));
			fname.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(seat);

			/*
			 * Paragraph fromPlace=new Paragraph("From "+" "+ pdf.getFrom());
			 * fname.setAlignment(Element.ALIGN_RIGHT); document.add(fromPlace); Paragraph
			 * to=new Paragraph("TO "+" "+ user.get);
			 * fname.setAlignment(Element.ALIGN_RIGHT); document.add(to); Paragraph dept=new
			 * Paragraph("DEPT TIME "+" "+ pdf.getDeptName());
			 * fname.setAlignment(Element.ALIGN_RIGHT); document.add(dept); Paragraph
			 * arrt=new Paragraph("ARR. TIME "+" "+ pdf.getArrTime());
			 * fname.setAlignment(Element.ALIGN_RIGHT); document.add(arrt);
			 */

			Paragraph pass = new Paragraph("PASSENGER DETAILS",
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(200, 200, 255)));
			title.setAlignment(Element.ALIGN_LEFT);

			fname.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(pass);

			for (int i = 0; i < user.getPassenger().size(); i++) {
				System.out.println("passenger for loop");
				Paragraph passengers = new Paragraph("Name " + user.getPassenger().get(i).getName() + "  Gender "
						+ user.getPassenger().get(i).getGender());
				passengers.setAlignment(Element.ALIGN_CENTER);
				document.add(passengers);
			}
			document.close();
			fos.close();
			System.out.println("pdf generated");
		} catch (Exception ex) {

		}

	}
}
