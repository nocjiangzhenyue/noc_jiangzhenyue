/**
 * 功能描述：
 * 适配器类，实现VGA和VGA的转换
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月06日 15:42
 */

/**
 * 功能描述：
 * 适配器类，电脑有HDMI类，投影仪需要VGA类，需要将HDMI转换为VGA
 * @author jiangzhenyue
 * @date 2021年09月06日 15:42
 */
public class Adapter extends VGA{
    private HDMI hdmi;

    public Adapter(HDMI hdmi){
        this.hdmi = hdmi;
        hdmi.input();
    }

    public HDMI getHDMI() {
        return hdmi;
    }

    public void setHDMI(HDMI hdmi) {
        this.hdmi = hdmi;
    }

}
