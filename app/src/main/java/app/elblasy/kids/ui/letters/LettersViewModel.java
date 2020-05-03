package app.elblasy.kids.ui.letters;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.R;
import app.elblasy.kids.models.LettersModel;

public class LettersViewModel extends ViewModel {
    MutableLiveData<List<LettersModel>> mutableLiveData;
    private List<LettersModel> list;

    public LettersViewModel() {
        mutableLiveData = new MutableLiveData<>();
        list = new ArrayList<>();
    }

    void setLitterList() {
        list.add(new LettersModel("", R.drawable.letter_a, R.raw.a));
        list.add(new LettersModel("", R.drawable.letter_b, R.raw.b));
        list.add(new LettersModel("", R.drawable.letter_c, R.raw.c));
        list.add(new LettersModel("", R.drawable.letter_d, R.raw.d));
        list.add(new LettersModel("", R.drawable.letter_e, R.raw.e));
        list.add(new LettersModel("", R.drawable.letter_f, R.raw.f));
        list.add(new LettersModel("", R.drawable.letter_g, R.raw.g));
        list.add(new LettersModel("", R.drawable.letter_h, R.raw.h));
        list.add(new LettersModel("", R.drawable.letter_i, R.raw.i));
        list.add(new LettersModel("", R.drawable.letter_j, R.raw.j));
        list.add(new LettersModel("", R.drawable.letter_k, R.raw.k));
        list.add(new LettersModel("", R.drawable.letter_l, R.raw.l));
        list.add(new LettersModel("", R.drawable.letter_m, R.raw.m));
        list.add(new LettersModel("", R.drawable.letter_n, R.raw.n));
        list.add(new LettersModel("", R.drawable.letter_o, R.raw.o));
        list.add(new LettersModel("", R.drawable.letter_p, R.raw.p));
        list.add(new LettersModel("", R.drawable.letter_q, R.raw.q));
        list.add(new LettersModel("", R.drawable.letter_r, R.raw.r));
        list.add(new LettersModel("", R.drawable.letter_s, R.raw.s));
        list.add(new LettersModel("", R.drawable.letter_t, R.raw.t));
        list.add(new LettersModel("", R.drawable.letter_u, R.raw.u));
        list.add(new LettersModel("", R.drawable.letter_v, R.raw.v));
        list.add(new LettersModel("", R.drawable.letter_w, R.raw.w));
        list.add(new LettersModel("", R.drawable.letter_x, R.raw.x));
        list.add(new LettersModel("", R.drawable.letter_y, R.raw.y));
        list.add(new LettersModel("", R.drawable.letter_z, R.raw.z));


        mutableLiveData.setValue(list);
    }
    void setWordsList() {
        list.add(new LettersModel("Apple", R.drawable.apple, R.raw.apple));
        list.add(new LettersModel("Banana", R.drawable.banana, R.raw.banana));
        list.add(new LettersModel("Car", R.drawable.car, R.raw.car));
        list.add(new LettersModel("Dog", R.drawable.dog, R.raw.dog));
        list.add(new LettersModel("Elephant", R.drawable.elephant, R.raw.elephant));
        list.add(new LettersModel("Finger", R.drawable.finger, R.raw.finger));
        list.add(new LettersModel("Girl", R.drawable.girl, R.raw.girl));
        list.add(new LettersModel("Hotel", R.drawable.hotel, R.raw.hotel));
        list.add(new LettersModel("Image", R.drawable.image, R.raw.image));
        list.add(new LettersModel("Jungle", R.drawable.jungle, R.raw.jungle));
        list.add(new LettersModel("Kangaroo", R.drawable.kangaroo, R.raw.kangaroo));
        list.add(new LettersModel("Lion", R.drawable.lion, R.raw.lion));
        list.add(new LettersModel("Mother", R.drawable.mother, R.raw.mother));
        list.add(new LettersModel("Night", R.drawable.night, R.raw.night));
        list.add(new LettersModel("Oat", R.drawable.oat, R.raw.oat));
        list.add(new LettersModel("Piano", R.drawable.piano, R.raw.piano));
        list.add(new LettersModel("Queen", R.drawable.queen, R.raw.queen));
        list.add(new LettersModel("Rabbit", R.drawable.rabbit, R.raw.rabit));
        list.add(new LettersModel("Seven", R.drawable.letter_seven, R.raw.seven));
        list.add(new LettersModel("Tea", R.drawable.tea, R.raw.tea));
        list.add(new LettersModel("Under", R.drawable.under, R.raw.under));
        list.add(new LettersModel("Vampire", R.drawable.vampire, R.raw.vampire));
        list.add(new LettersModel("Worm", R.drawable.worm, R.raw.worm));
        list.add(new LettersModel("Xylophone", R.drawable.xylophone, R.raw.xylphone));
        list.add(new LettersModel("Yard", R.drawable.yard, R.raw.yard));
        list.add(new LettersModel("Zebra", R.drawable.zebra, R.raw.zebra));


        mutableLiveData.setValue(list);
    }
    void setArabicList(){
        list.add(new LettersModel("أ",R.raw.alf));
        list.add(new LettersModel("ب",R.raw.baa));
        list.add(new LettersModel("ت",R.raw.ta2));
        list.add(new LettersModel("ث",R.raw.tha2));
        list.add(new LettersModel("ج",R.raw.gem));
        list.add(new LettersModel("ح",R.raw.haa));
        list.add(new LettersModel("خ",R.raw.khaa));
        list.add(new LettersModel("د",R.raw.dal));
        list.add(new LettersModel("ذ",R.raw.zal));
        list.add(new LettersModel("ر",R.raw.ra2));
        list.add(new LettersModel("ز",R.raw.zay));
        list.add(new LettersModel("س",R.raw.seen));
        list.add(new LettersModel("ش",R.raw.sheen));
        list.add(new LettersModel("ص",R.raw.sad));
        list.add(new LettersModel("ض",R.raw.dad));
        list.add(new LettersModel("ط",R.raw.ta2_tiara));
        list.add(new LettersModel("ظ",R.raw.za2));
        list.add(new LettersModel("ع",R.raw.een));
        list.add(new LettersModel("غ",R.raw.ghen));
        list.add(new LettersModel("ف",R.raw.faa));
        list.add(new LettersModel("ق",R.raw.kkaf));
        list.add(new LettersModel("ك",R.raw.kaf));
        list.add(new LettersModel("ل",R.raw.lam));
        list.add(new LettersModel("م",R.raw.mem));
        list.add(new LettersModel("ن",R.raw.non));
        list.add(new LettersModel("ه",R.raw.ha2));
        list.add(new LettersModel("و",R.raw.waw));
        list.add(new LettersModel("ي",R.raw.ya2));


        mutableLiveData.setValue(list);
    }
    void setArabicListLevel2(){
        list.add(new LettersModel("أ",R.raw.alf_level2));
        list.add(new LettersModel("ب",R.raw.ba2_level2));
        list.add(new LettersModel("ت",R.raw.ta2_level2));
        list.add(new LettersModel("ث",R.raw.tha2_level2));
        list.add(new LettersModel("ج",R.raw.gem_level2));
        list.add(new LettersModel("ح",R.raw.ha2_level2));
        list.add(new LettersModel("خ",R.raw.kha2_level2));
        list.add(new LettersModel("د",R.raw.dal_level2));
        list.add(new LettersModel("ذ",R.raw.zal_level2));
        list.add(new LettersModel("ر",R.raw.ra2_level2));
        list.add(new LettersModel("ز",R.raw.zay_level2));
        list.add(new LettersModel("س",R.raw.seen_level2));
        list.add(new LettersModel("ش",R.raw.sheen_level2));
        list.add(new LettersModel("ص",R.raw.sad_level2));
        list.add(new LettersModel("ض",R.raw.dad_level2));
        list.add(new LettersModel("ط",R.raw.ta2_tiara_level2));
        list.add(new LettersModel("ظ",R.raw.za2_level2));
        list.add(new LettersModel("ع",R.raw.een_level2));
        list.add(new LettersModel("غ",R.raw.gheen_level2));
        list.add(new LettersModel("ف",R.raw.fa2_level2));
        list.add(new LettersModel("ق",R.raw.kkaf_level2));
        list.add(new LettersModel("ك",R.raw.kaf_level2));
        list.add(new LettersModel("ل",R.raw.lam_level2));
        list.add(new LettersModel("م",R.raw.mem_level2));
        list.add(new LettersModel("ن",R.raw.non_level2));
        list.add(new LettersModel("ه",R.raw.ha_level2));
        list.add(new LettersModel("و",R.raw.waw_level2));
        list.add(new LettersModel("ي",R.raw.ya2_level2));


        mutableLiveData.setValue(list);
    }

}
