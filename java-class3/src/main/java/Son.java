/**
 * 功能描述：
 * 子类
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月06日 13:46
 */

/**
 * 功能描述：
 * 子类
 * @author jiangzhenyue
 * @date 2021年09月06日 13:46
 */
public class Son extends Father{
    private String name = "son";
    static{
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类name:"+name);
        System.out.println("子类代码块1");
    }
    public Son(){
        super("name from son");
        System.out.println("子类无参构造方法");
    }
    public Son(String name){
        this.name = name;
        System.out.println("子类有参构造方法");
    }
    {
        System.out.println("子类代码块2");
    }

    public static void main(String[] args) {
        /*
          原打印结果:       	     打印结果:
        1.父类静态代码块          父类静态代码块
        2.子类静态代码块	       子类静态代码块
        3.父类name:father	   父类name:father
        4.父类代码块1		       父类代码块1
        5.父类有参构造方法		   父类代码块2
        6.父类代码块2		       父类有参构造方法
        7.子类name:son          子类name:son
        8.子类代码块1            子类代码块1
        7.子类无参构造方法		   子类代码块2   -> 错误
        8.son		           子类无参构造方法
                               son
        原因：
        1.java代码执行顺序为：
        有static修饰的，在类初始化前加载，按顺序执行
        没有static修饰的，构造代码块优先于构造执行，构造代码块按顺序执行
        2.子类构造前需要调用父类构造
        3.调用构造函数时，根据参数选择不同构造函数执行
        即：
        1. 在类初始化之前，静态代码块先执行，且父类先于子类执行，
        2. 子类初始化时，需要父类先初始化，此时又有构造代码块优先于构造函数执行，
        所以此时父类进行构造，构造代码块->构造函数，此处构造函数有参数
        3. 父类构造完成后，子类构造代码块->构造函数，此次构造函数无参
        错误原因：
        构造方法块的位置可以不放在开头，写在类中的代码块都是构造代码块，并且按顺序执行
        */
        Son son = new Son();
        System.out.println(son.name);
    }
}
