package Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Repository<TElem> {

    protected ArrayList<TElem> objects = new ArrayList<TElem>();
    //private Properties prop = new Properties();



    public void addElem(TElem newElem)
    {
        this.objects.add(newElem);
    }

    public ArrayList<TElem> getAllElems()
    {
        return this.objects;
    }

    public TElem getByIndex(int index)
    {
        return this.objects.get(index);
    }

    public void setAtIndex(TElem newElem,int index)
    {
        this.objects.set(index,newElem);
    }

    public void deleteByIndex(int index)
    {
         this.objects.remove(index);
    }


}
