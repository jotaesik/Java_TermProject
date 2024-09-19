import java.awt.*;        
import javax.swing.*;        
import javax.swing.table.*;        
class Gui {
    public static void main(String[] args) {
    	wordcount wc=new wordcount();
        JFrame frame = new JFrame("Word count");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setLocation(500, 400);
        Container contentPane = frame.getContentPane();
        String colNames[] = { "단어", "등장 횟수"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);         
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        JTextField text1 = new JTextField(6);
        JButton button1 = new JButton("실행");
        panel.add(new JLabel("파일명"));
        panel.add(text1);
        panel.add(button1);
        contentPane.add(panel, BorderLayout.SOUTH);
        button1.addActionListener(new Buttonlistener(model,text1,wc));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}