/**
 * 功能描述：
 * 动物抽象类
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月06日 14:34
 */

/**
 * 功能描述：
 * 动物抽象类，都会动
 * @author jiangzhenyue
 * @date 2021年09月06日 14:34
 */
public abstract class Animal {
    // 动物通用属性：活着
    final boolean live;

    protected Animal() {
        live = false;
    }

    // 动物都会动
    abstract void move();
}
