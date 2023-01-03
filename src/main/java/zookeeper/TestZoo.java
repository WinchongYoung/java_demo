package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

public class TestZoo {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("101.43.131.248:2183", 3000, watchedEvent -> {
            switch (watchedEvent.getType()) {
                case None:
                    break;
                case NodeCreated:
                    break;
                case NodeDeleted:
                    break;
                case NodeDataChanged:
                    break;
                case NodeChildrenChanged:
                    break;
                case DataWatchRemoved:
                    break;
                case ChildWatchRemoved:
                    break;
                case PersistentWatchRemoved:
                    break;
            }

            switch (watchedEvent.getState()) {
                case Unknown:
                    break;
                case Disconnected:
                    break;
                case NoSyncConnected:
                    break;
                case SyncConnected:
                    countDownLatch.countDown();
                    System.out.println("SyncConnected.............................");
                    break;
                case AuthFailed:
                    break;
                case ConnectedReadOnly:
                    break;
                case SaslAuthenticated:
                    break;
                case Expired:
                    break;
                case Closed:
                    break;
            }
        });

        // create
        String ret = zooKeeper.create("/ooxx", "oldData".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(ret);

        // get
        byte[] data = zooKeeper.getData("/ooxx", watchedEvent -> System.out.println("even happening:" + watchedEvent), new Stat());
        String ret2 = new String(data, StandardCharsets.UTF_8);
        System.out.println(ret2);

        // get data sync
        zooKeeper.getData("/ooxx", false, (i, s, o, bytes, stat) -> {
            System.out.println("sync out");
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        }, "");

        // set
        zooKeeper.setData("/ooxx", "oldData".getBytes(StandardCharsets.UTF_8), 0);
        // set 2
        zooKeeper.setData("/ooxx", "oldData".getBytes(StandardCharsets.UTF_8), 1);

        countDownLatch.await();
    }

}
