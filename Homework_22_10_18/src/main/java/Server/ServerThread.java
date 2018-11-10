package Server;

import Server.Calculator.InToPost;
import Server.Calculator.LexerException;
import Server.Calculator.PostfixCalc;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread{
    private ObjectOutputStream out;
    BufferedReader is;
    private InetAddress addr;

    ServerThread(Socket s) throws IOException {
        out = new ObjectOutputStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();

    }
    public void run() {
        int i = 0;
        String str;
        try {
            while (true)
            if ((str = is.readLine()) != null) {
                System.out.println(str + addr.getHostName());
                out.writeObject(createXmlOfFunction(str));
            }
        }
        catch (IOException e) { // если клиент не отвечает, соединение с ним разрывается
             System.err.println("Disconnect");
        }
        finally {
            disconnect(); // уничтожение потока
        }
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
                point.setAttribute("x", i + "");
                point.setAttribute("y", Double.toString(calculate(funk, i)));
                root.appendChild(point);
            }
            return doc;
        }
        catch (RuntimeException |ParserConfigurationException e){
            Log.logger.error(e.getLocalizedMessage());
            return null;
        }
    }

    public Double calculate(String funk, int value){
        funk= funk.replace("x",Integer.toString(value));
        InToPost inToPost = new InToPost(funk);
        PostfixCalc postfixCalc = new PostfixCalc(inToPost.doTrans());
        return postfixCalc.parse();
    }

    public void disconnect() {
        try {
            if (out != null) {
                out.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            Log.logger.error(e.getLocalizedMessage());
        } finally {
            this.interrupt();
        }
    }
}
