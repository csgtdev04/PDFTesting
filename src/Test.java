import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Test {
    public static void main(String[] args) throws IOException {
        //Loading an existing document
        File file = new File("Sample.pdf");
        PDDocument document = PDDocument.load(file);
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        System.out.println(text);


        // Logic
        final String MONTHS = "January February March December";
        final String DATES = "12345678910111213141516171819202122232425262728293031"; // dates
        // sometimes formatted differently
        ArrayList<String> month = new ArrayList<>();
        ArrayList<String> day = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();


        Scanner fileScanner = new Scanner(text);
        while (fileScanner.hasNext()) {
            String text1 = fileScanner.next();
            if (MONTHS.contains(text1)) {
                month.add(text1);
            }
            if (DATES.contains(text1)) {
                day.add(text1);
            }
        }
        System.out.println(month);
        System.out.println(day);





        //Closing the document
        document.close();
    }
}
