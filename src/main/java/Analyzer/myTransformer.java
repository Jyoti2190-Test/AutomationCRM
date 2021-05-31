package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class myTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation iannotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		iannotation.setRetryAnalyzer(retyAnalyzer.class);
		
	}

}
 