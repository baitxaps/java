package cn.huse.fastjson;
import java.util.*;

import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class JsonTest {
	@Test
	public void test() {
		//entityToJson();
		listToJson();
	}
	
	public void listToJson() {
		
		FastJsonModel m1 = new FastJsonModel();
		m1.setId(1);
		m1.setCount(100);
		m1.setName("william");
		m1.setPrice(1000);
		m1.setPdate(new Date());
		
		FastJsonModel m2 = new FastJsonModel();
		m2.setId(2);
		m2.setCount(200);
		m2.setName("java");
		m2.setPrice(2000);
		m2.setPdate(new Date());
		
		List<FastJsonModel> list = new ArrayList<FastJsonModel>();
		list.add(m1);
		list.add(m2);
		
		//"$ref":"$[1]"},{"$ref":"$[1]"  Circular Reference
		list.add(m2);
		list.add(m2);
		
		//String json = JSONObject.toJSONString(list);
		String json = JSONObject.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);

		System.out.println(json);
	}
	
	public void entityToJson() {
		FastJsonModel fm = new FastJsonModel();
		fm.setId(1);
		fm.setCount(100);
		fm.setName("william");
		fm.setPrice(2000);
		
//		SerializeFilter filter = new SerializeFilter();
//		public boolean apply()
		
		String json = JSONObject.toJSONString(fm);
		System.out.println(json);
		
		
		// 指定一个Filter
//		 SerializeFilter filter = new PropertyFilter() {
//		 public boolean apply(java.lang.Object arg0, java.lang.String arg1,
//		 java.lang.Object arg2) {
//		 if ("编号".equals(arg1)) {
//			 return false;
//		 }
//		 	return true;
//		 }
//		 };
		
		SerializeFilter filter = new SimplePropertyPreFilter("count", "name", "price", "pDate"); 
		// 将需要的属性指定
		json = JSONObject.toJSONString(fm, filter);
		System.out.println(json);
		
		
	}
}










