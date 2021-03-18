import com.kiteaio.captcha.CaptchaHarvester;
import com.kiteaio.captcha.models.CaptchaWindow;

/**
 * @author Brennan
 * @since 3/18/2021
 **/
public class Test {

    public static void main(String[] args) {
        final CaptchaHarvester captchaHarvester = new CaptchaHarvester("", "");

        final CaptchaWindow captchaWindow = captchaHarvester.createWindow();

    }

}
