package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
	public List<String> getAllFileName(String path) {
		List<String> list = new ArrayList<>();
		File f = new File(path);
		if (f.isDirectory()) {
			for (File file : f.listFiles()) {
				list.add(file.getName());
			}
		}
		return list;
	}
}
