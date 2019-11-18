import Controller.Controller;
import Domain.Activity;
import Domain.Discipline;
import Domain.Relation;
import Domain.Teacher;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private Controller ctrl;

    public UI(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void addTeacher()
    {

        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter a name for the teacher: ");
        String name =  sc.nextLine();
        Teacher t = new Teacher(name);

        this.ctrl.addTeacher(t);
    }

    public void addActivity()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter a name for the activity: ");
        String name = sc.nextLine();
        System.out.println("Please enter an activity type: ");
        String activityType = sc.nextLine();

        Activity a = new Activity(name,activityType);

        this.ctrl.addActivity(a);
    }

    public void addDiscipline()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter a name for the discipline: ");
        String name = sc.nextLine();

        Discipline d = new Discipline(name);

        this.ctrl.addDiscipline(d);
    }

    public void addRelation()
    {
        Scanner sc =  new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter key1: ");
        String key1 = sc.nextLine();

        //sc.nextLine();
        System.out.println("Please enter key2: ");
        String key2 = sc.nextLine();

        Relation<String> r = new Relation<>(key1,key2);

        this.ctrl.addRelation(r);
    }

    public void add()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        int choice = 1;

        while(choice != 0)
        {

            System.out.println("1. Add a new teacher");
            System.out.println("2. Add a new activity");
            System.out.println("3. Add a new discipline");
            System.out.println("4. Add a new relation");
            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.addTeacher();
                    break;
                case 2:
                    this.addActivity();
                    break;
                case 3:
                    this.addDiscipline();
                    break;
                case 4:
                    this.addRelation();
                    break;
            }
        }
    }

    public void getAllTeachers()
    {
        ArrayList<Teacher> teachers = this.ctrl.getAllTeachers();

        for(int i=0; i < teachers.size(); i++)
        {
            System.out.printf("\t%d-%s\n",i,teachers.get(i));
        }
    }

    public void getTeacherByIndex()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the index: ");
        int index = sc.nextInt();

        Teacher t = this.ctrl.getTeacherByIndex(index);

        System.out.printf("\t%s",t);
    }

    public void getTeachers()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        while(choice != 0)
        {
            System.out.println("1. Get all teachers");
            System.out.println("2. Get a teacher by index");

            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.getAllTeachers();
                    break;
                case 2:
                    this.getTeacherByIndex();
                    break;
            }
        }
    }

    public void getAllActivities()
    {
        ArrayList<Activity> activities = this.ctrl.getAllActivities();

        for(int i=0; i < activities.size(); i++)
        {
            System.out.printf("\t%d-%s\n",i,activities.get(i));
        }
    }

    public void getActivityByIndex()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the index: ");
        int index = sc.nextInt();

        Activity a = this.ctrl.getActivityByIndex(index);

        System.out.printf("\t%s",a);
    }

    public void getActivities()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        while(choice != 0)
        {
            System.out.println("1. Get all activities");
            System.out.println("2. Get an activity by index");

            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.getAllActivities();
                    break;
                case 2:
                    this.getActivityByIndex();
                    break;
            }
        }
    }

    public void getAllDisciplines()
    {
        ArrayList<Discipline> disciplines = this.ctrl.getAllDisciplines();

        for(int i=0; i < disciplines.size(); i++)
        {
            System.out.printf("\t%d-%s\n",i,disciplines.get(i));
        }
    }

    public void getDisciplineByIndex()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the index: ");
        int index = sc.nextInt();

        Discipline d = this.ctrl.getDisciplineByIndex(index);

        System.out.printf("\t%s",d);
    }

    public void getDisciplines()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        while(choice != 0)
        {
            System.out.println("1. Get all disciplines");
            System.out.println("2. Get a discipline by index");
            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.getAllDisciplines();
                    break;
                case 2:
                    this.getDisciplineByIndex();
                    break;
            }
        }
    }

    public void getAllRelations()
    {
        ArrayList<Relation> relations = this.ctrl.getAllRelations();

        for(int i=0; i < relations.size(); i++)
        {
            System.out.printf("\t%d-%s\n",i,relations.get(i));
        }
    }

    public void getRelationByIndex()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please introduce the index: ");
        int index = sc.nextInt();

        Relation<String> r = this.ctrl.getRelationByIndex(index);

        System.out.printf("\t%s",r);
    }

    public void getRelations()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        while(choice != 0)
        {
            System.out.println("1. Get all relations");
            System.out.println("2. Get a relation by index");
            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.getAllRelations();
                    break;
                case 2:
                    this.getRelationByIndex();
                    break;
            }
        }
    }

    public void retrieve()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        while(choice != 0) {
            System.out.println("1. Get teachers");
            System.out.println("2. Get activities");
            System.out.println("3. Get disciplines");
            System.out.println("4. Get relations");

            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    this.getTeachers();
                    break;
                case 2:
                    this.getActivities();
                    break;
                case 3:
                    this.getDisciplines();
                    break;
                case 4:
                    this.getRelations();
                    break;
            }
        }
    }

    public void updateTeacher()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        //sc.nextLine();
        System.out.println("Please enter the new name: ");
        String name = sc.nextLine();
        this.ctrl.updateTeacherByIndex(index,name);
    }

    public void updateActivity()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        //sc.nextLine();
        System.out.println("Please enter the new name: ");
        String name = sc.nextLine();

        this.ctrl.updateActivityByIndex(index,name);
    }

    public void updateDiscipline()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        //sc.nextLine();
        System.out.println("Please enter the new name: ");
        String name = sc.nextLine();
        this.ctrl.updateDisciplineByIndex(index,name);
    }

    public void updateRelation()
    {
        Scanner sc =  new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        //sc.nextLine();
        System.out.println("Please enter key1: ");
        String key1 = sc.nextLine();
        //sc.nextLine();
        System.out.println("Please enter key2: ");
        String key2 = sc.nextLine();

        this.ctrl.updateRelationByIndex(index,key1,key2);
    }

    public void update()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;
        while(choice != 0)
        {
            System.out.println("1.Update teacher");
            System.out.println("2.Update activity");
            System.out.println("3.Update discipline");
            System.out.println("4.Update relation");

            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.updateTeacher();
                    break;
                case 2:
                    this.updateActivity();
                    break;
                case 3:
                    this.updateDiscipline();
                    break;
                case 4:
                    this.updateRelation();
            }
        }
    }

    public void deleteTeacher()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        this.ctrl.deleteTeacherByIndex(index);
    }

    public void deleteActivity()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        this.ctrl.deleteActivityByIndex(index);
    }

    public void deleteDiscipline()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        this.ctrl.deleteDisciplineByIndex(index);
    }

    public void deleteRelation()
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();

        this.ctrl.deleteRelationByIndex(index);
    }

    public void delete()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;
        while(choice != 0)
        {
            System.out.println("1.Delete teacher");
            System.out.println("2.Delete activity");
            System.out.println("3.Delete discipline");
            System.out.println("4.Delete relation");

            System.out.println("Please choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.deleteTeacher();
                    break;
                case 2:
                    this.deleteActivity();
                    break;
                case 3:
                    this.deleteDiscipline();
                    break;
                case 4:
                    this.deleteRelation();
                    break;
            }
        }
    }

    public void run()
    {
       /** Scanner sc = new Scanner(System.in);
        Teacher t1 = new Teacher("Mihai");
        Teacher t2 = new Teacher("Rares");
        Teacher t3 = new Teacher("Catalin");
        Teacher t4 = new Teacher("Cosmin");
        Teacher t5 = new Teacher("Gabi");

        this.ctrl.addTeacher(t1);
        this.ctrl.addTeacher(t2);
        this.ctrl.addTeacher(t3);
        this.ctrl.addTeacher(t4);
        this.ctrl.addTeacher(t5);

       Activity a1 = new Activity("Activity0");
       Activity a2 = new Activity("Activity1");
       Activity a3 = new Activity("Activity2");
       Activity a4 = new Activity("Activity3");
       Activity a5 = new Activity("Activity4");

       this.ctrl.addActivity(a1);
       this.ctrl.addActivity(a2);
       this.ctrl.addActivity(a3);
       this.ctrl.addActivity(a4);
       this.ctrl.addActivity(a5);

       Discipline d1 = new Discipline("Discipline0");
       Discipline d2 = new Discipline("Discipline1");
       Discipline d3 = new Discipline("Discipline2");
       Discipline d4 = new Discipline("Discipline3");
       Discipline d5 = new Discipline("Discipline4");

       this.ctrl.addDiscipline(d1);
       this.ctrl.addDiscipline(d2);
       this.ctrl.addDiscipline(d3);
       this.ctrl.addDiscipline(d4);
       this.ctrl.addDiscipline(d5);

       Relation<String> r1 = new Relation<>("Mihai","Activity0");
       Relation<String> r2 = new Relation<>("Mihai","Activity1");
       Relation<String> r3 = new Relation<>("Gabi","Activity2");
       Relation<String> r4 = new Relation<>("Catalin","Activity3");
       Relation<String> r5 = new Relation<>("Catalin","Activity4");

       this.ctrl.addRelation(r1);
       this.ctrl.addRelation(r2);
       this.ctrl.addRelation(r3);
       this.ctrl.addRelation(r4);
       this.ctrl.addRelation(r5);

        **/
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        while(choice != 0)
        {
            System.out.println("1. Add");
            System.out.println("2. Retrieve");
            System.out.println("3. Update");
            System.out.println("4. Delete");

            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    this.add();
                    break;
                case 2:
                    this.retrieve();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
            }
        }

        System.out.println("You exit from the application");
    }
}
