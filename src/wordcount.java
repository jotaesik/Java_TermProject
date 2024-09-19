import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class Word implements Comparable<Word> { // Ŭ���� ����   
   String word; // �ܾ�
   int count = 0; // �ܾ��� ��
   Word(String word, int cnt) { // ������
      this.word = word; // this���
      count = cnt; // �ѹ� �Ҹ��� count�� 1
   }
   Word(){}
   void Upcount() { // count�����Լ�
      count++; // count 1 ����
   }
   @Override
   public int compareTo(Word target) {
      if (this.word.compareTo(target.word) < 0) {
         return -1;
      } else if (this.word.compareTo(target.word) > 0) {
         return 1;
      }
      return 0;
   }
   @Override
   public String toString() {
      return word + " : " + count;
   }
}
class findWord{
	Word[] wordlist;
	int wordcount;
	String word;
findWord(Word[] wordlist, int wordcount, String word) {
   this.wordlist=wordlist;
   this.wordcount=wordcount;
   this.word=word;
 }
int run() {
	for (int i = 0; i < wordcount; i++) {
    if (wordlist[i].word.equals(word)) {
       return i;
    }
 }
 return -1;
}
}

class wordcount {
	  Word[] wordlist = new Word[100000]; 
	  Word wordlist2 = new Word();
      int wordcnt = 0;
	void run(String name) {
      PriorityQueue<Word> priorityQueue = new PriorityQueue<>();
      try {
    	  BufferedReader br = new BufferedReader(new FileReader(name));
    	  StringTokenizer stok;
         String str = "";
         while ((str = br.readLine()) != null) { // ��ū�� ���������� while��
            stok = new StringTokenizer(str," |,|.|;|"); // str�� ��ū ���� �з�
            String str2 = stok.toString();
            while (stok.hasMoreTokens()) {
               str2 = stok.nextToken();
               findWord fw =new findWord(wordlist, wordcnt, str2); // index�� findword�Լ������� ���.
               int index =fw.run();
               if (index == -1) { // index�� -1�̸�
                  wordlist[wordcnt++] = new Word(str2, 1); // ������ϹǷ� �迭�� ����
               } else { // index�� -1�� �ƴҽ�
                  wordlist[index].Upcount(); // �����ϴ°��̹Ƿ� upcount() ���� 1 count ����
               }
            }
         }
         for (int i = 0; i < wordcnt; i++) {
            priorityQueue.offer(new Word(wordlist[i].word, wordlist[i].count));
         }
         for(int i=0;i<wordcnt;) {
        	wordlist2=priorityQueue.poll();
        	if(wordlist2.word.contentEquals("a")||wordlist2.word.contentEquals("an")||wordlist2.word.contentEquals("the")||
        			wordlist2.word.contentEquals("is")||wordlist2.word.contentEquals("are")||wordlist2.word.contentEquals("were")||	
        			wordlist2.word.contentEquals("will")||wordlist2.word.contentEquals("was")||wordlist2.word.contentEquals("to")||
        			wordlist2.word.contentEquals("it")||wordlist2.word.contentEquals("for")||wordlist2.word.contentEquals("of")||
        			wordlist2.word.contentEquals("if")||wordlist2.word.contentEquals("and")) {
        		wordcnt--;
        	}
        	else {
        		wordlist[i]=wordlist2;
        		i++;
        	}
         }
         
       br.close();
      } catch (Exception e) {
         System.out.println("������ ������");
      }
	}
}
