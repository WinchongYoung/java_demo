package test.common;

import org.redisson.Redisson;
import org.redisson.RedissonFairLock;
import org.redisson.api.RLock;

public class Test2 {
	Redisson redisson;
	RLock rLock;
	RedissonFairLock redissonFairLock;
}
