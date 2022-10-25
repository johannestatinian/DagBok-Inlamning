public class Post {
    private String title;
    private String diaryText;
    private String date;

    public Post() {
    }

    public Post(String title, String diaryText, String date) {
        this.title = title;
        this.diaryText = diaryText;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public void setDiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
