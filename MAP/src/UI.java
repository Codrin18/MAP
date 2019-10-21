import Controller.Controller;
import Domain.Activity;
import Domain.Discipline;
import Domain.Teacher;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private Controller ctrl;

    public UI() {
        this.ctrl = new Controller();
    }

    public void addTeacher()
    {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter a name for the teacher: ");
        String name =  sc.nextLine();
        Teacher t = new Teacher(name);

        this.ctrl.addTeacher(t);
    }

    public void addActivity()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter a name for the activity: ");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("Please enter the name of the teacher: ");
        String teacherName = sc.nextLine();

        Activity a = new Activity(name,teacherName);

        this.ctrl.addActivity(a);
    }

    public void addDiscipline()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter a name for the discipline: ");
        String name = sc.nextLine();

        Discipline d = new Discipline(name);

        this.ctrl.addDiscipline(d);
    }

    public void add()
    {
        int choice = 1;

        while(choice != 0)
        {
            System.out.println("1. Add a new teacher");
            System.out.println("2. Add a new activity");
            System.out.println("3. Add a new discipline");
            Scanner sc = new Scanner(System.in);
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

    public void retrieve()
    {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        while(choice != 0) {
            System.out.println("1. Get teachers");
            System.out.println("2. Get activities");
            System.out.println("3. Get disciplines");

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
            }
        }
    }

    public void updateTeacher()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the new name: ");
        String name = sc.nextLine();
        this.ctrl.updateTeacherByIndex(index,name);
    }

    public void updateActivity()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the new name: ");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("Please enter the teacher name: ");
        String teacherName = sc.nextLine();
        this.ctrl.updateActivityByIndex(index,name,teacherName);
    }

    public void updateDiscipline()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the new name: ");
        String name = sc.nextLine();
        this.ctrl.updateDisciplineByIndex(index,name);
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
        sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        this.ctrl.deleteActivityByIndex(index);
    }

    public void deleteDiscipline()
    {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Please enter the index: ");
        int index = sc.nextInt();
        this.ctrl.deleteDisciplineByIndex(index);
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
            }
        }
    }

    public void run()
    {
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

        System.out.println("You exit the from the application");
    }
}
