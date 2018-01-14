package juraj.podgajski.com.chucknorrisjoketeller.model;

/**
 * Created by jurajdnd on 27/09/2017.
 */

public class Joke {

    private int id;
    private String joke;

    public Joke(int id, String joke) {
        this.id = id;
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }
}
