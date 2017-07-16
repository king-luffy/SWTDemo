package swt.listViewer;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class ListViewerDemo{


	public void run() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setLayout(new FillLayout());
		ListViewer viewer = new ListViewer(shell, SWT.BORDER);

		viewer.setContentProvider(new ListContentProvider());
		viewer.setLabelProvider(new ListLabelProvider());

		ListModel input = new ListModel();

		viewer.setInput(input);


		//after view is set,then change date
		input.add(new User(1,"a"));
		input.add(new User(2, "b"));

		viewer.refresh();
		//viewer.refresh(input);

		shell.open();
		shell.layout();



		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();

	}

}
