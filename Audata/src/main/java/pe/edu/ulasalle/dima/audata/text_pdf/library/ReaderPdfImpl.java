package pe.edu.ulasalle.dima.audata.text_pdf.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ReaderPdfImpl implements IReaderPdf {

	public String readPDF(FileInputStream fstream) throws IOException {
		
		InputStream instream = fstream;
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();

        if (!document.isEncrypted()) {
		
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);

            PDFTextStripper tStripper = new PDFTextStripper();

            String pdfFileInText = tStripper.getText(document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (String line : lines) {
            	str.append(line);
            }
        }
        
		return str.toString();
		
	}

	
	@Override
	public String readPDF(FileInputStream fstream, int pagIni, int pagFin) throws IOException{
		
		InputStream instream = fstream;
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();

        if (!document.isEncrypted()) {
		
            PDFTextStripper tStripper = new PDFTextStripper();

            tStripper.setStartPage(pagIni);
            tStripper.setEndPage(pagFin);
            
            String pdfFileInText = tStripper.getText(document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (String line : lines) {
            	str.append(line);
            }
        }
        
		return str.toString();
	}


	@Override
	public String readPDF(FileInputStream fstream, int page) throws IOException {
		
		InputStream instream = fstream;
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();

        if (!document.isEncrypted()) {
		
            PDFTextStripper tStripper = new PDFTextStripper();

            tStripper.setStartPage(page);
            tStripper.setEndPage(page);
            
            String pdfFileInText = tStripper.getText(document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (String line : lines) {
            	str.append(line);
            }
        }
        
		return str.toString();
	}

	
	@Override
	public int numeroPaginas(FileInputStream fstream) throws IOException {
		
		InputStream instream = fstream;
		int count = 0;
		
		try (PDDocument document = PDDocument.load(instream)){
			if (!document.isEncrypted()) {
				count = document.getNumberOfPages();	
				return count;
			}
		} catch (Exception e) {
			System.err.println("Documento encriptado!");
		}
		
		return count;
	}


	@Override
	public int bookmarkPagIni(FileInputStream fstream, String bookmark) throws IOException {
		InputStream instream = fstream;
    	PDDocument doc = PDDocument.load(instream);
        PDDocumentOutline outline =  doc.getDocumentCatalog().getDocumentOutline();
        
        LinkedHashMap<String,Integer> listBookmarks = new LinkedHashMap<String,Integer>();
		listBookmark(outline,listBookmarks);
		
		return listBookmarks.get(bookmark);
	}


	public LinkedHashMap<String, Integer> listBookmark(PDOutlineNode bookmark,
			LinkedHashMap<String, Integer> listBookmarks) throws IOException {
        
		PDOutlineItem current = bookmark.getFirstChild();
        while (current != null) {
            if (current.getDestination() instanceof PDPageDestination) {
                PDPageDestination pd = (PDPageDestination) current.getDestination();
                int rpn = pd.retrievePageNumber()+1;
                listBookmarks.put(current.getTitle(), rpn);
            }
            if (current.getAction() instanceof PDActionGoTo) {
                PDActionGoTo gta = (PDActionGoTo) current.getAction();
                if (gta.getDestination() instanceof PDPageDestination) {
                    PDPageDestination pd = (PDPageDestination) gta.getDestination();
                    int rpn = pd.retrievePageNumber()+1;
                    listBookmarks.put(current.getTitle(), rpn);
                }
                
            }
            listBookmark(current,listBookmarks);
            current = current.getNextSibling();
        }
		return listBookmarks;
	}
	
	
}
