package co.edu.cue.proyectoNuclear.domain.configuration;

public class Pages {

    //GENERAL
    public static String LOGIN = "index";

    //ADMIN
    public static String ADMIN_HOME = "administrative/homeAdmin";
    public static String ADMIN_TABLE_USERS ="administrative/administrativeTableUsers";
    public static String ADMIN_SCHEDULE_USERS = "administrative/administrativeScheduleUsers";
    public static String ADMIN_RESERVATION = "administrative/adminReservation";
    public static String ADMIN_INFORMATION ="administrative/administrativeInformation";
    public static String ADMIN_REGISTER_USERS ="administrative/administrativeRegisterUsers";
    public static String ADMIN_CLASSROOM ="administrative/adminRegisterClassroom";
    public static String ADMIN_SUBJECT ="administrative/adminRegisterSubject";
    public static String ADMIN_EDIT_SUBJECT="administrative/adminEditSubject";
    public static String ADMIN_PASSWORD="administrative/changePasswordAdministrative";
    public static String ADMIN_EDIT_USER="administrative/adminEditUser";

    //STUDENT

    public static String STUDENT_HOME = "student/home";
    public static String STUDENT_INFORMATION ="student/personalInformation";
    public static String STUDENT_CHANGES ="student/change";
    public static String STUDENT_SCHEDULE ="student/scheduleStudent";
    public static String STUDENT_PASSWORD ="student/changePassword";

    //TEACHER
    public static String TEACHERHOME ="teacher/homeTeacher";
    public static String TEACHERINFORMATION="teacher/teacherTable";
    public static String TEACHEREDIT="teacher/teacherEdit";
    public static String TEACHERAVAILABILITY="teacher/addAvailability";
    public static String CHANGEPASSSWORD="teacher/changePasswordTeacher";
    public static String EDITAVAILABILITY="teacher/editAvailability";
    public static String ADD_RESERVATION="teacher/teacherReservation";
    public static String SCHEDULE_TEACHER="teacher/scheduleTeacher";
}
