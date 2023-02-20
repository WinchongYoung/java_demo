package designpattern.structural.AFcomposite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用组合模式，组织层级结构的数据
 */
@Data
public class Menu {

    private Integer id;
    private String name;

    public Menu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //组合模式关注点
    private List<Menu> children = new ArrayList<>();

    //提供添加层级的方法
    void addChildMenu(Menu menu) {
        children.add(menu);
    }

    //层级遍历方法
    void printMenu() {
        System.out.println(name);
        if (children.size() > 0) {
            for (Menu child : children) {
                child.printMenu();
            }
        }
    }

}
