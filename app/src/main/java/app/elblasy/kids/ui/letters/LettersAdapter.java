package app.elblasy.kids.ui.letters;

import android.app.Dialog;
import android.content.Context;
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
import app.elblasy.kids.models.LettersModel;

public class LettersAdapter extends RecyclerView.Adapter<LettersAdapter.ViewHolder> {

    List<LettersModel> letters_item = new ArrayList<>();
    private Context context;

    public LettersAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LettersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.letters_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LettersAdapter.ViewHolder holder, int position) {
        LettersModel lettersModel = letters_item.get(position);

        if (lettersModel.getImage() != -1) {
            holder.upperCase.setImageResource(lettersModel.getImage());
        }

        if (!lettersModel.getName().equals("")) {
            holder.title.setText(lettersModel.getName());
        }
        holder.cardView.setOnClickListener(v -> {
            if (lettersModel.getAudio() != -1) {
                MediaPlayer mediaPlayer = MediaPlayer.create(context, lettersModel.getAudio());
                mediaPlayer.start();
            }else {
                videoDialog(lettersModel.getVideo());
            }
        });
    }

    @Override
    public int getItemCount() {
        return letters_item.size();
    }

    public void setList(List<LettersModel> letters_item) {
        this.letters_item = letters_item;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView upperCase;
        CardView cardView;
        TextView title;

        ViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.title);
            cardView = view.findViewById(R.id.card);
            upperCase = view.findViewById(R.id.upper_case);
        }
    }

    private void videoDialog(int video){

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.video_dialog);

        VideoView videoView = dialog.findViewById(R.id.video);
        String path = "android.resource://" + context.getPackageName() + "/" + video;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();

        Button end = dialog.findViewById(R.id.end);

        end.setOnClickListener(v-> dialog.dismiss());

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
