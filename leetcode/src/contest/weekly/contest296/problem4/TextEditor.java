package contest.weekly.contest296.problem4;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-05 10:46
 **/
public class TextEditor {
    StringBuilder myText;
    int cursor;
    public TextEditor() {
        myText = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text) {
        myText.insert(cursor, text);
        cursor += text.length();

    }

    public int deleteText(int k) {
        int toDelete = Math.min(k, cursor);
        myText.delete(cursor - toDelete, cursor);
        cursor -= toDelete;

        return toDelete;
    }

    public String cursorLeft(int k) {
        int toMove = Math.min(k, cursor);
        cursor -= toMove;
        int showLeft = Math.min(10, cursor);

        return myText.substring(cursor - showLeft, cursor);
    }

    public String cursorRight(int k) {
        int toMove = Math.min(k, myText.length() - cursor);
        cursor += toMove;
        int showLeft = Math.min(10, cursor);

        return myText.substring(cursor - showLeft, cursor);
    }
}
