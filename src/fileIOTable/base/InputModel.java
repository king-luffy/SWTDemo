package fileIOTable.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InputModel implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String Column1 = "File Type";
	public static final String Column2 = "File Path";
	public static final String Column3 = "File Dialog";

	protected List<InputFile> inputs = new ArrayList<>();

	public List<InputFile> getInputs(){
		return inputs;
	}

	public InputModel add(InputFile inputFile){
		inputs.add(inputFile);
		return this;
	}

}
