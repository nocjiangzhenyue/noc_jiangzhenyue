/**
 * 功能描述：
 * 适配器类
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月06日 14:40
 */

/**
 * 功能描述：
 * 适配器类，实现转换功能
 * @author jiangzhenyue
 * @date 2021年09月06日 14:40
 */
public class Projector {
    private VGA vga;
    public void play(){
        this.vga.output();
        System.out.println("播放投影");
    }

    public VGA getVga(){
        return vga;
    }

    public void setVga(VGA vga) {
        this.vga = vga;
    }

    /*
     * 功能描述：
     * HDMI转VGA
     * @author jiangzhenyue
     * @date 2021/9/6 15:25
     * @param null
     * @return null
    */
    public static void main(String[] args) {
        Projector projector = new Projector();
        // todo:输入HDMI类，输出VGA类，将VGA对象传给投影仪
        VGA vga = new Adapter(new HDMI());
        projector.setVga(vga);
        projector.play();
    }
}
