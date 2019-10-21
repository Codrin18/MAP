package Repository;

import java.util.ArrayList;

public class Repository<TElem> {

    private ArrayList<TElem> objects = new ArrayList<TElem>();

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
