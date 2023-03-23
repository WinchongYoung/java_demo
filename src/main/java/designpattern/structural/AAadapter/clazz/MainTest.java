package designpattern.structural.AAadapter.clazz;

import designpattern.structural.AAadapter.MoviePlayer;

/**
 * 类继承方式
 */
public class MainTest {

    public static void main(String[] args) {
        MoviePlayer player = new MoviePlayer();
        JPMoviePlayerAdapter playerAdapter = new JPMoviePlayerAdapter(player);
        playerAdapter.play();
    }
}
