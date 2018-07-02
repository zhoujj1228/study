package chapter5.springMVC;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 总体：
 * SpingMVC配置流程：
 * 1.继承AbstractAnnotationConfigDispatcherServletInitializer,重写三个方法
 * 2.配置WebConfig类，添加Configuration、EnableWebMvc、ComponentScan注解，添加视图Bean配置，重写configureDefaultServletHandling方法进行静态资源过滤
 * 3.配置RootConfig类，添加Configuration、ComponentScan注解
 * 3.编写Controller类添加Controller注解，在对应地方（方法、或许还有类）上添加RequestMapping注解进行路径映射配置
 * 
 * 
 * 
 * 
 * 1.springMVC运行流程:
 * a.客户端请求发往前端控制器DispatcherServlet
 * b.DispatcherServlet会查询一个或多个处理器映射（handler mapping）来确定请求发往哪个controller
 * c.请求到了controller会卸下其负载（用户提交的信息）并耐心等待控制器处理这些信息（交予服务对象进行处理，控制器不处理）,处理后得到返回
 * 信息（模型）,将打包后的模型和对应视图名返回给DispatcherServlet
 * d.DispatcherServlet根据视图名查询产生结果的最终视图（使用视图解析器）
 * e.视图实现，将模型数据进行视图渲染
 * f.将最终结果返回客户端
 * 
 * 
 * 2.spring容器加载机理：
 * 在Servlet3.0环境中，容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类，
 * 如果能发现的话，就会用它来配置Servlet容器。Spring提供了这个接口的实现，名为SpringServletContainerInitializer，
 * 这个类反过来又会查找实现WebApplicationInitializer的类并将配置的任务交给它们来完成。
 * Spring3.2引入了一个便利的WebApplicationInitializer基础实现，
 * 也就是AbstractAnnotationConfigDispatcherServletInitializer。
 * 因为我们的Spittr-WebAppInitializer扩展了AbstractAnnotationConfigDispatcherServlet-Initializer（同时也就实现了WebApplicationInitializer），
 * 因此当部署到Servlet3.0容器中的时候，容器会自动发现它，并用它来配置Servlet上下文。
 * 
 * 3.AbstractAnnotationConfigDispatcherServletInitializer里两个应用上下文：
 * DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及处理器映射
 * ContextLoaderListener要加载应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件。
 * 
 * 4.两个应用上下文加载过程：
 * AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener。
 * GetServlet-ConfigClasses()方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean。
 * getRootConfigClasses()方法返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean。
 * 
 * 5.方法级别、类级别的请求处理
 * 在方法和类上用@RequestMapping注解进行修饰（见HomeController）,代表该controller负责哪些请求
 * @RequestMapping({"/", "/homepage"})
 * 
 * 6.模型数据返回
 * 多种返回方式见ModelController.getTestList()
 * 
 * 7.处理查询参数
 * 见ParamController.getTestListByNum()
 * 
 * 8.通过路径参数接受输入
 * 见ParamController.getSomeOneById()
 * 如果路径占位符与方法参数名一致可以去掉@PathVariable中的value属性
 * 
 * 9.通过表单提交数据
 * 见FormController.register() 和 FormController.register(TestDomain td)
 * a.注意get和post方式
 * b.如果表单内不使用action属性则提交是按照展现时相同路径进行提交 
 * c.表单需要作为一个方法参数传入，如TestDomain,并且需要一个无参数的默认构造方法
 * d.使用重定向：return "redirect:/getSomeOne/" + td.getId();
 * e.使用请求前往：return "forward:/getSomeOne/" + td.getId();
 * 
 * 10.表单的校验
 * 需要额外导入JSR303规范的API，如hibernate validator
 * a.参数要使用@Valid修饰
 * b.表单类属性要添加对应校验注解修饰
 * 常用校验注解：
 * @AssertFalse 所注解的元素必须是Boolean类型，并且值为false
 * @AssertTrue 所注解的元素必须是Boolean类型，并且值为true
 * @DecimalMax 所注解的元素必须是数字，并且它的值要小于或等于给定的BigDecimalString值
 * @DecimalMin 所注解的元素必须是数字，并且它的值要大于或等于给定的BigDecimalString值
 * @Digits 所注解的元素必须是数字，并且它的值必须有指定的位数
 * @Future 所注解的元素的值必须是一个将来的日期
 * @Max 所注解的元素必须是数字，并且它的值要小于或等于给定的值
 * @Min 所注解的元素必须是数字，并且它的值要大于或等于给定的值
 * @NotNull 所注解元素的值必须不能为null
 * @Null 所注解元素的值必须为null
 * @Past 所注解的元素的值必须是一个已过去的日期
 * @Pattern 所注解的元素的值必须匹配给定的正则表达式
 * @Size 所注解的元素的值必须是String、集合或数组，并且它的长度要符合给定的范围
 * 
 * 
 * 11.视图
 * a.springMVC内部视图实现：
 * ViewResolver接口里面包括resolveViewName(String viewName,Locale locale)方法, 传入视图名和locale对象，返回View实例
 * View接口里面包括render(Map<String, V>, HttpServletRequest req, HttpServletResponse rsp)方法，主要接受模型servlet的req和rsp对象并将结果渲染到rsp中
 * 
 * b.配置JSP视图解析器
 * InternalResourceViewResolver是常用的JSP视图解析器，具体配置见WebConfig
 * 
 * c.使用Spring的JSP库
 * Spring提供两个标签库，一个是表单标签库，一个是通用工具类标签库
 * 
 * 表单标签库：
 * <sf:checkbox>渲染成一个HTML<input>标签，其中type属性设置为checkbox
 * <sf:checkboxes>渲染成多个HTML<input>标签，其中type属性设置为checkbox
 * <sf:errors>在一个HTML，<span>中渲染输入域的错误
 * <sf:form>渲染成一个HTML<form>标签，并为其内部标签暴露绑定路径，用于数据绑定
 * <sf:hidden>渲染成一个HTML<input>标签，其中type属性设置为hidden
 * <sf:input>渲染成一个HTML<input>标签，其中type属性设置为text
 * <sf:label>渲染成一个HTML<label>标签
 * <sf:option>渲染成一个HTML<option>标签，其selected属性根据所绑定的值进行设置
 * <sf:options>按照绑定的集合、数组或Map，渲染成一个HTML<option>标签的列表
 * <sf:password>渲染成一个HTML<input>标签，其中type属性设置为password
 * <sf:radiobutton>渲染成一个HTML<input>标签，其中type属性设置为radio
 * <sf:radiobuttons>渲染成多个HTML<input>标签，其中type属性设置为radio
 * <sf:select>渲染为一个HTML，<select>标签
 * <sf:textarea>渲染为一个HTML<textarea>标签
 * 其中：
 * <input>标签的value属性值将会设置为模型对象中path属性所对应的值。
 * 使用cssClass代替原生的class属性
 * 
 * 通用标签库：
 * <s:bind>将绑定属性的状态导出到一个名为status的页面作用域属性中，与<s:path>组合使用获取绑定属性的值
 * <s:escapeBody>将标签体中的内容进行HTML和/或JavaScript转义
 * <s:hasBindErrors>根据指定模型对象（在请求属性中）是否有绑定错误，有条件地渲染内容
 * <s:htmlEscape>为当前页面设置默认的HTML转义值
 * <s:message>根据给定的编码获取信息，然后要么进行渲染（默认行为），要么将其设置为页面作用域、请求作用域、会话作用域或应用作用域的变量（通过使用var和scope属性实现）
 * <s:nestedPath>设置嵌入式的path，用于<s:bind>之中
 * <s:theme>根据给定的编码获取主题信息，然后要么进行渲染（默认行为），要么将其设置为页面作用域、请求作用域、会话作用域或应用作用域的变量（通过使用var和scope属性实现）
 * <s:transform>使用命令对象的属性编辑器转换命令对象中不包含的属性
 * <s:url>创建相对于上下文的URL，支持URI模板变量以及HTML/XML/JavaScript转义。可以渲染URL（默认行为），也可以将其设置为页面作用域、请求作用域、会话作用域或应用作用域的变量（通过使用var和scope属性实现）
 * <s:eval>计算符合Spring表达式语言（SpringExpressionLanguage，SpEL）语法的某个表达式的值，然后要么进行渲染（默认行为），要么将其设置为页面作用域、请求作用域、会话作用域或应用作用域的变量（通过使用var和scope属性实现）
 * 
 * 12.自定义DispatcherServlet
 * 重写AbstractAnnotationConfigDispatcherServletInitializer的customizeRegistration()方法：
 * 运行机理：在AbstractAnnotation-ConfigDispatcherServletInitializer将DispatcherServlet注册到Servlet容器中之后，就会调用customizeRegistration()，并Servlet注册后得到的Registration.Dynamic传递进来。* 通过重载customizeRegistration()方法，我们可以对DispatcherServlet进行额外的配置。
 * 具体例子：见SpringMVCWebAppInitializer
 * 其他配置：
 * 	调用setLoadOnStartup()设置优先级
 * 	通过setInitParameter()设置初始化参数，
 * 	通过调用setMultipartConfig()配置Servlet3.0对multipart的支持。
 * 
 * 13.自定义servlet
 * a.新建servlet
 * b.新建类实现WebApplicationInitializer，并重写onStartup，具体见MyServletInitializer
 * 注：其实也可以使用注解，具体见有道云笔记
 * 
 * 14.自定义filter
 * 具体见MyServletInitializer
 * 
 * 15.Sping使用配置文件进行配置
 * 见springMvc项目
 * 
 * 16.处理multipart请求
 * a.配置MultipartResolver的Bean，具体见WebConfig
 * b.进行基础配置：
 * 使用了自定义servlet加载DispatcherServlet方式：具体见MyServletInitializer
 * 继承了AbstractAnnotationConfigDispatcherServletInitializer方式：具体见SpringMVCWebAppInitializer
 * c.配置Controller：主要配置参数MultipartFile，具体见MultipartController
 * 
 * 17.处理异常
 * a.将异常映射为http响应码：定义异常并添加对应注解，具体见MyNotFoundRuntimeException
 * b.处理当前Controller下的异常,具体见TestExceptionController
 * c.处理所有Controller抛出的异常，具体见MyExceptionHandler
 * 
 * 注意:
 * 1.jar包要放在WEB-INF/lib下，否则无法加载配置，报404错误
 * @author Jay
 * @date 2018年4月9日
 */

public class TestSpringMVC {

}
