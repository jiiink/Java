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
        String msg = "";
        String objects = "";
        for (Object object : shapes) {
            // objects += object.toString();
            msgList.add(object.toString());
        }
        // msgArray.append()
        msg += "[" + objects + "]";
        // System.out.println(msg);
        System.out.println(msgList);
    }

    public void clear() {
        shapes.clear();
    }
}

