package pe.edu.ulasalle.dima.audata.text_pdf.library;

//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface IReaderPdf {

	public String readPDF( FileInputStream fstream ) throws FileNotFoundException, IOException;
	
}
