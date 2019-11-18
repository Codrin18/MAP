package Repository;

import Domain.Activity;
import Domain.Discipline;

import java.io.*;
import java.util.ArrayList;

public class DisciplineBinaryRepo extends Repository<Discipline> {

    private String filename;

    public DisciplineBinaryRepo(String filename) {
        this.filename = filename;
        readBinaryFile();
    }

    @Override
    public void addElem(Discipline newElem) {
        super.addElem(newElem);
        writeBinaryFile();
    }

    public void readBinaryFile()
    {
        ObjectInputStream in = null;

        try
        {
            in = new ObjectInputStream(new FileInputStream(filename));
            this.objects = (ArrayList<Discipline>) in.readObject();
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
