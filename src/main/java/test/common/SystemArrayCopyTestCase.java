package test.common;

public class SystemArrayCopyTestCase {

    public static void main(String[] args) {
        User[] users = new User[]{
                new User(1, "seven", "seven@qq.com"),
                new User(2, "six", "six@qq.com"),
                new User(3, "ben", "ben@qq.com")};// 初始化对象数组
        User[] target = new User[users.length];// 新建一个目标对象数组
        System.arraycopy(users, 0, target, 0, users.length);// 实现复制
        System.out.println("源对象与目标对象的物理地址是否一样：" + (users[0] == target[0] ? "浅复制" : "深复制"));  //浅复制
        target[0].setEmail("admin@sina.com");
        System.out.println("修改目标对象的属性值后源对象users：");
        for (User user : users) {
            System.out.println(user);
        }
    }
}

class User {
    private Integer id;
    private String username;
    private String email;

    // 无参构造函数
    public User() {
    }

    // 有参的构造函数
    public User(Integer id, String username, String email) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }
}