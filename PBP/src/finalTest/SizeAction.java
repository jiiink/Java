package finalTest;

import javax.swing.Action;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SizeAction extends AbstractAction {
    public SizeAction(final String name) {
        super(name);
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        if (getValue(Action.NAME).equals("Bigger")) {
            ServerFrame.setBallSize(2.0);
        } else {
            ServerFrame.setBallSize(0.5);
        }
    }
}
