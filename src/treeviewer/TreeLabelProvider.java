package treeviewer;



import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import treeviewer.model.Itree;

public class TreeLabelProvider extends LabelProvider implements ILabelProvider {
		public String getText(Object element) {
			Itree node = (Itree)element;
			return node.getName();
		}
		public Image getImage(Object element) {
			return null;
		}
	}