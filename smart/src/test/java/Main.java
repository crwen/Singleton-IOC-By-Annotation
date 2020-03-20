import me.crw.smart.annotated.Inject;
import me.crw.smart.annotated.Processing;

/**
 * ClassName: Main
 * Description:
 * date: 2020/1/3 22:46
 *
 * @author crwen
 * @create 2020-01-03-22:46
 * @since JDK 1.8
 */
//@Controller
@Processing("/abc")
public class Main {

	@Inject
	public static Bean bean;

	public static void main(String[] args) {

		Processing annotation = Main.class.getAnnotation(Processing.class);
		String value = annotation.value();
		System.out.println(value);
		//Config.setPath(Main.class.getPackage().getName());
		//BeanManager.init();
		//System.out.println(bean);
		//bean.say();
	}
}
