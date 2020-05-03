package app.elblasy.kids.models;

import java.util.List;

public class QuestionsModel {

    private int audio;
   private List<Integer> answers;

    public QuestionsModel(int audio, List<Integer> answers) {
        this.audio = audio;
        this.answers = answers;
    }

    public int getAudio() {
        return audio;
    }

    public List<Integer> getAnswers() {
        return answers;
    }
}
