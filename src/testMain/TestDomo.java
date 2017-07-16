package testMain;

import swt.base.SWTShell;
import swt.color.ColorDomo;
import swt.dataTime.DateTimeDemo;
import swt.listViewer.ListViewerDemo;
import swt.table.TableDemo;
import swt.tree.TreeDemo;

public class TestDomo {

	public static void main(String[] args) {
		test3();
	}

	public static void test1(){
		//test color
		new SWTShell(new ColorDomo()).run();
	}

	public static void test2(){
		//test dataTime
		new SWTShell(new DateTimeDemo()).run();
	}

	public static void test3(){
		//test table
		new SWTShell(new TableDemo()).run();
	}

	public static void test4(){
		//test listViewer
		new ListViewerDemo().run();
	}

	public static void test5(){
		//test tableViewer
		new SWTShell(new TreeDemo()).run();
	}
}
