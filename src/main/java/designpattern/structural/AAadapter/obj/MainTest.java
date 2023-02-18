package designpattern.structural.AAadapter.obj;


import designpattern.structural.AAadapter.MoviePlayer;

public class MainTest {
    public static void main(String[] args) {
        JPMoviePlayerAdapter adapter = new JPMoviePlayerAdapter(new MoviePlayer());
        adapter.play();
    }
}
