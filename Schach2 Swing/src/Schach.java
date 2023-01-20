import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Schach implements ActionListener {
    JFrame frame = new JFrame();

    JPanel title_panel = new JPanel();

    JPanel Button_panel = new JPanel();

    JLabel textfield1 = new JLabel();

    int Turn = 0;
    int a = 8;
    int posx = 0;
    int posy = 0;
    boolean Gegner = false;
    JButton[][] buttons = new JButton[a][a];

    boolean Player1_turn;

    int Winner = 0;
    int[] Position = new int[2];

    Random random = new Random();

    int[][] Statusfeld = new int[buttons.length][buttons.length];
    int[][] firstTurnfeld = new int[buttons.length][buttons.length];

    Schach() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Schach in Java");

        textfield1.setBackground(new Color(58, 58, 58));
        textfield1.setForeground(new Color(0, 255, 255));
        textfield1.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield1.setHorizontalAlignment(JLabel.CENTER);

        textfield1.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 1000, 100);
        Button_panel.setBackground(new Color(122, 118, 118));
        Button_panel.setLayout(new GridLayout(a, a));

        Spielfeld();

    }


    public void Spielfeld() {
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                Statusfeld[y][x] = 0;
                buttons[y][x] = new JButton();
                buttons[y][x].setForeground(new Color(198, 0, 255));
                buttons[y][x].setText("");
                if ((y + x) % 2 == 0) {
                    buttons[y][x].setBackground(new Color(160, 0, 0));
                } else {
                    buttons[y][x].setBackground(new Color(0, 15, 152));
                }
                Button_panel.add(buttons[y][x]);
                buttons[y][x].setFont(new Font("Algerian", Font.BOLD, 120));
                buttons[y][x].setFocusable(false);
                buttons[y][x].addActionListener(this);

                if (y == 0 && x == 0) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("T");
                    Statusfeld[y][x] = 1;
                }
                if (y == 0 && x == 7) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("T");
                    Statusfeld[y][x] = 1;
                }
                if (y == 0 && x == 1) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("B");
                    Statusfeld[y][x] = 2;
                }
                if (y == 0 && x == 6) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("B");
                    Statusfeld[y][x] = 2;
                }
                if (y == 0 && x == 2) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("P");
                    Statusfeld[y][x] = 3;
                }
                if (y == 0 && x == 5) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("P");
                    Statusfeld[y][x] = 3;
                }
                if (y == 0 && x == 3) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("Q");
                    Statusfeld[y][x] = 4;
                }
                if (y == 0 && x == 4) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("K");
                    Statusfeld[y][x] = 5;
                }
                if (y == 1) {
                    buttons[y][x].setForeground(new Color(255, 255, 255));
                    buttons[y][x].setText("I");
                    firstTurnfeld[y][x] = 1;
                    Statusfeld[y][x] = 6;
                }

                if (y == a - 1 && x == 0) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("T");
                    Statusfeld[y][x] = 1;
                }
                if (y == a - 1 && x == 7) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("T");
                    Statusfeld[y][x] = 1;
                }
                if (y == a - 1 && x == 1) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("B");
                    Statusfeld[y][x] = 2;
                }
                if (y == a - 1 && x == 6) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("B");
                    Statusfeld[y][x] = 2;
                }
                if (y == a - 1 && x == 2) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("P");
                    Statusfeld[y][x] = 3;
                }
                if (y == a - 1 && x == 5) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("P");
                    Statusfeld[y][x] = 3;
                }
                if (y == a - 1 && x == 3) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("Q");
                    Statusfeld[y][x] = 4;
                }
                if (y == a - 1 && x == 4) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("K");
                    Statusfeld[y][x] = 5;
                }
                if (y == a - 2) {
                    buttons[y][x].setForeground(new Color(0, 0, 0));
                    buttons[y][x].setText("I");
                    Statusfeld[y][x] = 6;
                    firstTurnfeld[y][x] = 1;
                }

            }


            title_panel.add(textfield1);
            frame.add(title_panel, BorderLayout.NORTH);
            frame.add(Button_panel);
            firstTurn();
        }
    }

    public void firstTurn() {
        if (random.nextInt(2) == 1) {
            Player1_turn = true;
            textfield1.setText("Weiß Zug");
        } else {
            Player1_turn = false;
            textfield1.setText("Schwarz Zug");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                if (e.getSource() == buttons[y][x]) {
                    if (Turn == 0) {
                        Position[0] = y;
                        Position[1] = x;
                    }
                    if (Turn == 1 || Objects.equals(buttons[y][x].getText(), "")) {
                        System.out.println("Kordinate " + (y + 1) + "," + (x + 1));
                    } else {
                        System.out.print("Kordinate " + (y + 1) + "," + (x + 1) + " = ");
                    }
                    if (Turn == 1) {

                        if (!Objects.equals(buttons[y][x].getBackground(), new Color(0, 255, 4))) {
                            Turn = 0;
                            for (int a = 0; a < buttons.length; a++) {
                                for (int b = 0; b < buttons.length; b++) {
                                    if ((a + b) % 2 == 0) {
                                        buttons[a][b].setBackground(new Color(160, 0, 0));
                                    } else {
                                        buttons[a][b].setBackground(new Color(0, 15, 152));
                                    }
                                }
                            }
                            return;
                        }
                        firstTurnfeld[y][x] = 0;
                    }

                    if (Player1_turn) {
                        if (Objects.equals(buttons[y][x].getBackground(), new Color(0, 255, 4))) {
                            Turn++;
                            Statusfeld[y][x] = Statusfeld[Position[0]][Position[1]];
                            buttons[Position[0]][Position[1]].setForeground(new Color(198, 0, 255));
                            if (Objects.equals(buttons[y][x].getText(), "K") && Objects.equals(buttons[y][x].getBackground(), new Color(0, 255, 4))) {
                                Winner = 1;
                            }
                            switch (Statusfeld[Position[0]][Position[1]]) {
                                case 1:
                                    buttons[y][x].setForeground(new Color(255, 255, 255));
                                    buttons[y][x].setText("T");
                                    break;
                                case 2:
                                    buttons[y][x].setForeground(new Color(255, 255, 255));
                                    buttons[y][x].setText("B");
                                    break;
                                case 3:
                                    buttons[y][x].setForeground(new Color(255, 255, 255));
                                    buttons[y][x].setText("P");
                                    break;
                                case 4:
                                    buttons[y][x].setForeground(new Color(255, 255, 255));
                                    buttons[y][x].setText("Q");
                                    break;
                                case 5:
                                    buttons[y][x].setForeground(new Color(255, 255, 255));
                                    buttons[y][x].setText("K");
                                    break;
                                case 6:
                                    buttons[y][x].setForeground(new Color(255, 255, 255));
                                    buttons[y][x].setText("I");
                                    if (y == 7) {
                                        buttons[y][x].setText("Q");
                                        Statusfeld[y][x] = 4;
                                    }
                                    break;
                            }
                            buttons[Position[0]][Position[1]].setText("");
                            firstTurnfeld[Position[0]][Position[1]] = 0;
                            Statusfeld[Position[0]][Position[1]] = 0;
                            for (int a = 0; a < buttons.length; a++) {
                                for (int b = 0; b < buttons.length; b++) {
                                    if ((a + b) % 2 == 0) {
                                        buttons[a][b].setBackground(new Color(160, 0, 0));
                                    } else {
                                        buttons[a][b].setBackground(new Color(0, 15, 152));
                                    }
                                }
                            }
                            if (Winner == 1) {
                                check();
                                return;
                            }
                            Player1_turn = false;
                            textfield1.setText("Schwarz Zug");
                            Turn = 0;
                        }
                    } else {
                        if (Objects.equals(buttons[y][x].getBackground(), new Color(0, 255, 4))) {
                            Statusfeld[y][x] = Statusfeld[Position[0]][Position[1]];
                            buttons[Position[0]][Position[1]].setForeground(new Color(198, 0, 255));
                            if (Objects.equals(buttons[y][x].getText(), "K") && Objects.equals(buttons[y][x].getBackground(), new Color(0, 255, 4))) {
                                Winner = 1;
                            }
                            switch (Statusfeld[Position[0]][Position[1]]) {
                                case 1:
                                    buttons[y][x].setForeground(new Color(0, 0, 0));
                                    buttons[y][x].setText("T");
                                    break;
                                case 2:
                                    buttons[y][x].setForeground(new Color(0, 0, 0));
                                    buttons[y][x].setText("B");
                                    break;
                                case 3:
                                    buttons[y][x].setForeground(new Color(0, 0, 0));
                                    buttons[y][x].setText("P");
                                    break;
                                case 4:
                                    buttons[y][x].setForeground(new Color(0, 0, 0));
                                    buttons[y][x].setText("Q");
                                    break;
                                case 5:
                                    buttons[y][x].setForeground(new Color(0, 0, 0));
                                    buttons[y][x].setText("K");
                                    break;
                                case 6:
                                    buttons[y][x].setForeground(new Color(0, 0, 0));
                                    buttons[y][x].setText("I");
                                    if (y == 0) {
                                        buttons[y][x].setText("Q");
                                        Statusfeld[y][x] = 4;
                                    }
                                    break;
                            }
                            buttons[Position[0]][Position[1]].setText("");
                            firstTurnfeld[Position[0]][Position[1]] = 0;
                            Statusfeld[Position[0]][Position[1]] = 0;
                            for (int a = 0; a < buttons.length; a++) {
                                for (int b = 0; b < buttons.length; b++) {
                                    if ((a + b) % 2 == 0) {
                                        buttons[a][b].setBackground(new Color(160, 0, 0));
                                    } else {
                                        buttons[a][b].setBackground(new Color(0, 15, 152));
                                    }
                                }
                            }
                            if (Winner == 1) {
                                check();
                                return;
                            }
                            Player1_turn = true;
                            textfield1.setText("Weiß Zug");
                            Turn = 0;
                        }
                    }

                    if (Player1_turn) {
                        Move();
                        Position[0] = y;
                        Position[1] = x;
                        if (Turn == 2) {
                            for (int a = 0; a < buttons.length; a++) {
                                for (int b = 0; b < buttons.length; b++) {
                                    if ((a + b) % 2 == 0) {
                                        buttons[a][b].setBackground(new Color(160, 0, 0));
                                    } else {
                                        buttons[a][b].setBackground(new Color(0, 15, 152));
                                    }
                                }
                            }
                            Player1_turn = false;
                            textfield1.setText("Schwarz Zug");
                            Turn = 0;
                        }
                    } else {
                        Move();
                        Position[0] = y;
                        Position[1] = x;
                        if (Turn == 2) {
                            for (int a = 0; a < buttons.length; a++) {
                                for (int b = 0; b < buttons.length; b++) {
                                    if ((a + b) % 2 == 0) {
                                        buttons[a][b].setBackground(new Color(160, 0, 0));
                                    } else {
                                        buttons[a][b].setBackground(new Color(0, 15, 152));
                                    }
                                }
                            }
                            Player1_turn = true;
                            textfield1.setText("Weiß Zug");
                            Turn = 0;
                        }
                    }
                }
            }
        }
    }


    public void Move() {
        Turn++;
        switch (Statusfeld[Position[0]][Position[1]]) {
            case 0:
                Turn = 0;
                break;
            case 1:
                Rook();
                break;
            case 2:
                Bishop();
                break;
            case 3:
                Knight();
                break;
            case 4:
                Queen();
                break;
            case 5:
                King();
                break;
            case 6:
                Pawn();
                break;
        }

    }

    public void King() {
        System.out.println("King");
        if (Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            if (Position[1] == 0 && Position[0] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 7 && Position[0] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 0 && Position[0] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 7 && Position[0] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            return;
        }

        if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(0, 0, 0))) {
            System.out.println("Fehler");
            Turn = 0;
            return;
        }
        if (Position[1] == 0 && Position[0] == 0) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[1] == 7 && Position[0] == 7) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[1] == 0 && Position[0] == 7) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[1] == 7 && Position[0] == 0) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[0] == 7) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[0] == 0) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[1] == 0) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[1] == 7) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0]][Position[1]-1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0]][Position[1]-1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (!Objects.equals(buttons[Position[0] + 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0] - 1][Position[1]].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0]][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0]][Position[1] - 1].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0]][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0]][Position[1] + 1].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
        }
        if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
            buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
        }
        buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));

    }

    public void Rook() {
        Gegner = false;
        posx = 0;
        posy = 0;
        System.out.println("Rook");
        if (Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }

            if (Position[1] == 0) {
                while (!Gegner) {
                    posx++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posx++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[1] != 7 && Position[1] != 0) {
                while (!Gegner) {
                    posx++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
                Gegner = false;
                posx = 0;
                while (!Gegner) {
                    posx++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            if (Position[0] != 7 && Position[0] != 0) {
                while (!Gegner) {
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
                Gegner = false;
                posy = 0;
                while (!Gegner) {
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

        }


        if (!Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(0, 0, 0))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }

            if (Position[1] == 0) {
                while (!Gegner) {
                    posx++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posx++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[1] != 7 && Position[1] != 0) {
                while (!Gegner) {
                    posx++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
                Gegner = false;
                posx = 0;
                while (!Gegner) {
                    posx++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            Gegner = false;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            if (Position[0] != 7 && Position[0] != 0) {
                while (!Gegner) {
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        }
                    } else {
                        Gegner = true;
                    }
                }
                Gegner = false;
                posy = 0;
                while (!Gegner) {
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
        }
        buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
    }

    public void Queen() {
        posx = 0;
        posy = 0;
        Gegner = false;
        System.out.println("Queen");
        if (Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }


            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }

            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] + posy <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[0] - posy >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            posx = 0;
            posy = 0;
            Gegner = false;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posx++;
                    posy++;
                    if (Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
        }



        if (!Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(0, 0, 0))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[0] == 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] + posy <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[0] == 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[0] == 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[0] == 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                                buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[0] == 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                                buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[0] == 7) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] - posy >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[0] == 7) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[0] == 7) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[0] == 7) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                                buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[0] == 7) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                                buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }


                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] == 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] + posy <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] == 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] == 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] - posy >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] == 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                                buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] == 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                                buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }

                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] == 7) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] + posy <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] == 7) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] - posy >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] == 7) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] == 7) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                                buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] == 7) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                                buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }

                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] + posy <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1]] == 0) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[0] - posy >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1]] == 0) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1]].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1]].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0]][Position[1] - posx] == 0) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                posx = 0;
                posy = 0;
                Gegner = false;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posx++;
                        posy++;
                        if (Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0]][Position[1] + posx] == 0) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0]][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0]][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                                buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                                buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                            if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                                buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
                Gegner = false;
                posy = 0;
                posx = 0;
                if (Position[1] != 7&&Position[0] != 7&&Position[1] != 0&&Position[0] != 0) {
                    while (!Gegner) {
                        posy++;
                        posx++;
                        if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                            if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                                buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            } else {
                                Gegner = true;
                            }
                            if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                                buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                                Gegner = true;
                            } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                                Gegner = true;
                            }
                        } else {
                            Gegner = true;
                        }
                    }
                }
        }
        buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
    }

    public void Pawn() {
        System.out.println("Pawn");
        int a = 0;
        if (firstTurnfeld[Position[0]][Position[1]] == 1) {
            a = 1;
        }
        if (Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            if (Position[1] == 0 && Position[0] == 0) {
                Turn = 0;
                return;
            }
            if (Position[1] == 7 && Position[0] == 0) {
                Turn = 0;
                return;
            }
            if (Position[1] == 7 && Position[0] == 7) {
                Turn = 0;
                return;
            }
            if (Position[1] == 0 && Position[0] == 7) {
                Turn = 0;
                return;
            }
            if (Position[0] == 7) {
                Turn = 0;
                return;
            }
            if (Position[0] == 0) {
                Turn = 0;
                return;
            }
            if (Position[1] != 0 && Position[1] != 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (Objects.equals(buttons[Position[0] + 1][Position[1]].getText(), "")) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                    if (Objects.equals(buttons[Position[0] + 1 + a][Position[1]].getText(), "")) {
                        buttons[Position[0] + 1 + a][Position[1]].setBackground(new Color(0, 255, 4));
                    }
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(255, 255, 255)) &&
                        !Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getText(), "")) {
                    buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(255, 255, 255)) &&
                        !Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getText(), "")) {
                    buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (Objects.equals(buttons[Position[0] + 1][Position[1]].getText(), "")) {
                    buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                    if (Objects.equals(buttons[Position[0] + 1 + a][Position[1]].getText(), "")) {
                        buttons[Position[0] + 1 + a][Position[1]].setBackground(new Color(0, 255, 4));
                    }
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getForeground(), new Color(255, 255, 255)) &&
                        !Objects.equals(buttons[Position[0] + 1][Position[1] + 1].getText(), "")) {
                    buttons[Position[0] + 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (Objects.equals(buttons[Position[0] + 1][Position[1]].getText(), "")) {
                buttons[Position[0] + 1][Position[1]].setBackground(new Color(0, 255, 4));
                if (Objects.equals(buttons[Position[0] + 1 + a][Position[1]].getText(), "")) {
                    buttons[Position[0] + 1 + a][Position[1]].setBackground(new Color(0, 255, 4));
                }
            }

            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getForeground(), new Color(255, 255, 255)) &&
                    !Objects.equals(buttons[Position[0] + 1][Position[1] - 1].getText(), "")) {
                buttons[Position[0] + 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(0, 0, 0))) {
            System.out.println("Fehler");
            Turn = 0;
            return;
        }
        if (Position[1] == 0 && Position[0] == 0) {
            Turn = 0;
            return;
        }
        if (Position[1] == 7 && Position[0] == 0) {
            Turn = 0;
            return;
        }
        if (Position[1] == 7 && Position[0] == 7) {
            Turn = 0;
            return;
        }
        if (Position[0] == 7) {
            Turn = 0;
            return;
        }
        if (Position[0] == 0) {
            Turn = 0;
            return;
        }
        if (Position[1] != 0 && Position[1] != 7) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (Objects.equals(buttons[Position[0] - 1][Position[1]].getText(), "")) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                if (Objects.equals(buttons[Position[0] - 1 - a][Position[1]].getText(), "")) {
                    buttons[Position[0] - 1 - a][Position[1]].setBackground(new Color(0, 255, 4));
                }
            }

            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(0, 0, 0)) &&
                    !Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getText(), "")) {
                buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(0, 0, 0)) &&
                    !Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getText(), "")) {
                buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        if (Position[1] == 0) {
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (Objects.equals(buttons[Position[0] - 1][Position[1]].getText(), "")) {
                buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
                if (Objects.equals(buttons[Position[0] - 1 - a][Position[1]].getText(), "")) {
                    buttons[Position[0] - 1 - a][Position[1]].setBackground(new Color(0, 255, 4));
                }
            }

            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getForeground(), new Color(0, 0, 0)) &&
                    !Objects.equals(buttons[Position[0] - 1][Position[1] + 1].getText(), "")) {
                buttons[Position[0] - 1][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            return;
        }
        buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
        if (Objects.equals(buttons[Position[0] - 1][Position[1]].getText(), "")) {
            buttons[Position[0] - 1][Position[1]].setBackground(new Color(0, 255, 4));
            if (Objects.equals(buttons[Position[0] - 1 - a][Position[1]].getText(), "")) {
                buttons[Position[0] - 1 - a][Position[1]].setBackground(new Color(0, 255, 4));
            }
        }

        if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getForeground(), new Color(0, 0, 0)) &&
                !Objects.equals(buttons[Position[0] - 1][Position[1] - 1].getText(), "")) {
            buttons[Position[0] - 1][Position[1] - 1].setBackground(new Color(0, 255, 4));
        }
    }

    public void Knight() {
        System.out.println("Knight");
        if (Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            if (Position[0] == 0 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getText(), "")) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(255, 255, 255))) {
                buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
            }
        }
        if (!Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(0, 0, 0))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            if (Position[0] == 0 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getText(), "")) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6 && Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1 && Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(9, 9, 9))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 0) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 7) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[0] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 1) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }
            if (Position[1] == 6) {
                buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
                }
                if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                    buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
                }
                return;
            }

            buttons[Position[0]][Position[1]].setBackground(new Color(0, 255, 5));
            if (!Objects.equals(buttons[Position[0] - 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] + 2].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] + 2].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 2][Position[1] + 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 2][Position[1] + 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 2][Position[1] - 1].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 2][Position[1] - 1].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] - 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] - 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
            }
            if (!Objects.equals(buttons[Position[0] + 1][Position[1] - 2].getForeground(), new Color(0, 0, 0))) {
                buttons[Position[0] + 1][Position[1] - 2].setBackground(new Color(0, 255, 4));
            }
        }

    }


    public void Bishop() {
        posx = 0;
        posy = 0;
        Gegner = false;
        System.out.println("Bishop");
        if (Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(255, 255, 255))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
        }


        if (!Player1_turn) {
            if (!Objects.equals(buttons[Position[0]][Position[1]].getForeground(), new Color(0, 0, 0))) {
                System.out.println("Fehler");
                Turn = 0;
                return;
            }
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[0] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 0) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] == 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] + posy][Position[1] + posx] == 0) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] + posy <= 7 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] + posy][Position[1] - posx] == 0) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] + posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] + posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] - posx >= 0) {
                        if (Statusfeld[Position[0] - posy][Position[1] - posx] == 0) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] - posy][Position[1] - posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] - posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
            Gegner = false;
            posy = 0;
            posx = 0;
            if (Position[1] != 7 && Position[1] != 0 && Position[0] != 0 && Position[0] != 7) {
                while (!Gegner) {
                    posy++;
                    posx++;
                    if (Position[0] - posy >= 0 && Position[1] + posx <= 7) {
                        if (Statusfeld[Position[0] - posy][Position[1] + posx] == 0) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                        } else {
                            Gegner = true;
                        }
                        if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(255, 255, 255))) {
                            buttons[Position[0] - posy][Position[1] + posx].setBackground(new Color(0, 255, 4));
                            Gegner = true;
                        } else if (Objects.equals(buttons[Position[0] - posy][Position[1] + posx].getForeground(), new Color(0, 0, 0))) {
                            Gegner = true;
                        }
                    } else {
                        Gegner = true;
                    }
                }
            }
        }

        buttons[Position[0]][Position[1]].

                setBackground(new Color(0, 255, 5));
    }

    public void check() {
        if (Player1_turn) {
            textfield1.setText("Schwarz hat gewonnen");
        } else {
            textfield1.setText("Schwarz hat gewonnen");
        }
    }
}
