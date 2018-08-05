package tools

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.fest.assertions.api.Assertions.*;

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

import com.kms.katalon.core.annotation.Keyword// main one

//###########################################################################
//ADDING the ReadPDF() CUSTOM KEYWORD TO ANY PROJECT
//First add the pdfbox JAR file to the test project
//1. Open https://pdfbox.apache.org/download.cgi
//2. Download the latest pdfbox JAR file (e.g., pdfbox-2.0.8.jar)
//3. Start Katalon & select "Project > Settings > External Libraries"
//4. Click Add & add the pdfbox-2.0.8.jar libraries to the project & click Apply
//5. Add the following ReadPDF() method custom keyword
//6. After adding the custom keyword press CTRL + SHIFT + O to add the needed libraries
//###########################################################################
//USAGE:
// Call the keyword & pass the PDF URL as the keyword's input
// Use Assert.assertTrue() to verify the results on the PDF
//###########################################################################

@Keyword
def ReadPDF(String PDFURL)
{
	URL TestURL = new URL(PDFURL);
	BufferedInputStream bis = new BufferedInputStream(TestURL.openStream());
	PDDocument doc = PDDocument.load(bis);
	String pdfText = new PDFTextStripper().getText(doc);
	doc.close();
	bis.close();
	println(pdfText);
	//Assert.assertTrue(pdfText.contains("Colors and/or icons may vary from those shown here."));
	//Assert.assertEquals(pdfText.contains("Colors and/or icons may vary from those shown here."));
	assertThat(pdfText, containsString("Colors and/or icons may vary from those shown here."));
	println "PDF IS GOOD TO GO...\r";
}