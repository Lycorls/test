package test.callback;

public class B {
	
	/**
	 * Java接口回调机制详解
	 * @author hefan
	 * @date 创建时间：2017年1月23日 下午2:07:37
	 * @param onClickListener
	 */
	public static void main(String[] args) {
		A a = new A();
		a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
