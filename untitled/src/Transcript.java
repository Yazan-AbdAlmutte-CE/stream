public class Transcript {
    private String audio_url;
    private String id;
private String text;
private String status;

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }


    public void setAudioUrl(String audioUrl) {
        this.audio_url = audioUrl;
    }
    public void setId(String id) {
        this.id = id;
    }

}
