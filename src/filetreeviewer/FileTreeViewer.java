package filetreeviewer;


import java.io.File;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class FileTreeViewer {

	private static Tree tree;
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(500, 375);
		shell.setText("SWT Application");

		final TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER|SWT.H_SCROLL);
		tree = treeViewer.getTree();
		tree.setBounds(83, 75, 264, 185);

		treeViewer.setLabelProvider(new FileTreeLabelProvider());
		treeViewer.setContentProvider(new FileTreeContentProvider());
		treeViewer.setInput(File.listRoots());

		shell.open();
		shell.setLayout(new FillLayout());
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public TreeViewer getTreeViewer(Composite parent){
		final TreeViewer treeViewer = new TreeViewer(parent, SWT.BORDER|SWT.H_SCROLL);
		tree = treeViewer.getTree();
		tree.setBounds(83, 75, 264, 185);

		treeViewer.setLabelProvider(new FileTreeLabelProvider());
		treeViewer.setContentProvider(new FileTreeContentProvider());
		treeViewer.setInput(File.listRoots());

		return treeViewer;
	}
}
