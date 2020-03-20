package me.crw.smart.servlet;

import me.crw.smart.servlet.handler.AnnotationHandlerAdapter;
import me.crw.smart.servlet.handler.Handler;
import me.crw.smart.servlet.handler.HandlerManager;
import me.crw.smart.servlet.renderer.ModelAndView;
import me.crw.smart.utils.JsonUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DispatcherServlet
 * Description:
 * date: 2020/1/20 23:16
 *
 * @author crwen
 * @create 2020-01-20-23:16
 * @since JDK 1.8
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {


	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

		// 获取 ServletConfig 对象（用于注册 Servlet）
		ServletContext servletContext = servletConfig.getServletContext();
		// 处理注册 JSP 的 Servlet
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping( "/WEB-INF/*");
		// 注册处理静态资源的默认 Servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping( "/static/*");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// 创建请求参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration<String> paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = req.getParameter(paramName);
			paramMap.put(paramName, paramValue);
		}
		paramMap.put("HttpServletRequest" , req);
		paramMap.put("HttpServletResponse" , resp);

		ModelAndView mv;
		Handler handler = getHandler(req);
		if (null == handler) {
			return;
		} else {
			HandlerAdapter ha = getHandlerAdapter(handler);
			// 调用方法执行
			mv = ha.handler(handler, paramMap);

			if (null != mv.getView()) {
				String responseURL = "/static/" + mv.getView();
				//System.out.println(responseURL);
				req.getRequestDispatcher(responseURL).forward(req, resp);
			} else if (null != mv.getModel()){
					// 返回 JSON 数据
				Object model = mv.getModel();
				if (model != null) {
					System.out.println(model);
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					PrintWriter writer = resp.getWriter();
					String json = JsonUtils.toJson(model);
					writer.write(json);
					writer.flush();
					writer.close();
				}
			}

		}


	}

	private HandlerAdapter getHandlerAdapter(Handler handler) {

		return new AnnotationHandlerAdapter();
	}

	/**
	 *  获取请求处理器
	 * @param request
	 * @return
	 */
	private Handler getHandler(HttpServletRequest request) {
		return HandlerManager.getHandler(request);
	}
}
