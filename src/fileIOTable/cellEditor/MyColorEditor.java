package fileIOTable.cellEditor;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class MyColorEditor extends DialogCellEditor{

	public MyColorEditor(Composite parent) {
		super(parent,SWT.NONE);
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		ColorDialog dialog = new ColorDialog(cellEditorWindow.getShell());
        Object value = getValue();
        if (value != null) {
			dialog.setRGB((RGB) value);
		}
        value = dialog.open();
        return dialog.getRGB();
	}

}
