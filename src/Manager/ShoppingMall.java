package Manager;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import DB.GoodsDAO;

public class ShoppingMall extends JFrame {
	Scanner in = new Scanner(System.in);
	String header[] = { "��ǰ�ڵ�", "��ǰ�̸�", "����", "����", "üũ" };
	JTabbedPane tabpane = new JTabbedPane();
	DefaultTableModel tablemodel = new DefaultTableModel(header, 0);
	JTable table = new JTable(tablemodel);
	JScrollPane tableScroll = new JScrollPane(table);

	// center panel
	JPanel tab_center = new JPanel();
	JPanel tab_south = new JPanel();
	JPanel south_north = new JPanel();

	// JTextField[] txtfield = new JTextField[5];
	JTextField tfield = null;

	int modIntRow = -1;

	private GoodsDAO dao = GoodsDAO.getInstance();
	ArrayList<String[]> initList = new ArrayList<>();
	// basketlist list = null;

	public ShoppingMall() {
		super("���θ�");// super�� ������ ȣ��
		Dimension size = new Dimension(600, 400);
		createpanel();
		createtb();
		tablesetting();

		//createchkbox();

		init();

		this.setLocation(300, 300);
		this.setSize(size);
		this.add(tabpane);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

	}

	private void createchkbox() {
		table.getColumn("üũ").setCellRenderer(dcr);
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("üũ").setCellEditor(new DefaultCellEditor(box));

	}

	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent // ��������
		(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JCheckBox box = new JCheckBox();
			box.setSelected(((Boolean) value).booleanValue());
			box.setHorizontalAlignment(JLabel.CENTER);
			return box;
		}
	};

	private void init() {
//		JCheckBox[] Order = new JCheckBox[2];
//		String[] name = { "1", "2" };
//		for (int i = 0; i < Order.length; i++) {
//			Order[i] = new JCheckBox(name[i]); // ���ڿ��� ���� üũ�ڽ� ����
//			Order[i].setBorderPainted(true); // üũ�ڽ��� �ܰ���(�׵θ�) �����ֱ�
//			tablemodel.addRow(Order);// �гο� üũ�ڽ� �����ϱ�
//			Order[i].addItemListener(); // üũ�ڽ��� ������ ���
//		}

		initList = dao.getList();
		for (int i = 0; i < initList.size(); i++) {
			tablemodel.addRow(initList.get(i));
			
		}
		

		int rowNum = tablemodel.getRowCount();
		int colNum = tablemodel.getColumnCount();

	}

	public void tablesetting() {
		table.setRowMargin(0);
		table.getColumnModel().setColumnMargin(0);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {// ���콺 ���� Ŭ��
					modIntRow = table.getSelectedRow();
					// for (int i = 0; i < txtfield.length; i++) {
					// txtfield[i].setText((String) table.getValueAt(modIntRow,
					// i));
					// }
					// modIntRow = table.getSelectedRow();
					// tfield.setText((String) table.getValueAt(modIntRow, 5));
					// }
					if (e.getClickCount() == 2) {// ���� ���� Ŭ��

					}
					if (e.getClickCount() == 3) {

						modIntRow = table.getSelectedRow();
					}
				}
			}
		});
		DefaultTableCellRenderer ts = new DefaultTableCellRenderer();// ���̺��� ��
																		// ���� ����
		ts.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc = table.getColumnModel();
		for (int i = 0; i < tc.getColumnCount(); i++) {
			tc.getColumn(i).setCellRenderer(ts);
		}

	}

	private void createtb() {
		// south_north.setLayout(new BoxLayout(south_north, BoxLayout.X_AXIS));
		// for (int i = 0; i < txtfield.length; i++) {
		// south_north.add(txtfield[i] = new JTextField());
		// }
		JLabel all = new JLabel("�� �ݾ�");
		south_north.add(all);

		JTextField total = new JTextField(10);
		south_north.add(total);

//		JCheckBox ox = new JCheckBox();
//		ox.add(forbox);

//		Checkbox chk1 = new Checkbox("�ٳ���");
//		chk1.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				total.setText("�ٳ���  Checkbox : " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
//			}
//		});

		JButton addB = new JButton("��ٱ��Ͽ� ���");
		south_north.add(addB);

		addB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String in[] = new String[5];
				// for (int i = 0; i < txtfield.length; i++) {
				// in[i] = txtfield[i].getText();
				// txtfield[i].setText("");
				// }
				// int sum = Integer.parseInt(in[3]) * Integer.parseInt(in[4]);
				// in[5] = Integer.toString(sum);
				// dto = new DTO();
				// dto.setTotal(in[5]);
				tablemodel.addRow(in);
				// saveToDB(in);
			}

		});

		JButton modB = new JButton("�ٷ� �ֹ��ϱ�");
		south_north.add(modB);
		modB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String in[] = new String[5];
				// for (int i = 0; i < txtfield.length; i++) {
				// in[i] = txtfield[i].getText();
				// txtfield[i].setText("");
				// }
				// int sum = Integer.parseInt(in[3]) * Integer.parseInt(in[4]);
				// in[5] = Integer.toString(sum);
				// delTableRow(modIntRow);
				// tablemodel.insertRow(modIntRow, in);
				// dto = new DTO();
				// editToDB(in);
				modIntRow = -1;
			}
		});

	}

	private void createpanel() {
		this.add(tab_center, "Center");
		this.add(tab_south, "South");

		tab_center.setLayout(new BorderLayout());
		tab_center.add(tableScroll, "Center");
		tab_center.add(tab_south, "South");
		tabpane.add("shopping", tab_center);

		tab_south.setLayout(new BorderLayout());
		tab_south.add(south_north, "North");
		// tab_south.add(south_south, "South");

	}

}
