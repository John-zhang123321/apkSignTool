package cn.jungu009.view;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import cn.jungu009.command.CreateKeyCommand;

/**
 * 创建密钥的图形界面
 * 
 * 获取必要的参数
 * 
 * @author jungu009
 *
 */
public class CreateKey extends Frame{
	
	public CreateKey(){
		super("自动签名工具");
	
		inintView();
		addWidget();
		addListener();
		
	}
	
	
	/**
	 * init tools
	 */
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Dimension dim = tk.getScreenSize();
	
	/**
	 * frame size
	 */
	private int frameWidth = 800;
	private int frameHeight = 500;
	private int frameX = (dim.width - frameWidth) / 2;
	private int frameY = (dim.height - frameHeight) / 2;
	
	
	
	private Widget widget = new Widget(frameWidth, frameHeight);
	
	
	/**
	 * all widgets references
	 *  
	 *  
	 *  CN=w,OU=w,O=localhost,L=w,ST=w,C=CN
	 */
	
	TextField tf_Alias, tf_KeyStore, tf_Keyalg, tf_Validity, tf_Keypass, tf_Storepass;
	TextField tf_CN, tf_OU, tf_O, tf_L, tf_ST, tf_C;
	TextField [] tf_Array = {tf_Alias, tf_KeyStore, tf_Keyalg, tf_Validity, tf_Keypass, tf_Storepass, null};
	TextField [] tf_Array1= {tf_CN, tf_OU, tf_O, tf_L, tf_ST, tf_C};
 	String [] tf_name = {"test", "G:\\java\\eclipse\\signertool\\test.keystore", "RSA", "1000", "123456", "123456"};
 	String [] tf_name1 = {"w", "w", "localhost", "w", "w", "CN"};
	
	Label lb_Alias, lb_KeyStore, lb_Keyalg, lb_Validity, lb_Keypass, lb_Storepass;
	Label lb_CN, lb_OU, lb_O, lb_L, lb_ST, lb_C;
	Label [] lb_Array = {lb_Alias, lb_KeyStore, lb_Keyalg, lb_Validity, lb_Keypass, lb_Storepass};
	Label [] lb_Array1= {lb_CN, lb_OU, lb_O, lb_L, lb_ST, lb_C};
	String [] lb_name = {"密钥别名    ：", "密钥库名字：", "加密算法    ：", "有效天数    ：", "密钥口令    ：", "密钥库口令："};
	String [] lb_name1= {"CN  ：", "OU  ：", "O     ：", "L     ：", "ST  ：", "C     ："};
	
	Button b_CreateKey, b_DeleteKey;
	
	
	/**
	 * 初始化组件
	 */
	private void inintView(){
		initFrame();
		initLabel();
		initTextField();
		initButton();
	}
	
	
	/**
	 * 初始化本窗口
	 */
	private void initFrame(){
		
		this.setBounds( frameX, frameY, frameWidth, frameHeight);
		
		this.setLayout(null);
		
		this.setVisible(true);	
		
	}
	
	private void initLabel(){
		for(int i = 0; i < lb_Array.length; i++){
			lb_Array[i] = new Label(lb_name[i]);
			widget.setLabelSize(lb_Array[i]);
			widget.setLabelSite(lb_Array[i], i);
		}
		for(int i = 0; i < lb_Array1.length; i++){
			lb_Array1[i] = new Label(lb_name1[i]);
			widget.setLabelSize(lb_Array1[i]);
			widget.setLabelSite1(lb_Array1[i], i);
		}
	}
	
	private void initTextField(){
		for(int i = 0; i < tf_Array.length - 1; i++){
			tf_Array[i] = new TextField(tf_name[i]);
			widget.setTextFieldSize(tf_Array[i]);
			widget.setTextFieldSite(tf_Array[i], i);
		}
		for(int i = 0; i < tf_Array1.length; i++){
			tf_Array1[i] = new TextField(tf_name1[i]);
			widget.setTextFieldSize(tf_Array1[i]);
			widget.setTextFieldSite1(tf_Array1[i], i);
		}
	}
	
	private void initButton(){
		b_CreateKey = new Button("创建密钥");
		b_DeleteKey = new Button("删除密钥");
		
		widget.setButtonSize(b_CreateKey);
		widget.setButtonSize(b_DeleteKey);
		
		widget.setLeftButtonSite(b_CreateKey);
		widget.setRightButtonSite(b_DeleteKey);
		
	}
	
	/**
	 * 将组件添加到frame中
	 */
	private void addWidget(){
		
		for(int i = 0; i < lb_Array.length; i++){
			this.add(lb_Array[i]);
		}
		
		for(int i = 0; i < lb_Array1.length; i++){
			this.add(lb_Array1[i]);
		}
		
		for(int i = 0; i < tf_Array.length - 1; i++){
			this.add(tf_Array[i]);
		}
		
		for(int i = 0; i < tf_Array1.length; i++){
			this.add(tf_Array1[i]);
		}
		
		
		
		this.add(b_CreateKey);
		this.add(b_DeleteKey);
		
	}
	
	/**
	 * 添加监听
	 */
	private void addListener(){
		MyListener ml = new MyListener();
		
		this.addWindowListener(ml);
		
		b_CreateKey.addActionListener(ml);
		b_DeleteKey.addActionListener(ml);
		
	}
	
	
	private String[] getAllArgument(){
		String [] str = new String[(tf_Array.length + tf_Array1.length)];
		
		for(int i = 0; i < tf_Array.length; i++){   // tf_Array1.length
			if(i < tf_Array.length - 1){
				str[i] = tf_Array[i].getText();
			}else{
				str[6] = "\"CN=w OU=w O=localhost L=w ST=w C=CN\"";  // error
			}
		}
		
		return str;
	}
	
	
	/**
	 * 对CreateKey窗口的监听
	 * @author jungu009
	 *
	 */
	private class MyListener extends WindowAdapter implements ActionListener{

		@Override
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(b_CreateKey)){		
				new CreateKeyCommand().exeCommand(getAllArgument());
				
				System.out.println("创建成功");
			}
			
			if(e.getSource().equals(b_DeleteKey)){
				new CreateKeyCommand().exeCommand();;
			}
			
		}
		
	} // MyListener
	
	
	
	
} // CreateKey
