package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class SmsTest {
	/**
	 * @param args
	 * @throws IOException
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		String str=MD5("987654321");
		
		//发送内容
		String content = "企信通JAVA示例测试"; 
		
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://api.wxduanxin.com/?");

		// 向StringBuffer追加用户名
		sb.append("ac=send&uid=70307201");

		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=" + str);

		// 向StringBuffer追加手机号码
		sb.append("&mobile=18663991760");

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content="+URLEncoder.encode(content));

		// 创建url对象
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		// 返回发送结果
		String inputline = in.readLine();

		// 返回结果为‘100’ 发送成功
		System.out.println(inputline);

	}
	
	private static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
