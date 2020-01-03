package sample;

import Domain.*;
import Repository.*;

import java.util.ArrayList;

public class RepoController {

    protected ActivityRepository activityRepository;
    protected DisciplineRepository disciplineRepository;
    protected FormationRepository formationRepository;
    protected RelationRepository relationRepository;
    protected RoomRepository roomRepository;
    protected TeacherRepository teacherRepository;

    public RepoController() {
        this.activityRepository = new ActivityRepository();
        this.disciplineRepository = new DisciplineRepository();
        this.formationRepository = new FormationRepository();
        this.relationRepository = new RelationRepository();
        this.roomRepository = new RoomRepository();
        this.teacherRepository = new TeacherRepository();
    }

    protected void addActivity(Activity a){
        activityRepository.addActivity(a);
    }

    protected  void addDiscipline(Discipline d){
        disciplineRepository.addDiscipline(d);
    }

    protected void addFormation(Formation f){
        formationRepository.addFormation(f);
    }

    protected void addRelation(Relation r){
        relationRepository.addRelation(r);
    }

    protected void addRoom(Room r){
        roomRepository.addRoom(r);
    }

    protected void addTeacher(Teacher t){
        teacherRepository.addTeacher(t);
    }

    protected ArrayList<Activity> getAllActivities(){
        return activityRepository.getAllActivities();
    }

    protected ArrayList<Discipline> getAllDisciplines(){
        return disciplineRepository.getAllDisciplines();
    }

    protected ArrayList<Formation> getAllFormations(){
        return formationRepository.getAllFormations();
    }

    protected ArrayList<Relation> getALlRelations(){
        return relationRepository.getAllRelations();
    }

    protected ArrayList<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }

    protected ArrayList<Teacher> getAllTeachers(){
        return teacherRepository.getAllTeachers();
    }

    protected void removeActivity(Activity a){
        activityRepository.deleteActivity(a);
    }

    protected void removeDiscipline(Discipline d){
        disciplineRepository.deleteDiscipline(d);
    }

    protected void removeFormation(Formation f){
        formationRepository.deleteFormation(f);
    }

    protected  void removeRelation(Relation r){
        relationRepository.removeRelation(r);
    }

    protected void removeRoom(Room r){
        roomRepository.deleteRoom(r);
    }

    protected void removeTeacher(Teacher t){
        teacherRepository.removeTeacher(t);
    }
}
