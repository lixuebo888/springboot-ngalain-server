package bigxuexue.club.ngalain.sys.util;

import java.util.UUID;

/**
 * 工具类
 * 
 * @author lixuebo
 *
 */
public class IDGenerator {
	/**
	 * 得到32位随机值，用于关联各个表
	 * 
	 * @author xhma 2015-3-24 下午3:49:21
	 * @return
	 */
	public static String generate() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
