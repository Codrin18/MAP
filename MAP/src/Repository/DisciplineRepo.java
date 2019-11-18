package Repository;

import Domain.Activity;
import Domain.Discipline;

import java.io.*;

public class DisciplineRepo extends Repository<Discipline> {

    private String filename;

    public DisciplineRepo(String filename) {
        this.filename = filename;
        readFile(filename);
    }

    @Override
    public void addElem(Discipline newElem) {
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
                Discipline d = new Discipline(elems[0]);
                this.objects.add(d);
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

            for(Discipline d: objects)
            {
                bw.write(d.getName());
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
