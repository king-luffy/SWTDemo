package swt.listViewer;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ListContentProvider implements IStructuredContentProvider{

	private Viewer viewer;
	private ListModel model;
	
	@Override
	public void dispose() {}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (newInput instanceof ListModel) {
			model = (ListModel) newInput;
		}
		
	}

	@Override
	public Object[] getElements(Object obj) {
		return model.users.toArray();
	}

}
