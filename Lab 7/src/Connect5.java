import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.util.*;

public class Connect5 extends JFrame implements ActionListener {

	static JFrame myframe = new Connect5();
	JPanel settingpanel, droppanel, boardpanel;
	JButton[] dropbtn, setbtn;
	JButton[][] gameboard;
	JLabel start, empty, uturn, cturn, ut;
	JMenu grid, color;
	JMenuItem[] size, ucolor;
	static JMenuBar mb;

	File history = new File("C:\\Users\\noriss\\Documents\\Brunel\\NC1601\\connect5_history.txt");

	int row = 7, col = 8, last_color = 0, last_size = 2;
	// static int frame_width=650,frame_height=550;
	static int panel_width = 650, panel_height = 550;
	int order, user_turn, comp_turn, i, j, user = 1, comp = 2;
	int[] c_head;
	int[][] board;

	Color choose_color = Color.cyan;
	Color comp_color = Color.pink;

	public Connect5() {
		// create menu bar
		mb = new JMenuBar();
		grid = new JMenu("Size");
		color = new JMenu("Color");

		// size option
		size = new JMenuItem[3];
		size[0] = new JMenuItem("5x6");
		size[1] = new JMenuItem("6x7");
		size[2] = new JMenuItem("7x8");

		// color option
		ucolor = new JMenuItem[3];
		ucolor[0] = new JMenuItem("Blue");
		ucolor[1] = new JMenuItem("Grey");
		ucolor[2] = new JMenuItem("Yellow");

		for (i = 0; i < 3; i++) {
			grid.add(size[i]);
			color.add(ucolor[i]);
			size[i].addActionListener(this);
			ucolor[i].addActionListener(this);
		}
		// color.add(a)
		mb.add(grid);
		mb.add(color);

		// constructor creates panel
		// 7row*8columns
		c_head = new int[col];
		board = new int[row][col];

		// setting
		settingpanel = new JPanel();
		settingpanel.setPreferredSize(new Dimension(120, 400));
		add(settingpanel, BorderLayout.WEST);
		start = new JLabel("Start: ");
		// start.setHorizontalAlignment(alignment);
		settingpanel.add(start);
		setbtn = new JButton[5];
		setbtn[0] = new JButton("User");
		setbtn[1] = new JButton("Computer");
		empty = new JLabel("       		            ");
		setbtn[2] = new JButton("Pause");
		setbtn[3] = new JButton("Restore");
		setbtn[4] = new JButton("Reset");
		uturn = new JLabel("User Turn:   " + user_turn);
		cturn = new JLabel("Comp Turn: " + comp_turn);

		for (i = 0; i < 5; i++) {
			setbtn[i].setPreferredSize(new Dimension(105, 30));
			setbtn[i].addActionListener(this);
			if (i == 2) {
				settingpanel.add(uturn);
				settingpanel.add(cturn);
				settingpanel.add(empty);
			}
			settingpanel.add(setbtn[i]);
		}

		// drop
		droppanel = new JPanel();
		add(droppanel, BorderLayout.NORTH);
		empty = new JLabel("                                  ");
		droppanel.add(empty);
		dropbtn = new JButton[col];
		for (i = 0; i < col; i++) {
			dropbtn[i] = new JButton("V");
			dropbtn[i].setPreferredSize(new Dimension(55, 30));
			dropbtn[i].setBackground(Color.white);
			dropbtn[i].addActionListener(this);
			droppanel.add(dropbtn[i]);
		}

		// gameboard
		boardpanel = new JPanel();
		add(boardpanel, BorderLayout.CENTER);
		gameboard = new JButton[row][col];
		for (i = row - 1; i >= 0; i--) {
			for (j = 0; j < col; j++) {
				gameboard[i][j] = new JButton("");
				gameboard[i][j].setPreferredSize(new Dimension(55, 55));
				gameboard[i][j].setAction(null);
				gameboard[i][j].setBorder(new LineBorder(Color.gray));
				boardpanel.add(gameboard[i][j]);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == size[0]) {
			reset();
			row = 5;
			col = 6;
			setgrid(row, col);
			myframe.setSize(550, 450);
			last_size = 0;
		}

		if (e.getSource() == size[1]) {
			reset();
			row = 6;
			col = 7;
			setgrid(row, col);
			myframe.setSize(600, 500);
			last_size = 1;
		}

		if (e.getSource() == size[2]) {
			reset();
			row = 7;
			col = 8;
			setgrid(row, col);
			myframe.setSize(650, 550);
			last_size = 2;

		}

		if (e.getSource() == ucolor[0]) {
			choose_color = Color.cyan;
			last_color = 0;
			for (int i = row - 1; i >= 0; i--) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 1) {
						gameboard[i][j].setBackground(choose_color);
					}
				}
			}
		}

		if (e.getSource() == ucolor[1]) {
			choose_color = Color.LIGHT_GRAY;
			last_color = 1;
			for (int i = row - 1; i >= 0; i--) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 1) {
						gameboard[i][j].setBackground(choose_color);
					}
				}
			}
		}

		if (e.getSource() == ucolor[2]) {
			choose_color = Color.yellow;
			last_color = 2;
			for (int i = row - 1; i >= 0; i--) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 1) {
						gameboard[i][j].setBackground(choose_color);
					}
				}
			}
		}

		if (e.getSource() == dropbtn[0]) {
			user_drop(0);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[1]) {
			user_drop(1);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[2]) {
			user_drop(2);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[3]) {
			user_drop(3);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[4]) {
			user_drop(4);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[5]) {
			user_drop(5);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[6]) {
			user_drop(6);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == dropbtn[7]) {
			user_drop(7);
			if (!check_win(user)) {
				comp_drop();
				check_win(comp);
			}
		}

		if (e.getSource() == setbtn[0]) {
			// gameboard[0][0].setBackground(Color.red);
		}

		if (e.getSource() == setbtn[1]) {
			comp_drop();
		}

		if (e.getSource() == setbtn[2]) {
			try {
				save();
			} catch (IOException ioe) {
				System.out.println("error");
			}

		}

		if (e.getSource() == setbtn[3]) {
			try {
				recall();
			} catch (IOException ioe) {
				System.out.println("error");
			}
		}

		if (e.getSource() == setbtn[4]) {
			reset();
		}
	}

	public void user_drop(int x) {
		gameboard[c_head[x]][x].setBackground(choose_color);
		board[c_head[x]][x] = 1;
		if (c_head[x] <= col - 1) {
			c_head[x] += 1;
		}
		user_turn += 1;
		uturn.setText("User Turn:   " + user_turn);
		// test
		/*
		 * for(int i=6;i>=0;i--) { for(int j=0;j<8;j++) { System.out.print(board[i][j]);
		 * } System.out.println(); }
		 */
	}

	public void comp_drop() {
		boolean d = false;
		Random rand = new Random();
		int c = rand.nextInt(col);
		int connect4 = ai();
		while (!d) {
			// avoid user win
			if (connect4 >= 0 && c_head[connect4] < col - 1) {
				gameboard[c_head[connect4]][connect4].setBackground(comp_color);
				board[c_head[connect4]][connect4] = 2;
				c_head[connect4] += 1;
				d = true;
			} else {
				// random drop
				if (c_head[c] < col - 1) {
					gameboard[c_head[c]][c].setBackground(comp_color);
					board[c_head[c]][c] = 2;
					c_head[c] += 1;
					d = true;
				} else {
					c = rand.nextInt(col);
				}
			}
		}
		comp_turn += 1;
		cturn.setText("Comp Turn: " + comp_turn);
	}

	public int ai() {
		int connect4 = -1;
		int c = drop4(2);
		if (c >= 0) {
			connect4 = c;
		} else {
			c = drop4(1);
			if (c >= 0) {
				connect4 = c;
			} else {
				c = drop3(1);
				if (c >= 0) {
					connect4 = c;
				} else {
					c = drop3(2);
					if (c >= 0) {
						connect4 = c;
					} else {
						c = drop2(2);
						if (c >= 0) {
							connect4 = c;
						} else {
							c = drop2(1);
							if (c >= 0) {
								connect4 = c;
							}
						}
					}
				}
			}
		}
		return connect4;
	}

	public int drop4(int x) {
		int i = 0, j = 0;
		int connect4 = -1;
		// check vertical connect 4
		while (connect4 < 0 && j <= col - 1) {
			for (i = 0; i <= row - 5; i++) {
				if (board[i][j] == x && board[i + 1][j] == x && board[i + 2][j] == x && board[i + 3][j] == x
						&& board[i + 4][j] == 0) {
					connect4 = j;
					System.out.println(x + " ver " + connect4);
				}
			}
			j++;
		}

		// check horizontal connect 4
		i = 0;
		j = 0;
		while (connect4 < 0 && i <= row - 1) {
			for (j = 0; j <= col - 4; j++) {
				if (j <= col - 5) {
					if (board[i][j] == x && board[i][j + 1] == x && board[i][j + 2] == x && board[i][j + 3] == x
							&& board[i][j + 4] == 0) {
						if (c_head[j + 4] == i) {
							connect4 = j + 4;
							System.out.println(x + " hor " + connect4);
						}
					}
				}
				if (j > 0 && connect4 < 0) {
					if (board[i][j] == x && board[i][j + 1] == x && board[i][j + 2] == x && board[i][j + 3] == x
							&& board[i][j - 1] == 0) {
						if (c_head[j - 1] == i) {
							connect4 = j - 1;
							System.out.println(x + " hor " + connect4);
						}
					}
				}
			}
			i++;
		}
		// check dia connect4
		i = 0;
		j = 0;
		while (connect4 < 0 && j <= col - 4) {
			for (i = 0; i <= row - 4; i++) {
				if (i <= row - 5 && j <= col - 5) {
					if (board[i][j] == x && board[i + 1][j + 1] == x && board[i + 2][j + 2] == x
							&& board[i + 3][j + 3] == x && board[i + 4][j + 4] == 0) {
						if (c_head[j + 4] == i + 4) {
							connect4 = j + 4;
							System.out.println(x + " +dia up " + connect4);
						}
					}
				}
				if (i > 0 && j > 0 && connect4 < 0) {
					if (board[i][j] == x && board[i + 1][j + 1] == x && board[i + 2][j + 2] == x
							&& board[i + 3][j + 3] == x && board[i - 1][j - 1] == 0) {
						if (c_head[j - 1] == i - 1) {
							connect4 = j - 1;
							System.out.println(x + " +dia down " + connect4);
						}
					}
				}

			}
			j++;
		}

		j = 3;
		while (connect4 < 0 && j <= col - 1) {
			for (i = 0; i <= row - 4; i++) {
				if (i <= row - 5 && j > 3) {
					if (board[i][j] == x && board[i + 1][j - 1] == x && board[i + 2][j - 2] == x
							&& board[i + 3][j - 3] == x && board[i + 4][j - 4] == 0) {
						if (c_head[j - 4] == i + 4) {
							connect4 = j - 4;
							System.out.println(x + " -dia up " + connect4);
						}
					}
				}
				if (i > 0 && j <= col - 2 && connect4 < 0) {
					if (board[i][j] == x && board[i + 1][j - 1] == x && board[i + 2][j - 2] == x
							&& board[i + 3][j - 3] == x && board[i - 1][j + 1] == 0) {
						if (c_head[j + 1] == i - 1) {
							connect4 = j + 1;
							System.out.println(x + " -dia down " + connect4);
						}
					}
				}

			}
			j++;
		}

		return connect4;
	}

	public int drop3(int x) {
		int connect4 = -1, i, j;
		i = 0;
		j = 0;
		while (connect4 < 0 && j <= col - 1) {
			for (i = 0; i <= row - 5; i++) {
				if (board[i][j] == x && board[i + 1][j] == x && board[i + 2][j] == x && board[i + 3][j] == 0) {
					connect4 = j;
					System.out.println(x + " ver3 " + connect4);
				}
			}
			j++;
		}
		// check hor connect3
		i = 0;
		j = 0;
		while (connect4 < 0 && i <= row - 1) {
			for (j = 0; j <= col - 3; j++) {
				if (j <= col - 5) {
					if (board[i][j] == x && board[i][j + 1] == x && board[i][j + 2] == x && board[i][j + 3] == 0) {
						if (c_head[j + 3] == i) {
							connect4 = j + 3;
							System.out.println(x + " hor3 " + connect4);
						}
					}
				}
				if (j > 1 && connect4 < 0) {
					if (board[i][j] == x && board[i][j + 1] == x && board[i][j + 2] == x && board[i][j - 1] == 0) {
						if (c_head[j - 1] == i) {
							connect4 = j - 1;
							System.out.println(x + " hor3 " + connect4);
						}
					}
				}
			}
			i++;
		}

		// check dia connect3
		i = 0;
		j = 0;
		while (connect4 < 0 && j <= col - 3) {
			for (i = 0; i <= row - 3; i++) {
				if (i <= row - 4 && j <= col - 4) {
					if (board[i][j] == x && board[i + 1][j + 1] == x && board[i + 2][j + 2] == x
							&& board[i + 3][j + 3] == 0) {
						if (c_head[j + 3] == i + 3) {
							connect4 = j + 3;
							System.out.println(x + " +dia3 up " + connect4);
						}
					}
				}
				if (i > 0 && j > 0 && connect4 < 0) {
					if (board[i][j] == x && board[i + 1][j + 1] == x && board[i + 2][j + 2] == x
							&& board[i - 1][j - 1] == 0) {
						if (c_head[j - 1] == i - 1) {
							connect4 = j - 1;
							System.out.println(x + " +dia3 down " + connect4);
						}
					}
				}

			}
			j++;
		}

		j = 2;
		while (connect4 < 0 && j <= col - 1) {
			for (i = 0; i <= row - 3; i++) {
				if (i <= row - 4 && j > 2) {
					if (board[i][j] == x && board[i + 1][j - 1] == x && board[i + 2][j - 2] == x
							&& board[i + 3][j - 3] == 0) {
						if (c_head[j - 3] == i + 3) {
							connect4 = j - 3;
							System.out.println(x + " -dia3 up " + connect4);
						}
					}
				}
				if (i > 0 && j <= col - 2 && connect4 < 0) {
					if (board[i][j] == x && board[i + 1][j - 1] == x && board[i + 2][j - 2] == x
							&& board[i - 1][j + 1] == 0) {
						if (c_head[j + 1] == i - 1) {
							connect4 = j + 1;
							System.out.println(x + " -dia3 down " + connect4);
						}
					}
				}
			}
			j++;
		}

		return connect4;
	}

	public int drop2(int x) {
		int connect4 = -1, i, j;
		// check hor connect2
		i = 0;
		j = 0;
		while (connect4 < 0 && i <= row - 1) {
			for (j = 0; j <= col - 2; j++) {
				if (j <= col - 5) {
					if (board[i][j] == x && board[i][j + 1] == x && board[i][j + 2] == 0) {
						if (c_head[j + 2] == i) {
							connect4 = j + 2;
							System.out.println(x + " hor2 " + connect4);
						}
					}
				}
				if (j > 2 && connect4 < 0) {
					if (board[i][j] == x && board[i][j + 1] == x && board[i][j - 1] == 0) {
						if (c_head[j - 1] == i) {
							connect4 = j - 1;
							System.out.println(x + " hor2 " + connect4);
						}
					}
				}
			}
			i++;
		}
		// check dia connect2
		i = 0;
		j = 0;
		while (connect4 < 0 && j <= col - 5) {
			for (i = 0; i <= row - 5; i++) {
				if (board[i][j] == x && board[i + 1][j + 1] == x && board[i + 2][j + 2] == 0) {
					if (c_head[j + 2] == i + 2) {
						connect4 = j + 2;
						System.out.println(x + " +dia2 " + connect4);
					}
				}
			}
			j++;
		}

		j = 4;
		while (connect4 < 0 && j <= col - 1) {
			for (i = 0; i <= row - 5; i++) {
				if (board[i][j] == x && board[i + 1][j - 1] == x && board[i + 2][j - 2] == 0) {
					if (c_head[j - 2] == i + 2) {
						connect4 = j - 2;
						System.out.println(x + " -dia2 " + connect4);
					}
				}
			}
			j++;
		}
		return connect4;
	}

	public boolean check_win(int x) {
		boolean win = false;
		if (check_hor(x) || check_ver(x) || check_dia(x)) {
			win = true;
			popup(x);
		}
		if (!win) {
			if (user_turn + comp_turn == row * col) {
				popup(3);
			}
		}
		return win;
	}

	public boolean check_hor(int x) {
		boolean hor = false;
		int i = 0, j = 0;
		while (!hor && i <= row - 1) {
			for (j = 0; j <= col - 5; j++) {
				if (board[i][j] == x && board[i][j + 1] == x && board[i][j + 2] == x && board[i][j + 3] == x
						&& board[i][j + 4] == x) {
					for (int k = 0; k < 5; k++) {
						gameboard[i][j + k].setBorder(new LineBorder(Color.RED, 5));
					}
					hor = true;
				}
			}
			i++;
		}
		return hor;
	}

	public boolean check_ver(int x) {
		boolean ver = false;
		int i = 0, j = 0;
		while (!ver && j < col) {
			for (i = 0; i < row - 4; i++) {
				if (board[i][j] == x && board[i + 1][j] == x && board[i + 2][j] == x && board[i + 3][j] == x
						&& board[i + 4][j] == x) {
					for (int k = 0; k < 5; k++) {
						gameboard[i + k][j].setBorder(new LineBorder(Color.RED, 5));
					}
					ver = true;
				}
			}
			j++;
		}
		return ver;
	}

	public boolean check_dia(int x) {
		boolean dia = false;
		int i = 0, j = 0;
		while (!dia && j <= col - 5) {
			for (i = 0; i <= row - 5; i++) {
				if (board[i][j] == x && board[i + 1][j + 1] == x && board[i + 2][j + 2] == x && board[i + 3][j + 3] == x
						&& board[i + 4][j + 4] == x) {
					for (int k = 0; k < 5; k++) {
						gameboard[i + k][j + k].setBorder(new LineBorder(Color.RED, 5));
					}
					dia = true;
				}
			}
			j++;
		}
		j = 4;
		while (!dia && j <= col - 1) {
			for (i = 0; i <= row - 5; i++) {
				if (board[i][j] == x && board[i + 1][j - 1] == x && board[i + 2][j - 2] == x && board[i + 3][j - 3] == x
						&& board[i + 4][j - 4] == x) {
					for (int k = 0; k < 5; k++) {
						gameboard[i + k][j - k].setBorder(new LineBorder(Color.RED, 5));
					}
					dia = true;
				}
			}
			j++;
		}
		return dia;
	}

	public void popup(int x) {
		JFrame popupframe = new JFrame();
		if (x == 1) {
			JOptionPane.showMessageDialog(popupframe, "User Win");
		} else if (x == 2) {
			JOptionPane.showMessageDialog(popupframe, "Computer Win");
		} else {
			JOptionPane.showMessageDialog(popupframe, "Draw");
		}

	}

	public void save() throws IOException {
		FileWriter FW = new FileWriter(history);
		BufferedWriter BW = new BufferedWriter(FW);
		// save color
		BW.write(last_color);
		BW.newLine();
		// save size
		BW.write(last_size);
		BW.newLine();
		// save board
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				BW.write(board[i][j]);
			}
			BW.newLine();
		}
		// save head
		for (int k = 0; k < col; k++) {
			BW.write(c_head[k]);
		}
		BW.newLine();
		// save turn
		BW.write(user_turn);
		BW.write(comp_turn);
		BW.close();
	}

	public void recall() throws IOException {
		reset();
		FileReader FR = new FileReader(history);
		BufferedReader BR = new BufferedReader(FR);
		// read color
		last_color = BR.read();
		switch (last_color) {
		case 0:
			choose_color = Color.cyan;
			break;
		case 1:
			choose_color = Color.LIGHT_GRAY;
			break;
		case 2:
			choose_color = Color.yellow;
			break;
		}
		BR.readLine();
		// read size
		last_size = BR.read();
		setgrid(row, col);
		switch (last_size) {
		case 0: {
			row = 5;
			col = 6;
			setgrid(row, col);
			myframe.setSize(550, 450);
		}
			break;

		case 1: {
			row = 6;
			col = 7;
			setgrid(row, col);
			myframe.setSize(600, 500);
		}
			break;

		case 2: {
			reset();
			row = 7;
			col = 8;
			setgrid(row, col);
			myframe.setSize(650, 550);
		}
			break;
		}
		BR.readLine();

		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				board[i][j] = BR.read();
				if (board[i][j] == 1) {
					gameboard[i][j].setBackground(choose_color);
				} else if (board[i][j] == 2) {
					gameboard[i][j].setBackground(comp_color);
				}
			}
			BR.readLine();
		}
		// recall head
		for (int k = 0; k < col; k++) {
			c_head[k] = BR.read();
		}
		BR.readLine();
		// recall turn
		user_turn = BR.read();
		uturn.setText("User Turn: " + user_turn);
		comp_turn = BR.read();
		cturn.setText("Comp Turn: " + comp_turn);
		BR.close();
	}

	public void reset() {
		System.out.println("reset");
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				this.gameboard[i][j].setBackground(null);
				this.gameboard[i][j].setBorder(new LineBorder(Color.gray));
				board[i][j] = 0;
				c_head[j] = 0;
			}
		}
		user_turn = 0;
		comp_turn = 0;
		cturn.setText("Comp Turn: " + comp_turn);
		uturn.setText("User Turn:   " + user_turn);
	}

	public void setgrid(int r, int c) {
		boardpanel.removeAll();
		boardpanel.revalidate();
		add(boardpanel, BorderLayout.CENTER);
		gameboard = new JButton[r][c];
		for (i = r - 1; i >= 0; i--) {
			for (j = 0; j < c; j++) {
				gameboard[i][j] = new JButton("");
				gameboard[i][j].setPreferredSize(new Dimension(55, 55));
				gameboard[i][j].setAction(null);
				gameboard[i][j].setBorder(new LineBorder(Color.gray));
				boardpanel.add(gameboard[i][j]);
			}
		}

	}

	public static void main(String[] args) {

		// Classname objname = new contstructorname(parameter)
		myframe.setTitle("Connect 5 Game Test");
		myframe.setJMenuBar(mb);
		myframe.setSize(650, 550);
		myframe.setLocation(600, 30);
		myframe.setVisible(true);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
