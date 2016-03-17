package cn.jungu009.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateKeyCommand {

	
	//String cmd = "";
//	private String alias;
//	private String keyStore;
//	private String keyAlg;
//	private String validity;
//	private String keyPass;
//	private String storePass;
//	private String CN;
//	private String OU;
//	private String O;
//	private String L;
//	private String ST;
//	private String C;
//	
//	private String [] array = {alias, keyStore, keyAlg, validity, keyPass,
//			 storePass, CN, OU, O, L, ST, C};
	
	
//	public CreateKeyCommand(String alias, String keyStore, String keyAlg, String validity, String keyPass,
//			String storePass, String cN, String oU, String o, String l, String sT, String c) {
//		super();
//		this.alias = alias;
//		this.keyStore = keyStore;
//		this.keyAlg = keyAlg;
//		this.validity = validity;
//		this.keyPass = keyPass;
//		this.storePass = storePass;
//		CN = cN;
//		OU = oU;
//		O = o;
//		L = l;
//		ST = sT;
//		C = c;
//	}

	public void setArguments(String [] array, String [] strArray){
		for(int i = 0; i < 12; i++){   // error
			array[i] = strArray[i]; 
//			System.out.println(strArray[i]);  //test
//			System.out.println(array[i]);     //test
		}
	}
	

	public void exeCommand(String [] strArray){
		
//		String alias = null;
//		String keyStore = null;
//		String keyAlg = null;
//		String validity = null;
//		String keyPass = null;
//		String storePass = null;
//		String dname = null;
//		String CN = null;
//		String OU = null;
//		String O = null;
//		String L = null;
//		String ST = null;
//		String C = null;
//		
//		
//		String [] array = {alias, keyStore, keyAlg, validity, keyPass,
//				 storePass, dname};
//		
//		setArguments(array, strArray);
		
		
//		for(int i = 0; i < array.length; i++){
//			System.out.println(array[i]);
//		}
		
		// test
		System.out.println("keytool " + "-genkey " + "-alias " + strArray[0] + " " + 
											"-keyalg " + strArray[2] +  " " +
											"-validity " + strArray[3] +  " " +
											"-keystore " + strArray[1] +  " " +
											"-dname " + strArray[6] + " " +
											"-keypass " + strArray[4] +  " " +
											"-storepass " + strArray[5]);
		
		try{
			
			Process p = Runtime.getRuntime().exec("cmd /k start " + "keytool " + "-genkey " + "-alias " + strArray[0] + " " + 
											"-keyalg " + strArray[2] +  " " +
											"-validity " + strArray[3] +  " " +
											"-keystore " + strArray[1] +  " " +
											"-dname " + strArray[6] + " " +
											"-keypass " + strArray[4] +  " " +
											"-storepass " + strArray[5]);		
			
			//Runtime.getRuntime().exec("cmd /k start " + "mkdir G:\\java\\eclipse\\signertool\\test");
			
			
			/* 输出命令行在终端的显示信息 */
//			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			String line = null;
//			StringBuilder sb = new StringBuilder();
//			while((line = br.readLine()) != null){
//				System.out.println(br.readLine());
//			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void exeCommand(){ 
		System.out.println("delete");
		System.out.println("del G:\\java\\eclipse\\signertool\\test.keystore");
		
		try{
			Runtime.getRuntime().exec("cmd /k start " + "del G:\\java\\eclipse\\signertool\\test.keystore");
		}catch(IOException e){
			
		}
	}
	
} // CreateKeyCommand