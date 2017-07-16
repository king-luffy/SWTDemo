package swt.table;


//import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import swt.base.ICreate;

public class TableDemo implements ICreate{



	@Override
	public void create(final Shell shell) {

		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(10, 10, 140, 20);
		button.setText("choose date");


		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				createTable(shell);

			}
		});



	}

	private void createTable(Shell shell){
		final Shell dialog = new Shell(shell, SWT.DIALOG_TRIM);

		dialog.setText("Shell");
		dialog.setSize(new Point(700, 500));
		dialog.setLayout(new FillLayout());
		//dialog.setLayout(new GridLayout(2, false));
		//dialog.setLayout(null);
		//dialog.setBounds(10,10,500,500);

		//Table table = new Table(dialog, SWT.BORDER);
		Table table = new Table(dialog, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		//table.setBounds(20, 20, 200, 100);


		//image
		Image image1 = new Image(Display.getCurrent(), getClass().getResourceAsStream("/swt/table/icon1.gif"));
		Image image2 = new Image(Display.getCurrent(), getClass().getResourceAsStream("/swt/table/icon2.gif"));
//		ImageRegistry registry = new ImageRegistry();
//		registry.put("image1", image1);
//		registry.put("image2", image2);

		//column creation
		TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		tableColumn1.setWidth(140);

		tableColumn1.setText("编辑列");
		tableColumn1.setImage(image1);

		TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		tableColumn2.setWidth(100);
		tableColumn2.setText("拷贝列");
		tableColumn2.setImage(image2);

		TableColumn tableColumn3 = new TableColumn(table, SWT.NONE);
		tableColumn3.setWidth(100);
		tableColumn3.setText("列3");
		tableColumn3.setImage(image2);

		TableColumn tableColumn4 = new TableColumn(table, SWT.NONE);
		tableColumn4.setWidth(100);
		tableColumn4.setText("列4");
		tableColumn4.setImage(image2);

		//item creation
		TableItem item1 = new TableItem(table,SWT.NONE);
		item1.setText(new String[]{"Content 11","Content 12","13"});
		//item1.setImage(new Image[]{image1,image2});

		TableItem item2 = new TableItem(table,SWT.NONE);
		item2.setText(new String[]{"","Content 22","23"});
		//item2.setImage(new Image[]{image1,image2});

		TableItem item3 = new TableItem(table, SWT.None);
		item3.setText(new String[]{"Content31","Content 32","33"});

		//item 1 insert text
		final TableEditor editor = new TableEditor(table);
		final Text text =new Text(table, SWT.PASSWORD);
		text.setText(item1.getText(0));
//		Color color = shell.getDisplay().getSystemColor(SWT.COLOR_GRAY);
//		text.setBackground(color);
		editor.grabHorizontal = true;

		editor.setEditor(text, item1, 0);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				editor.getItem().setText(1, text.getText());

			}
		});

		//item 2 insert combo
		final TableEditor editor2 = new TableEditor(table);
		final Combo combo = new Combo(table, SWT.None);
		String[] a = new String[]{"a","b","c"};
		combo.setItems(a);
		combo.setText(item2.getText(0));
		//editor2.grabVertical = false;
		editor2.grabHorizontal = true;

		editor2.setEditor(combo, item2, 0);
		combo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				editor2.getItem().setText(1, combo.getText());

			}
		});
		//set height
//		table.addListener(SWT.MeasureItem, new Listener() {
//
//			@Override
//			public void handleEvent(Event arg0) {
//				arg0.height = 50;
//
//			}
//		});

		//item 3 insert tree
		Image image = new Image(shell.getDisplay(), 1, 100);
		item3.setImage(image);
		final TableEditor editor3 = new TableEditor(table);
		Tree tree = new Tree(table, SWT.CHECK|SWT.MULTI);
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(100);
		treeColumn.setText("Column 1");
		TreeColumn treeColumn1 = new TreeColumn(tree, SWT.NONE);
		treeColumn1.setWidth(100);
		treeColumn1.setText("Column 2");

		TreeItem root1 = new TreeItem(tree,SWT.NONE);
		root1.setText(new String[]{"Root 1","Root 1 Content"});
		TreeItem root2 = new TreeItem(tree,SWT.NONE);
		root2.setText(new String[]{"Root 2","Root 2 Content"});
		TreeItem child1 = new TreeItem(root1,SWT.NONE);
		child1.setText("Child 1");
		TreeItem child2 = new TreeItem(root1,SWT.NONE);
		child2.setText("Child 2");
		TreeItem child3 = new TreeItem(root2,SWT.NONE);
		child3.setText("Child 3");
		TreeItem grandChild1 = new TreeItem(child3, SWT.None);
		grandChild1.setText("Grand Child 1");
		editor3.grabHorizontal = true;

		editor3.setEditor(tree, item3, 0);
		//dialog.pack();
		dialog.open();

	}
}
