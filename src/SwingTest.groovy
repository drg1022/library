import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

def message = new Message()

SwingBuilder.build() {
    frame(title:'Echo GUI', size:[300,100], visible: true, defaultCloseOperation:WC.EXIT_ON_CLOSE) {
        gridLayout(cols: 2, rows: 0)
        label 'Input text: '
        input = textField(columns:10, actionPerformed: { message.text = input.text })
        label 'Echo: '
        label(text: bind { message.text })
    }
}

public class Message {
    private String text;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public String getText() {
        return text;
    }

    public void setText(String text) {
        pcs.firePropertyChange("text", this.text, this.text = text);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}