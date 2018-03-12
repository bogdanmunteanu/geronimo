package bogdanmunteanu.ro.geronimo.model;

/**
 * Created by Bogdan on 3/12/2018.
 */

public class Item {

    public String title;
    public String subtitile;
    public String imageUrl;

    public Item(String title, String subtitile, String imageUrl) {
        this.title = title;
        this.subtitile = subtitile;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", subtitile='" + subtitile + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
