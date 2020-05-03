package app.elblasy.kids.models;

public class LettersModel {

    private String name;
    private int image = -1;
    private int audio = -1;
    private int video;

    public LettersModel(String name, int image, int audio) {
        this.name = name;
        this.image = image;
        this.audio = audio;
    }

    public LettersModel(String name, int video) {
        this.name = name;
        this.video = video;
    }


    public int getVideo() {
        return video;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getAudio() {
        return audio;
    }
}
