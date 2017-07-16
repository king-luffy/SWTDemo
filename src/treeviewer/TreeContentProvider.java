package treeviewer;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import treeviewer.model.Itree;

public class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List){
				List input = (List)inputElement;
				return input.toArray();
			}
			return new Object[0];
		}
		public Object[] getChildren(Object parentElement) {
			Itree node = (Itree)parentElement;
			List list = node.getChildren();
			if(list == null){
				return new Object[0];
			}
			return list.toArray();
		}

		public boolean hasChildren(Object element) {
			Itree node = (Itree)element;
			List list = node.getChildren();
			return !(list == null || list.isEmpty());
		}

		public Object getParent(Object element) {
			return null;
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
	}