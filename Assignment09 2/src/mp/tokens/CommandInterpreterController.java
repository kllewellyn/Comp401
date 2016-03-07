package mp.tokens;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import mp.interfaces.CommandInterpreterInterface;
import util.annotations.Tags;

@Tags({"CommandInterpreterController", "ObservableCommandInterpreter"})
public class CommandInterpreterController implements ActionListener{

	JTextField text, error;
	TextField command;
	CommandInterpreterInterface commandInterpreter;
	
    public CommandInterpreterController(JTextField text1, CommandInterpreterInterface commands) {
        text = text1;
        commandInterpreter = commands;
        text.addActionListener(this);
    }

	public void setModel(CommandInterpreterInterface commands1) {
		commandInterpreter = commands1;
	}

	public void actionPerformed(ActionEvent arg0) {
		JTextField source = (JTextField) arg0.getSource();
		 String text1 = source.getText();
		 text.setText(text1);
		 command.setText(text1);
		 commandInterpreter.setCommand(text1);
		 error.setText(commandInterpreter.getError());
			
	}
	public TextField getCommand(){return command;}
	public String getError(){return error.getText();}

	public void processInput() {}

}
