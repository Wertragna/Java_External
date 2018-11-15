package Client;

import Server.Log;
import org.jfree.data.xy.XYSeries;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static Server.ServerThread.calculate;
import static org.junit.Assert.*;

public class ClientTest {
    String funk="x+5";
    @Test
    public void xySeriesFromXMm_Doc_correctXySeries() {
        XYSeries xySeriesFromXMm =Client.xySeriesFromXMm(createXmlOfFunction(funk),funk);
        assertEquals(xySeries(funk),xySeriesFromXMm);
    }
    private Document createXmlOfFunction(String funk)  {
        Document doc = null;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            db = builderFactory.newDocumentBuilder();
            doc = db.newDocument();
            Element root = doc.createElement("Plot");
            doc.appendChild(root);
            for (int i = 0; i < 10; i++) {
                Element point = doc.createElement("point");
                point.setAttribute("x", Integer.toString(i));
                point.setAttribute("y", Integer.toString(i));
                root.appendChild(point);
            }
            return doc;
        }
        catch (RuntimeException | ParserConfigurationException e){
            return null;
        }
    }
    static XYSeries xySeries(String expression){
        XYSeries series = new XYSeries(expression);
        for(int i = 0; i<10;i++){
                series.add(i, i);
        }
        return series;
    }
}