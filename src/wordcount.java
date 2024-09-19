import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class Word implements Comparable<Word> { // 클래스 생성   
   String word; // 단어
   int count = 0; // 단어의 수
   Word(String word, int cnt) { // 생성자
      this.word = word; // this사용
      count = cnt; // 한번 불릴시 count는 1
   }
   Word(){}
   void Upcount() { // count증가함수
      count++; // count 1 증가
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
         while ((str = br.readLine()) != null) { // 토큰이 없을때가지 while문
            stok = new StringTokenizer(str," |,|.|;|"); // str은 토큰 띄어쓰기 분류
            String str2 = stok.toString();
            while (stok.hasMoreTokens()) {
               str2 = stok.nextToken();
               findWord fw =new findWord(wordlist, wordcnt, str2); // index는 findword함수문으로 사용.
               int index =fw.run();
               if (index == -1) { // index가 -1이면
                  wordlist[wordcnt++] = new Word(str2, 1); // 존재안하므로 배열에 저장
               } else { // index가 -1이 아닐시
                  wordlist[index].Upcount(); // 존재하는것이므로 upcount() 통해 1 count 증가
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
         System.out.println("파일이 ㅇ벗졍");
      }
	}
}
