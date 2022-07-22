import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Action {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    public static void main(String[] args) {

        jFrame.add(jPanel);
        AbstractAction myAction = new MyAction();
        JButton jButton = new JButton(myAction);
        jButton.setText("Tyk");
        jPanel.add(jButton);

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "changeColor");
        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put("changeColor", myAction);
    }

    static class MyAction extends AbstractAction {

//        MyAction() {
//            putValue(AbstractAction.SHORT_DESCRIPTION, "My small action");
//        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.CYAN);
        }
    }
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(750,250, 500,300);
        return jFrame;
    }
}
