package Client;

import javafx.util.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class Client {
    Socket socket = null;
    PrintWriter out = null;
    ObjectInputStream in;
    BufferedReader inConsole;

    public Client() {
        try {
            socket = initSocket(); /* здесь "ИМЯ_СЕРВЕРА" компьютер, на котором стоит сервер-сокет"*/
            out = initPrintWriter();
            in = new ObjectInputStream(socket.getInputStream());
            inConsole = new BufferedReader(new InputStreamReader(System.in));
            processedClient();
        } catch (IOException|ClassNotFoundException e) {
            Log.logger.error(e.getLocalizedMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.logger.error(e.getLocalizedMessage());
                }
            }
            if (socket != null) {
                try { // разрыв соединения
                    socket.close();
                } catch (IOException e) {
                    Log.logger.error(e.getLocalizedMessage());
                }
            }
        }
    }

    private void processedClient() throws IOException, ClassNotFoundException {
        String expression;
        while (true){
            System.out.println("Enter expression:");
            expression=inConsole.readLine();
            out.println(expression);
            Document doc = (Document) in.readObject();
            PlotFunction(doc, expression);
            System.out.println("Enter \"yes\" if you want continue work with this program");
            if(!inConsole.readLine().equalsIgnoreCase("yes"))
               break;
        }
    }


    Socket initSocket() throws IOException {
        return  new Socket(InetAddress.getLocalHost(), 8080);
    }

    PrintWriter initPrintWriter() throws IOException {
        return new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())),
                true);
    }

    static XYSeries xySeriesFromXMm(Document doc,String expression){
        XYSeries series = new XYSeries(expression);
        Element root = doc.getDocumentElement();
        if (root.getTagName().equals("Plot")){
            NodeList plot = root.getElementsByTagName("point");
            for(int i = 0; i<plot.getLength();i++){
                Element point = (Element)plot.item(i);
                Double x = Double.parseDouble(point.getAttribute("x"));
                Double y = Double.parseDouble(point.getAttribute("y"));
                series.add(x, y);
            }
        }
        return series;
    }

    private static boolean PlotFunction(Document doc,String expression){
        if(doc==null){
            System.out.println("Input format data exception");
            return false;
        }
        XYSeries series = xySeriesFromXMm(doc,expression);
        JFreeChart chart = createJFreeChart(expression,series);
        JFrame frame = createJfame(chart);
        frame.show();
        return true;
    }


    static JFreeChart  createJFreeChart(String expression,  XYSeries series){
        XYDataset xyDataset = new XYSeriesCollection(series);
        return ChartFactory
                .createXYLineChart(expression, "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

    }

    static JFrame createJfame(JFreeChart chart){
        JFrame frame =
                new JFrame("MinimalStaticChart");
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        return frame;
    }


}
