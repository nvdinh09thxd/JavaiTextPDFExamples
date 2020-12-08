package com.howtodoinjava.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class JavaPdfHelloWorld {
	public static void main(String[] args) {
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
			document.open();
			document.add(new Paragraph("A Hello World PDF document1."));
			document.add(new Paragraph("A Hello World PDF document2."));
			document.add(new Paragraph("A Hello World PDF document3."));
			document.close();
			System.out.println("Đã tạo ra file pdf!");
			writer.close();
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}