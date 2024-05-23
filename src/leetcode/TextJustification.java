package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static String helper(List<String> linewords, int maxWidth, boolean lastline, int stringsize){
        StringBuilder sb = new StringBuilder();
        int totalcount = linewords.size();

        if(lastline){
            for(String word: linewords){
                sb.append(word);
                sb.append(" ");
            }
            int extraspaces = maxWidth - sb.length();
            if(extraspaces <= 0){
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(" ".repeat(extraspaces));
            }
            return sb.toString();
        } else if(totalcount == 1) {
            sb.append(linewords.get(0));
            sb.append(" ".repeat(maxWidth - stringsize));
            return sb.toString();
        } else {
            int evendistrib = (maxWidth - stringsize)/(totalcount - 1);
            int extraspaces = (maxWidth - stringsize) - (evendistrib*(totalcount - 1));

            for(int i = 0; i<linewords.size(); i++){
                sb.append(linewords.get(i));
                if(i==linewords.size()-1){
                    break;
                }
                if(extraspaces>0){
                    sb.append(" ".repeat(evendistrib+1));
                    extraspaces--;
                } else {
                    sb.append(" ".repeat(evendistrib));
                }
            }
            return sb.toString();
        }


    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;
        int stringsize = 0;
        List<String> result = new ArrayList<>();
        List<String> linewords = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            if(count + words[i].length() <= maxWidth){
                linewords.add(words[i]);
                count = count+words[i].length();
                stringsize = stringsize + words[i].length();
                if(maxWidth>count+1){
                    count++;
                }
                if(i== words.length - 1){
                    String s = helper(linewords, maxWidth, true, stringsize);
                    result.add(s);
                    break;
                }
            } else {
                if(i== words.length - 1){
                    String s = helper(linewords, maxWidth, false, stringsize);
                    result.add(s);
                    linewords = new ArrayList<>();
                    linewords.add(words[i]);
                    stringsize = words[i].length();
                    String s2 = helper(linewords, maxWidth, true, stringsize);
                    result.add(s2);
                    break;
                }
                String s = helper(linewords, maxWidth, false, stringsize);
                linewords = new ArrayList<>();
                linewords.add(words[i]);
                result.add(s);
                count = words[i].length();
                stringsize = words[i].length();
                if(maxWidth>count+1){
                    count++;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"When","I","was","just","a","little","girl","I","asked","my","mother","what","will","I","be","Will","I","be","pretty","Will","I","be","rich","Here's","what","she","said","to","me","Que","sera","sera","Whatever","will","be","will","be","The","future's","not","ours","to","see","Que","sera","sera","When","I","was","just","a","child","in","school","I","asked","my","teacher","what","should","I","try","Should","I","paint","pictures","Should","I","sing","songs","This","was","her","wise","reply","Que","sera","sera","Whatever","will","be","will","be","The","future's","not","ours","to","see","Que","sera","sera","When","I","grew","up","and","fell","in","love","I","asked","my","sweetheart","what","lies","ahead","Will","there","be","rainbows","day","after","day","Here's","what","my","sweetheart","said","Que","sera","sera","Whatever","will","be","will","be","The","future's","not","ours","to","see","Que","sera","sera","What","will","be,","will","be","Que","sera","sera..."};
        System.out.println(fullJustify(words, 60));
    }
}

