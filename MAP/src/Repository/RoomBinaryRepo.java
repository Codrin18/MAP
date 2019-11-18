package Repository;

import Domain.Discipline;
import Domain.Room;

import java.io.*;
import java.util.ArrayList;

public class RoomBinaryRepo extends Repository<Room> {

    private String filename;

    public void readBinaryFile()
    {
        ObjectInputStream in = null;

        try
        {
            in = new ObjectInputStream(new FileInputStream(filename));
            this.objects = (ArrayList<Room>) in.readObject();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeBinaryFile()
    {
        ObjectOutputStream ou = null;

        try
        {
            ou = new ObjectOutputStream(new FileOutputStream(filename));
            ou.writeObject(this.objects);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                ou.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
