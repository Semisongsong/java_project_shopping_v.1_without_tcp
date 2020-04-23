package Manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame implements ActionListener {

	private JButton buttonOK;
	private JCheckBox onion, chese, tomato;

	public MyFrame() {
		// TODO Auto-generated constructor stub
		setTitle("üũ�ڽ� �׽�Ʈ");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("�ܹ��ſ� ������ �߰��ϰڽ��ϱ�?");
		JPanel toPanel = new JPanel();
		toPanel.add(label);
		add(toPanel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		onion = new JCheckBox("����");
		panel.add(onion);
		chese = new JCheckBox("ġ��");
		panel.add(chese);
		tomato = new JCheckBox("�丶��");
		panel.add(tomato);
		add(panel, BorderLayout.CENTER);

		buttonOK = new JButton("OK");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(buttonOK);
		add(buttonPanel, BorderLayout.SOUTH);
		buttonOK.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonOK) {
			String msg = "";
			if (onion.isSelected())
				msg += "����\n";
			if (chese.isSelected())
				msg += "ġ��\n";
			if (tomato.isSelected())
				msg += "�丶��\n";
			msg = "������ �ɼ��� �ٿ�������ϴ�\n" + msg;
			System.out.println(msg);
			onion.setSelected(false);
			chese.setSelected(false);
			tomato.setSelected(false);
		}
	}

}

public class Testt {
	public static void main(String[] args) {
		new MyFrame();
	}
}
