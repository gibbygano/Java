/* Ryan Blake
 * Java I
 * Fall 2013
 * Lab 5 */



//imporat libraries needed for application
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.*;
import java.text.*;


public class calculator extends JFrame {



	//declare button variables for 0-9 and decimal
	private JButton jbtOne;
	private JButton jbtTwo;
	private JButton jbtThree;
	private JButton jbtFour;
	private JButton jbtFive;
	private JButton jbtSix;
	private JButton jbtSeven;
	private JButton jbtEight;
	private JButton jbtNine;
	private JButton jbtZero;
	private JButton	jbtDec;

	//declare textfield variables
	private JTextField results;

	//declare operations buttons variables
	private JButton jbtClear;
	private JButton jbtAdd;
	private JButton jbtSub;
	private JButton jbtDiv;
	private JButton jbtMult;
	private JButton jbtEqual;

	//declare variables that will hold values
	//for user inputs and solutions
	private double firstVal;
	private double solvedVal;

	//declare variable for the operation string
	private String operation;




	public calculator() {



		//create main panel
		JPanel p1 = new JPanel();

		//create buttons 0-9 to main panel
    	jbtOne = new JButton("1");
    	jbtTwo = new JButton("2");
    	jbtThree = new JButton("3");
    	jbtFour = new JButton("4");
    	jbtFive = new JButton("5");
    	jbtSix = new JButton("6");
    	jbtSeven = new JButton("7");
    	jbtEight = new JButton("8");
    	jbtNine = new JButton("9");
    	jbtZero = new JButton("0");
    	jbtDec = new JButton(".");

		//position buttons into grid layout
		p1.setLayout(new GridLayout(4, 3, 4, 4));

		//put buttons along border layout with margins
    	p1.setBorder(new EmptyBorder(3, 4, 3, 4));
		add(p1, BorderLayout.WEST);

		//add buttons to pannel
		p1.add(jbtOne);
		p1.add(jbtTwo);
		p1.add(jbtThree);
		p1.add(jbtFour);
		p1.add(jbtFive);
		p1.add(jbtSix);
		p1.add(jbtSeven);
		p1.add(jbtEight);
		p1.add(jbtNine);
		p1.add(jbtZero);
		p1.add(jbtDec);

		//new action listeners for calculator panel 1
		//each listener outputs a its corresponding number when
		//pressed and also reads any previous characters in the field
		//and outputs them along with the new character
		jbtOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "1");
			}
		});

		jbtTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "2");
			}
		});

		jbtThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			results.setText(results.getText() + "3");
			}
		});

		jbtFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "4");
			}
		});

		jbtFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "5");
			}
		});

		jbtSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "6");
			}
		});

		jbtSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "7");
			}
		});

		jbtEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "8");
			}
		});

		jbtNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "9");
			}
		});

		jbtZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + "0");
			}
		});

		jbtDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				results.setText(results.getText() + ".");

			}

		});

		//create second panel with text field inside panel 1, set it north against top of window
	    JPanel p2 = new JPanel(new BorderLayout());

		//create new font with Helvetica typeface, non-bold style and 20 pt type
		Font resultsFont = new Font("Helvetica", Font.PLAIN, 20);

		//create new text field
	    results = new JTextField("");

	    //set preferred length and width
	    results.setPreferredSize(new Dimension(200,30));

	    //align cursor to the right of the text field
	    results.setHorizontalAlignment(results.RIGHT);

	    //assign the font created previously to the textfield
	    results.setFont(resultsFont);

		//add the text field to the second panel
	    p2.add(results);

	    p2.add(results,BorderLayout.NORTH);
		p2.setBorder(new EmptyBorder(2, 3, 2, 3));

	    add(p2, BorderLayout.NORTH);

		//third JPanel containted the operater buttons laid out to the bottom of the frame.
		JPanel p3 = new JPanel(new BorderLayout());


		//adding buttons to panel 3

		p3.setLayout(new GridLayout(6, 1, 4, 4));
		p3.setBorder(new EmptyBorder(2, 3, 2, 3));
		add(p3, BorderLayout.EAST);

		//create operation buttons
		jbtClear = new JButton("C");
		jbtEqual = new JButton("=");
		jbtDiv = new JButton("/");
		jbtMult = new JButton("X");
		jbtSub = new JButton("-");
		jbtAdd = new JButton("+");

		//add buttons to panel 3
		p3.add(jbtAdd);
		p3.add(jbtSub);
		p3.add(jbtMult);
		p3.add(jbtDiv);
		p3.add(jbtEqual);
		p3.add(jbtClear);

		//action listeners for operation buttons


		jbtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//set textfield to blank when 'C' is pressed
				results.setText("");
			}
		});

		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//parse first number from user to a double from a string
				firstVal = Double.parseDouble(results.getText());

				//clear the textfield
                results.setText("");

                //flag the operation variable for addition
                operation = "addition";
			}
		});

		jbtSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//parse first number from user to a double from a string
				firstVal = Double.parseDouble(results.getText());

				//clear the textfield
                results.setText("");

                //flag the operation variable for subtraction
                operation = "subtraction";
			}
		});

		jbtMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//parse first number from user to a double from a string
				firstVal = Double.parseDouble(results.getText());

				//clear the textfield
                results.setText("");

                //flag the operation variable for multiplication
                operation = "multiplication";
			}
		});

		jbtDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//parse first number from user to a double from a string
				firstVal = Double.parseDouble(results.getText());

				//clear the textfield
                results.setText("");

                //flag the operation variable for division
                operation = "division";
			}
		});

		//upon equal button press, do the operatin correspoing to the
		//String value that was assigned to the operation variable
		jbtEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//parse second value to double  for operations
				solvedVal = Double.parseDouble(results.getText());

				//if operation String variable is addition,
				//perform addition operation for firstVal and solvedVal
				if (operation == "addition")

					solvedVal = solvedVal + firstVal;

				//if operation String variable is subtraction,
				//perform subtraction operation for firstVal and solvedVal
                else if (operation == "subtraction")

                    solvedVal = firstVal - solvedVal;

				//if operation String variable is multiplication,
				//perform multiplication operation for firstVal and solvedVal
                else if (operation == "multiplication")

                    solvedVal = firstVal * solvedVal;

				//if operation String variable is division,
				//perform division operation for firstVal and solvedVal
                else if (operation == "division")

                    solvedVal = firstVal / solvedVal;

				//format double solvedVal to string and
				//submit to textfield
				results.setText(Double.toString(solvedVal));

				//reset the operation String variable to null
   				operation = ("");
			}
		});
	}

	public static void main(String[] args) {
		//set name and size to frame
		calculator frame = new calculator();
    	frame.setTitle("Calculator");
    	frame.setSize(325, 270);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
}
