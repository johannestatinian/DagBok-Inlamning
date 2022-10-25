public class Post {
    private String title;
    private String diaryText;

    public Post() {
    }

    public Post(String title, String diaryText) {
        this.title = title;
        this.diaryText = diaryText;
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
}
