package hw07.edu.pnu.edit;
import java.util.*;

public class Editor {
	private List<Object> shapes = new ArrayList<>();

    Editor() {}

    public <T> void add(T object) {
        shapes.add(object);
    }

    public void list() {
        List<String> msgList = new ArrayList<>();
        for (Object object : shapes) {
            msgList.add(object.toString());
        }
        System.out.println(msgList);
    }

    public void clear() {
        shapes.clear();
    }
}

