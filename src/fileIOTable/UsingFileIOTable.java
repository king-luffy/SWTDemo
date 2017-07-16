package fileIOTable;

import java.io.File;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColorCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import fileIOTable.base.FileTableCellModifier;
import fileIOTable.base.FileTableContentProvider;
import fileIOTable.base.FileTableLabelProvider;
import fileIOTable.base.InputFile;
import fileIOTable.base.InputFileType;
import fileIOTable.base.InputModel;
import fileIOTable.cellEditor.FileDialogEditor;
import fileIOTable.cellEditor.MyColorEditor;
import tableviwer.ListModel;
import tableviwer.TableContentProvider;
import tableviwer.TableLabelProvider;
import tableviwer.User;

public class UsingFileIOTable {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(550, 400);
		shell.setLayout(new FillLayout());

		Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setText(InputModel.Column1);
		column1.setWidth(100);
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(300);
		column2.setText(InputModel.Column2);
		TableColumn column3 = new TableColumn(table, SWT.NONE);
		column3.setWidth(100);
		column3.setText(InputModel.Column3);

		table.setHeaderVisible(true);
		//table.setLinesVisible(true);


		TableViewer viewer = new TableViewer(table);

		viewer.setColumnProperties(new String[]{InputModel.Column1,InputModel.Column2,InputModel.Column3});
		CellEditor[] cellEditors = new CellEditor[3];
		cellEditors[0] = null;
		cellEditors[1] = new TextCellEditor(viewer.getTable());
		cellEditors[2] = new FileDialogEditor(table);
		//cellEditors[2] = new MyColorEditor(table);
		//cellEditors[2] = new ColorCellEditor(table);

		viewer.setCellEditors(cellEditors);

		viewer.setContentProvider(new FileTableContentProvider());
		viewer.setLabelProvider(new FileTableLabelProvider());
		viewer.setCellModifier(new FileTableCellModifier(viewer));


		InputModel input = new InputModel()
				.add(new InputFile(InputFileType.SyDB, "/input/inputTest.txt"))
				.add(new InputFile(InputFileType.BeaconLayout, "/input/inputTest.txt"))
				.add(new InputFile(InputFileType.ProjectConfig, "/input/inputTest.txt"));
		viewer.setInput(input);

//		viewer.addDoubleClickListener(new IDoubleClickListener() {
//
//			@Override
//			public void doubleClick(DoubleClickEvent event) {
//
//				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
//				User user =(User)selection.getFirstElement();
//				System.out.println(user.getName());
//
//				user.setName("哇哈哈");
//				event.getViewer().refresh();
//			}
//		});

		shell.open();
		shell.layout();

//		input.add(new User("1", "张三"));
//		input.add(new User("2", "李四"));
//		input.add(new User("3", "王五"));

		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();

	}
}
