package test;

import java.util.List;

public class SendPortUtils {
	
	//发送起始标志位
	private byte START_FLAG;
	
	//发送起始标志位
	private byte END_FLAG;
	
	private byte[] baseArray = null;
	
	public SendPortUtils() {
		super();
	}

	public SendPortUtils(byte startFlag,byte endFlag) {
		START_FLAG = startFlag;
		END_FLAG = endFlag;
	}
	
	public Byte[] buildSendDataPackage(List<Integer> sendData){
		baseArray = new byte[sendData.size()];
		baseArray[0] = START_FLAG;
		baseArray[sendData.size() - 1] = END_FLAG;
		return null;
	}
	
}

