package swt.color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import swt.base.ICreate;

public class ColorDomo implements ICreate{

	@Override
	public void create(final Shell shell) {
		
		//button for pop color dialog
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(10, 10, 140, 20);
		button.setText("choose color");
		
		
		button.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				//color dialog
				ColorDialog cd = new ColorDialog(shell);
				RGB rgb = cd.open();
				if (rgb != null) {
					Color color = new Color(Display.getDefault(), rgb);
					// Use Color
					System.out.println(color.getRGB());
					color.dispose();
				}

			}
		});
		
	}

}
