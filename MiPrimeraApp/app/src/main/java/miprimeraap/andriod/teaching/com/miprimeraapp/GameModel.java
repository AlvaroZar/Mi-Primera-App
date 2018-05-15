package miprimeraap.andriod.teaching.com.miprimeraapp;

public class GameModel {
    private int id;
    private String name;
    private String description;
    private String oficialWebsiteUr;
    private  int iconDrawable;
    private int backgroundDrawable;

    public GameModel(int id, String name, String description, String oficialWebsiteUr, int iconDrawable, int backgroundDrawable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.oficialWebsiteUr = oficialWebsiteUr;
        this.iconDrawable = iconDrawable;
        this.backgroundDrawable = backgroundDrawable;
    }



    public GameModel() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOficialWebsiteUr() {
        return oficialWebsiteUr;
    }

    public void setOficialWebsiteUr(String oficialWebsiteUr) {
        this.oficialWebsiteUr = oficialWebsiteUr;
    }

    public int getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public int getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public void setBackgroundDrawable(int backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
    }
}
