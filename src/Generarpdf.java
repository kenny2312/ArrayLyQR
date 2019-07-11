
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HOME
 */
public class Generarpdf {

    private Font fuenteBold = new Font(Font.FontFamily.COURIER, 15, Font.BOLD);
    private Font TitulofuenteBoldnew = new Font(Font.FontFamily.COURIER, 30, Font.BOLD);

    public void generarpdf(String info, String rutaimagen, String salida) {
        try {
            Document document = new Document(PageSize.A4, 36, 36, 10, 10);
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            document.add(getTitle());
            document.add(getInfo(info));
            document.add(getTexto());
            Image imagen = Image.getInstance(rutaimagen);
            imagen.scaleAbsolute(100, 100);
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);
            document.add(getInfo("\n" + " Recuerde presentar el ticket a la salida del parqueadero."));

            document.close();

            Desktop d = Desktop.getDesktop();
            File x = new File(salida);
            d.open(x);
            d.print(x);

        } catch (Exception e) {

        }

    }

    private Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_LEFT);
        c.append(texto + "\n " + " ");
        c.setFont(fuenteBold);
        p.add(c);
        return p;

    }

    private Paragraph getTitle() {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.TITLE);
        c.append("Parqueadero Ups\n" + " ");
        c.setFont(TitulofuenteBoldnew);
        p.add(c);
        return p;

    }

    private Paragraph getTexto() {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append("Recuerde no dejar objetos valiosos en el auto, la empresa no se responzabiliza por daños causados u objetos extraviados dentro del mismo.");
        c.setFont(fuenteBold);
        p.add(c);
        return p;

    }
}
