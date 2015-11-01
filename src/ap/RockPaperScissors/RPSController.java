package ap.RockPaperScissors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class RPSController {
	Image rock = new Image(getClass().getResourceAsStream("rock.png"));
	Image paper = new Image(getClass().getResourceAsStream("paper.png"));
	Image scissors = new Image(getClass().getResourceAsStream("scissors.png"));
	boolean rdyPlay1 = false;
	boolean rdyPlay2 = false;
	int roundNum = 0;
	int P1Points = 0;
	int P2Points = 0;
	
	
    @FXML
    private Button buttonStartRound;

    @FXML
    private Label labelP1Points;

    @FXML
    private Label labelP2Choice;

    @FXML
    private ImageView imageP2;

    @FXML
    private ImageView imageP1;

    @FXML
    private Label labelP1Choice;

    @FXML
    private Label labelP2Points;

    @FXML
    private TextField textFieldP2Name;

    @FXML
    private TextField textFieldP1Name;

    @FXML
    private Label labelRoundSummary;
    
    @FXML
    private Label labelSpacebar;

    @FXML
    void buttonClickListener() {
    	if(textFieldP1Name.getText().equals(""))
    	{
    		textFieldP1Name.setText("Player 1");
    	}
    	if(textFieldP2Name.getText().equals(""))
    	{
    		textFieldP2Name.setText("Player 2");
    	}
    	
    	labelRoundSummary.setText("ROUND " + ++roundNum);
    	textFieldP1Name.setEditable(false);
    	textFieldP2Name.setEditable(false);
    	buttonStartRound.setDisable(true);
    	rdyPlay1 = true;
    	rdyPlay2 = true;
    }
    
    @FXML
    void keyReleaseListener(KeyEvent event) {

    	if(event.getText().equals("a") && rdyPlay1)
    	{
    		imageP1.setImage(rock);
    		//imageP1.setVisible(true);
    		labelP1Choice.setText("ROCK");
    		//labelP1Choice.setVisible(true);
    		rdyPlay1 = false;
    	}
    	else if(event.getText().equals("s") && rdyPlay1)
    	{
    		imageP1.setImage(paper);
    		//imageP1.setVisible(true);
    		labelP1Choice.setText("PAPER");
    		//labelP1Choice.setVisible(true);
    		rdyPlay1 = false;
    	}
    	else if(event.getText().equals("d") && rdyPlay1)
    	{
    		imageP1.setImage(scissors);
    		//imageP1.setVisible(true);
    		labelP1Choice.setText("SCISSORS");
    		//labelP1Choice.setVisible(true);
    		rdyPlay1 = false;
    	}
    	else if(event.getText().equals("j") && rdyPlay2)
    	{
    		imageP2.setImage(rock);
    		//imageP2.setVisible(true);
    		labelP2Choice.setText("ROCK");
    		//labelP2Choice.setVisible(true);
    		rdyPlay2 = false;
    	}
    	else if(event.getText().equals("k") && rdyPlay2)
    	{
    		imageP2.setImage(paper);
    		//imageP2.setVisible(true);
    		labelP2Choice.setText("PAPER");
    		//labelP2Choice.setVisible(true);
    		rdyPlay2 = false;
    	}
    	else if(event.getText().equals("l") && rdyPlay2)
    	{
    		imageP2.setImage(scissors);
    		//imageP2.setVisible(true);
    		labelP2Choice.setText("SCISSORS");
    		//labelP2Choice.setVisible(true);
    		rdyPlay2 = false;
    	}
    	
    	//!labelP1Choice.getText().equals("P1 Choice") && !labelP2Choice.getText().equals("P2 Choice")
    	if(!labelP1Choice.getText().equals("P1 Choice") && !labelP2Choice.getText().equals("P2 Choice")
    			&& !labelP2Choice.isVisible())
    	{
    		imageP1.setVisible(true);
    		imageP2.setVisible(true);
    		labelP1Choice.setVisible(true);
    		labelP2Choice.setVisible(true);
    		//labelRoundSummary.setVisible(true);
    		if(labelP1Choice.getText().equals(labelP2Choice.getText()))
    		{
    			labelRoundSummary.setText("DRAW!");
    		}
    		else if(labelP1Choice.getText().equals("ROCK") && labelP2Choice.getText().equals("SCISSORS"))
    		{
    			P1Points++;
    			labelP1Points.setText("" + P1Points);
    			labelRoundSummary.setText(textFieldP1Name.getText() + " WINS!");
    		}
    		else if(labelP1Choice.getText().equals("ROCK") && labelP2Choice.getText().equals("PAPER"))
    		{
    			P2Points++;
    			labelP2Points.setText("" + P2Points);
    			labelRoundSummary.setText(textFieldP2Name.getText() + " WINS!");
    		}
    		else if(labelP1Choice.getText().equals("SCISSORS") && labelP2Choice.getText().equals("ROCK"))
    		{
    			P2Points++;
    			labelP2Points.setText("" + P2Points);
    			labelRoundSummary.setText(textFieldP2Name.getText() + " WINS!");
    		}
    		else if(labelP1Choice.getText().equals("SCISSORS") && labelP2Choice.getText().equals("PAPER"))
    		{
    			P1Points++;
    			labelP1Points.setText("" + P1Points);
    			labelRoundSummary.setText(textFieldP1Name.getText() + " WINS!");
    		}
    		else if(labelP1Choice.getText().equals("PAPER") && labelP2Choice.getText().equals("SCISSORS"))
    		{
    			P2Points++;
    			labelP2Points.setText("" + P2Points);
    			labelRoundSummary.setText(textFieldP2Name.getText() + " WINS!");
    		}
    		else if(labelP1Choice.getText().equals("PAPER") && labelP2Choice.getText().equals("ROCK"))
    		{
    			P1Points++;
    			labelP1Points.setText("" + P1Points);
    			labelRoundSummary.setText(textFieldP1Name.getText() + " WINS!");
    		}
    		
    		labelSpacebar.setVisible(true);
    	}
    	
    	
    	if(event.getText().equals(" ") && buttonStartRound.isDisabled() && imageP1.isVisible())
    	{
    		labelRoundSummary.setText("ROUND " + ++roundNum);
    		imageP1.setVisible(false);
    		imageP2.setVisible(false);
    		labelP1Choice.setVisible(false);
    		labelP2Choice.setVisible(false);
    		labelP1Choice.setText("P1 Choice");
    		labelP2Choice.setText("P2 Choice");
    		labelSpacebar.setVisible(false);
    		rdyPlay1 = true;
    		rdyPlay2 = true;
    	}
    	
    	
    }

}