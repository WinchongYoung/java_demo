package prox;

/**
 * 业务接口实现类
 * 
 * @author Muscleape
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("增加一个用户。。。");
	}

	@Override
	public void editUser() {
		System.out.println("编辑一个用户。。。");
	}

	@Override
	public boolean equals() {
		return false;
	}

}