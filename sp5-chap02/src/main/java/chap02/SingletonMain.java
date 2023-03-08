package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter greeter1 = ctx.getBean("greeter",Greeter.class);
		Greeter greeter2 = ctx.getBean("greeter",Greeter.class);
		System.out.println(greeter1 == greeter2);
		
		Greeter greeter3 = ctx.getBean("greeter",Greeter.class);
		Greeter greeter4 = ctx.getBean("greeter1",Greeter.class); //∫Û∞¥√º¿« ¿Ã∏ß¿ª ¥ﬁ∏Æ«‘
		System.out.println(greeter3 == greeter4);
		ctx.close();
	}
}
