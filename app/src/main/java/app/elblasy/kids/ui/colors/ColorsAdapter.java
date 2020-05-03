package app.elblasy.kids.ui.colors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.elblasy.kids.R;
import app.elblasy.kids.models.LettersModel;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ViewHolder> {

    List<LettersModel> letters_item = new ArrayList<>();
    private static final String TAG = "ColorsAdapter";
    private Context context;

    public ColorsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ColorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.colors_item,
                parent, false);
        return new ColorsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsAdapter.ViewHolder holder, int position) {
        LettersModel lettersModel = letters_item.get(position);

        holder.color.setImageResource(lettersModel.getImage());
        holder.colorName.setText(lettersModel.getName());

        Bitmap image = BitmapFactory.decodeResource(context.getResources(), lettersModel.getImage());
        int color = getDominantColor(image);
        if (color != -1) {
            holder.colorName.setTextColor(getDominantColor(image));
        }

        holder.cardView.setOnClickListener(v->{
            MediaPlayer mediaPlayer = MediaPlayer.create(context,lettersModel.getAudio());
            mediaPlayer.start();
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

        ImageView color;
        TextView colorName;
        CardView cardView;

        ViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card);
            colorName = view.findViewById(R.id.color_name);
            color = view.findViewById(R.id.color_image);
        }
    }

    public static int getDominantColor(Bitmap bitmap) {
        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
        final int color = newBitmap.getPixel(0, 0);
        newBitmap.recycle();
        return color;
    }
}