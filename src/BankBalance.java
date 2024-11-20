import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalance extends JFrame implements ActionListener {
    private JLabel addAccountLabel;
    private JLabel balanceLabel;
    private JLabel depositLabel;
    private JLabel withdrawLabel;
    private JTextField addAccountField;
    private JTextField balanceField;
    private JTextField depositField;
    private JTextField withdrawField;
    private JButton submit;
    private JButton reset;

    private double balance;

    BankBalance() {

        GridBagConstraints layoutConst = null;

        setTitle("Bank Account");

        addAccountLabel = new JLabel("Enter Bank Balance:");
        depositLabel = new JLabel("Deposit:");
        withdrawLabel = new JLabel("Withdraw:");
        balanceLabel = new JLabel("Bank Balance:");

        addAccountField = new JTextField(15);
        addAccountField.setEditable(true);
        addAccountField.setText("0");

        depositField = new JTextField(15);
        depositField.setEditable(true);
        depositField.setText("0");

        withdrawField = new JTextField(15);
        withdrawField.setEditable(true);
        withdrawField.setText("0");

        balanceField = new JTextField(15);
        balanceField.setEditable(false);
        balanceField.setText("0");

        submit = new JButton("Submit");
        submit.addActionListener(this);

        reset = new JButton("Reset");
        reset.addActionListener(this);

        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();

        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(addAccountLabel, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(addAccountField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(depositLabel, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(depositField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(withdrawLabel, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(withdrawField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(balanceLabel, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(balanceField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(submit, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(reset, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String userInputStartingBalance;
            double startingBalance;
            String userDeposit;
            double deposit;
            String userWithdraw;
            double withdraw;

            userInputStartingBalance = addAccountField.getText();
            startingBalance = Double.parseDouble(userInputStartingBalance);

            userDeposit = depositField.getText();
            deposit = Double.parseDouble(userDeposit);

            userWithdraw = withdrawField.getText();
            withdraw = Double.parseDouble(userWithdraw);

            balance += startingBalance + deposit - withdraw;
            balanceField.setText(Double.toString(balance));

            addAccountField.setText("0");
            depositField.setText("0");
            withdrawField.setText("0");
        } else if (e.getSource() == reset) {
            addAccountField.setText("0");
            depositField.setText("0");
            withdrawField.setText("0");
            balanceField.setText("0");
            balance = 0;
        }
    }
}
