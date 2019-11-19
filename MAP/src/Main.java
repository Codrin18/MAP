import Controller.Controller;
import Domain.Activity;
import Domain.Discipline;
import Domain.Teacher;
import Repository.Repository;
import Repository.ActivityDatabseRepo;
import Repository.TeacherRepo;
import Repository.TeacherDatabaseRepo;
import Repository.TeacherBinaryRepo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.Properties;

public class Main {

    public static void setProperties()
    {
        File configFile = new File("config.properties");
        try{
            Properties props = new Properties();
            props.setProperty("Repository","binary");
            props.setProperty("Teachers","/home/codrin18/Desktop/MAP/src/teachers.bin");
            props.setProperty("Disciplines","/home/codrin18/Desktop/MAP/src/Controller/disciplines.txt");
            props.setProperty("Activities","/home/codrin18/Desktop/MAP/src/Controller/activities.txt");
            FileWriter writer = new FileWriter(configFile);
            props.store(writer,"repository settings");
            writer.close();
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String [] args)
    {
        setProperties();
        File configFile = new File("config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);



            if (props.getProperty("Repository").equals("text file"))
            {
                TeacherDatabaseRepo teacherDatabaseRepo = new TeacherDatabaseRepo();
                Repository<Discipline> disciplineRepository = new Repository<Discipline>();
                ActivityDatabseRepo activityRepository = new ActivityDatabseRepo();
                //teacherRepository.readFile(props.getProperty("Teachers"));
                Controller ctrl = new Controller(teacherDatabaseRepo, activityRepository, disciplineRepository);
                //ctrl.readTeachers(props.getProperty("Teachers"));
                //ctrl.readActivities(props.getProperty("Activities"));
                ctrl.readDisciplines(props.getProperty("Disciplines"));
                UI app = new UI(ctrl);
                app.run();
            }
            else {
                TeacherDatabaseRepo teacherDatabaseRepo = new TeacherDatabaseRepo();
                Repository<Discipline> disciplineRepository = new Repository<Discipline>();
                ActivityDatabseRepo activityRepository = new ActivityDatabseRepo();
                /*Teacher t = new Teacher("Teacher0");
                Teacher t1 = new Teacher("Teacher1");
                Teacher t3 = new Teacher("Teacher2");
                Teacher t4 = new Teacher("Teacher3");
                    teacherBinaryRepo.addElem(t);
                    teacherBinaryRepo.addElem(t1);
                    teacherBinaryRepo.addElem(t3);
                    teacherBinaryRepo.addElem(t4);*/


                Controller ctrl = new Controller(teacherDatabaseRepo, activityRepository, disciplineRepository);
                //ctrl.readTeachers(props.getProperty("Teachers"));
                //ctrl.readActivities(props.getProperty("Activities"));
                ctrl.readDisciplines(props.getProperty("Disciplines"));
                UI app = new UI(ctrl);
                app.run();
                teacherDatabaseRepo.closeConnection();
                activityRepository.closeConnection();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
        } catch (IOException ex) {
            // I/O error
        }


    }
}
