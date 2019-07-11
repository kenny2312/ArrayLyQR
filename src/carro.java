
import com.barcodelib.barcode.QRCode;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kenny
 */
public class carro {

    private String placa;
    private String fecha1;
    private String fecha2;
    private String hora1;
    private String hora2;
    private QRCode qr;
    private String puesto;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public QRCode getQr() {
        return qr;
    }

    public void setQr(QRCode qr) {
        this.qr = qr;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public carro() {

    }

    public carro(String placa, String fecha1, String fecha2, String hora1, String hora2) {
        this.placa = placa;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.hora1 = hora1;
        this.hora2 = hora2;

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
