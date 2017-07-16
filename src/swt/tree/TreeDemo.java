package swt.tree;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import swt.base.ICreate;

public class TreeDemo implements ICreate{

	@Override
	public void create(Shell shell) {
		shell.setLayout(new FillLayout());
		shell.setText("Using Tree");
		shell.setSize(new Point(300, 200));
		Tree tree = new Tree(shell, SWT.CHECK|SWT.MULTI);
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

		//child3 insert text
		final TreeEditor editor = new TreeEditor(tree);
		final Text text =new Text(tree, SWT.None);
		text.setText(child3.getText(0));
		editor.grabHorizontal = true;

		editor.setEditor(text, child3, 0);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				editor.getItem().setText(0, text.getText());

			}
		});

	}

}
