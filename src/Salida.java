
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Salida {

    public String addzero(int x) {
        String t;
        if (x < 10) {
            t = "0" + x;
        } else {
            t = "" + x;
        }
        return  t;

    }

    public static JLabel x = new JLabel();

    public void busqueda(String result) {
        boolean encontrado = false;
        for (int i = 0; i < venta1.lstcarrospark.size(); i++) {
            if (venta1.lstcarrospark.get(i).getQr().getData().equals(result)) {
                String fecha_salida = fecha_salida();
                String hora_salida = hora_salida();
                JOptionPane.showMessageDialog(venta1.jPanel4, venta1.lstcarrospark.get(i).getQr().getData() + "\n" + "Fecha y hora de salida: " + fecha_salida + hora_salida);

                encontrado = true;
                venta1.recibirfechsal(fecha_salida, hora_salida, venta1.lstcarros.get(i).getPlaca());
                String t = venta1.lstcarrospark.get(i).getPuesto();
                Salida.Carrerasal carro = new Salida.Carrerasal(8, venta1.lblsal, (Integer.parseInt(t)));
                carro.start();
                int p = Integer.parseInt(venta1.lstcarrospark.get(i).getPuesto()) + 1;
                agregarfechalista(i, fecha_salida, hora_salida, p + "");

                venta1.lstcarrospark.remove(i);
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se econtró informacion con ese qr");

        }
    }

    public void agregarfechalista(int i, String f_sal, String h_sal, String puesto) {
        for (int j = 0; j < venta1.lstcarros.size(); j++) {
            if (venta1.lstcarrospark.get(i).getPlaca().equals(venta1.lstcarros.get(j).getPlaca())) {
                venta1.lstcarros.get(j).setFecha2(f_sal);
                venta1.lstcarros.get(j).setHora2(h_sal);
                venta1.precioapagar(venta1.lstcarros.get(i));
                break;
            }

        }
        for (int y = 0; y < venta1.lista2.getRowCount(); y++) {
            if (puesto.equals(venta1.lista2.getValueAt(y, 0).toString())) {
                venta1.lista2.setValueAt("Disponible", y, 1);
                venta1.lista2.setValueAt("", y, 2);
                venta1.lista2.setValueAt("", y, 3);
                break;
            }
        }
    }

    public String fecha_salida() {
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);   //Metodos para obtener correspondiente la fecha atual del sistema

        mes = mes + 1;
        String fecha_salida = "" + addzero(dia) + "/" + addzero(mes) + "/" + anio + " ";
        return fecha_salida;

    }

    public String hora_salida() {
        Calendar fecha = new GregorianCalendar();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String hora_salida = addzero(hora) + ":" + addzero(minuto) + ":" + addzero(segundo);
        return hora_salida;
    }

    class Carrerasal extends Thread {

        JLabel j;
        int velocidad;
        int btn;
        ImageIcon iconDown = new ImageIcon(getClass().getResource("/imagenes/iconocarDownpng.png"));

        ImageIcon iconUp = new ImageIcon(getClass().getResource("/imagenes/iconocarUp.png"));
        ImageIcon iconRight = new ImageIcon(getClass().getResource("/imagenes/iconocarRight.png"));
        ImageIcon iconLeft = new ImageIcon(getClass().getResource("/imagenes/iconocarLeft.png"));

        public Carrerasal(int velocidad, JLabel j, int t) {
            this.j = j;
            this.velocidad = velocidad;
            this.btn = t;
        }

        @Override
        public void run() {
            venta1.jTabbedPane1.setSelectedIndex(3);

            if (btn < 10) {

                if (!venta1.btnp[btn].isEnabled()) {
                    venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(venta1.btnp[btn].getX(), venta1.btnp[btn].getY(), 36, 70));
                    j.setIcon(iconDown);
                    j.setVisible(true);
                    while (j.getY() < 330) {
                        j.setLocation(j.getX(), j.getY() - 1);
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                    j.setIcon(iconLeft);
                    while (j.getX() > venta1.btnp[9].getLocation().x) {
                        j.setLocation(j.getX() - 1, j.getY());
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                    j.setIcon(iconUp);
                    while (j.getY() > venta1.btnp[19].getLocation().y) {
                        j.setLocation(j.getX(), j.getY() - 1);
                        try {
                            sleep(10 / velocidad);
                        } catch (InterruptedException e) {
                        }
                    }
                    venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                    j.setIcon(iconRight);
                    while (j.getX() < venta1.btnp[btn].getLocation().x) {
                        j.setLocation(j.getX() + 1, j.getY());
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
                    j.setIcon(iconDown);
                    while (j.getY() < venta1.btnp[10].getLocation().y) {
                        j.setLocation(j.getX(), j.getY() + 1);
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 70, 36));
                    j.setIcon(iconLeft);
                    while (j.getX() < 640) {
                        j.setLocation(j.getX() + 1, j.getY());
                        try {
                            sleep(100 / velocidad);
                        } catch (InterruptedException e) {
                        }

                    }
                    venta1.btnp[btn].setEnabled(true);

                    ImageIcon fot = new ImageIcon(getClass().getResource("/imagenes/estacionamiento.jpg"));
                    Icon icono = new ImageIcon(fot.getImage().getScaledInstance(venta1.btnp[btn].getWidth(), venta1.btnp[btn].getHeight(), Image.SCALE_DEFAULT));
                    venta1.btnp[btn].setIcon(icono);
                }

            } else if (btn >= 10 && btn < 19) {

                while (j.getX() < venta1.btnp[19].getLocation().x) {
                    j.setLocation(j.getX() + 1, j.getY());
                    try {
                        sleep(10 / velocidad);
                    } catch (InterruptedException e) {
                    }

                }
                while (j.getY() > venta1.btnp[18].getLocation().y) {
                    j.setLocation(j.getX(), j.getY() - 1);
                    try {
                        sleep(10 / velocidad);
                    } catch (InterruptedException e) {
                    }

                }

                while (j.getX() < venta1.btnp[29].getLocation().x) {
                    j.setLocation(j.getX() + 1, j.getY());
                    try {
                        sleep(10 / velocidad);
                    } catch (InterruptedException e) {
                    }
                }
                while (j.getY() < venta1.btnp[10].getLocation().y) {
                    j.setLocation(j.getX(), j.getY() + 1);
                    try {
                        sleep(10 / velocidad);
                    } catch (InterruptedException e) {
                    }

                }
                while (j.getX() < 640) {
                    j.setLocation(j.getX() + 1, j.getY());
                    try {
                        sleep(10 / velocidad);
                    } catch (InterruptedException e) {
                    }

                }
                venta1.btnp[btn].setEnabled(true);

            }
            venta1.jPanel4.add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(j.getX(), j.getY(), 36, 70));
            j.setVisible(false);

        }
    }
}
