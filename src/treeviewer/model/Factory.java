package treeviewer.model;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	public static List<Country> createTree(){
		//���ɹ���
		Country cn = new Country("中国");
		Country us = new Country("美国");
		Country jp = new Country("日本");
		//���ɳ���
		City beijing  = new City("北京");
		City shanghai = new City("上海");
		City newyork = new City("纽约");
		City la = new City("洛杉矶");
		City tokyo = new City("东京");
		City osaka = new City("大阪");
		//������
		ArrayList<People> list = new ArrayList<People>();
		list.add(new People("张三"));
		list.add(new People("李四"));
		list.add(new People("王五"));
		beijing.setChildren(list);
		//�Ϻ���
		list = new ArrayList<People>();
		list.add(new People("翠花"));
		list.add(new People("小红"));
		list.add(new People("小崔"));
		shanghai.setChildren(list);
		//ŦԼ��
		list = new ArrayList<People>();
		list.add(new People("tom"));
		list.add(new People("rose"));
		list.add(new People("john"));
		newyork.setChildren(list);
		//��ɼ���
		list = new ArrayList<People>();
		list.add(new People("Sofia"));
		list.add(new People("sarah"));
		list.add(new People("Jennifer"));
		la.setChildren(list);
		//������
		list = new ArrayList<People>();
		list.add(new People("渡边"));
		list.add(new People("鬼冢"));
		list.add(new People("山本"));
		tokyo.setChildren(list);
		//������
		list = new ArrayList<People>();
		list.add(new People("奈奈子"));
		list.add(new People("菜菜子"));
		list.add(new People("新垣结衣"));
		osaka.setChildren(list);

		//�������������
		//�й�
		ArrayList<City> citys = new ArrayList<City>();
		citys.add(beijing);
		citys.add(shanghai);
		cn.setChildren(citys);
		//����
		citys = new ArrayList<City>();
		citys.add(newyork);
		citys.add(la);
		us.setChildren(citys);
		//�ձ�
		citys = new ArrayList<City>();
		citys.add(tokyo);
		citys.add(osaka);
		jp.setChildren(citys);
		//�����б�
		ArrayList<Country> countrys = new ArrayList<Country>();
		countrys.add(cn);
		countrys.add(us);
		countrys.add(jp);
		return countrys;
	}
}
