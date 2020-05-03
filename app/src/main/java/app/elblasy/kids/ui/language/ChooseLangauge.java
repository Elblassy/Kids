package app.elblasy.kids.ui.language;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import app.elblasy.kids.CustomSharedPref;
import app.elblasy.kids.R;
import app.elblasy.kids.databinding.ChooseLangaugeFragmentBinding;

public class ChooseLangauge extends Fragment {

    private ChooseLangaugeViewModel mViewModel;
    private ChooseLangaugeFragmentBinding binding;

    public static ChooseLangauge newInstance() {
        return new ChooseLangauge();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = ChooseLangaugeFragmentBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(ChooseLangaugeViewModel.class);

        CustomSharedPref pref = new CustomSharedPref(getContext());

        binding.english.setOnClickListener(v -> {
            pref.setPrefLang("en");
            Navigation.findNavController(v).navigate(R.id.action_chooseLangauge_to_levels);
        });

        binding.arabic.setOnClickListener(v -> {
            pref.setPrefLang("ar");
            Navigation.findNavController(v).navigate(R.id.action_chooseLangauge_to_levels);
        });
        return binding.getRoot();
    }



}
