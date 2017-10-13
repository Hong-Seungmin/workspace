package classdiagram;

import java.io.IOException;

public abstract class SuperFoo {
	private static int classOrStaticAttribute;
	public String publicAttribute;
	private String privateAttribute;
	String assumedPrivateAttribute;
	boolean isInitializedAttribue = true;
	VeggieBurger[] aCollection;
	String[] attributeMayLegallyBeNull;
	final int finalConstantAttribute=5;
	//derivedAttribute;
	
	public static void classOrStaticMethod() {
	}
	public void publicMethod() {
	}
	void assumedPublicMethod(){		
	}
	private void privateMethod(){		
	}
	protected void protectedMethod(){	
	}
	/*package*/ void packageVisibleMethod(){		
	}
	SuperFoo(){		
	}
	void methodWithParams(String param1, float param2){		
	}
	VeggieBurger methodReturnsSomething(){
		return null;
	}
	void methodThrowsException() throws IOException {
	}
	abstract void abstractMethod2();
	final void finalMethod(){
	}
	synchronized void sysnchronizedMethod(){		
	}
}
