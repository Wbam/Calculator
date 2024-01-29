import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton [] numberButton= new JButton[10];
    JButton [] functionButton=new JButton[9];
    JButton addButton,
            subButton,
            divisionButton,
            multiplicationButton,
            decimalButton,
            equalButton,
            deleteButton,
            negativeButton,
            clearButton;
    JPanel panel;
    Font font= new Font("Times New Roman",Font.PLAIN,12);
    double  number1=0,
            number2=0,
            result=0;
    char operator;

    public Calculator() {
        frame= new JFrame("Calculator");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(300,400);
          frame.setLayout(null);

          textField=new JTextField();
          textField.setBounds(30,25,225,50);
          textField.setFont(font);
          frame.add(textField);
          textField.setEditable(false);

          addButton=new JButton("+");
          divisionButton=new JButton("/");
          multiplicationButton=new JButton("*");
          subButton=new JButton("-");
          decimalButton=new JButton(".");
          equalButton=new JButton("=");
          deleteButton=new JButton("del");
          clearButton=new JButton("clr");
          negativeButton=new JButton("(-)");

          functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=multiplicationButton;
        functionButton[3]=divisionButton;
        functionButton[4]=equalButton;
        functionButton[5]=decimalButton;
        functionButton[6]=clearButton;
        functionButton[7]=deleteButton;
        functionButton[8]=negativeButton;

        for(int i=0;i<9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(font);
            functionButton[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numberButton[i]= new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(font);
            numberButton[i].setFocusable(false);
        }
        negativeButton.setBounds(30,300,75,30);
        deleteButton.setBounds(100,300,80,30);
        clearButton.setBounds(175,300,77,30);

        panel= new JPanel();
        panel.setBounds(30,90,225,200);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multiplicationButton);
        panel.add(decimalButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);
        panel.add(divisionButton);


        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==addButton){
            number1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            number1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==multiplicationButton){
            number1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divisionButton){
            number1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equalButton){
            number2=Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result=number1+number2;
                            break;
                case '-':
                    result=number1-number2;
                            break;
                case '*':
                    result=number1*number2;
                            break;
                case '/':
                    result=number1/number2;
                            break;
            }
            textField.setText(String.valueOf(result));
            number1=result;
        }
        if(e.getSource()==clearButton){
            textField.setText("");
        }
        if(e.getSource()==deleteButton){
            String string= textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negativeButton){
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
            }


    }
}
