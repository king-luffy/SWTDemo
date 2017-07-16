package treeviewer.model;

import java.util.List;

public interface Itree<T> {
	public String getName();
	public void setName(String name);
	public void setChildren(List<T>Children);
	public List<T> getChildren();
}
