package Controller;

import Domain.*;
import Repository.Repository;
import Repository.TeacherDatabaseRepo;
import Repository.ActivityDatabseRepo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private TeacherDatabaseRepo teacherRepo;
    private ActivityDatabseRepo activityRepo;
    private Repository<Discipline> disciplineRepo;
    private Repository<Room> roomRepo;
    private Repository<Relation> relationRepo;

    public Controller(TeacherDatabaseRepo teacherRepo,ActivityDatabseRepo activityRepo,Repository<Discipline> disciplineRepo) {
        this.teacherRepo = teacherRepo;
        this.activityRepo = activityRepo;
        this.disciplineRepo = disciplineRepo;
        this.roomRepo = new Repository<Room>();
        this.relationRepo = new Repository<Relation>();
    }

    public void addTeacher(Teacher newTeacher)
    {
        this.teacherRepo.addElem(newTeacher);
    }

    public void addActivity(Activity newActivity)
    {
        this.activityRepo.addElem(newActivity);
    }

    public void addDiscipline(Discipline newDiscipline)
    {
        this.disciplineRepo.addElem(newDiscipline);
    }

    public void addRoom(Room newRomm) { this.roomRepo.addElem(newRomm);}

    public void addRelation(Relation newRelation) { this.relationRepo.addElem(newRelation);}

    public ArrayList<Teacher> getAllTeachers()
    {
        return this.teacherRepo.getAllElems();
    }

    public ArrayList<Activity> getAllActivities()
    {
        return this.activityRepo.getAllElems();
    }

    public ArrayList<Discipline> getAllDisciplines()
    {
        return this.disciplineRepo.getAllElems();
    }

    public ArrayList<Room> getAllRooms() { return this.roomRepo.getAllElems(); }

    public ArrayList<Relation> getAllRelations()
    {
        return this.relationRepo.getAllElems();
    }

    public Teacher getTeacherByIndex(int index)
    {
        return this.teacherRepo.getByIndex(index);
    }


    public Activity getActivityByIndex(int index)
    {
        return this.activityRepo.getByIndex(index);
    }

    public Discipline getDisciplineByIndex(int index)
    {
        return this.disciplineRepo.getByIndex(index);
    }

    public Room getRoomByIndex(int index)
    {
        return this.roomRepo.getByIndex(index);
    }

    public Relation getRelationByIndex(int index)
    {
        return this.relationRepo.getByIndex(index);
    }

    public void updateTeacherByIndex(int index,String name)
    {
        Teacher t = this.teacherRepo.getByIndex(index);
        t.setName(name);
        this.teacherRepo.setAtIndex(t, index);
    }

    public void updateActivityByIndex(int index,String name)
    {
        Activity a = this.activityRepo.getByIndex(index);
        a.setName(name);
        //a.setTeacherName(teacherName);
        this.activityRepo.setAtIndex(a,index);
    }

    public void updateDisciplineByIndex(int index,String name)
    {
        Discipline d = this.disciplineRepo.getByIndex(index);
        d.setName(name);
        this.disciplineRepo.setAtIndex(d,index);
    }

    public void updateRoomByIndex(int index,String newIdRoom,String building)
    {
        Room r = this.roomRepo.getByIndex(index);
        r.setBuilding(building);
        r.setIdRoom(newIdRoom);
        this.roomRepo.setAtIndex(r,index);
    }

    public void updateRelationByIndex(int index,String key1,String key2)
    {
        Relation<String> r = this.relationRepo.getByIndex(index);
        r.setKey1(key1);
        r.setKey2(key2);
        this.relationRepo.setAtIndex(r,index);
    }

    public void deleteTeacherByIndex(Teacher t)
    {
        this.teacherRepo.removeElem(t);
    }

    public void deleteActivityByIndex(int index)
    {
        this.activityRepo.deleteByIndex(index);
    }

    public void deleteDisciplineByIndex(int index)
    {
        this.disciplineRepo.deleteByIndex(index);
    }

    public void deleteRoomByIndex(int index) { this.roomRepo.deleteByIndex(index);}

    public void deleteRelationByIndex(int index) { this.relationRepo.deleteByIndex(index);}

    public  void readTeachers(String filename)
    {
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length != 2)
                    continue;
                Teacher t = new Teacher(elems[0],elems[1]);
                this.teacherRepo.addElem(t);
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

    public void readDisciplines(String filename)
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
                this.disciplineRepo.addElem(d);
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

    public void readActivities(String filename)
    {
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length < 2)
                    continue;
                Activity a = new Activity(elems[0],elems[1]);
                this.activityRepo.addElem(a);
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


}
