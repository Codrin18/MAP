package Repository;

import Domain.Teacher;

import java.io.*;
import java.util.ArrayList;

public class TeacherRepo extends Repository<Teacher> {

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
                Teacher t = new Teacher(elems[0]);
                this.objects.add(t);
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

            for(Teacher t: objects)
            {
                bw.write(t.getName());
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
