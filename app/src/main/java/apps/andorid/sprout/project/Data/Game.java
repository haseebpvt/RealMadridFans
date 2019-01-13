package apps.andorid.sprout.project.Data;

public class Game {

    private String title;
    private String subTitle;
    private String id;
    private int image;

    //Constructors

    public Game() {}

    public Game(String title, String subTitle, String id, int image) {
        this.title = title;
        this.subTitle = subTitle;
        this.id = id;
        this.image = image;
    }

    //Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
