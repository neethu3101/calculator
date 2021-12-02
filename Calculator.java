//GUI calculator
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Calculator extends JFrame implements ActionListener{
  JTextField io;
  JButton zero,one,two,three,four,five,six,seven,eight,nine,
                        plus,minus,multi,divide,mod,result,decpoint,clear;
  JPanel buttons;
  Calculator(){
    super("Calculator");
    setSize(300,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    zero = new JButton("0");
    one = new JButton("1");
    two = new JButton("2");
    three = new JButton("3");
    four = new JButton("4");
    five = new JButton("5");
    six = new JButton("6");
    seven = new JButton("7");
    eight = new JButton("8");
    nine = new JButton("9");
    plus = new JButton("+");
    minus = new JButton("-");
    multi = new JButton("*");
    divide = new JButton("/");
    mod = new JButton("%");
    result = new JButton("=");
    decpoint = new JButton(".");
    clear = new JButton("C");
    io = new JTextField(10);
    buttons = new JPanel();

    buttons.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx=0;
    gbc.gridy =0;
    gbc.gridwidth =4;
    gbc.fill =GridBagConstraints.HORIZONTAL;
    buttons.add(io,gbc);

    gbc.gridy =1;
    gbc.gridx =0;
    gbc.gridwidth = 1;
    gbc.insets =new Insets(10,10,10,10);
    buttons.add(mod,gbc);
    gbc.gridx =1;
    buttons.add(divide,gbc);
    gbc.gridx =2;
    buttons.add(multi,gbc);
    gbc.gridx =3;
    buttons.add(clear,gbc);
    gbc.gridx =0;
    gbc.gridy =2;
    buttons.add(seven,gbc);
    gbc.gridx =1;
    buttons.add(eight,gbc);
    gbc.gridx =2;
    buttons.add(nine,gbc);
    gbc.gridx =3;
    buttons.add(minus,gbc);
    gbc.gridx =0;
    gbc.gridy =3;
    buttons.add(four,gbc);
    gbc.gridx =1;
    buttons.add(five,gbc);
    gbc.gridx =2;
    buttons.add(six,gbc);
    gbc.gridx =3;
    gbc.gridheight = 2;
    gbc.fill = GridBagConstraints.VERTICAL;
    buttons.add(plus,gbc);
    gbc.fill = GridBagConstraints.NONE;
    gbc.gridx =0;
    gbc.gridy =4;
    gbc.gridheight =1;
    buttons.add(one,gbc);
    gbc.gridx =1;
    buttons.add(two,gbc);
    gbc.gridx =2;
    buttons.add(three,gbc);
    gbc.gridx =0;
    gbc.gridy =5;
    buttons.add(decpoint,gbc);
    gbc.gridx = 1;
    buttons.add(zero,gbc);
    gbc.gridwidth = 2;
    gbc.gridx =2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    buttons.add(result,gbc);

    add(buttons);

    zero.addActionListener(this);
    one.addActionListener(this);
    two.addActionListener(this);
    three.addActionListener(this);
    four.addActionListener(this);
    five.addActionListener(this);
    six.addActionListener(this);
    seven.addActionListener(this);
    eight.addActionListener(this);
    nine.addActionListener(this);
    plus.addActionListener(this);
    minus.addActionListener(this);
    multi.addActionListener(this);
    divide.addActionListener(this);
    mod.addActionListener(this);
    result.addActionListener(this);
    decpoint.addActionListener(this);
    clear.addActionListener(this);

  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == zero){
      io.setText(io.getText()+"0");
    }
    else if(ae.getSource() == one){
      io.setText(io.getText()+"1");
    }
    else if(ae.getSource() == two){
      io.setText(io.getText()+"2");
    }
    else if(ae.getSource() == three){
      io.setText(io.getText()+"3");
    }
    else if(ae.getSource() == four){
      io.setText(io.getText()+"4");
    }
    else if(ae.getSource() == five){
      io.setText(io.getText()+"5");
    }
    else if(ae.getSource() == six){
      io.setText(io.getText()+"6");
    }
    else if(ae.getSource() == seven){
      io.setText(io.getText()+"7");
    }
    else if(ae.getSource() == eight){
      io.setText(io.getText()+"8");
    }
    else if(ae.getSource() == nine){
      io.setText(io.getText()+"9");
    }
    else if(ae.getSource() == plus){
      io.setText(io.getText()+"+");
    }
    else if(ae.getSource() == minus){
      io.setText(io.getText()+"-");
    }
    else if(ae.getSource() == multi){
      io.setText(io.getText()+"*");
    }
    else if(ae.getSource() == clear){
      io.setText("");
    }
    else if(ae.getSource() == divide){
      io.setText(io.getText()+"/");
    }
    else if(ae.getSource() == mod){
      io.setText(io.getText()+"%");
    }
    else if(ae.getSource() == decpoint){
      io.setText(io.getText()+".");
    }
    else if(ae.getSource() == result){
      int r;
      String operator="";
      try{
      String str[] =  io.getText().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
      r = Integer.parseInt(str[0]);
      for(int i=1;i<str.length;i++){
        if(i%2==0){
          switch(operator){
            case "+":r= r+(Integer.parseInt(str[i]));
                      break;
            case "-":r = r-(Integer.parseInt(str[i]));
                    break;
            case "*":r = r*(Integer.parseInt(str[i]));
                      break;
            case "/":r = r/(Integer.parseInt(str[i]));
                      break;
            case "%":r = r% (Integer.parseInt(str[i]));
          }
        }
        else{
          operator = str[i];
        }
      }
      io.setText(r+"");
    }catch(ArithmeticException a){
      io.setText("Error!");
    }
    catch(NumberFormatException nfe){
      io.setText("Error!");
    }

    }

  }
  public static void main(String args[]){
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Calculator();
      }
    });
  }
}
