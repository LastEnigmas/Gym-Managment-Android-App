package com.example.gymmanagementapp;

import java.util.ArrayList;

public class utils {
    private static ArrayList<Training> trainings;
    private static ArrayList<Plan> plans;
    public static void initTrainings(){
        if(null == trainings){
            trainings=new ArrayList<>();
            Training pushups=new Training(1,"Push-up","The push-up is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole. Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training. They are also a common form of punishment used in the military, school sport, and some martial arts disciplines.","Pushups are a simple and effective bodyweight movement that can help increase strength in your upper body and core.","https://static.strengthlevel.com/images/illustrations/push-ups-1-1000x1000.jpg");
            trainings.add(pushups);

            Training squats=new Training(2,"Squat","A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up. During the descent of a squat, the hip and knee joints flex while the ankle joint dorsiflexes; conversely the hip and knee joints extend and the ankle joint plantarflexes when standing up.","A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.","https://static.strengthlevel.com/images/illustrations/bodyweight-squat-2-1000x1000.jpg");
            trainings.add(squats);

            Training Situps=new Training(3,"Sit-up","The sit-up (or curl-up) is an abdominal endurance training exercise to strengthen, tighten and tone the abdominal muscles. It is similar to a crunch (crunches target the rectus abdominis and also work the external and internal obliques), but sit-ups have a fuller range of motion and condition additional muscles.","The sit-up (or curl-up) is an abdominal endurance training exercise to strengthen, tighten and tone the abdominal muscles.","https://static.strengthlevel.com/images/illustrations/sit-ups-2-1000x1000.jpg");
            trainings.add(Situps);

            Training benchpress=new Training(4,"Bench Press","The bench press, or chest press, is an upper-body weight training exercise in which the trainee presses a weight upwards while lying on a weight training bench. The exercise uses the pectoralis major, the anterior deltoids, and the triceps, among other stabilizing muscles. A barbell is generally used to hold the weight, but a pair of dumbbells can also be used.","The bench press, or chest press, is an upper-body weight training exercise in which the trainee presses a weight upwards while lying on a weight training bench. ","https://static.strengthlevel.com/images/illustrations/bench-press-1-1000x1000.jpg");
            trainings.add(benchpress);

            Training pullups=new Training(5,"Pull Ups Standards","A pullup is a challenging upper body exercise where you grip an overhead bar and lift your body until your chin is above that bar. It's a hard exercise to execute — so hard, in fact, that a U.S. Marine can receive a passing score on the annual physical fitness test without doing pullups at all.","A pullup is a challenging upper body exercise where you grip an overhead bar and lift your body until your chin is above that bar. ","https://static.strengthlevel.com/images/illustrations/pull-ups-2-1000x1000.jpg");
            trainings.add(pullups);
        }





    }

    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    public static boolean addplan(Plan p){
        if(plans ==null){
            plans= new ArrayList<>();


        }
        return plans.add(p);

    }

    public static ArrayList<Plan> getPlans() {
        return plans;
    }
    public static boolean removeplan(Plan plan){
        return plans.remove(plan);
    }
}
