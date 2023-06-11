package co.edu.cue.proyectoNuclear.domain.configuration;

public class Pages {

    //GENERAL
    public static String LOGIN = "index";

    //ADMIN
    public static String ADMINHOME = "administrative/homeAdmin";
    public static String ADMINTABLEUSERS ="administrative/administrativeTableUsers";
    public static String ADMINSCHEDULEUSERS = "administrative/administrativeScheduleUsers";
    public static String ADMININFORMATION ="administrative/administrativeInformation";

    public static String ADMINREGISTERUSERS ="administrative/administrativeRegisterUsers";

    public static String CLASSROOM="administrative/adminRegisterClassroom";

    public static String SUBJECT="administrative/adminRegisterSubject";

    //STUDENT

    public static String STUDENTHOME = "student/home";
    public static String STUDENTINFORMATION="student/personalInformation";
    public static String CHANGES="student/change";
    public static String SCHEDULESTUDENT="student/scheduleStudent";
    public static String PASSWORD="student/changePassword";

    //TEACHER
    public static String TEACHERHOME ="teacher/homeTeacher";
    public static String TEACHERINFORMATION="teacher/teacherTable";
    public static String TEACHEREDIT="teacher/teacherEdit";
    public static String TEACHERAVAILABILITY="teacher/addAvailability";
    public static String CHANGEPASSSWORD="teacher/changePasswordTeacher";
    public static String EDITAVAILABILITY="teacher/editAvailability";
}
