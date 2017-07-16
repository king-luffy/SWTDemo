package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fileIOTable.base.InputFile;
import fileIOTable.base.InputFileType;
import fileIOTable.base.InputModel;

public class Serializer {

	public static void main(String[] args) throws Exception {

		new Serializer("").new Test().testWirteAndReadMap();


	}



	class Test{

		private void testWirteAndReadMap() throws Exception{
			ObjectOutputStream out =
					new ObjectOutputStream(new FileOutputStream("D:\\serializationTest.obj"));

			Map<String, InputModel> inputMap = new HashMap<>();



			InputModel inputModel = new InputModel();
			inputModel.add(new InputFile(InputFileType.SyDB, "SyDBTest"));

			inputMap.put("A", inputModel);
			inputMap.put("B", inputModel);

			out.writeObject(inputMap);
			out.close();

			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("D:\\serializationTest.obj"));

			System.out.println(in);

			Map<String, InputModel> readInputModel = (Map<String, InputModel>)in.readObject();

			System.out.println(readInputModel.get("A").getInputs().get(0).getFilePath());

			in.close();
		}

		private void testWriteAndReadArrayList() throws Exception{
			ObjectOutputStream out =
					new ObjectOutputStream(new FileOutputStream("D:\\serializationTest.obj"));

			List<InputModel> inputModels = new ArrayList<InputModel>();


			InputModel inputModel = new InputModel();
			inputModel.add(new InputFile(InputFileType.SyDB, "SyDBTest"));

			inputModels.add(inputModel);
			inputModels.add(inputModel);

			out.writeObject(inputModels);
			out.close();

			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("D:\\serializationTest.obj"));

			System.out.println(in);

			List<InputModel> readInputModel = (List<InputModel>)in.readObject();

			System.out.println(readInputModel.get(0).getInputs().get(0).getFilePath());

			in.close();
		}
		private void testWriteAndReadSingleObj() throws Exception{
			ObjectOutputStream out =
					new ObjectOutputStream(new FileOutputStream("D:\\serializationTest.obj"));

			InputModel inputModel = new InputModel();
			inputModel.add(new InputFile(InputFileType.SyDB, "SyDBTest"));
			out.writeObject(inputModel);
			out.close();

			File file = new File("D:\\serializationTest.obj");
			System.out.println(file.exists());

			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("D:\\serializationTest.obj"));

			System.out.println(in);

			InputModel readInputModel = (InputModel)in.readObject();

			System.out.println(readInputModel.getInputs().get(0).getFilePath());

			in.close();
		}
	}


	private File file = null;

	public Serializer(String filePath){
		file = new File(filePath);
	}
	public Serializer(File file){
		this.file = file;
	}


	public boolean writeObj2File(Object obj){

		//when file not exist, create a new one, when create failed, return false
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!file.exists())
				return false;
		}

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));

			out.writeObject(obj);

			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	return true;
	}

	public Object readObjFromFile(){
		if(!file.exists())
			return null;
		ObjectInputStream in = null;
		Object object = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));

			object = in.readObject();

			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}
}
