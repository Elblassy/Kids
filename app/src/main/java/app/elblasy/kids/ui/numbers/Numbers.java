package app.elblasy.kids.ui.numbers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.elblasy.kids.CustomSharedPref;
import app.elblasy.kids.databinding.NumbersFragmentBinding;

public class Numbers extends Fragment {

    private NumbersViewModel mViewModel;
    private NumbersAdapter numbersAdapter;
    private NumbersAdapterLevel2 numbersAdapterLevel2;
    private NumbersFragmentBinding binding;

    public static Numbers newInstance() {
        return new Numbers();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(NumbersViewModel.class);

        binding = NumbersFragmentBinding.inflate(inflater, container, false);

        CustomSharedPref pref = new CustomSharedPref(getContext());

        if (pref.getPrefLang("lang").equals("ar")) {
            if (pref.getSessionValue("level")) {
                binding.title.setText("تعلم الجمع والطرح");
                mViewModel.setListLevel2Ar();
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                binding.recyclerView.setLayoutManager(mLayoutManager);
                binding.recyclerView.setNestedScrollingEnabled(false);
                numbersAdapterLevel2 = new NumbersAdapterLevel2(getContext());
                binding.recyclerView.setAdapter(numbersAdapterLevel2);
            } else {
                binding.title.setText("الارقام");
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
                binding.recyclerView.setLayoutManager(mLayoutManager);
                binding.recyclerView.setNestedScrollingEnabled(false);
                numbersAdapter = new NumbersAdapter(getContext());
                binding.recyclerView.setAdapter(numbersAdapter);
                mViewModel.setListAr();
            }

        } else if (pref.getSessionValue("level")) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            binding.recyclerView.setLayoutManager(mLayoutManager);
            binding.recyclerView.setNestedScrollingEnabled(false);
            numbersAdapterLevel2 = new NumbersAdapterLevel2(getContext());
            mViewModel.setListLevel2();
            binding.recyclerView.setAdapter(numbersAdapterLevel2);
            binding.title.setText("Maths");
        } else {
            //Recyclerview implementation
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
            binding.recyclerView.setLayoutManager(mLayoutManager);
            binding.recyclerView.setNestedScrollingEnabled(false);
            numbersAdapter = new NumbersAdapter(getContext());
            binding.recyclerView.setAdapter(numbersAdapter);
            mViewModel.setList();
        }


        mViewModel.mutableLiveData.observe(getViewLifecycleOwner(), lettersModels -> {
            if (numbersAdapter != null)
                numbersAdapter.setList(lettersModels);
            else
                numbersAdapterLevel2.setList(lettersModels);
        });


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
