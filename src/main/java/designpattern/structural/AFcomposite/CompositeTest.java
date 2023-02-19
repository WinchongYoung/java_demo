package designpattern.structural.AFcomposite;

/**
 * 把一组相似的对象当作一个单一的对象。如：树形菜单
 */
public class CompositeTest {

    public static void main(String[] args) {
        Menu root = new Menu(1, "系统管理");
        Menu 角色管理 = new Menu(2, "角色管理");
        root.addChildMenu(角色管理);
        角色管理.addChildMenu(new Menu(6, "固定角色"));
        角色管理.addChildMenu(new Menu(7, "临时授予"));

        Menu 用户管理 = new Menu(3, "用户管理");
        root.addChildMenu(用户管理);

        用户管理.addChildMenu(new Menu(4, "临时用户"));
        用户管理.addChildMenu(new Menu(5, "注册用户"));

        //按照不同层级展示
        root.printMenu();
    }
}
/**
 * 什么场景用到？
 * 层级结构
 * 部门组织结构
 * 组合了别的对象还是组合模式吗？
 * ......
 */
