package com.yrw.test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Calculater extends JFrame implements ActionListener {
    JTextField x;
    String preOperater = "";
    double sum = 0;

    public Calculater(String title) {
        super(title);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        x = new JTextField(50);
        c.add("North", x);
        String buttoned[] = {"0", "1", "2", "3", "+/-", ".", "C", "退格", "求倒",
                "4", "5", "6", "7", "+", "-", "*", "/", "%", "8", "9", "=",
                "sqrt", "pow", "log", "cos", "tan", "exp"};
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 9, 10, 10));
        for (int k = 0; k < buttoned.length; k++) {
            JButton b = new JButton(buttoned[k]);
            p.add(b);
            b.addActionListener(this);
            c.add("Center", p);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String Command = e.getActionCommand();
        try {
            if (Character.isDigit(Command.charAt(0))) {
                x.setText(x.getText() + Command);
            } else if (Command.equals(".")) {
                xiaoshu();
            } else if (Command.equals("+/-")) {
                fuhao();
            } else if (Command.equals("退格")) {
                backspace();
            } else if (Command.equals("=")) {
                x.setText(x.getText() + Command);
                dengyu();
            } else if (Command.equals("sqrt")) {
                sqrt();
            } else if (Command.equals("log")) {
                log();
            } else if (Command.equals("cos")) {
                cos();
            } else if (Command.equals("tan")) {
                tan();
            } else if (Command.equals("exp")) {
                exp();
            } else if (Command.equals("求倒")) {
                qiudao();
            } else if (Command.equals("C")) {
                clear();
            } else if (Command.equals("+")) {
                x.setText(x.getText() + Command);
            }
            else {
                doOperation();
                tText("");
                preOperater = Command;
            }
        } catch (Exception ex) {
            sum = 0;
            x.setText("");
            throw new RuntimeException(ex);
        }
    }



    private void tText(String string) {
        // TODO Auto-generated method stub

    }

    void xiaoshu() {
        String s = x.getText();
        if (s.indexOf(".") == -1)
            x.setText(s + ".");

    }

    void fuhao() {
        String s = x.getText();
    }

    void backspace() {
        String s = x.getText();
        if (s.length() > 0)
            x.setText(s.substring(0, s.length() - 1));
    }

    void dengyu() {
        doOperation();
        x.setText("" + sum);
        preOperater = "";
    }

    void sqrt() {
        double m = Double.parseDouble(x.getText());
        if (m < 0)
            x.setText("负数不能开根号");

        else
            x.setText("" + Math.sqrt(m));
    }

    void log() {
        double m = Double.parseDouble(x.getText());
        if (m < 0)
            x.setText("负数不能进行自然对数运算");
        else
            x.setText("" + Math.log(m));
    }

    void cos() {
        double m = Double.parseDouble(x.getText());
        x.setText("" + Math.cos(m));
    }

    void tan() {
        double m = Double.parseDouble(x.getText());
        x.setText("" + Math.tan(m));
    }

    void exp() {
        double m = Double.parseDouble(x.getText());
        x.setText("" + Math.exp(m));
    }


    void qiudao() {
        if (Double.parseDouble(x.getText()) == 0) {
            x.setText("除数不能为零");
        } else {
            x.setText("" + 1 / (Double.parseDouble(x.getText())));
            preOperater = "";
        }
    }


    void clear() {
        sum = 0;
        x.setText("");
        preOperater = "";
    }


    void doOperation() {
        double m = Double.parseDouble(x.getText());
        if (preOperater.equals("")) sum = m;
        if (preOperater.equals("+")) sum = sum + m;
        if (preOperater.equals("-")) sum = sum - m;
        if (preOperater.equals("*")) sum = sum * m;
        if (preOperater.equals("/")) sum = sum / m;
        if (preOperater.equals("%")) sum = sum % m;
        if (preOperater.equals("pow")) sum = Math.pow(sum, m);
    }

    public static void main(String a[]) {
        JFrame x = new Calculater("计算器");
        x.setSize(650, 300);
        x.setVisible(true);
    }
}
