package coding;

import java.io.UnsupportedEncodingException;

public class Coding {

	public static void main(String[] args) throws Exception {
//		String utf8 = "鎴戞潵浜�";
//
//		for (Byte b : utf8.getBytes("utf-8")) {
//			System.out.print(b+" ");
//		}
//		System.out.println(utf8);
//		System.out.println(" ");
//		String gbk = new String(utf8.getBytes("utf-8"),"gbk");
//
//		for (Byte b : gbk.getBytes("gbk")) {
//			System.out.print(b+" ");
//		}
//		System.out.println(new String(gbk.getBytes("gbk"),"utf-8"));

//		String gbk = "我来了";
//
//		String utf8= new String(gbk.getBytes(),"UTF-8");
//
//		for (byte b : gbk.getBytes("gbk")) {
//			System.out.print(b+" ");
//		}
//		System.out.println();
//		System.out.println(gbk);
//		for (byte b : utf8.getBytes("UTF-8")) {
//			System.out.print(b+" ");
//		}
//		System.out.println();
//		for (byte b : utf8.getBytes()) {
//			System.out.print(b+" ");
//		}
//		System.out.println();
//		System.out.println(utf8);

		String utf8 = "凤天路";
		
		byte[] bytes = utf8.getBytes("gbk");
		StringBuilder sBuilder = new StringBuilder();
		for (byte b : bytes) {
			sBuilder.append(b+" ");
		}
		System.out.println(sBuilder.toString());
		
		bytes = utf8.getBytes("gb18030");
		
		sBuilder = new StringBuilder();
		
		for (byte b : bytes) {
			sBuilder.append(b+" ");
		}
		System.out.println(sBuilder.toString());
		
		byte[] bytes2 = new byte[6];
		bytes2[0] = (byte) 0xB7;
		bytes2[1] = (byte) 0xEF;
		bytes2[2] = (byte) 0xCC;
		bytes2[3] = (byte) 0xEC;
		bytes2[4] = (byte) 0xC2;
		bytes2[5] = (byte) 0xB7;
		String s = new String(bytes2,"gb18030");
		System.out.println(s);
	}
}
