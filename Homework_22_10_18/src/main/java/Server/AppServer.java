package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AppServer
{
    public static void main( String[] args ) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("initialized");
            while (true) { // ожидание клиента
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected"); /* * создание отдельного потока для обмена данными* с соединившимся клиентом */
                ServerThread thread = new ServerThread(socket); // запуск потока
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    static void server(){
        Socket s = null; PrintStream ps = null; try { // отправка строки клиенту // создание объекта и назначение номера порта
            ServerSocket server = new ServerSocket(8030);
            s = server.accept(); // ожидание соединения
            ps = new PrintStream(s.getOutputStream()); // помещение строки "привет!" в буфер
            ps.println("привет!"); // отправка содержимого буфера клиенту
            ps.flush();
        } catch (IOException e) {
            System.err.println("Ошибка соединения потока: " + e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (s != null) {
                try { // разрыв соединения
                    s.close();
                } catch (IOException e)
                { e.printStackTrace(); }
            }
        }
    }
}
