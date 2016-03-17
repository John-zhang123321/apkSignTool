package cn.jungu009.view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

/**
 * 设置组件的大小和位置
 * @author jungu009
 *
 */
public class Widget {
	private int frameWidth;
	private int frameHeight;
	
	public Widget(int frameWidth, int frameHeight){
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}
	
	
	public void setLabelSize(Label lb){
		lb.setSize(70, 20);
	}
	
	public void setLabelSite(Label lb, int i){
		lb.setLocation(frameWidth / 8, 100 + i * 40);
	}
	
	/**
	 * dname 参数设置
	 * @param lb
	 * @param i
	 */
	public void setLabelSite1(Label lb, int i){
		lb.setLocation(frameWidth / 2, 100 + i * 40);
	}
	
	public void setTextFieldSize(TextField tf){
		tf.setSize(120, 20);
	}
	
	public void setTextFieldSite(TextField tf, int i){
		tf.setLocation(270, 100 + i * 40);  //test
		tf.setLocation(frameWidth / 8 + 80, 100 + i * 40);
	}
	
	/**
	 * dname 参数设置
	 * @param tf
	 * @param i
	 */
	public void setTextFieldSite1(TextField tf, int i){
		tf.setLocation(270, 100 + i * 40);  //test
		tf.setLocation(frameWidth / 2 + 80, 100 + i * 40);
	}
	
	public void setButtonSize(Button button){
		button.setSize(60, 30);
	}
	
	/**
	 * 
	 * @param button
	 * @param i
	 */
	public void setLeftButtonSite(Button button){             
		button.setLocation(frameWidth / 2 - 120, frameHeight - 130);
	}
	
	public void setRightButtonSite(Button button){
		button.setLocation(frameWidth / 2 + 60, frameHeight - 130);
	}
	
	
} // Widget
