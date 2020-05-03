package app.elblasy.kids.ui.numbers;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.R;
import app.elblasy.kids.models.LettersModel;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {

    private List<LettersModel> letters_item = new ArrayList<>();
    private Context context;

    public NumbersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NumbersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_item,
                parent, false);
        return new NumbersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersAdapter.ViewHolder holder, int position) {
        LettersModel lettersModel = letters_item.get(position);

        holder.number.setImageResource(lettersModel.getImage());
        holder.cardView.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, lettersModel.getAudio());

            mediaPlayer.start();
        });
    }

    @Override
    public int getItemCount() {
        return letters_item.size();
    }

    public void setList(List<LettersModel> letters_item) {
        this.letters_item = letters_item;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView number;
        CardView cardView;

        ViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card);
            number = view.findViewById(R.id.number);
        }
    }
}
