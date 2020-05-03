package app.elblasy.kids.ui.colors;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.R;
import app.elblasy.kids.models.LettersModel;
import app.elblasy.kids.models.NumbersLevel2Model;

public class ColorsViewModel extends ViewModel {
    MutableLiveData<List<LettersModel>> mutableLiveData;
    MutableLiveData<List<NumbersLevel2Model>> mutableLiveDataLevel2;

    private List<LettersModel> list;
    private List<NumbersLevel2Model> numbersLevel2ModelList;

    public ColorsViewModel() {
        mutableLiveData = new MutableLiveData<>();
        mutableLiveDataLevel2 = new MutableLiveData<>();

        list = new ArrayList<>();
        numbersLevel2ModelList = new ArrayList<>();
    }

    void setList() {
        list.add(new LettersModel("RED", R.drawable.color_red, R.raw.red));
        list.add(new LettersModel("YELLOW", R.drawable.color_yellow, R.raw.yellow));
        list.add(new LettersModel("GREEN", R.drawable.color_green, R.raw.green));
        list.add(new LettersModel("BLACK", R.drawable.color_black, R.raw.black));
        list.add(new LettersModel("BLUE", R.drawable.color_blue, R.raw.blue));
        list.add(new LettersModel("WHITE", R.drawable.color_white, R.raw.white));
        list.add(new LettersModel("PURPLE", R.drawable.color_purple, R.raw.purple));

        mutableLiveData.setValue(list);
    }

    void setListAr() {
        list.add(new LettersModel("أحمر", R.drawable.color_red, R.raw.red_ar));
        list.add(new LettersModel("أصفر", R.drawable.color_yellow, R.raw.yellow_ar));
        list.add(new LettersModel("أخضر", R.drawable.color_green, R.raw.green_ar));
        list.add(new LettersModel("أسود", R.drawable.color_black, R.raw.black_ar));
        list.add(new LettersModel("أزرق", R.drawable.color_blue, R.raw.blue_ar));
        list.add(new LettersModel("أبيض", R.drawable.color_white, R.raw.white_ar));
        list.add(new LettersModel("بنفسجي", R.drawable.color_purple, R.raw.purple_ar));

        mutableLiveData.setValue(list);
    }

    void setListLevel2() {
        numbersLevel2ModelList.add(new NumbersLevel2Model(R.drawable.color_red,R.drawable.plus, R.drawable.color_yellow,R.drawable.color_orang, R.raw.orang_voice));
        numbersLevel2ModelList.add(new NumbersLevel2Model(R.drawable.color_red,R.drawable.plus, R.drawable.color_blue,R.drawable.color_purple, R.raw.purple_voice));
        numbersLevel2ModelList.add(new NumbersLevel2Model(R.drawable.color_yellow,R.drawable.plus, R.drawable.color_blue,R.drawable.color_green, R.raw.green_voice));

        mutableLiveDataLevel2.setValue(numbersLevel2ModelList);
    }

    void setListLevel2Ar() {
        numbersLevel2ModelList.add(new NumbersLevel2Model(R.drawable.color_red,R.drawable.plus, R.drawable.color_yellow,R.drawable.color_orang, R.raw.orange_result_ar));
        numbersLevel2ModelList.add(new NumbersLevel2Model(R.drawable.color_red,R.drawable.plus, R.drawable.color_blue,R.drawable.color_purple, R.raw.purple_result_ar));
        numbersLevel2ModelList.add(new NumbersLevel2Model(R.drawable.color_yellow,R.drawable.plus, R.drawable.color_blue,R.drawable.color_green, R.raw.green_result_ar));

        mutableLiveDataLevel2.setValue(numbersLevel2ModelList);
    }
}
