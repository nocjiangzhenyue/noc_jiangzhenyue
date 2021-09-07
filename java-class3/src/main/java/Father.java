/**
 * 功能描述：
 * 父类
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月06日 13:38
 */

/**
 * 功能描述：
 * 父类
 * @author jiangzhenyue
 * @date 2021年09月06日 13:38
 */
public abstract class Father {
    private String name = "father";

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类name:" + name);
        System.out.println("父类代码块1");
    }

    public Father() {
        System.out.println("父类无参构造方法");
    }

    public Father(String name) {
        this.name = name;
        System.out.println("父类有参构造方法");
    }

    {
        System.out.println("父类代码块2");
        name = "father2";
    }

}
