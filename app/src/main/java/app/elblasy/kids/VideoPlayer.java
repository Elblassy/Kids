package app.elblasy.kids;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        String path = getIntent().getStringExtra("video");
        VideoView videoView = findViewById(R.id.video);
        videoView.setVideoURI(Uri.parse(path));
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.start();

        Button end = findViewById(R.id.end);

        end.setOnClickListener(v -> {
            videoView.stopPlayback();
            onBackPressed();
        });

    }
}
