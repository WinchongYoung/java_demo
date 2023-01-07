package concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest {

    public static void main(String[] args) {
        new CompletableFutureTest().test();
    }

    public void test() {
        List<YoutubeVideoEntity> subVideosList = new ArrayList<>();
        subVideosList.add(new YoutubeVideoEntity(1, "A"));
        subVideosList.add(new YoutubeVideoEntity(2, "B"));
        subVideosList.add(new YoutubeVideoEntity(3, "C"));
        subVideosList.add(new YoutubeVideoEntity(4, "D"));
        List<CompletableFuture<YoutubeVideoEntity>> futures = subVideosList.stream()
                .map(item ->
                        CompletableFuture.supplyAsync(() -> this.getRetry(item)
                                , Executors.newFixedThreadPool(3))
                ).collect(Collectors.toList());

        List<YoutubeVideoEntity> videoEntities = futures.stream().map(CompletableFuture::join).filter(item -> item != null && item.getVideoId() != null).collect(Collectors.toList());
        for (YoutubeVideoEntity tmp : videoEntities) {
            System.out.println(tmp.getRetry());
        }
    }

    public YoutubeVideoEntity getRetry(YoutubeVideoEntity youtubeVideoEntity) {
        return new YoutubeVideoEntity(youtubeVideoEntity.getVideoId(), youtubeVideoEntity.getRetry() + "666");
    }

    class YoutubeVideoEntity {

        Integer videoId;

        String retry;

        public Integer getVideoId() {
            return videoId;
        }

        public void setVideoId(Integer videoId) {
            this.videoId = videoId;
        }

        public String getRetry() {
            return retry;
        }

        public void setRetry(String retry) {
            this.retry = retry;
        }

        public YoutubeVideoEntity(Integer videoId, String retry) {
            this.videoId = videoId;
            this.retry = retry;
        }

    }
}
