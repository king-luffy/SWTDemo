package tableviwer;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class UsingTable {

	private static Shell shell = null;  //  @jve:decl-index=0:visual-constraint="71,58"
	private static Table table = null;
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {

		shell = new Shell();
		shell.setText("Shell");
		shell.setSize(new Point(349, 252));
		shell.setLayout(new FillLayout());
		table = new Table(shell, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Image image1 = new Image(Display.getCurrent(), getClass().getResourceAsStream("/book/ch7/table/icon1.gif"));
		Image image2 = new Image(Display.getCurrent(), getClass().getResourceAsStream("/book/ch7/table/icon2.gif"));
		ImageRegistry registry = new ImageRegistry();
		registry.put("image1", image1);
		registry.put("image2", image2);

		TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		tableColumn1.setWidth(tableColumn1.getWidth());
		tableColumn1.setText("Column 1");
		tableColumn1.setImage(image1);

		TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		tableColumn2.setWidth(100);
		tableColumn2.setText("Column 2");
		tableColumn2.setImage(image2);

		TableItem item1 = new TableItem(table,SWT.NONE);
		item1.setText(new String[]{"Content 11","Content 12"});
		item1.setImage(new Image[]{image1,image2});

		TableItem item2 = new TableItem(table,SWT.NONE);
		item2.setText(new String[]{"Content 21","Content 22"});
		item2.setImage(new Image[]{image1,image2});
	}
	public static void main(String[] args) {
		Display display = Display.getDefault();


		shell = new Shell();
		shell.setText("Shell");
		shell.setSize(new Point(349, 252));
		shell.setLayout(new FillLayout());
		table = new Table(shell, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Image image1 = new Image(Display.getCurrent(), new UsingTable().getClass().getResourceAsStream("/book/ch7/table/icon1.gif"));
		Image image2 = new Image(Display.getCurrent(), new UsingTable().getClass().getResourceAsStream("/book/ch7/table/icon2.gif"));
		ImageRegistry registry = new ImageRegistry();
		registry.put("image1", image1);
		registry.put("image2", image2);

		TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		//tableColumn1.setWidth(100);
		//tableColumn1.setWidth(tableColumn1.getWidth());
		tableColumn1.setText("Column 1");
		System.out.println(tableColumn1.getWidth());
		tableColumn1.setWidth(tableColumn1.getWidth());
		tableColumn1.setImage(image1);

		TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		tableColumn2.setWidth(100);
		tableColumn2.setText("Column 2");
		tableColumn2.setImage(image2);

		TableItem item1 = new TableItem(table,SWT.NONE);
		item1.setText(new String[]{"Content 11","Content 12"});
		item1.setImage(new Image[]{image1,image2});

		TableItem item2 = new TableItem(table,SWT.NONE);
		item2.setText(new String[]{"Content 21","Content 22"});
		item2.setImage(new Image[]{image1,image2});

		shell.open();
		shell.layout();


		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
	}
}
