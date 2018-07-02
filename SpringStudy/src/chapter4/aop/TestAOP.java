package chapter4.aop;

/**
 * 主要说明AOP的使用
 * 主要作用:对原有代码不修改进行代码切入,实现通用功能切入主要代码，但同时不影响原有代码的流程关注点
 * 应用场景:主要非业务逻辑模块，在业务执行过程不用关心这些模块的执行，如日志模块，事务管理模块
 * 
 * 主要概念：
 * 通知：切面需要完成的工作称为通知。定义何时、做什么
 * 连接点：应用程序中能插入切面的一个点，可以是调用方法时，抛出异常时
 * 切点：配置通知切入程序连接点的地方，定义何处
 * 切面：通知和切点的整合，共同定义何时、何处、做什么
 * 引入：引入允许我们向现有的类添加新方法或属性。
 * 织入：织入是把切面应用到目标对象并创建新的代理对象的过程。
 * 
 * 主要分类:
 * 基于代理的经典SpringAOP；
 * 纯POJO切面；
 * @AspectJ 注解驱动的切面；
 * 注入式AspectJ切面（适用于Spring各版本）
 * 
 * 前三种都是SpringAOP实现的变体，SpringAOP构建在动态代理基础之上，因此，Spring对AOP的支持局限于方法拦截。
 * 
 * spring里面使用AspectJ的切点表达式语言来定义切点，spring支持的表达式如下：
 * execution()：用于匹配是连接点的执行方法
 * arg()：限制连接点匹配参数为指定类型的执行方法
 * @args()：限制连接点匹配参数由指定注解标注的执行方法
 * this()：限制连接点匹配AOP代理的bean引用为指定类型的类
 * target：限制连接点匹配目标对象为指定类型的类
 * @target()：限制连接点匹配特定的执行对象，这些对象对应的类要具有指定类型的注解
 * within()：限制连接点匹配指定的类型
 * @within()：限制连接点匹配指定注解所标注的类型（当使用SpringAOP时，方法定义在由指定的注解所标注的类里）
 * @annotation：限定匹配带有指定注解的连接点
 * 特殊引入：bean()：使用beanID或bean名称作为参数来限制切点只匹配特定的bean。
 * 
 * 注意：
 * 只有execution指示器是实际执行匹配的，而其他的指示器都是用来限制匹配的。
 * 这说明execution指示器是我们在编写切点定义时最主要使用的指示器。在此基础上，我们使用其他指示器来限制所匹配的切点。
 * 
 * 例子1：execution(* chapter2.autoPack.IMediaPlayer.play(..))
 * 该切点应用于所有实现IMediaPlayer的play方法
 * 里面*代表不关心返回值的类型
 * 参数..表示切点选择任意的play方法，无论方法的入参是什么
 * 
 * 例子2：execution(* chapter2.autoPack.IMediaPlayer.play(..)) && within(chapter2.autoPack.*)
 * 里面&&等同于and(其中：or用||, not用!)
 * within(chapter2.autoPack.*)表示只匹配chapter2.autoPack包下的类
 * 
 * 例子3：execution(* chapter2.autoPack.IMediaPlayer.play(..)) && !bean('MP3Player')
 * 在此场景下，切面的通知会被编织到所有ID不为MP3Player的bean中。
 * 
 * 例子4：execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.outputSongName(String, int)) && args(name, id)
 * 在此场景下，通知方法的参数名为name和id,不一定与被切入方法同一个参数名。(其中name, id是通知方法的参数名)
 * 
 * 切面方法：
 * 使用JoinPoint作为切面方法参数进行传入，具体见MediaPlayerHelper
 * 1.获取切入对象：JoinPoint.getTarget()
 * 2.获取切入方法名：JoinPoint.getSignature().getName()
 * 3.获取切入方法参数：JoinPoint.getArgs()
 * 
 * @author Jay
 * @date 2018年3月29日
 */

public class TestAOP {

}
