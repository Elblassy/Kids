package app.elblasy.kids.ui.colors;

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
import app.elblasy.kids.models.NumbersLevel2Model;

public class ColorsAdapterLevel2 extends RecyclerView.Adapter<ColorsAdapterLevel2.ViewHolder> {

    private List<NumbersLevel2Model> letters_item = new ArrayList<>();
    private Context context;

    public ColorsAdapterLevel2(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ColorsAdapterLevel2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.colors_item_level2,
                parent, false);
        return new ColorsAdapterLevel2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsAdapterLevel2.ViewHolder holder, int position) {
        NumbersLevel2Model lettersModel = letters_item.get(position);

        holder.firstNumber.setImageResource(lettersModel.getFirstNumber());
        holder.secondNumber.setImageResource(lettersModel.getSecondNumber());
        holder.sign.setImageResource(lettersModel.getSign());
        holder.equal.setImageResource(lettersModel.getEqual());

        holder.cardView.setOnClickListener(v -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, lettersModel.getAudio());
            mediaPlayer.start();
        });
    }

    @Override
    public int getItemCount() {
        return letters_item.size();
    }

    public void setList(List<NumbersLevel2Model> letters_item) {
        this.letters_item = letters_item;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView firstNumber, sign, secondNumber, equal;
        CardView cardView;

        ViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card);
            firstNumber = view.findViewById(R.id.first_number);
            sign = view.findViewById(R.id.sign);
            secondNumber = view.findViewById(R.id.second_number);
            equal = view.findViewById(R.id.number_equal);

        }
    }
}
