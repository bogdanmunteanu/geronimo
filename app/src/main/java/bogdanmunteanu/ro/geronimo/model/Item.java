package bogdanmunteanu.ro.geronimo.model;

import java.util.Random;

/**
 * Created by Bogdan Munteanu
 * Model class that holds information presented in the UI
 * Contains method that generates a random generator for pictureUrl;
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

    public Item(String title) {
        this.title = title;
        this.subtitile = getRandomPictureUrl();
        this.imageUrl = getRandomPictureUrl();

    }

    public String  getRandomPictureUrl()
    {
        String url = "http://picsum.photos/600/300/?image=";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(1000);
        StringBuilder builder = new StringBuilder();
        builder.append(url);
        builder.append(randomNumber);
        return builder.toString();
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
