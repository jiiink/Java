package hw12;

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
            BounceFrame.setBallSize(2.0);
        } else {
            BounceFrame.setBallSize(0.5);
        }
    }
}
