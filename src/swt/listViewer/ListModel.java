package swt.listViewer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Vector;

public class ListModel {
	
	//数据变更发布订阅模式 （发布者）
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	public void firePropertyChange(PropertyChangeEvent evt) {
		pcs.firePropertyChange(evt);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
	//数据结构
	Vector<User> users = new Vector<>();
	
	//数据变更操作
	public void add(User user){
		if(users.add(user))
			firePropertyChange(new PropertyChangeEvent(this, "add", null, user));;
	}
	
	public void delete(int ind){
		if (users.size()>ind) {
			users.remove(ind);
		}
	}
}
