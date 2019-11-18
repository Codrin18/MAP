package Repository;

import Domain.Teacher;

import java.io.*;
import java.util.ArrayList;

public class TeacherBinaryRepo extends  Repository<Teacher> {

    private String filename;

    public TeacherBinaryRepo(String filename) {
        this.filename = filename;
        readBinaryFile();
    }

    public int getSize()
    {
        return this.objects.size();
    }
    @Override
    public void addElem(Teacher newElem)
    {
        //System.out.println("Binary add");
        super.addElem(newElem);
        writeBinaryFile();
    }
    public void readBinaryFile()
    {
        ObjectInputStream in = null;

        try
        {
            in = new ObjectInputStream(new FileInputStream(filename));
            this.objects = (ArrayList<Teacher>) in.readObject();
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
