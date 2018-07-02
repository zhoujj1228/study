package chapter5.springMVC;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ���壺
 * SpingMVC�������̣�
 * 1.�̳�AbstractAnnotationConfigDispatcherServletInitializer,��д��������
 * 2.����WebConfig�࣬���Configuration��EnableWebMvc��ComponentScanע�⣬�����ͼBean���ã���дconfigureDefaultServletHandling�������о�̬��Դ����
 * 3.����RootConfig�࣬���Configuration��ComponentScanע��
 * 3.��дController�����Controllerע�⣬�ڶ�Ӧ�ط����������������ࣩ�����RequestMappingע�����·��ӳ������
 * 
 * 
 * 
 * 
 * 1.springMVC��������:
 * a.�ͻ���������ǰ�˿�����DispatcherServlet
 * b.DispatcherServlet���ѯһ������������ӳ�䣨handler mapping����ȷ���������ĸ�controller
 * c.������controller��ж���为�أ��û��ύ����Ϣ�������ĵȴ�������������Щ��Ϣ��������������д���������������,�����õ�����
 * ��Ϣ��ģ�ͣ�,��������ģ�ͺͶ�Ӧ��ͼ�����ظ�DispatcherServlet
 * d.DispatcherServlet������ͼ����ѯ���������������ͼ��ʹ����ͼ��������
 * e.��ͼʵ�֣���ģ�����ݽ�����ͼ��Ⱦ
 * f.�����ս�����ؿͻ���
 * 
 * 
 * 2.spring�������ػ���
 * ��Servlet3.0�����У�����������·���в���ʵ��javax.servlet.ServletContainerInitializer�ӿڵ��࣬
 * ����ܷ��ֵĻ����ͻ�����������Servlet������Spring�ṩ������ӿڵ�ʵ�֣���ΪSpringServletContainerInitializer��
 * ����෴�����ֻ����ʵ��WebApplicationInitializer���ಢ�����õ����񽻸���������ɡ�
 * Spring3.2������һ��������WebApplicationInitializer����ʵ�֣�
 * Ҳ����AbstractAnnotationConfigDispatcherServletInitializer��
 * ��Ϊ���ǵ�Spittr-WebAppInitializer��չ��AbstractAnnotationConfigDispatcherServlet-Initializer��ͬʱҲ��ʵ����WebApplicationInitializer����
 * ��˵�����Servlet3.0�����е�ʱ���������Զ���������������������Servlet�����ġ�
 * 
 * 3.AbstractAnnotationConfigDispatcherServletInitializer������Ӧ�������ģ�
 * DispatcherServlet���ذ���Web�����bean�������������ͼ�������Լ�������ӳ��
 * ContextLoaderListenerҪ����Ӧ���е�����bean����Щbeanͨ��������Ӧ�ú�˵��м������ݲ������
 * 
 * 4.����Ӧ�������ļ��ع��̣�
 * AbstractAnnotationConfigDispatcherServletInitializer��ͬʱ����DispatcherServlet��ContextLoaderListener��
 * GetServlet-ConfigClasses()�������صĴ���@Configurationע����ཫ����������DispatcherServletӦ���������е�bean��
 * getRootConfigClasses()�������صĴ���@Configurationע����ཫ����������ContextLoaderListener������Ӧ���������е�bean��
 * 
 * 5.���������༶���������
 * �ڷ�����������@RequestMappingע��������Σ���HomeController��,�����controller������Щ����
 * @RequestMapping({"/", "/homepage"})
 * 
 * 6.ģ�����ݷ���
 * ���ַ��ط�ʽ��ModelController.getTestList()
 * 
 * 7.�����ѯ����
 * ��ParamController.getTestListByNum()
 * 
 * 8.ͨ��·��������������
 * ��ParamController.getSomeOneById()
 * ���·��ռλ���뷽��������һ�¿���ȥ��@PathVariable�е�value����
 * 
 * 9.ͨ�����ύ����
 * ��FormController.register() �� FormController.register(TestDomain td)
 * a.ע��get��post��ʽ
 * b.������ڲ�ʹ��action�������ύ�ǰ���չ��ʱ��ͬ·�������ύ 
 * c.����Ҫ��Ϊһ�������������룬��TestDomain,������Ҫһ���޲�����Ĭ�Ϲ��췽��
 * d.ʹ���ض���return "redirect:/getSomeOne/" + td.getId();
 * e.ʹ������ǰ����return "forward:/getSomeOne/" + td.getId();
 * 
 * 10.����У��
 * ��Ҫ���⵼��JSR303�淶��API����hibernate validator
 * a.����Ҫʹ��@Valid����
 * b.��������Ҫ��Ӷ�ӦУ��ע������
 * ����У��ע�⣺
 * @AssertFalse ��ע���Ԫ�ر�����Boolean���ͣ�����ֵΪfalse
 * @AssertTrue ��ע���Ԫ�ر�����Boolean���ͣ�����ֵΪtrue
 * @DecimalMax ��ע���Ԫ�ر��������֣���������ֵҪС�ڻ���ڸ�����BigDecimalStringֵ
 * @DecimalMin ��ע���Ԫ�ر��������֣���������ֵҪ���ڻ���ڸ�����BigDecimalStringֵ
 * @Digits ��ע���Ԫ�ر��������֣���������ֵ������ָ����λ��
 * @Future ��ע���Ԫ�ص�ֵ������һ������������
 * @Max ��ע���Ԫ�ر��������֣���������ֵҪС�ڻ���ڸ�����ֵ
 * @Min ��ע���Ԫ�ر��������֣���������ֵҪ���ڻ���ڸ�����ֵ
 * @NotNull ��ע��Ԫ�ص�ֵ���벻��Ϊnull
 * @Null ��ע��Ԫ�ص�ֵ����Ϊnull
 * @Past ��ע���Ԫ�ص�ֵ������һ���ѹ�ȥ������
 * @Pattern ��ע���Ԫ�ص�ֵ����ƥ�������������ʽ
 * @Size ��ע���Ԫ�ص�ֵ������String�����ϻ����飬�������ĳ���Ҫ���ϸ����ķ�Χ
 * 
 * 
 * 11.��ͼ
 * a.springMVC�ڲ���ͼʵ�֣�
 * ViewResolver�ӿ��������resolveViewName(String viewName,Locale locale)����, ������ͼ����locale���󣬷���Viewʵ��
 * View�ӿ��������render(Map<String, V>, HttpServletRequest req, HttpServletResponse rsp)��������Ҫ����ģ��servlet��req��rsp���󲢽������Ⱦ��rsp��
 * 
 * b.����JSP��ͼ������
 * InternalResourceViewResolver�ǳ��õ�JSP��ͼ���������������ü�WebConfig
 * 
 * c.ʹ��Spring��JSP��
 * Spring�ṩ������ǩ�⣬һ���Ǳ���ǩ�⣬һ����ͨ�ù������ǩ��
 * 
 * ����ǩ�⣺
 * <sf:checkbox>��Ⱦ��һ��HTML<input>��ǩ������type��������Ϊcheckbox
 * <sf:checkboxes>��Ⱦ�ɶ��HTML<input>��ǩ������type��������Ϊcheckbox
 * <sf:errors>��һ��HTML��<span>����Ⱦ������Ĵ���
 * <sf:form>��Ⱦ��һ��HTML<form>��ǩ����Ϊ���ڲ���ǩ��¶��·�����������ݰ�
 * <sf:hidden>��Ⱦ��һ��HTML<input>��ǩ������type��������Ϊhidden
 * <sf:input>��Ⱦ��һ��HTML<input>��ǩ������type��������Ϊtext
 * <sf:label>��Ⱦ��һ��HTML<label>��ǩ
 * <sf:option>��Ⱦ��һ��HTML<option>��ǩ����selected���Ը������󶨵�ֵ��������
 * <sf:options>���հ󶨵ļ��ϡ������Map����Ⱦ��һ��HTML<option>��ǩ���б�
 * <sf:password>��Ⱦ��һ��HTML<input>��ǩ������type��������Ϊpassword
 * <sf:radiobutton>��Ⱦ��һ��HTML<input>��ǩ������type��������Ϊradio
 * <sf:radiobuttons>��Ⱦ�ɶ��HTML<input>��ǩ������type��������Ϊradio
 * <sf:select>��ȾΪһ��HTML��<select>��ǩ
 * <sf:textarea>��ȾΪһ��HTML<textarea>��ǩ
 * ���У�
 * <input>��ǩ��value����ֵ��������Ϊģ�Ͷ�����path��������Ӧ��ֵ��
 * ʹ��cssClass����ԭ����class����
 * 
 * ͨ�ñ�ǩ�⣺
 * <s:bind>�������Ե�״̬������һ����Ϊstatus��ҳ�������������У���<s:path>���ʹ�û�ȡ�����Ե�ֵ
 * <s:escapeBody>����ǩ���е����ݽ���HTML��/��JavaScriptת��
 * <s:hasBindErrors>����ָ��ģ�Ͷ��������������У��Ƿ��а󶨴�������������Ⱦ����
 * <s:htmlEscape>Ϊ��ǰҳ������Ĭ�ϵ�HTMLת��ֵ
 * <s:message>���ݸ����ı����ȡ��Ϣ��Ȼ��Ҫô������Ⱦ��Ĭ����Ϊ����Ҫô��������Ϊҳ�����������������򡢻Ự�������Ӧ��������ı�����ͨ��ʹ��var��scope����ʵ�֣�
 * <s:nestedPath>����Ƕ��ʽ��path������<s:bind>֮��
 * <s:theme>���ݸ����ı����ȡ������Ϣ��Ȼ��Ҫô������Ⱦ��Ĭ����Ϊ����Ҫô��������Ϊҳ�����������������򡢻Ự�������Ӧ��������ı�����ͨ��ʹ��var��scope����ʵ�֣�
 * <s:transform>ʹ�������������Ա༭��ת����������в�����������
 * <s:url>��������������ĵ�URL��֧��URIģ������Լ�HTML/XML/JavaScriptת�塣������ȾURL��Ĭ����Ϊ����Ҳ���Խ�������Ϊҳ�����������������򡢻Ự�������Ӧ��������ı�����ͨ��ʹ��var��scope����ʵ�֣�
 * <s:eval>�������Spring���ʽ���ԣ�SpringExpressionLanguage��SpEL���﷨��ĳ�����ʽ��ֵ��Ȼ��Ҫô������Ⱦ��Ĭ����Ϊ����Ҫô��������Ϊҳ�����������������򡢻Ự�������Ӧ��������ı�����ͨ��ʹ��var��scope����ʵ�֣�
 * 
 * 12.�Զ���DispatcherServlet
 * ��дAbstractAnnotationConfigDispatcherServletInitializer��customizeRegistration()������
 * ���л�����AbstractAnnotation-ConfigDispatcherServletInitializer��DispatcherServletע�ᵽServlet������֮�󣬾ͻ����customizeRegistration()����Servletע���õ���Registration.Dynamic���ݽ�����* ͨ������customizeRegistration()���������ǿ��Զ�DispatcherServlet���ж�������á�
 * �������ӣ���SpringMVCWebAppInitializer
 * �������ã�
 * 	����setLoadOnStartup()�������ȼ�
 * 	ͨ��setInitParameter()���ó�ʼ��������
 * 	ͨ������setMultipartConfig()����Servlet3.0��multipart��֧�֡�
 * 
 * 13.�Զ���servlet
 * a.�½�servlet
 * b.�½���ʵ��WebApplicationInitializer������дonStartup�������MyServletInitializer
 * ע����ʵҲ����ʹ��ע�⣬������е��Ʊʼ�
 * 
 * 14.�Զ���filter
 * �����MyServletInitializer
 * 
 * 15.Spingʹ�������ļ���������
 * ��springMvc��Ŀ
 * 
 * 16.����multipart����
 * a.����MultipartResolver��Bean�������WebConfig
 * b.���л������ã�
 * ʹ�����Զ���servlet����DispatcherServlet��ʽ�������MyServletInitializer
 * �̳���AbstractAnnotationConfigDispatcherServletInitializer��ʽ�������SpringMVCWebAppInitializer
 * c.����Controller����Ҫ���ò���MultipartFile�������MultipartController
 * 
 * 17.�����쳣
 * a.���쳣ӳ��Ϊhttp��Ӧ�룺�����쳣����Ӷ�Ӧע�⣬�����MyNotFoundRuntimeException
 * b.����ǰController�µ��쳣,�����TestExceptionController
 * c.��������Controller�׳����쳣�������MyExceptionHandler
 * 
 * ע��:
 * 1.jar��Ҫ����WEB-INF/lib�£������޷��������ã���404����
 * @author Jay
 * @date 2018��4��9��
 */

public class TestSpringMVC {

}
