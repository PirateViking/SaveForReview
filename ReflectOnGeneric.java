package test.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demo02 {
	
	public static void test01(Map<String,Integer> map,List<String> list){
		System.out.println("Demo02.test01");
	}
	
	public static Map<String,Integer> test02(){
		
		return null;
	}
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		try {
			
			Method m=Demo02.class.getDeclaredMethod("test01", Map.class,List.class);
			Type[] t=m.getGenericParameterTypes();
			for(Type paramType:t){
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType){
					Type[] genericTypes=((ParameterizedType)paramType).getActualTypeArguments();
					for(Type genericType:genericTypes){
						System.out.println("泛型类型："+genericType);
					}
				}
			}
			
			Method m2=Demo02.class.getDeclaredMethod("test02", null);
			Type t2=m2.getGenericReturnType(); //因为返回值肯定只有一个
			System.out.println("#"+t2);
			if(t2 instanceof ParameterizedType){
				Type[] genericTypes=((ParameterizedType)t2).getActualTypeArguments();
				for(Type genericType:genericTypes){
					System.out.println("返回类型："+genericType);
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
