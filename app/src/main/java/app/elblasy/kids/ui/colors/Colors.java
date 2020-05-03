package app.elblasy.kids.ui.colors;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.CustomSharedPref;
import app.elblasy.kids.R;
import app.elblasy.kids.databinding.ColorsFragmentBinding;
import app.elblasy.kids.models.LettersModel;
import app.elblasy.kids.ui.letters.LettersAdapter;
import app.elblasy.kids.ui.numbers.NumbersAdapter;
import app.elblasy.kids.ui.numbers.NumbersAdapterLevel2;

public class Colors extends Fragment {

    private ColorsViewModel mViewModel;
    private ColorsAdapter colorsAdapter;
    private ColorsAdapterLevel2 colorsAdapterLevel2;

    private ColorsFragmentBinding binding;

    public static Colors newInstance() {
        return new Colors();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ColorsViewModel.class);

        binding = ColorsFragmentBinding.inflate(inflater, container, false);

        CustomSharedPref pref = new CustomSharedPref(getContext());

        if (pref.getPrefLang("lang").equals("ar")){
            if (pref.getSessionValue("level")){
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                binding.recyclerView.setLayoutManager(mLayoutManager);
                binding.recyclerView.setNestedScrollingEnabled(false);
                colorsAdapterLevel2 = new ColorsAdapterLevel2(getContext());
                binding.recyclerView.setAdapter(colorsAdapterLevel2);
                mViewModel.setListLevel2Ar();
            }else {
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
                binding.recyclerView.setLayoutManager(mLayoutManager);
                binding.recyclerView.setNestedScrollingEnabled(false);
                colorsAdapter = new ColorsAdapter(getContext());
                binding.recyclerView.setAdapter(colorsAdapter);
                mViewModel.setListAr();
            }
            binding.title.setText("ألالوان");

        }else if (pref.getSessionValue("level")) {
            binding.title.setText("Colors");
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            binding.recyclerView.setLayoutManager(mLayoutManager);
            binding.recyclerView.setNestedScrollingEnabled(false);
            colorsAdapterLevel2 = new ColorsAdapterLevel2(getContext());
            binding.recyclerView.setAdapter(colorsAdapterLevel2);
            mViewModel.setListLevel2();
        } else {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
            binding.recyclerView.setLayoutManager(mLayoutManager);
            binding.recyclerView.setNestedScrollingEnabled(false);
            colorsAdapter = new ColorsAdapter(getContext());
            binding.recyclerView.setAdapter(colorsAdapter);
            mViewModel.setList();
        }


        mViewModel.mutableLiveData.observe(getViewLifecycleOwner(), lettersModels -> {
            if (colorsAdapter != null)
                colorsAdapter.setList(lettersModels);
        });

        mViewModel.mutableLiveDataLevel2.observe(getViewLifecycleOwner(), numbersLevel2Models -> {
            if (colorsAdapterLevel2 != null)
                colorsAdapterLevel2.setList(numbersLevel2Models);
        });




        return binding.getRoot();
    }


}
