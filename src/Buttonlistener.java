import java.awt.event.*;        
import javax.swing.*;        
import javax.swing.table.*;        
class Buttonlistener implements ActionListener {
    JTextField text1;
    wordcount wc;
    DefaultTableModel model;
    Buttonlistener( DefaultTableModel model, JTextField text1,wordcount wc) {
        this.text1 = text1;
        this.wc=wc;
        this.model=model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	String arr=text1.getText();
    	wc.run(arr);
    	model.setNumRows(0);
	      for (int i = 0; i < wc.wordcnt; i++)
	      {
	         Object Data[] = {wc.wordlist[i].word, wc.wordlist[i].count };
	         model.addRow(Data);
	      }
    	text1.setText("");
    }
}