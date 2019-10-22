package Controller;

import Domain.Activity;
import Domain.Discipline;
import Domain.Relation;
import Domain.Teacher;
import Repository.Repository;

import java.util.ArrayList;

public class Controller {

    private Repository<Teacher> teacherRepo;
    private Repository<Activity> activityRepo;
    private Repository<Discipline> disciplineRepo;
    private Repository<Relation> relationRepo;

    public Controller() {
        this.teacherRepo = new Repository<Teacher>() ;
        this.activityRepo = new Repository<Activity>();
        this.disciplineRepo = new Repository<Discipline>();
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

    public void updateRelationByIndex(int index,String key1,String key2)
    {
        Relation<String> r = this.relationRepo.getByIndex(index);
        r.setKey1(key1);
        r.setKey2(key2);
        this.relationRepo.setAtIndex(r,index);
    }

    public void deleteTeacherByIndex(int index)
    {
        this.teacherRepo.deleteByIndex(index);
    }

    public void deleteActivityByIndex(int index)
    {
        this.activityRepo.deleteByIndex(index);
    }

    public void deleteDisciplineByIndex(int index)
    {
        this.disciplineRepo.deleteByIndex(index);
    }

    public void deleteRelationByIndex(int index) { this.relationRepo.deleteByIndex(index);}
}
