package com.howtodoinjava.examples;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ReadModifyPdfExample {
	public static void main(String[] args) {
		try {
			// Read file using PdfReader
			PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

			// Modify file using PdfReader
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("HelloWorld-modified.pdf"));
			// ảnh nền
			Image image = Image.getInstance("hoa-don-ban-le.png");
			image.scaleAbsolute(400, 400);
			image.setAbsolutePosition(100f, 400f);

			for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
				PdfContentByte content = pdfStamper.getUnderContent(i);
				content.addImage(image);
			}

			pdfStamper.close();

		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
