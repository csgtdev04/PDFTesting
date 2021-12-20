import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        final String DATES = "1st 2nd 3rd 4th";
        final String DATES_v2 = "1 2 3 4"; // dates sometimes formatted differently
        ArrayList<String> month = new ArrayList<>();
        ArrayList<String> day = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();



        Scanner fileScanner = new Scanner(text);
        while (fileScanner.hasNext()) {
            if (MONTHS.contains(fileScanner.next())) {
                month.add(fileScanner.next());
            }
            if (DATES.contains(fileScanner.next()) || DATES_v2.contains(fileScanner.next())) {
                day.add(fileScanner.next());
            } else {
                day.add("-1");
            }

        }
        System.out.println(month);
        System.out.println(day);





        //Closing the document
        document.close();
    }
}
