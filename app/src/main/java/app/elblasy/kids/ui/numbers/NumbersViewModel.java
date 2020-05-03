package app.elblasy.kids.ui.numbers;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.R;
import app.elblasy.kids.models.LettersModel;
import app.elblasy.kids.models.NumbersLevel2Model;

public class NumbersViewModel extends ViewModel {

    MutableLiveData<List<LettersModel>> mutableLiveData;
    private List<LettersModel> list;

    public NumbersViewModel() {
        mutableLiveData = new MutableLiveData<>();

        list = new ArrayList<>();
    }

    void setList() {
        list.add(new LettersModel("0", R.drawable.letter_zero, R.raw.zero));
        list.add(new LettersModel("1", R.drawable.letter_one, R.raw.one));
        list.add(new LettersModel("2", R.drawable.letter_two, R.raw.two));
        list.add(new LettersModel("3", R.drawable.letter_three, R.raw.three));
        list.add(new LettersModel("4", R.drawable.letter_four, R.raw.four));
        list.add(new LettersModel("5", R.drawable.letter_five, R.raw.five));
        list.add(new LettersModel("6", R.drawable.letter_six, R.raw.six));
        list.add(new LettersModel("7", R.drawable.letter_seven, R.raw.seven));
        list.add(new LettersModel("8", R.drawable.letter_eight, R.raw.eight));
        list.add(new LettersModel("9", R.drawable.letter_nine, R.raw.nine));
        list.add(new LettersModel("10", R.drawable.letter_ten, R.raw.ten));

        mutableLiveData.setValue(list);
    }

    void setListLevel2() {
        list.add(new LettersModel("Addition", R.raw.math_plus));
        list.add(new LettersModel("Subtraction", R.raw.subtraction_math));

        mutableLiveData.setValue(list);
    }

    void setListLevel2Ar() {
        list.add(new LettersModel("الجمع", R.raw.numbers_sum_ar));
        list.add(new LettersModel("الطرح", R.raw.numbers_sub_ar));

        mutableLiveData.setValue(list);
    }

    void setListAr() {
        list.add(new LettersModel("0", R.drawable.zero_ar, R.raw.zero_ar_sound));
        list.add(new LettersModel("1", R.drawable.one_ar, R.raw.one_ar_sound));
        list.add(new LettersModel("2", R.drawable.two_ar, R.raw.two_ar_sound));
        list.add(new LettersModel("3", R.drawable.three_ar, R.raw.three_ar_sound));
        list.add(new LettersModel("4", R.drawable.four_ar, R.raw.four_ar_sound));
        list.add(new LettersModel("5", R.drawable.five_ar, R.raw.five_ar_sound));
        list.add(new LettersModel("6", R.drawable.six_ar, R.raw.six_ar_sound));
        list.add(new LettersModel("7", R.drawable.seven_ar, R.raw.seven_ar_sound));
        list.add(new LettersModel("8", R.drawable.eight_ar, R.raw.eight_ar_sound));
        list.add(new LettersModel("9", R.drawable.nine_ar, R.raw.nine_ar_sound));
        list.add(new LettersModel("10", R.drawable.ten_ar, R.raw.ten_ar_sound));

        mutableLiveData.setValue(list);
    }
}
