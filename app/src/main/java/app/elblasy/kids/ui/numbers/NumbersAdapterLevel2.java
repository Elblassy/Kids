package app.elblasy.kids.ui.numbers;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.R;
import app.elblasy.kids.VideoPlayer;
import app.elblasy.kids.models.LettersModel;
import app.elblasy.kids.models.NumbersLevel2Model;

public class NumbersAdapterLevel2 extends RecyclerView.Adapter<NumbersAdapterLevel2.ViewHolder> {

    private List<LettersModel> letters_item = new ArrayList<>();
    private Context context;

    public NumbersAdapterLevel2(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NumbersAdapterLevel2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_item_level2,
                parent, false);
        return new NumbersAdapterLevel2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersAdapterLevel2.ViewHolder holder, int position) {
        LettersModel lettersModel = letters_item.get(position);

      holder.number.setText(lettersModel.getName());
        holder.cardView.setOnClickListener(v -> {
            videoDialog(lettersModel.getVideo());
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

        TextView number;
        CardView cardView;

        ViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card);
            number = view.findViewById(R.id.title);


        }
    }

    private void videoDialog(int video){

        String path = "android.resource://" + context.getPackageName() + "/" + video;
        context.startActivity(new Intent(context, VideoPlayer.class).putExtra("video", path));
    }

}
