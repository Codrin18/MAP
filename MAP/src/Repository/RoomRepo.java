package Repository;

import Domain.Activity;
import Domain.Room;

import java.io.*;

public class RoomRepo extends Repository<Room> {

    private String filename;

    public RoomRepo(String filename){
        this.filename = filename;
        readFile(filename);
    }

    @Override
    public void addElem(Room newElem) {
        super.addElem(newElem);
        writeFile(filename);
    }

    public void readFile(String filename)
    {
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length != 1)
                    continue;
                Room r = new Room(elems[0],elems[1]);
                this.objects.add(r);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    public void writeFile(String filename)
    {
        BufferedWriter bw = null;

        try
        {
            bw = new BufferedWriter(new FileWriter(filename));

            for(Room r: objects)
            {
                bw.write(r.getIdRoom());
                bw.write(r.getBuilding());
                bw.newLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                bw.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
