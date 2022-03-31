package com.abdullaev.smartagro.common;

import android.os.CountDownTimer;

import com.abdullaev.smartagro.fragment.boarding.FragmentOnBoardingPages;
import com.abdullaev.smartagro.model.BoardingModel;
import com.abdullaev.smartagro.model.CurrentQuestion;
import java.util.ArrayList;
import java.util.List;

public class Common {
    public static int time_lay = Common.TOTLA_TIME;
    public static Boolean isVariantEnglish=false;
    public static String share="https://play.google.com/store/apps/details?id=com.jaloliddinabdullaev.abiturient2021";
    public static String title;

    public static String GET_FREE_QUESTIONS="free_questions";

    public static int hozirgiSavol=0, engOxirgiList;
    public static int timer=0;
    public static int togriJavoblar=0;
    public static int number;
    public static List<String> tenlanganJavoblar=new ArrayList<>();


    public static List<String> togriJavoblarDatabasedan=new ArrayList<>();
    public static List<String> onlineDBcorrectAnswers=new ArrayList<>();
    public static List<String> tanlanganOnlineDBJavoblar=new ArrayList<>();


    public static final int TOTLA_TIME = 3600 * 1000;
    public static ArrayList<BoardingModel> questionNumbers =new ArrayList<>();

    public static CountDownTimer countDownTimer;
    public static List<CurrentQuestion> currentQuestions =new ArrayList<>();
    public static ArrayList<FragmentOnBoardingPages> fragmentQuestions =new ArrayList<>();
}
