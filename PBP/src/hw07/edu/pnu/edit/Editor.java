package hw07.edu.pnu.edit;
import java.util.*;

public class Editor {
	private List<Object> shapes = new ArrayList<>();

    Editor() {}
    public <T> void add(T object) {
        shapes.add(object);
    }

    public void list() {
        String msg = "";
        String objects = "";
        for (Object object : shapes) {
            objects += object.toString() + " ";
        }
        msg += "[" + objects + "]";
        System.out.println(msg);
    }

    public void clear() {
        shapes.clear();
    }
}

