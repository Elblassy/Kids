package app.elblasy.kids.ui.levels;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import app.elblasy.kids.CustomSharedPref;
import app.elblasy.kids.R;
import app.elblasy.kids.databinding.LevelsFragmentBinding;

public class Levels extends Fragment {

    private LevelsViewModel mViewModel;
    private LevelsFragmentBinding binding;
    private static final String TAG = "Levels";

    public static Levels newInstance() {
        return new Levels();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = LevelsFragmentBinding.inflate(inflater, container, false);

        CustomSharedPref pref = new CustomSharedPref(getContext());

        Log.d(TAG, "onCreateView: "+ pref.getPrefLang("lang"));
        if (pref.getPrefLang("lang").equals("ar")){
            binding.levelOneText.setText("المستوى الاول");
            binding.levelTwoText.setText("المستوى الثاني");
            binding.title.setText("المستويات");
        }

        binding.levelOne.setOnClickListener(v -> {
            pref.setPrefLevel(false);
            Navigation.findNavController(v).navigate(R.id.action_levels_to_title2);
        });

        binding.levelTwo.setOnClickListener(v -> {
            pref.setPrefLevel(true);
            Navigation.findNavController(v).navigate(R.id.action_levels_to_title2);
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LevelsViewModel.class);
        // TODO: Use the ViewModel
    }

}
