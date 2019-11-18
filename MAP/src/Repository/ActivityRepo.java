package Repository;

import Domain.Activity;
import Domain.Teacher;

import java.io.*;

public class ActivityRepo extends  Repository<Activity> {

    private String filename;

    public ActivityRepo(String filename) {
        this.filename = filename;
        readFile(filename);
    }

    @Override
    public void addElem(Activity newElem) {
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
                Activity a = new Activity(elems[0],elems[1]);
                this.objects.add(a);
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

            for(Activity a: objects)
            {
                bw.write(a.getName());
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
