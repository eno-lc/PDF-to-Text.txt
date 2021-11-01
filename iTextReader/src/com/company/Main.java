package com.company;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Main {

    @Test
    public void ReadPDFFile() throws Exception {
        File file =  new File("C:\\Users\\Sindroma\\Desktop\\TestingFileReaderWriter\\java.pdf");
        FileInputStream fis = new FileInputStream(file);
        PDDocument document = Loader.loadPDF(file);
        long pages = document.getNumberOfPages();
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String documentTxt = pdfTextStripper.getText(document);
        FileWriter writer = new FileWriter("C:\\Users\\Sindroma\\Desktop\\TestingFileReaderWriter\\Java.txt");
        for(int i = 0; i<pages; i++){
            writer.write(documentTxt);
        }
        //System.out.println(documentTxt);
        document.close();
        fis.close();
        writer.close();
    }
}
