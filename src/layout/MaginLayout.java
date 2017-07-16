package layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MaginLayout {
	public static void main(String[] args) {
		Display display = Display.getDefault();

		Shell shell = new Shell();
		shell.setText("Hello SWT");
		shell.setSize(400, 400);
		shell.open();

		Composite composite = new MaginLayout().createMarginComposite(shell,30);

		composite.setBackground(new Color(Display.getCurrent(), new RGB(150,150,150)));
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private Composite createMarginComposite(Shell parent,int margin){
		parent.setLayout(new FillLayout());

		Composite container = new Composite(parent, SWT.FILL);

		//container.setBackground(new Color(Display.getCurrent(), new RGB(150,150,150)));

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);


		final Label upLabel = new Label(container, SWT.NONE);
		//upLabel.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		final GridData gridDataUpDn = new GridData(SWT.FILL,SWT.CENTER,true,false,3,1);
		gridDataUpDn.widthHint =margin;
		gridDataUpDn.heightHint =margin;
		upLabel.setLayoutData(gridDataUpDn);

		final Label centerLabel1 = new Label(container, SWT.NONE);
		//centerLabel1.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		final GridData gridDataLR = new GridData(SWT.CENTER, SWT.FILL, false, true, 1, 1);
		gridDataLR.widthHint =margin;

		final GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		centerLabel1.setLayoutData(gridDataLR);

		final Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(gridData2);

		final Label centerLabel3 = new Label(container, SWT.NONE);
		centerLabel3.setLayoutData(gridDataLR);


		final Label bottomLabel = new Label(container, SWT.NONE);
		//bottomLabel.setBackground(new Color(Display.getCurrent(), new RGB(0,0,0)));
		bottomLabel.setLayoutData(gridDataUpDn);

		return composite;
	}
}
