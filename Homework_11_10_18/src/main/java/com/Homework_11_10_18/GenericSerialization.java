package com.Homework_11_10_18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;


public class GenericSerialization<T extends Serializable> {
    final  Logger logger = LogManager.getLogger("serialization");
    public boolean serialization(T vehicle, String fileName) {

        boolean flag = false;  File f = new File(fileName);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {    ostream = new ObjectOutputStream(fos);
            ostream.writeObject(vehicle); // сериализация
                 flag = true;
            }
        }
        catch (FileNotFoundException e) {
          logger.error("Файл не может быть создан: "+ e);
        }
        catch (NotSerializableException e) {
            logger.error("Класс не поддерживает сериализацию: " + e);
        }
        catch (IOException e) {
            logger.error(e);
        }
        finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }
            }
            catch (IOException e) {
                logger.error("ошибка закрытия потока");
            }
        }
        return flag;
    }

    public  T deserialization (String fileName) throws InvalidObjectException {
        File fr = new File(fileName);  ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);    //десериализация
            T st = (T) istream.readObject();
            return st;
        } catch (ClassNotFoundException ce) {
            logger.error("Класс не существует: " + ce);
        } catch (FileNotFoundException e) {
            logger.error("Файл для десериализации не существует: "+ e);
        } catch (InvalidClassException ioe) {
            logger.error("Несовпадение версий классов: " + ioe);
        }
        catch (IOException ioe) {   System.err.println("Общая I/O ошибка: " + ioe);
        }
        finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            }
            catch (IOException e) {
                logger.error("ошибка закрытия потока ");
            }
        }
        throw new InvalidObjectException("объект не восстановлен"); }
}
