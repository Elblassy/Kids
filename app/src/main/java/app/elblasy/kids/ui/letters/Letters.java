package app.elblasy.kids.ui.letters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.elblasy.kids.CustomSharedPref;
import app.elblasy.kids.databinding.LettersFragmentBinding;
import app.elblasy.kids.models.LettersModel;

public class Letters extends Fragment {

    private LettersViewModel mViewModel;
    private LettersAdapter lettersAdapter;
    private LettersFragmentBinding binding;

    private static final String TAG = "Letters";

    public static Letters newInstance() {
        return new Letters();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(LettersViewModel.class);

        binding = LettersFragmentBinding.inflate(inflater, container, false);

        CustomSharedPref pref = new CustomSharedPref(getContext());

        //Recyclerview implementation
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.setNestedScrollingEnabled(false);


        lettersAdapter = new LettersAdapter(getContext());
        binding.recyclerView.setAdapter(lettersAdapter);

        if (pref.getPrefLang("lang").equals("ar")) {
            if (pref.getSessionValue("level")) {
                mViewModel.setArabicListLevel2();
                binding.title.setText("حروف الهجاء بالتشكيل");
            } else {
                mViewModel.setArabicList();
                binding.title.setText("حروف الهجاء");
            }
        } else if (pref.getSessionValue("level")) {
            binding.title.setText("Words");
            mViewModel.setWordsList();

        } else {
            mViewModel.setLitterList();
        }

        mViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<LettersModel>>() {
            @Override
            public void onChanged(List<LettersModel> lettersModels) {
                lettersAdapter.setList(lettersModels);
            }
        });


        return binding.getRoot();
    }


}
