package utils;
/***
 * @author 15185丁硕
 * Json数据工具包
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.alibaba.fastjson.JSON;




public class JsonUtils {
	private JsonUtils() {
		
	}
	static public String FileTOString(String path) {//地址
		String str=null;
		try {
			str = FileUtils.readFileToString(new File(path),"utf-8");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	static public <T>List<T> StringToList(String str,Class<T> clazz){//字符和类型
		return JSON.parseArray(str,clazz);
	}
	static public <T>List<T> PathTolist(String path,Class<T> clazz){//地址和类型
		String str=FileTOString(path);
		return JSON.parseArray(str,clazz);
	}
	static public void StringToFile(String path,String str) {//地址和字符
		try {
			FileUtils.writeStringToFile(new File(path), str,"utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public String ListToJsonStr(List list) {
		return JSON.toJSONString(list);
	}
	static public void ListToFile(String path,List list) {
		String str=ListToJsonStr(list);
		StringToFile(path, str);
	}

}
