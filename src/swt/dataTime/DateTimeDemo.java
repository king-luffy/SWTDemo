package swt.dataTime;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;

import swt.base.ICreate;

public class DateTimeDemo implements ICreate{

	@Override
	public void create(final Shell shell) {
		
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(10, 10, 140, 20);
		button.setText("choose date");
		
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				final Shell dialog = new Shell(shell, SWT.DIALOG_TRIM);
				dialog.setLayout(new GridLayout(3, false));
				
				final DateTime calender = new DateTime(dialog, SWT.CALENDAR | SWT.LONG);
				final DateTime date = new DateTime(dialog, SWT.DATE | SWT.LONG);
				final DateTime time = new DateTime(dialog, SWT.TIME | SWT.LONG);
				

				dialog.pack();
				dialog.open();
								
			}
		});
		
		
	}

}
