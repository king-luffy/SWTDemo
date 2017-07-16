package swt.base;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTShell {

	private ICreate creator;
	
	public SWTShell(ICreate create){
		creator = create;
	}
	
	public void run(){
		Display display = Display.getDefault();

		final Shell shell = new Shell(display);
		shell.setSize(400, 300);
		
		creator.create(shell);

		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
}
