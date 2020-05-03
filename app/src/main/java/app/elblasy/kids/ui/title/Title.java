package app.elblasy.kids.ui.title;

import android.os.Bundle;
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
import app.elblasy.kids.databinding.TitleFragmentBinding;

public class Title extends Fragment {

    private TitleViewModel mViewModel;
    private TitleFragmentBinding binding;

    public static Title newInstance() {
        return new Title();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = TitleFragmentBinding.inflate(inflater, container, false);

        CustomSharedPref pref = new CustomSharedPref(getContext());

        if (pref.getPrefLang("lang").equals("ar")){
            binding.titleLetter.setText("الحروف والكلمات");
            binding.numberTitle.setText("الارقام");
            binding.colorsTitle.setText("الالوان");
            binding.quizTitle.setText("اختبار");
            binding.title.setText("المستوى الاول");
            binding.letterImage.setImageResource(R.drawable.alphabet_letters_ar);
            binding.numberImage.setImageResource(R.drawable.numbers_alphabet_ar);
        }

        if (pref.getSessionValue("level")) {
            if (pref.getPrefLang("lang").equals("ar")){
                binding.titleLetter.setText("الحروف والكلمات");
                binding.numberTitle.setText("الارقام");
                binding.colorsTitle.setText("الالوان");
                binding.quizTitle.setText("اختبار");
                binding.title.setText("المستوى الثاني");

            }else {
                binding.title.setText("Level Two");
                binding.titleLetter.setText("Words\n and\n Letters");
            }

        }
        binding.lettersCard.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_title2_to_letters);
        });
        binding.numbersCard.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_title2_to_numbers);

        });
        binding.colorsCard.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_title2_to_colors);

        });
        binding.quiz.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_title2_to_questions);

        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TitleViewModel.class);
    }

}
