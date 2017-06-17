package test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class Test {
	public static void main(String[] args) throws IOException {
		String tmp = "68010000003039006A16";
		System.out.println(tmp.substring(6, 14));
		System.out.println(hexStringToBytes("00003039"));
		System.out.println(Integer.parseInt(tmp.substring(6, 14),16));
		byte[] tmp2 = tmp.getBytes();
		int a = Byte.toUnsignedInt((tmp2[3])) << 24 | Byte.toUnsignedInt((tmp2[4])) << 16
				| Byte.toUnsignedInt((tmp2[5])) << 8 | Byte.toUnsignedInt((tmp2[6]));
		System.out.println(bytesToHexString(tmp.getBytes()));
		//System.out.println(Byte.decode("0x" + tmp));
		Integer flag = 1;
		byte[] send = new byte[9];
		send[0] = (byte)0x68;
		
		if(flag == 1){
			//上传
			send[1] = (byte)0x01;
		}
		else{
			//召测
			send[1] = (byte)0x00;
		}
		
		send[2] = (byte)0x00;
		send[3] = (byte)0xEE;
		send[4] = (byte)0xEE;
		send[5] = (byte)0xEE;
		send[6] = (byte)0xEE;
		send[7] = (byte)0x00;
		send[8] = (byte)0xB9;
		send[9] = (byte)0x16;
		
		
		byte[] tmp3 = new byte[9];
		tmp3[0] = (byte)0x68;
		tmp3[1] = (byte)0x00;
		tmp3[2] = (byte)0x00;
		tmp3[3] = (byte)0xEE;
		tmp3[4] = (byte)0xEE;
		tmp3[5] = (byte)0xEE;
		tmp3[6] = (byte)0xEE;
		tmp3[7] = (byte)0x00;
		tmp3[8] = (byte)0xB9;
		tmp3[9] = (byte)0x16;
		System.out.println(tmp3.toString());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();    
        DataOutputStream dos = new DataOutputStream(baos);    
        dos.writeByte(0x68); 
        dos.writeByte(0x00);
        dos.writeByte(0x00);
        dos.writeByte(0xEE);
        dos.writeByte(0xEE);
        dos.writeByte(0xEE);
        dos.writeByte(0xEE);
        dos.writeByte(0x00);
        dos.writeByte(0xB9);
        dos.writeByte(0x16);
        dos.writeByte(1);    
        dos.writeByte(1); 
        byte[] aa = baos.toByteArray();  
		
//		String localPath = "E:/almDayReport/香港大昌行报警日志2016年11月21日.xlsx";
//		String tmp = localPath.substring(localPath.lastIndexOf("/") + 1);
//		System.out.println(tmp);
		/*Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startTime = calendar.getTime();
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endTime = calendar.getTime();
		System.out.println("startTime:" + startTime.toLocaleString());
		System.out.println("endTime:" + endTime.toLocaleString());*/
	}
	private static String hexString="0123456789ABCDEF";
	
	public static String encode(String str)
	{
	// 根据默认编码获取字节数组
	byte[] bytes=str.getBytes();
	StringBuilder sb=new StringBuilder(bytes.length*2);
	// 将字节数组中每个字节拆解成2位16进制整数
	for(int i=0;i<bytes.length;i++)
	{
	sb.append(hexString.charAt((bytes[i]&0xf0)>>4));
	sb.append(hexString.charAt((bytes[i]&0x0f)>>0));
	}
	return sb.toString();
	}
	
	public static String decode(String bytes)
	{
	ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2);
	// 将每2位16进制整数组装成一个字节
	for(int i=0;i<bytes.length();i+=2)
	baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1))));
	return new String(baos.toByteArray());
	}
	
	public static String bytesToHexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }   
	    return stringBuilder.toString();   
	}
	
	public static byte[] hexStringToBytes(String hexString) {   
	    if (hexString == null || hexString.equals("")) {   
	        return null;   
	    }   
	    hexString = hexString.toUpperCase();   
	    int length = hexString.length() / 2;   
	    char[] hexChars = hexString.toCharArray();   
	    byte[] d = new byte[length];   
	    for (int i = 0; i < length; i++) {   
	        int pos = i * 2;   
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));   
	    }   
	    return d;   
	}   
	
	/**  
	 * Convert char to byte  
	 * @param c char  
	 * @return byte  
	 */  
	 private static byte charToByte(char c) {   
	    return (byte) "0123456789ABCDEF".indexOf(c);   
	}  
}
