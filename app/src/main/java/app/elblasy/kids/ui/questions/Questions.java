package app.elblasy.kids.ui.questions;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.elblasy.kids.CustomSharedPref;
import app.elblasy.kids.R;
import app.elblasy.kids.databinding.QuestionsFragmentBinding;
import app.elblasy.kids.models.QuestionsModel;

import static java.util.Arrays.asList;

public class Questions extends Fragment {

    private List<QuestionsModel> questions;
    private List<Integer> answers;
    private QuestionsFragmentBinding binding;
    private QuestionsModel currentQuestion;
    private int questionIndex = 0;
    private int correctAnswer;
    Dialog dialog;
    private int numQuestions = 10;
    List<String> greating = new ArrayList<>();

    public static Questions newInstance() {
        return new Questions();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = QuestionsFragmentBinding.inflate(inflater, container, false);

        questions = new ArrayList<>();
        String tryAgain;
        String finish;

        CustomSharedPref pref = new CustomSharedPref(getContext());

        if (pref.getPrefLang("lang").equals("ar")) {
            if (pref.getSessionValue("level")) {
                makeQuestionsLevel2Ar();
                numQuestions = 7;
            } else {
                makeQuestionsLevel1Ar();
            }
            binding.questionText.setText("اختر ما تسمعه");
            greating.add("عظيم!");
            greating.add("احسنت!");
            greating.add("انت ذكي!");
            greating.add("عمل جيدّ");
            tryAgain = "حاول مجددًا";
            finish = "عمل جيد !";
        } else if (pref.getSessionValue("level")) {
            makeQuestionsLevel2();
            greating.add("Great!");
            greating.add("Well Done!");
            greating.add("You are genius!");
            greating.add("Good Job!");
            tryAgain = "try again!";
            finish = "Good Job!";
        } else {
            makeQuestionsLevel1();
            greating.add("Great!");
            greating.add("Well Done!");
            greating.add("You are genius!");
            greating.add("Good Job!");
            tryAgain = "try again!";
            finish = "Good Job!";
        }

        binding.questionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkId) {
                Collections.shuffle(greating);
                if (-1 != checkId) {
                    int answerIndex = 0;
                    switch (checkId) {
                        case R.id.radio1:
                            answerIndex = 1;
                            break;
                        case R.id.radio2:
                            answerIndex = 2;
                            break;
                        case R.id.radio3:
                            answerIndex = 3;
                            break;
                    }
                    if (answers.get(answerIndex) == correctAnswer) {
                        showDialog(greating.get(answerIndex), 750);

                        questionIndex++;
                        if (questionIndex < numQuestions) {
                            currentQuestion = questions.get(questionIndex);
                            setQuestions(800);
                            group.clearCheck();
                        } else {
                            showDialog(finish, 2000);
                            Navigation.findNavController(binding.questionRadioGroup).navigate(R.id.action_questions_to_title22);
                        }
                    } else {
                        showDialog(tryAgain, 1500);
                    }
                }
            }
        });


        binding.questionImage.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentQuestion.getAudio());
            mediaPlayer.start();
        });
        return binding.getRoot();
    }


    private void makeQuestionsLevel1() {

        questions.add(new QuestionsModel(R.raw.c, asList(R.drawable.letter_a, R.drawable.letter_z,
                R.drawable.letter_one, R.drawable.letter_c)));

        questions.add(new QuestionsModel(R.raw.five, asList(R.drawable.letter_h, R.drawable.color_red,
                R.drawable.letter_ten, R.drawable.letter_five)));

        questions.add(new QuestionsModel(R.raw.i, asList(R.drawable.letter_s, R.drawable.letter_q,
                R.drawable.letter_nine, R.drawable.letter_i)));

        questions.add(new QuestionsModel(R.raw.z, asList(R.drawable.letter_p, R.drawable.letter_o,
                R.drawable.letter_three, R.drawable.letter_z)));

        questions.add(new QuestionsModel(R.raw.red, asList(R.drawable.color_yellow, R.drawable.color_black,
                R.drawable.color_blue, R.drawable.color_red)));

        questions.add(new QuestionsModel(R.raw.m, asList(R.drawable.letter_a, R.drawable.letter_z,
                R.drawable.letter_n, R.drawable.letter_m)));

        questions.add(new QuestionsModel(R.raw.x, asList(R.drawable.letter_u, R.drawable.letter_k,
                R.drawable.letter_y, R.drawable.letter_x)));

        questions.add(new QuestionsModel(R.raw.ten, asList(R.drawable.letter_zero, R.drawable.letter_z,
                R.drawable.letter_nine, R.drawable.letter_ten)));

        questions.add(new QuestionsModel(R.raw.two, asList(R.drawable.letter_eight, R.drawable.letter_y,
                R.drawable.letter_three, R.drawable.letter_two)));

        questions.add(new QuestionsModel(R.raw.purple, asList(R.drawable.color_cyan, R.drawable.letter_one,
                R.drawable.color_yellow, R.drawable.color_purple)));

        questions.add(new QuestionsModel(R.raw.yellow, asList(R.drawable.color_purple, R.drawable.color_white,
                R.drawable.color_red, R.drawable.color_yellow)));


        Collections.shuffle(questions);
        setQuestions(800);
    }

    private void makeQuestionsLevel1Ar() {

        questions.add(new QuestionsModel(R.raw.red_ar, asList(R.drawable.color_black, R.drawable.color_yellow,
                R.drawable.color_blue, R.drawable.color_red)));

        questions.add(new QuestionsModel(R.raw.blue_ar, asList(R.drawable.color_purple, R.drawable.color_red,
                R.drawable.color_orang, R.drawable.color_blue)));

        questions.add(new QuestionsModel(R.raw.orange_ar, asList(R.drawable.color_green, R.drawable.color_black,
                R.drawable.color_yellow, R.drawable.color_orang)));

        questions.add(new QuestionsModel(R.raw.purple_ar, asList(R.drawable.color_yellow, R.drawable.color_white,
                R.drawable.color_red, R.drawable.color_purple)));

        questions.add(new QuestionsModel(R.raw.one_ar_sound, asList(R.drawable.ten_ar, R.drawable.nine_ar,
                R.drawable.two_ar, R.drawable.one_ar)));

        questions.add(new QuestionsModel(R.raw.eight_ar_sound, asList(R.drawable.seven_ar, R.drawable.three_ar,
                R.drawable.six_ar, R.drawable.eight_ar)));

        questions.add(new QuestionsModel(R.raw.ten_ar_sound, asList(R.drawable.two_ar, R.drawable.five_ar,
                R.drawable.one_ar, R.drawable.ten_ar)));

        questions.add(new QuestionsModel(R.raw.five_ar_sound, asList(R.drawable.one_ar, R.drawable.seven_ar,
                R.drawable.ten_ar, R.drawable.five_ar)));

        questions.add(new QuestionsModel(R.raw.alf_sound, asList(R.drawable.non_image, R.drawable.fa_image,
                R.drawable.kkaf_image, R.drawable.alf_image)));

        questions.add(new QuestionsModel(R.raw.non_sound, asList(R.drawable.fa_image, R.drawable.alf_image,
                R.drawable.kkaf_image, R.drawable.non_image)));

        questions.add(new QuestionsModel(R.raw.faa_sound, asList(R.drawable.kaf_image, R.drawable.alf_image,
                R.drawable.non_image, R.drawable.fa_image)));


        Collections.shuffle(questions);
        setQuestions(800);
    }


    private void makeQuestionsLevel2() {

        questions.add(new QuestionsModel(R.raw.apple, asList(R.drawable.car, R.drawable.zebra,
                R.drawable.banana, R.drawable.apple)));

        questions.add(new QuestionsModel(R.raw.dog, asList(R.drawable.yard, R.drawable.kangaroo,
                R.drawable.hotel, R.drawable.dog)));

        questions.add(new QuestionsModel(R.raw.kangaroo, asList(R.drawable.girl, R.drawable.mother,
                R.drawable.vampire, R.drawable.kangaroo)));

        questions.add(new QuestionsModel(R.raw.queen, asList(R.drawable.letter_seven, R.drawable.finger,
                R.drawable.under, R.drawable.queen)));

        questions.add(new QuestionsModel(R.raw.tea, asList(R.drawable.worm, R.drawable.xylophone,
                R.drawable.lion, R.drawable.tea)));

        questions.add(new QuestionsModel(R.raw.zebra, asList(R.drawable.jungle, R.drawable.oat,
                R.drawable.apple, R.drawable.zebra)));

        questions.add(new QuestionsModel(R.raw.banana, asList(R.drawable.car, R.drawable.piano,
                R.drawable.xylophone, R.drawable.banana)));

        questions.add(new QuestionsModel(R.raw.three_plus_seven, asList(R.drawable.letter_zero, R.drawable.letter_five,
                R.drawable.letter_nine, R.drawable.letter_ten)));

        questions.add(new QuestionsModel(R.raw.four_plus_two, asList(R.drawable.letter_eight, R.drawable.letter_one,
                R.drawable.letter_three, R.drawable.letter_six)));

        questions.add(new QuestionsModel(R.raw.nine_minus_two, asList(R.drawable.letter_eight, R.drawable.letter_one,
                R.drawable.letter_zero, R.drawable.letter_seven)));

        questions.add(new QuestionsModel(R.raw.eight_minus_eight, asList(R.drawable.letter_four, R.drawable.letter_three,
                R.drawable.letter_one, R.drawable.letter_zero)));


        Collections.shuffle(questions);
        setQuestions(800);
    }

    private void makeQuestionsLevel2Ar() {

        questions.add(new QuestionsModel(R.raw.red_plus_blue_ar, asList(R.drawable.color_red, R.drawable.color_blue,
                R.drawable.color_orang, R.drawable.color_purple)));

        questions.add(new QuestionsModel(R.raw.red_plus_yellow_ar, asList(R.drawable.color_yellow, R.drawable.color_black,
                R.drawable.color_blue, R.drawable.color_orang)));

        questions.add(new QuestionsModel(R.raw.lion_ar, asList(R.drawable.girl, R.drawable.mother,
                R.drawable.vampire, R.drawable.lion)));

        questions.add(new QuestionsModel(R.raw.one_pluse_two_ar, asList(R.drawable.two_ar, R.drawable.nine_ar,
                R.drawable.one_ar, R.drawable.three_ar)));


        questions.add(new QuestionsModel(R.raw.seven_three_ar, asList(R.drawable.six_ar, R.drawable.zero_ar,
                R.drawable.five_ar, R.drawable.four_ar)));

        questions.add(new QuestionsModel(R.raw.eight_minus_eight_ar, asList(R.drawable.eight_ar, R.drawable.two_ar,
                R.drawable.one_ar, R.drawable.zero_ar)));

        questions.add(new QuestionsModel(R.raw.four_plus_six_ar, asList(R.drawable.six_ar, R.drawable.four_ar,
                R.drawable.nine_ar, R.drawable.ten_ar)));


        Collections.shuffle(questions);
        setQuestions(800);
    }

    private void setQuestions(int delay) {
        currentQuestion = questions.get(questionIndex);
        answers = new ArrayList<>();
        answers = currentQuestion.getAnswers();
        correctAnswer = answers.get(3);

        Collections.shuffle(answers);

        binding.radio0.setCompoundDrawablesWithIntrinsicBounds(0, 0, answers.get(0), 0);
        binding.radio1.setCompoundDrawablesWithIntrinsicBounds(0, 0, answers.get(1), 0);
        binding.radio2.setCompoundDrawablesWithIntrinsicBounds(0, 0, answers.get(2), 0);
        binding.radio3.setCompoundDrawablesWithIntrinsicBounds(0, 0, answers.get(3), 0);

        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentQuestion.getAudio());

        Runnable play = new Runnable() {
            public void run() {
                mediaPlayer.start();
            }
        };
        new Handler().postDelayed(play, delay);
    }

    private void showDialog(String message, int delay) {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog);

        TextView textMessage = dialog.findViewById(R.id.message);
        textMessage.setText(message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        Runnable dismissRunner = new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        };
        new Handler().postDelayed(dismissRunner, delay);
    }
}
